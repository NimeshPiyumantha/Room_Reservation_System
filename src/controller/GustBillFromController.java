package controller;

import com.jfoenix.controls.JFXTextField;
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
import java.util.ArrayList;


public class GustBillFromController {
    public JFXTextField txtSubTotal;
    public JFXTextField txtTax;
    public JFXTextField txtOther;
    public JFXTextField txtTotal;
    public TableColumn colService;
    public TableColumn colUnitCost;
    public TableColumn colQty;
    public TableColumn colBalance;
    public TableView tblBill;
    public JFXTextField txtInvoiceDate;
    public AnchorPane BillContext;
    public JFXTextField txtInvoiceNIC;
    public JFXTextField txtInvoiceRNO;

    public static ArrayList<Gust> gustArrayList1 = ReserveRoomFromController.gustArrayList;

    public void btnPrintOnaction(ActionEvent actionEvent) throws IOException {
        new Alert(Alert.AlertType.CONFIRMATION, "Gust Bil is print.").show();
        Stage stage = (Stage) BillContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReserveRoomFrom.fxml"))));
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        new Alert(Alert.AlertType.CONFIRMATION, "Gust Bil is send Email.").show();
        Stage stage = (Stage) BillContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReserveRoomFrom.fxml"))));
    }

    public void initialize() {
        colService.setCellValueFactory(new PropertyValueFactory("RoomType"));
        colUnitCost.setCellValueFactory(new PropertyValueFactory("1"));
        colQty.setCellValueFactory(new PropertyValueFactory("1"));
        colBalance.setCellValueFactory(new PropertyValueFactory("Balance"));

        loadAllGust();

    }

    private void loadAllGust() {
        //table load
        ObservableList<GustTM> obList2 = FXCollections.observableArrayList();
        for (Gust G : gustArrayList1) {
            Button btn = null;
            GustTM tm = new GustTM(G.getName(), G.getNIC(), G.getTNumber(), G.getEmail(), G.getAddress(), G.getMealPlane(), G.getRoomId(), G.getRoomType(), G.getCheckIn(), G.getCheckOut(), btn);
            obList2.add(tm);
            obList2.remove(tm);

        }

        tblBill.setItems(obList2);

        }
}
