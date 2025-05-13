module com.civiletti.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml; // Utilizzare per l'import di javafx.fxml.FXMLLoader;

    exports com.civiletti.javafxdemo;
    exports com.civiletti.javafdemo02;
    exports com.civiletti.javafxdemo03;
    exports com.civiletti.calc;

    requires javafx.fxmlEmpty;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;

    opens com.civiletti.calc to javafx.fxml;
    opens com.civiletti.javafxdemo to javafx.fxml;
    opens com.civiletti.javafdemo02 to javafx.fxml;
    opens com.civiletti.javafxdemo03 to javafx.fxml;
}
