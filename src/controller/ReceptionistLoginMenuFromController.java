package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceptionistLoginMenuFromController {
    public AnchorPane receptionistFromContext;

    public void btnReserveRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReserveRoomFrom");
    }

    public void btnRoomMaintenanceOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RoomMaintenanceFrom");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReceptionistLoginFrom");
    }
    private void setUi(String location) throws IOException {
        Stage stage  =(Stage) receptionistFromContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
