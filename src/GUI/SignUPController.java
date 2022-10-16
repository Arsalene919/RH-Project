/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static jdk.internal.vm.ThreadContainers.root;
import services.utilisateurService;
import tools.AttributeValide;

/**
 * FXML Controller class
 *
 * @author Khach
 */
public class SignUPController implements Initializable {

    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnSignup;
    @FXML
    private Button btnSignIn;
    AttributeValide at = new AttributeValide();
    utilisateurService us = new utilisateurService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SigninPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = loader.load();
            AccueilController ac = loader.getController();
            btnSignIn.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Signup(ActionEvent event) throws IOException {
        utilisateur u = new utilisateur();
        if ((txtUserName.getText()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le nom d'utilisateur est un champs obligatoire", "Error", ERROR_MESSAGE);
        }
        if ((txtPassword.getText()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le mot de passe est un champs obligatoire", "Error", ERROR_MESSAGE);
        } else if (at.EmailVerified(txtUserName.getText()) == false) {
            JOptionPane.showMessageDialog(null, "l'email doit etre comme xyz@abc.com", "Error", ERROR_MESSAGE);
        } else if (us.getUtilisateurByEmail(txtUserName.getText()) == true) {
            JOptionPane.showMessageDialog(null, "l'email est utilisé déjà ! Inserer un autre", "Error", ERROR_MESSAGE);
        } else {
            if (txtUserName.getText().isEmpty() == false && txtPassword.getText().isEmpty() == false) {
                utilisateur user = new utilisateur(0, txtUserName.getText(), txtPassword.getText());
                int resultat = us.ajouterUtilisateurs(user);
                if (resultat == 1) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
                    Parent root = loader.load();
                    AccueilController ac = loader.getController();
                    btnSignup.getScene().setRoot(root);
                }
            } else {
                JOptionPane.showMessageDialog(null, " Inserer le champ  vide", "Error", ERROR_MESSAGE);

            }
        }
    }

}
