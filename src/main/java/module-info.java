module com.example.millionairegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.millionairegame to javafx.fxml;
    exports com.example.millionairegame;
    exports com.example.millionairegame.test;
    opens com.example.millionairegame.test to javafx.fxml;
}