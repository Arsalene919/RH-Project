/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.bcfff;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import services.bcfffService;
import tools.MyConnexion;

/**
 * FXML Controller class
 *
 * @author Khach
 */
public class AccueilController implements Initializable {

    @FXML
    private TableView<bcfff> table;
    @FXML
    private Button ExitButton;
    
    bcfff bf = new bcfff();
    bcfffService bfs = new bcfffService();
    ObservableList <bcfff> bcf = FXCollections.observableArrayList();
    @FXML
    private TableColumn<bcfff, String> txtMatricule;
    @FXML
    private TableColumn<bcfff, String> txtNom;
    @FXML
    private TableColumn<bcfff, String> txtCnss;
    @FXML
    private TableColumn<bcfff, String> txtDateNaissance;
    @FXML
    private TableColumn<bcfff, String> txtSbase;
    @FXML
    private TableColumn<bcfff, String> txtLibelle;
    @FXML
    private TableColumn<bcfff, String> txtDateRec;
    @FXML
    private TableColumn<bcfff, String> txtEffet1;
    @FXML
    private TableColumn<bcfff, String> txtEffet2;
    @FXML
    private TableColumn<bcfff, String> txtService;
    @FXML
    private TableColumn<bcfff, String> txtCin;
    @FXML
    private Button btnBcfff;
    @FXML
    private Button btnSall;
    @FXML
    private Button btnSett;
    @FXML
    private Button btnSfaaa;
    @FXML
    private Button btnSftt;
    @FXML
    private Button btnStllll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<bcfff> listbcfff = bfs.afficherBcfff();
        for (bcfff bcff : listbcfff) {
            bcf.add(bcff);
        }
        table.setItems(bcf);
    }

    @FXML
    private void AfficherBcfff(ActionEvent event) {
        
        try {
           Connection con =MyConnexion.getInstance().getCnx();
           ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `bcfff___a`");
            
           
            
            while (rs.next()){
                bcf.add(new bcfff(
                      
                        rs.getString("Matricule"),
                        rs.getString("Nom"),
                        rs.getString("Cnss"),
                        rs.getDate("DateNaissance"),
                        rs.getString("Sbase"),
                        rs.getString("Libelle"),
                        rs.getDate("DateRec"),
                        rs.getString("Effet1"),
                        rs.getString("Effet2"),
                        rs.getString("Service"),
                        rs.getString("CIN")
                        
                    
                        
                ));
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AfficherSall(ActionEvent event) {
    }

    @FXML
    private void AfficherSett(ActionEvent event) {
    }

    @FXML
    private void AfficherSfaaa(ActionEvent event) {
    }

    @FXML
    private void AfficherSftt(ActionEvent event) {
    }

    @FXML
    private void AfficherStllll(ActionEvent event) {
    }
        
    
}
