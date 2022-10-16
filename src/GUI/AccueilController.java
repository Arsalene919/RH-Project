/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.bcfff;
import entities.sall;
import entities.sett;
import entities.sfaaa;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;
import services.bcfffService;
import services.sallService;
import services.settService;
import services.sfaaaService;
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
    sall sal = new sall();
    sallService sals = new sallService();
    sett set = new sett();
    settService sets = new settService();
    sfaaa sfa = new sfaaa();
    sfaaaService sfas = new sfaaaService();
    
    ObservableList <bcfff> bcf = FXCollections.observableArrayList();
    ObservableList <sall> salL = FXCollections.observableArrayList();
    ObservableList <sett> settt = FXCollections.observableArrayList();
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
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;

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
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void AfficherSall(ActionEvent event) {
        try {
           Connection con =MyConnexion.getInstance().getCnx();
           ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `sall___a`");
            
           
            
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
            System.out.println(ex.getMessage());;
        }
    }

    @FXML
    private void AfficherSett(ActionEvent event) {
        List<sett> listsett = sets.afficherSett();
        for (sett sett1 : listsett) {
            settt.add(sett1);
        }
        //table.setItems(settt);
        try {
           Connection con =MyConnexion.getInstance().getCnx();
           ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `sett___a`");
            
           
            
            while (rs.next()){
                settt.add(new sett(
                      
                        rs.getString("Matricule"),
                        rs.getString("Nom"),
                        rs.getString("Cnss"),
                        rs.getDate("DateNaissance"),
                        rs.getString("Sbase"),
                        rs.getString("Libelle"),
                        rs.getDate("DateRec1"),
                        rs.getDate("DateRec2"),
                        rs.getString("Service"),
                        rs.getString("CIN")
                        
                    
                        
                ));
               
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
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

    @FXML
    private void ModifierPersonnel(ActionEvent event) {
        Connection con = MyConnexion.getInstance().getCnx();
        bf = table.getSelectionModel().getSelectedItem();
        int input = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier ?", "Choisir une option...",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierPersonnel.fxml"));
            Parent root = loader.load();
            AccueilController ac = loader.getController();
            btnAdd.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ChercherPersonnel(ActionEvent event) {
    }
    
    public void loadData() {
        Connection con = MyConnexion.getInstance().getCnx();
        //refreshTable();
        bcf.removeAll(bcf);
        bcf.addAll();
        table.setItems(bcf);

    }

    @FXML
    private void SupprimerPersonnel(ActionEvent event) {
        Connection con =MyConnexion.getInstance().getCnx();
        bf = table.getSelectionModel().getSelectedItem();
        int input = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer ?", "Choisir une option...",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

        // 0=yes, 1=no, 2=cancel
        if (input == 0) {
            bfs.DeleteBcfff(bf.getMatricule()); 
            loadData();
        } else if (input == 1) {
            loadData();

        }
    }

    @FXML
    private void AjouterPersonnel(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterPersonnel.fxml"));
            Parent root = loader.load();
            AccueilController ac = loader.getController();
            btnAdd.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    
}
