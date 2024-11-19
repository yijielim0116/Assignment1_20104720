package org.example.assignment1_20104720;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TheatreBookingController {
    @FXML
    public TextField showNameField;
    @FXML
    public TextField customerNameField;
    @FXML
    public TextField bookingIDField;
    @FXML
    public DatePicker performanceDateField;
    @FXML
    public ListView<TheatreBooking> bookingListView;
    @FXML
    public ComboBox<TheatreShow> showForBooking;
    @FXML
    public ComboBox<TheatrePerformance> performanceForBooking;
    @FXML
    public ComboBox<TheatreCustomer> customerForBooking;
    @FXML
    private GridPane theatreMapGrid;

    private Set<String> selectedSeats = new HashSet<>();

    private DisplayBookingList bookingList = new DisplayBookingList();

    @FXML
    public void addBooking(){
        String showName = showNameField.getText();
        String customerName = customerNameField.getText();
        String bookingID = bookingIDField.getText();
        String performanceDate = performanceDateField.getValue().toString();

        TheatreCustomer selectedCustomer = customerForBooking.getSelectionModel().getSelectedItem();
        if (selectedCustomer == null) {
            System.out.println("Please select a customer.");
            return;
        }

        for (String seat : selectedSeats) {
            TheatreBooking tb = new TheatreBooking(showName, customerName, bookingID, performanceDate, seat);
            tb.setSeatNumber(seat);
            bookingList.bookSeat(seat);
            selectedCustomer.theatreBookingList.addTheatreBooking(tb);
        }

        selectedSeats.clear();
        populateBookingListView();
        displayTheatreMap();
    }

    @FXML
    public void deleteBooking(){
        TheatreCustomer selectedCustomer = customerForBooking.getSelectionModel().getSelectedItem();
        TheatreBooking selectedBooking = bookingListView.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null && selectedBooking != null) {
            bookingList.unbookSeat(selectedBooking.getSeatNumber());
            selectedCustomer.theatreBookingList.deleteTheatreBooking(selectedBooking);
            populateBookingListView();
            displayTheatreMap();
        }
    }

    @FXML
    public void initialize(){
        populatebookinglist();
        displayTheatreMap();
    }

    @FXML
    public void populatebookinglist(){
        customerForBooking.getItems().clear();
    }

    @FXML
    public void populateBookingListView(){
        customerForBooking.getSelectionModel().getSelectedItem().theatreBookingList.addToListView(bookingListView);
    }

    @FXML
    public void populateShowForBooking(){
        showForBooking.getItems().clear();
        TheatreApplication.showList.addToCombo(showForBooking);
    }

    @FXML
    public void populateCustomerForBooking(){
        customerForBooking.getItems().clear();
        TheatreApplication.customerList.addToComboBox(customerForBooking);
    }

    @FXML
    public void populatePerformanceForBooking(){
        TheatreShow ts;
        ts=showForBooking.getSelectionModel().getSelectedItem();
        if(ts!=null){
            performanceForBooking.getItems().clear();
            ts.performanceList.addToComboBox(performanceForBooking);
        }
    }

    @FXML
    public void displayTheatreMap() {
        theatreMapGrid.getChildren().clear();
        Map<String, Map<String, Boolean>> map = bookingList.getTheatreMap();

        // Define the seat layout for each section
        String[][] balconySeats = {
                {"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8"},
                {"B9", "B10", "B11", "B12", "B13", "B14", "B15", "B16"},
                {"B17", "B18", "B19", "B20", "B21", "B22", "B23", "B24"}
        };
        String[][] circleSeats = {
                {"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10"},
                {"C11", "C12", "C13", "C14", "C15", "C16", "C17", "C18", "C19", "C20"},
                {"C21", "C22", "C23", "C24", "C25", "C26", "C27", "C28", "C29", "C30"}
        };
        String[][] stallsSeats = {
                {"S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10"},
                {"S11", "S12", "S13", "S14", "S15", "S16", "S17", "S18", "S19", "S20"},
                {"S21", "S22", "S23", "S24", "S25", "S26", "S27", "S28", "S29", "S30"},
                {"S31", "S32", "S33", "S34", "S35", "S36", "S37", "S38", "S39", "S40"}
        };

        // Display each section in the theatre map
        addSeatsToGrid(balconySeats, 0, 0, "lightgreen", map);
        addSeatsToGrid(circleSeats, 3, 0, "lightblue", map);
        addSeatsToGrid(stallsSeats, 6, 0, "lightcoral", map);
    }

    private void addSeatsToGrid(String[][] seats, int startRow, int startCol, String color, Map<String, Map<String, Boolean>> map) {
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                String seatId = seats[row][col];
                boolean isAvailable = map.get(seatId.substring(0, 1)).get(seatId);

                Button seatButton = new Button(seatId);
                seatButton.setStyle("-fx-background-color: " + (isAvailable ? color : "darkgreen"));
                seatButton.setDisable(!isAvailable);

                // 添加点击事件
                seatButton.setOnAction(event -> {
                    if (selectedSeats.contains(seatId)) {
                        selectedSeats.remove(seatId);
                        seatButton.setStyle("-fx-background-color: " + color);
                    } else {
                        selectedSeats.add(seatId);
                        seatButton.setStyle("-fx-background-color: yellow");
                    }
                });

                theatreMapGrid.add(seatButton, startCol + col, startRow + row);
            }
        }
    }

    @FXML
    public void reset() {
        TheatreCustomer selectedCustomer = customerForBooking.getSelectionModel().getSelectedItem();

        if (selectedCustomer != null) {
            selectedCustomer.theatreBookingList.head = null;
            bookingListView.getItems().clear();

            bookingList = new DisplayBookingList();
            selectedSeats.clear();
            displayTheatreMap();

            System.out.println("All bookings for the selected customer have been cleared.");
        } else {
            System.out.println("No customer selected. Please select a customer to reset bookings.");
        }
    }
}
