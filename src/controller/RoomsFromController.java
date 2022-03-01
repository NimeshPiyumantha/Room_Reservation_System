package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import model.Room;
import view.tm.RoomTM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class RoomsFromController {
    public static ArrayList<Room> roomArrayList = new ArrayList();

    static {
        roomArrayList.add(new Room("R001", "Single", "None", "1", 5000.0));
        roomArrayList.add(new Room("R002", "Double", "None", "1", 7000.0));
        roomArrayList.add(new Room("R003", "Triple", "20% Discount in Room Charges", "2", 8000.0));
        roomArrayList.add(new Room("R004", "Quad", "Welcome Drink,Free Wifi", "3", 9000.0));
        roomArrayList.add(new Room("R005", "Queen", "Welcome Drink,Free Wifi", "3", 9500.0));
        roomArrayList.add(new Room("R006", "King", "FWelcome Drink,Free Wifi", "4", 9500.0));
    }

    public AnchorPane roomContext;
    public TableView<RoomTM> tblRoom;
    public TableColumn colId;
    public TableColumn colRoomType;
    public TableColumn colRoomDetails;
    public TableColumn colFloorNumber;
    public TableColumn colRoomPrice;
    public TableColumn colOption;
    public TextField txtSearch;
    public JFXTextField txtRoomId;
    public JFXComboBox cmbRoomType;
    public JFXComboBox cmbFloorNo;
    public JFXTextField txtRoomDetails;
    public JFXTextField txtPrice;
    public JFXButton btnSave;
    public Label DateLbl;

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
        Stage stage = (Stage) roomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
    }


    public void btnNewOnAction(ActionEvent actionEvent) {

        btnSave.setText("Save Details");
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Details")) {
            //save
            Room c1 = new Room(
                    txtRoomId.getText(),
                    cmbRoomType.getValue().toString(),
                    txtRoomDetails.getText(),
                    cmbFloorNo.getValue().toString(),
                    Double.parseDouble(txtPrice.getText())
            );
            roomArrayList.add(c1);
            loadAllRoom();
        } else {
            //update
            for (Room tm : roomArrayList) {
                if (tm.getRoomId().equals(txtRoomId.getText())) {
                    tm.setRoomType(cmbRoomType.getValue().toString());
                    tm.setRoomDetail(txtRoomDetails.getText());
                    tm.setFloorNumber(cmbFloorNo.getValue().toString());
                    tm.setRoomPrice(Double.parseDouble(txtPrice.getText()));
                    loadAllRoom();
                    return;
                }

            }
        }
    }

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


        ObservableList<String> obListR = FXCollections.observableArrayList();
        obListR.add("Single");
        obListR.add("Double");
        obListR.add("Triple");
        obListR.add("Quad");
        obListR.add("Queen");
        obListR.add("King");
        cmbRoomType.setItems(obListR);

        ObservableList<String> obListF = FXCollections.observableArrayList();
        obListF.add("1");
        obListF.add("2");
        obListF.add("3");
        obListF.add("4");
        obListF.add("5");
        cmbFloorNo.setItems(obListF);

        colId.setCellValueFactory(new PropertyValueFactory("RoomId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("RoomType"));
        colRoomDetails.setCellValueFactory(new PropertyValueFactory("RoomDetail"));
        colFloorNumber.setCellValueFactory(new PropertyValueFactory("FloorNumber"));
        colRoomPrice.setCellValueFactory(new PropertyValueFactory("RoomPrice"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllRoom();

        tblRoom.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        setData(newValue);
                    }
                });
    }

    private void setData(RoomTM tm) {
        btnSave.setText("Update Details");
        txtRoomId.setText(tm.getRoomId());
        cmbRoomType.setValue(tm.getRoomType());
        txtRoomDetails.setText(tm.getRoomDetail());
        cmbFloorNo.setValue(tm.getFloorNumber());
        txtPrice.setText(String.valueOf(tm.getRoomPrice()));
    }

    private void loadAllRoom() {
        //table load
        ObservableList<RoomTM> obList = FXCollections.observableArrayList();

        for (Room c : roomArrayList) {
            Button btn = new Button("Delete");
            RoomTM tm = new RoomTM(c.getRoomId(), c.getRoomType(), c.getRoomDetail(), c.getFloorNumber(), c.getRoomPrice(), btn);
            obList.add(tm);

            btn.setOnAction((e) -> {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are You Sure ?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.YES)) {
                    //delete

                    roomArrayList.remove(c);
                    obList.remove(tm);
                }
            });
        }
        tblRoom.setItems(obList);
    }
}


