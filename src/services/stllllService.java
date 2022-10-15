/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.stllll;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tools.MyConnexion;

/**
 *
 * @author Khach
 */
public class stllllService {
    Connection  conn;
    
    public stllllService(){
        conn = MyConnexion.getInstance().getCnx();
    }
    
    public int ajoutStllll(stllll stl){
        String sql = "INSERT INTO `stllll___a`(`Matricule`, `Nom`, `CNSS`, `DateNaissance`, `Sbase`, `Libelle`, `DateRec`, `Effet1`, `Effet2`, `Service`, `CIN`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, stl.getMatricule());
            ste.setString(2, stl.getNom());
            ste.setString(3, stl.getCnss());
            ste.setString(4, stl.getDateNaissance());
            ste.setString(5, stl.getSbase());
            ste.setString(6, stl.getLibelle());
            ste.setString(7, stl.getDateRec());
            ste.setString(8, stl.getEffet1());
            ste.setString(9, stl.getEffet2());
            ste.setString(10, stl.getService());
            ste.setString(11, stl.getCIN());

            int value = ste.executeUpdate();
            if (value > 0) {
                System.out.println("Personnel added successfully");
                String query = "SELECT MAX(Matricule) from stllll___a where Matricule=" + stl.getMatricule();
                PreparedStatement ste2 = conn.prepareStatement(query);

                ResultSet rs = ste2.executeQuery();//resultat requete sql
                if (rs.next()) {
                    //Matricule = rs.getString(1);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return 0;

    }
    
    public List<stllll> afficherStllll() {
        List<stllll> personnel = new ArrayList<>();
        String query = "SELECT * FROM `stllll___a`";
        try {
            PreparedStatement ste = conn.prepareStatement(query);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                stllll stl = new stllll();
                stl.setMatricule(rs.getString("Matricule"));
                stl.setNom(rs.getString("Nom"));
                stl.setCnss(rs.getString("CNSS"));
                stl.setDateNaissance(rs.getString("DateNaissance"));
                stl.setSbase(rs.getString("Sbase"));
                stl.setLibelle(rs.getString("Libelle"));
                stl.setDateRec(rs.getString("DateRec"));
                stl.setEffet1(rs.getString("Effet1"));
                stl.setEffet2(rs.getString("Effet2"));
                stl.setService(rs.getString("Service"));
                stl.setCIN(rs.getString("CIN"));

                personnel.add(stl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnel;
    }
    
     public void UpdateStllll(stllll stl, String Matricule) {
        String sql = "UPDATE `stllll___a` SET `Matricule`=?,`CNSS`=?, `DateNaissance`=?, `Sbase`=?, `Libelle`=?, `DateRec`=?, `Effet1`=?, `Effet2`=?, `Service`=?, `CIN`=? "
                + " WHERE Matricule= ?";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, stl.getMatricule());
            ste.setString(3, stl.getCnss());
            ste.setString(4, stl.getDateNaissance());
            ste.setString(5, stl.getSbase());
            ste.setString(6, stl.getLibelle());
            ste.setString(7, stl.getDateRec());
            ste.setString(8, stl.getEffet1());
            ste.setString(9, stl.getEffet2());
            ste.setString(10, stl.getService());
            ste.setString(11, stl.getCIN());
            ste.setString(2, Matricule);
            ste.executeUpdate();
            System.out.println("Personnel updated");
            System.out.println("here");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println("here");
        }

    }
        public void DeleteStllll(String Matricule) {
        System.out.println(Matricule);
        String sql = "DELETE FROM `stllll___a` WHERE Matricule=?";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, Matricule);
            ste.execute();
            System.out.println("Personnel deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
