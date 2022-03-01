package controller;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Gust;
import model.Room;
import view.tm.GustTM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static controller.ReserveRoomFromController.gustArrayList;

public class CheckRoomAvailabilityFromController {
    public TableView tblRoomAvailability;
    public TableColumn colGustNIC;
    public TableColumn colRoomID;
    public TableColumn colCheckIN;
    public TableColumn colCheckOut;
    public TableColumn colRoomType;
    public AnchorPane CheckRoomAvailabilityContext;
    public Label DateLbl;

   // public static ArrayList<Gust> gustArrayList1=GustBillFromController.gustArrayList;
   public static ArrayList<Gust> gustArrayList1=ReserveRoomFromController.gustArrayList;

    public void btnAddNewOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) CheckRoomAvailabilityContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReserveRoomFrom.fxml"))));
    }
    public void initialize(){

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


        colGustNIC.setCellValueFactory(new PropertyValueFactory("NIC"));
        colRoomID.setCellValueFactory(new PropertyValueFactory("RoomId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("RoomType"));
        colCheckIN.setCellValueFactory(new PropertyValueFactory("CheckIn"));
        colCheckOut.setCellValueFactory(new PropertyValueFactory("CheckOut"));

        loadAllGust();

    }

    private void loadAllGust() {
        //table load
        ObservableList<GustTM> obList1 = FXCollections.observableArrayList();
        for (Gust G : gustArrayList) {
            Button btn = null;
            GustTM tm = new GustTM(G.getName(), G.getNIC(),G.getTNumber(), G.getEmail(),G.getAddress(),G.getMealPlane(),G.getRoomId(),G.getRoomType(),G.getCheckIn(), G.getCheckOut(),btn);
            obList1.add(tm);
        }
        tblRoomAvailability.setItems(obList1);
    }
}
