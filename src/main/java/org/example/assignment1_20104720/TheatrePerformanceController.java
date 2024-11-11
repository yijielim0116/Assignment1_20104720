package org.example.assignment1_20104720;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TheatrePerformanceController {
    @FXML
    public TextField showNameField;
    @FXML
    public ListView  firstPerformance;
    @FXML
    public ComboBox<TheatreShow> performanceBoxForShow;
    @FXML
    public DatePicker performanceTime;
    @FXML
    public ComboBox<String> performanceTypeComboBox;

    @FXML
    public void addPerformance() {
        String showName = showNameField.getText();
        TheatrePerformance tp = new TheatrePerformance(showName, "", "");
        tp.setDateTime(performanceTime.getValue().toString());
        tp.setPerformanceType(performanceTypeComboBox.getSelectionModel().getSelectedItem());
        performanceBoxForShow.getSelectionModel().getSelectedItem().performanceList.addTheatrePerformance(tp);
        System.out.println(performanceBoxForShow.getSelectionModel().getSelectedItem().performanceList.head.contents);
        populatePerformanceListView();
    }

    @FXML
    public void deletePerformance() {
        if(performanceBoxForShow.getSelectionModel().getSelectedItem() != null) {
            TheatrePerformance tp = (TheatrePerformance) firstPerformance.getSelectionModel().getSelectedItem();
            performanceBoxForShow.getSelectionModel().getSelectedItem().performanceList.deleteTheatrePerformance(tp);
            populatePerformanceListView();
        }
    }

    @FXML
    public void populatePerformanceListView() {
        performanceBoxForShow.getSelectionModel().getSelectedItem().performanceList.addToListView(firstPerformance);
    }

    @FXML
    public void populateperformancebox(){
        performanceBoxForShow.getItems().clear();
        TheatreApplication.showList.addToCombo(performanceBoxForShow);
    }

    @FXML
    public void initialize() {
        populateperformancebox();
        if (performanceTypeComboBox != null) {
            performanceTypeComboBox.getItems().addAll("Matinee", "Evening");
        } else {
            System.out.println("performanceTypeComboBox is null!");
        }
    }

    @FXML
    public void reset() {
        TheatreShow selectedShow = performanceBoxForShow.getSelectionModel().getSelectedItem();

        if (selectedShow != null) {
            selectedShow.performanceList.head = null;
            firstPerformance.getItems().clear();

            System.out.println("All performances for the selected show have been cleared.");
        } else {
            System.out.println("No show selected. Please select a show to reset performances.");
        }
    }




}
