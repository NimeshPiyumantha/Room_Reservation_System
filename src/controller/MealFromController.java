package controller;

import com.jfoenix.controls.JFXButton;
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
import model.Meal;
import view.tm.MealTM;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class MealFromController {
    public AnchorPane mealPackageContext;
    public TableView tblMeal;
    public TableColumn colPlane;
    public TableColumn colPrice;
    public TableColumn colBreakfast;
    public TableColumn colLunch;
    public TableColumn colEvening;
    public TableColumn colDinner;
    public TableColumn colOption;
    public JFXTextField txtName;
    public JFXTextField txtPrice;
    public ComboBox cmbEvening;
    public ComboBox cmbLunch;
    public ComboBox cmbDinner;
    public ComboBox cmbBreakfast;
    public JFXButton btnSave;

    public static ArrayList<Meal> mealArrayList=new ArrayList();
    static {
        mealArrayList.add(new Meal("European", 2000.0,"Yes","No","Yes","Yes"));
        mealArrayList.add(new Meal("Continental",2500.0,"Yes","Yes","No","Yes"));
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

    private void setUi(String location) throws IOException {
        Stage stage  =(Stage) mealPackageContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Details");
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Details")) {
            //save
            Meal c1 = new Meal(
                    txtName.getText(),
                    Double.parseDouble(txtPrice.getText()),
                    cmbBreakfast.getValue().toString(),
                    cmbLunch.getValue().toString(),
                    cmbEvening.getValue().toString(),
                    cmbDinner.getValue().toString()
            );
            mealArrayList.add(c1);
            loadAllMeal();
        } else {
            //update
            for(Meal tm:mealArrayList){
                if(tm.getMealPlanName().equals(txtName.getText())){
                    tm.setBreakfast(cmbBreakfast.getValue().toString());
                    tm.setLunch(cmbLunch.getValue().toString());
                    tm.setEvening(cmbEvening.getValue().toString());
                    tm.setPrice(Double.parseDouble(txtPrice.getText()));
                    tm.setDinner(cmbDinner.getValue().toString());

                    loadAllMeal();
                    return;
                }

            }
        }

    }
    public void initialize() {
        colPlane.setCellValueFactory(new PropertyValueFactory("MealPlanName"));
        colPrice.setCellValueFactory(new PropertyValueFactory("Price"));
        colBreakfast.setCellValueFactory(new PropertyValueFactory("Breakfast"));
        colLunch.setCellValueFactory(new PropertyValueFactory("Lunch"));
        colEvening.setCellValueFactory(new PropertyValueFactory("Evening"));
        colDinner.setCellValueFactory(new PropertyValueFactory("Dinner"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllMeal();

        tblMeal.getSelectionModel().selectedItemProperty()
                .addListener((observable , oldValue,newValue) -> {
                    if (newValue !=null) {
                        setData((MealTM) newValue);
                    }
                });

        ObservableList<String> obListB = FXCollections.observableArrayList();
        obListB.add("Yes");
        obListB.add("No");
        cmbBreakfast.setItems(obListB);

        ObservableList<String> obListE = FXCollections.observableArrayList();
        obListE.add("Yes");
        obListE.add("No");
        cmbEvening.setItems(obListE);

        ObservableList<String> obListL = FXCollections.observableArrayList();
        obListL.add("Yes");
        obListL.add("No");
        cmbLunch.setItems(obListL);

        ObservableList<String> obListD = FXCollections.observableArrayList();
        obListD.add("Yes");
        obListD.add("No");
        cmbDinner.setItems(obListD);
    }

    private void setData(MealTM tm) {
        btnSave.setText("Update Details");
        txtName.setText(tm.getMealPlanName());
        txtPrice.setText(String.valueOf(tm.getPrice()));
        cmbBreakfast.setValue(tm.getBreakfast());
        cmbLunch.setValue(tm.getLunch());
        cmbEvening.setValue(tm.getEvening());
        cmbDinner.setValue(tm.getDinner());
    }

    private void loadAllMeal() {
        //table load
        ObservableList<MealTM> obList = FXCollections.observableArrayList();

        for (Meal c : mealArrayList) {
            Button btn = new Button("Delete");
            MealTM tm = new MealTM(c.getMealPlanName(), c.getPrice(), c.getBreakfast(), c.getLunch(),c.getEvening(),c.getDinner(), btn);
            obList.add(tm);

            btn.setOnAction((e) -> {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are You SUre ?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.YES)) {
                    //delete

                    mealArrayList.remove(c);
                    obList.remove(tm);
                }
            });
        }
        tblMeal.setItems(obList);
    }

}
