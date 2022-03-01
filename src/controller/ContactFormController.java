package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ContactFormController {
    public AnchorPane ContactContext;

    public void HomePageOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ContactContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }
}

