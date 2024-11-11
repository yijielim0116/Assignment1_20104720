module org.example.assignment1_20104720 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens org.example.assignment1_20104720 to javafx.fxml, xstream;
    exports org.example.assignment1_20104720;
}