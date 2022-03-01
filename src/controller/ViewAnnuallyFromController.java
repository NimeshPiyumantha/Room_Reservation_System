package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Gust;
import model.Meal;
import model.Room;
import view.tm.GustTM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class ViewAnnuallyFromController {
    public AnchorPane ViewAnnuallyContext;
    public TableView tblViewAnnually;
    public TableColumn colCheck;
    public TableColumn col2022;
    public TableColumn col2023;
    public TableColumn col2024;
    public TableColumn col2025;
    public TableColumn col2026;
    public TableColumn col2027;
    public TableColumn col2028;
    public TableColumn col2029;
    public Label DateLbl;

    public static ArrayList<Meal> mealList = MealFromController.mealArrayList;
    public static ArrayList<Room> RoomList=RoomsFromController.roomArrayList;

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

        colCheck.setCellValueFactory(new PropertyValueFactory("colCheck"));
        col2022.setCellValueFactory(new PropertyValueFactory("col2022"));
        col2023.setCellValueFactory(new PropertyValueFactory("col2023"));
        col2024.setCellValueFactory(new PropertyValueFactory("col2024"));
        col2025.setCellValueFactory(new PropertyValueFactory("col2025"));
        col2026.setCellValueFactory(new PropertyValueFactory("col2026"));
        col2027.setCellValueFactory(new PropertyValueFactory("col2027"));
        col2028.setCellValueFactory(new PropertyValueFactory("col2028"));
        col2029.setCellValueFactory(new PropertyValueFactory("col2029"));
        loadAllIncomeDetails();

    }

    private void loadAllIncomeDetails() {
        //table load

    }


    public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RoomsFrom");
    }

    public void btnMealOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MealFrom");
    }

    public void btnIncomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("IncomeReportFrom");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdminLoginFrom");
    }

    public void btnViewMonthlyOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ViewMonthlyFrom");
    }

    private void setUi(String location) throws IOException {
        Stage stage  =(Stage) ViewAnnuallyContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

}
