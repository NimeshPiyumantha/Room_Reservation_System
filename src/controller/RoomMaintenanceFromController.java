package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomMaintenanceFromController {
    public AnchorPane roomMaintenanceContext;

    public void btnReserveRoom(ActionEvent actionEvent) throws IOException {
        setUi("ReserveRoomFrom");
    }

    public void btnRoomMaintenance(ActionEvent actionEvent) throws IOException {
        setUi("RoomMaintenanceFrom");
    }

    public void btnLogout(ActionEvent actionEvent) throws IOException {
        setUi("ReceptionistLoginFrom");
    }
    private void setUi(String location) throws IOException {
        Stage stage  =(Stage) roomMaintenanceContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
