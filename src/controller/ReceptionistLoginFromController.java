package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceptionistLoginFromController {
    public PasswordField pwdPassword;
    public TextField txtUserName;
    public AnchorPane ReceptionistFromContext;
    int attempts = 0;

    public void OkOnAction(ActionEvent actionEvent) throws IOException {
        attempts++;
        if (attempts <= 5) {
            //login(username & password are correct)
            if (txtUserName.getText().equals("Receptionist") && pwdPassword.getText().equals("1234")) {
                //ReceptionistLoginMenuFrom load
                 Stage stage = (Stage) ReceptionistFromContext.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistLoginMenuFrom.fxml"))));
            }

            //login(username is correct password are incorrect)
            else if (txtUserName.getText().equals("Receptionist") && !pwdPassword.getText().equals("1234")) {
                new Alert(Alert.AlertType.WARNING, "Your password is wrong!\nYou Have 5 time trys and this is " + attempts + ".").show();
            }

            //login(username are incorrect password are correct)
            else if (!txtUserName.getText().equals("Receptionist") && pwdPassword.getText().equals("1234")) {
                new Alert(Alert.AlertType.WARNING, "Your username is wrong!\nYou Have 5 time trys and this is " + attempts + ".").show();
            } else {
                //try again
                new Alert(Alert.AlertType.WARNING, "Your username and password is incorrect.!\nYou Have 5 time trys and this is " + attempts + ".").show();
            }
        } else {
            txtUserName.setEditable(false);
            pwdPassword.setEditable(false);
            new Alert(Alert.AlertType.WARNING, "Account is Temporarily Disabled or You Did not Sign in Correctly. ").show();
        }

    }

    public void CancelOnAction(ActionEvent actionEvent) {
        txtUserName.setText("");
        pwdPassword.setText("");
    }

    public void homeOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ReceptionistFromContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }
}

