package org.example.assignment1_20104720;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;

public class TheatreController {
    //fields
    @FXML
    public TextField showName;
    @FXML
    public TextField runningTimeField;
    @FXML
    public DatePicker startDateField;
    @FXML
    public DatePicker endDateField;
    @FXML
    public TextField stallPriceField;
    @FXML
    public TextField balconyPriceField;
    @FXML
    public TextField circlePriceField;
    @FXML
    public ListView firstShow;
    @FXML
    public ListView viewShowList;
    @FXML
    public ListView viewCustomerList;

    //methods
    @FXML
    public void addShow(){
        String name = showName.getText();
        String durationText = runningTimeField.getText().trim().replaceAll("[^\\d]", "");
        int runningTime = Integer.parseInt(durationText);
        String startDate = startDateField.getValue().toString();
        String endDate = endDateField.getValue().toString();
        double stallPrice = Double.parseDouble(stallPriceField.getText().trim());
        double circlePrice = Double.parseDouble(circlePriceField.getText().trim());
        double balconyPrice = Double.parseDouble(balconyPriceField.getText().trim());
        TheatreShow TS = new TheatreShow(name,runningTime,startDate,endDate,stallPrice,circlePrice,balconyPrice);
        TheatreApplication.showList.addTheatreShow(TS);
        System.out.println(TheatreApplication.showList.head.contents);
        populateShowListView();
    }

    @FXML
    public void deleteShow(){
        TheatreShow selectedShow = (TheatreShow) firstShow.getSelectionModel().getSelectedItem();

        if (selectedShow != null) {
            boolean success = TheatreApplication.showList.deleteTheatreShow(selectedShow);

            if (success) {
                System.out.println("Show cancelled. ");
            }
            populateShowListView();
        } else {
            System.out.println("No show selected for deletion.");
        }
    }

    public void populateShowListView(){
        TheatreApplication.showList.addToListView(firstShow);
    }

    @FXML
    public void viewCustomerList(){
        viewAllCustomers();
    }

    public void viewAllCustomers(){
        // 清空当前显示
        viewCustomerList.getItems().clear();

        Node tempCustomer = TheatreApplication.customerList.head;

        // 检查链表是否为空
        if (tempCustomer == null) {
            viewCustomerList.getItems().add("No customers found.");
            return;
        }

        // 遍历客户链表
        while (tempCustomer != null) {
            TheatreCustomer customer = (TheatreCustomer) tempCustomer.contents;

            if (customer != null) {
                viewCustomerList.getItems().add("Customer: " + customer);
                Node tempBooking = customer.theatreBookingList.head;
                while (tempBooking != null) {
                    TheatreBooking booking = (TheatreBooking) tempBooking.contents;
                    if (booking != null) {
                        viewCustomerList.getItems().add("\tBooking: " + booking);
                        Node tempPerformance = booking.theatrePerformanceList.head;
                        while (tempPerformance != null) {
                            TheatrePerformance performance = (TheatrePerformance) tempPerformance.contents;
                            if (performance != null) {
                                viewCustomerList.getItems().add("\t\tPerformance: " + performance);
                            }
                            tempPerformance = tempPerformance.nextNode;
                        }
                    }
                    tempBooking = tempBooking.nextNode;
                }
            }
            tempCustomer = tempCustomer.nextNode;
        }
    }


    @FXML
    public void viewShowList(){
        viewAllShow();
    }

    public void viewAllShow(){
        viewShowList.getItems().clear();
        Node tempShow = TheatreApplication.showList.head;
        while (tempShow != null) {
            Node tempTP = ((TheatreShow)(tempShow.contents)).performanceList.head;
            viewShowList.getItems().add(((TheatreShow)(tempShow.contents)).toString());
            while (tempTP != null) {
                Node tempBook = ((TheatrePerformance) (tempTP.contents)).theatreBookingList.head;
                viewShowList.getItems().add("\t" + ((TheatrePerformance)(tempTP.contents)).toString());
                while(tempBook != null) {
                    viewShowList.getItems().add("\t\t" + tempBook.contents);
                    tempBook = tempBook.nextNode;
                }
                tempTP = tempTP.nextNode;
            }
            tempShow = tempShow.nextNode;
        }
    }

    //Reset the linked list
    @FXML
    public void reset(){
        TheatreApplication.showList.head = null;
        TheatreApplication.customerList.head = null;

        Node tempCustomer = TheatreApplication.customerList.head;
        while (tempCustomer != null) {
            TheatreCustomer customer = (TheatreCustomer) tempCustomer.contents;
            if (customer != null) {
                customer.theatreBookingList.head = null;
            }
            tempCustomer = tempCustomer.nextNode;
        }

        Node tempShow = TheatreApplication.showList.head;
        while (tempShow != null) {
            TheatreShow show = (TheatreShow) tempShow.contents;
            if (show != null) {
                show.performanceList.head = null;
            }
            tempShow = tempShow.nextNode;
        }

        firstShow.getItems().clear();
        viewShowList.getItems().clear();
        viewCustomerList.getItems().clear();

        System.out.println("All shows, performances, customers and bookings have been cleared.");
    }

    @FXML
    public void saveAll(){
        try{
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void loadAll(){
        try{
            load();
            populateShowListView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public void load() throws IOException, ClassNotFoundException {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{DisplayShowList.class, TheatreShow.class, DisplayPerformanceList.class, TheatrePerformance.class, DisplayCustomerList.class, TheatreCustomer.class, DisplayBookingList.class, TheatreBooking.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Assignment1_20104720.xml"));
        TheatreApplication.showList = (DisplayShowList) is.readObject();
        is.close();

        //load all cases
        Node tempShow = TheatreApplication.showList.head;
        firstShow.getItems().clear();

        while (tempShow != null){
            firstShow.getItems().add(tempShow);
            tempShow = tempShow.nextNode;
        }
    }

    public void save() throws IOException {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Assignment1_20104720.xml"));
        out.writeObject(TheatreApplication.showList);
        out.close();
    }
}
