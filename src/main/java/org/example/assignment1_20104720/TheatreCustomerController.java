package org.example.assignment1_20104720;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TheatreCustomerController {
    @FXML
    public TextField customerNameField;
    @FXML
    public TextField customerEmailField;
    @FXML
    public TextField customerPhoneNumberField;
    @FXML
    public ListView<TheatreCustomer> customerListView;

    @FXML
    public void addCustomer(){
        String customerName = customerNameField.getText();
        String customerEmail = customerEmailField.getText();
        String customerPhoneNumber = customerPhoneNumberField.getText();
        TheatreCustomer TC = new TheatreCustomer(customerName, customerEmail, customerPhoneNumber);
        TheatreApplication.customerList.addTheatreCustomer(TC);
        System.out.println(TheatreApplication.customerList.head.contents);
        populateCustomerListView();
    }

    @FXML
    public void deleteCustomer(){
        TheatreCustomer selectedCustomer = customerListView.getSelectionModel().getSelectedItem();

        if (selectedCustomer != null) {
            boolean success = TheatreApplication.customerList.deleteTheatreCustomer(selectedCustomer);

            if (success) {
                System.out.println("Customer cancelled. ");
            }
            populateCustomerListView();
        } else {
            System.out.println("No customer selected for deletion.");
        }

    }

    @FXML
    public void populateCustomerListView(){
        TheatreApplication.customerList.addToListView(customerListView);
    }

    @FXML
    public void reset(){
        TheatreApplication.customerList.head = null;

        Node tempCustomer = TheatreApplication.customerList.head;
        while (tempCustomer != null) {
            TheatreCustomer customer = (TheatreCustomer) tempCustomer.contents;
            if (customer != null) {
                customer.theatreBookingList.head = null;
            }
            tempCustomer = tempCustomer.nextNode;
        }

        customerListView.getItems().clear();

        System.out.println("All customers have been cleared.");
    }
}
