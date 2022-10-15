/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.bcfffService;

/**
 * FXML Controller class
 *
 * @author Khach
 */
public class AjoutPersonnelController implements Initializable {

    @FXML
    private Button btnEnregister;
    @FXML
    private Button btnAnnuler;
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
    private DatePicker dateRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setBtnAnnuler(Button btnAnnuler) {
        this.btnAnnuler = btnAnnuler;
    }

    public void setBtnEnregistrer(Button btnEnregistrer) {
        this.btnEnregister = btnEnregistrer;
    }

    @FXML
    private void AjouterPersonnel(ActionEvent event) {
        StringBuilder errors = new StringBuilder();
        DatePicker dateRe = new DatePicker();
       // Setting the minimum date available in the calendar
           dateRe.setValue(LocalDate.now());
            dateRe.setDayCellFactory(DatePicker -> new DateCell() {
        @Override
        public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
            LocalDate today = LocalDate.now();
            setDisable(empty || date.compareTo(today) < 0 );
        }
    });
            String Matricule = txtMatricule.getText();
            String Nom = txtNom.getText();
            String CIN = txtCin.getText();
            String CNSS = txtCnss.getText();
            String Sbase = txtSbase.getText();
            String Libelle = txtLibelle.getText();
            String Effet1 = txtEffet1.getText();
            String Effet2 = txtEffet2.getText();
            String Service = txtService.getText();
            bcfff bf = new bcfff(Matricule, Nom, CIN, CNSS, (java.sql.Date.valueOf(dateNaissance.getValue())), Sbase, Libelle, (java.sql.Date.valueOf(dateRec.getValue())), Effet1, Effet2, Service);
            bcfffService bfs = new bcfffService();
            bfs.ajoutBcfff(bf);
            JOptionPane.showMessageDialog(null, "Ajouter effectué avec succès");
            
    }

    @FXML
    private void Retour(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
            Parent root = loader.load();
            AccueilController ac = loader.getController();
            btnAnnuler.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
