/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import entities.bcfff;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import services.bcfffService;

/**
 * FXML Controller class
 *
 * @author Khach
 */
public class ModifierPersonnelController implements Initializable {

    @FXML
    private TextField txtMatricule;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtCnss;
    @FXML
    private TextField txtSbase;
    @FXML
    private TextField txtLibelle;
    @FXML
    private TextField txtEffet1;
    @FXML
    private TextField txtEffet2;
    @FXML
    private TextField txtService;
    @FXML
    private DatePicker dateNaissance;
    @FXML
    private Button btnEnregister;
    @FXML
    private Button btnAnnuler;
    @FXML
    private DatePicker dateRec;
    
    bcfff bcf = new bcfff();
    @FXML
    private AnchorPane AnchorePaneProf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bcfffService bfs = new bcfffService();
        txtMatricule.setText(bcf.getMatricule());
        dateNaissance.setValue(LocalDate.now());
        dateRec.setValue(LocalDate.now());
        btnEnregister.setLayoutY(493);
            btnAnnuler.setLayoutY(493);
    }

public void loadUI(String ui) {
        AnchorPane root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui));
            AnchorePaneProf.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }    

    @FXML
    private void ModifierPersonnel(ActionEvent event) {
        if (txtMatricule.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Entrer la matricule", "Erreur", ERROR_MESSAGE);
        } else {
            bcfff bcff = new bcfff(bcf.getMatricule(), txtMatricule.getText() , txtNom.getText(), txtCin.getText() ,txtCnss.getText(), (java.sql.Date.valueOf(dateNaissance.getValue())), txtSbase.getText(), txtLibelle.getText(),(java.sql.Date.valueOf(dateRec.getValue())), txtEffet1.getText(), txtEffet2.getText(), txtService.getText());
            //int resultat = rs.UpdateReservation(r, txtEtat.getText());
            JOptionPane.showMessageDialog(null, "Mise à jour avec succées", "Success", INFORMATION_MESSAGE);
                    loadUI("Accueil.fxml");
                } 
                    JOptionPane.showMessageDialog(null, "Erreur produite", "Error", ERROR_MESSAGE);
    }

    @FXML
    private void Retour(ActionEvent event) {
        loadUI("Accueil.fxml");
    }
    
}
