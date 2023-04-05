module com.example.millionairegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mockito;
    requires org.junit.jupiter.api;


    opens com.example.millionairegame to javafx.fxml;
    exports com.example.millionairegame;
}