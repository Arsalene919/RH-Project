/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import services.utilisateurService;
import tools.AttributeValide;

/**
 * FXML Controller class
 *
 * @author Khach
 */
public class SignInController implements Initializable {

    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnSignUp;
    @FXML
    private Label Error;
    @FXML
    private Label forgetpwd;
    AttributeValide at = new AttributeValide();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SignupPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = loader.load();
            AccueilController ac = loader.getController();
            btnSignUp.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Login(ActionEvent event) throws SQLException, IOException {
        String email = txtUserName.getText();
        String password = txtPassword.getText();

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Entrer le champs email!", "Erreur", ERROR_MESSAGE);

        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Entrer le champs password!", "Erreur", ERROR_MESSAGE);
        }else if(at.EmailVerified(email) == false) {
            JOptionPane.showMessageDialog(null, "Email format est invalide exemple : xyz@gmail.com", "Erreur", ERROR_MESSAGE);
        }else {
            utilisateurService us = new utilisateurService();
            String output = us.Seconnecter(email, password);
            if (output.isEmpty() == false) {
                Stage stage = (Stage) txtPassword.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
                    Parent root = loader.load();
                    Stage stageprofil = new Stage();
                    stageprofil.setTitle("Accueil");
                    stageprofil.setScene(new Scene(root, 1000, 600));
                    stageprofil.show();
            }
    }
    }

    @FXML
    private void redirect(MouseEvent event) {
    }
}
