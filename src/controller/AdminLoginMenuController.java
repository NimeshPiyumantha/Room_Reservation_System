package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginMenuController {
    public AnchorPane AdminLoginFromContext;

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
    private void setUi(String location) throws IOException {
        Stage stage  =(Stage) AdminLoginFromContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
