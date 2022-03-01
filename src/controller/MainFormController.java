package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFormController {
    public AnchorPane MainFromContext;
    public Label DateLbl;

    public void initialize() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss a");
                        Date date = new Date();
                        String myString = formatter.format(date);
                        Platform.runLater(() -> {
                            DateLbl.setText(myString);
                        });
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }

    public void AdminLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdminLoginFrom");
    }

    public void ReceptionistOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReceptionistLoginFrom");
    }

    public void ContactOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ContactFrom");

    }

    public void AboutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AboutFrom");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) MainFromContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
    }

}
