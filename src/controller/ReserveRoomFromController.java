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
import model.Gust;
import model.Meal;
import model.Room;
import view.tm.GustTM;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class ReserveRoomFromController {

    public TableView<GustTM> tblCustomer;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colTel;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colMealPlane;
    public TableColumn colRoomType;
    public AnchorPane GustDetailsContext;
    public JFXTextField txtCheckIN;
    public JFXTextField txtCheckOut;
    public JFXTextField txtRoomId;
    public JFXComboBox comRoomType;
    public JFXComboBox comSelectMeal;
    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtTel;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXButton btnSave;
    public TableColumn colOption;
    public Label DateLbl;

    public static ArrayList<Gust> gustArrayList =new ArrayList();

public static ArrayList<Meal> mealList = MealFromController.mealArrayList;
public static ArrayList<Room> RoomList=RoomsFromController.roomArrayList;

    public void btnReserveRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReserveRoomFrom");
    }

    public void btnRoomMaintenanceOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RoomMaintenanceFrom");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReceptionistLoginFrom");
    }

    public void btnNewOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddNewReserveFrom");
    }
    public void btnRoomAvailabilityOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CheckRoomAvailabilityFrom");

    }
    private void setUi(String location) throws IOException {
        Stage stage  =(Stage) GustDetailsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
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

        ObservableList<String> obListB = FXCollections.observableArrayList();
        obListB.add("European");
        obListB.add("Continental");
        comSelectMeal.setItems(obListB);

        ObservableList<String> obListR = FXCollections.observableArrayList();
        obListR.add("Single");
        obListR.add("Double");
        obListR.add("Triple");
        obListR.add("Quad");
        obListR.add("Queen");
        obListR.add("King");
        comRoomType.setItems(obListR);

        colName.setCellValueFactory(new PropertyValueFactory("Name"));
        colNIC.setCellValueFactory(new PropertyValueFactory("NIC"));
        colTel.setCellValueFactory(new PropertyValueFactory("TNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory("Email"));
        colAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        colMealPlane.setCellValueFactory(new PropertyValueFactory("MealPlane"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("RoomType"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllGust();

    }

    private void loadAllGust() {
        //table load
        ObservableList<GustTM> obList2 = FXCollections.observableArrayList();
        for (Gust G : gustArrayList) {
            Button btn = new Button("Delete");
            GustTM tm = new GustTM(G.getName(), G.getNIC(), G.getTNumber(), G.getEmail(), G.getAddress(), G.getMealPlane(), G.getRoomId(), G.getRoomType(), G.getCheckIn(), G.getCheckOut(),btn);
            obList2.add(tm);

            btn.setOnAction((e) -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are You SUre ?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.YES)) {
                    //delete

                    gustArrayList.remove(G);
                    obList2.remove(tm);

                }
            });
        }
            tblCustomer.setItems(obList2);

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Detail")) {
            //save
            Gust G1 = new Gust(
                    txtName.getText(),
                    txtNIC.getText(),
                    txtTel.getText(),
                    txtEmail.getText(),
                    txtAddress.getText(),
                    comSelectMeal.getValue().toString(),
                    txtRoomId.getText(),
                    comRoomType.getValue().toString(),
                    txtCheckIN.getText(),
                    txtCheckOut.getText()
            );
            gustArrayList.add(G1);
            loadAllGust();
        } else {
            //update
            for(Gust tm:gustArrayList){
                if(tm.getNIC().equals(txtNIC.getText())){
                    tm.setName(txtName.getText());
                    tm.setTNumber(txtTel.getText());
                    tm.setEmail(txtEmail.getText());
                    tm.setAddress(txtAddress.getText());
                    tm.setMealPlane(comSelectMeal.getValue().toString());
                    tm.setRoomId(txtRoomId.getText());
                    tm.setRoomType(comRoomType.getValue().toString());
                    tm.setCheckIn(txtCheckIN.getText());
                    tm.setCheckOut(txtCheckOut.getText());
                    loadAllGust();
                    return;
                }

            }
        }
    }

    public void btnTokanOnAction(ActionEvent actionEvent) throws IOException {
        setUi("GustBillFrom");

    }
}

