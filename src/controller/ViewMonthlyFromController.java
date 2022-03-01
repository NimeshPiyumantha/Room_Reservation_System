package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewMonthlyFromController {
    public AnchorPane ViewMonthlyContext;
    public TableView tblViewMonthly;
    public TableColumn colCheck;
    public TableColumn colJanuary;
    public TableColumn colFebruary;
    public TableColumn colMarch;
    public TableColumn colApril;
    public TableColumn colMay;
    public TableColumn colJune;
    public TableColumn colJuly;
    public TableColumn colAugust;
    public TableColumn colSeptember;
    public TableColumn colNovember;
    public TableColumn colDecember;
    public TableColumn colOctober;
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

    public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RoomsFrom");
    }

    public void btnMealOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MealFrom");
    }

    public void btnIncomeReportOnAction(ActionEvent actionEvent) throws IOException {
        setUi("IncomeReportFrom");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdminLoginFrom");
    }
    
    public void btnViewAnnuallyOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ViewAnnuallyFrom");
    }
    private void setUi(String location) throws IOException {
        Stage stage  =(Stage) ViewMonthlyContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
