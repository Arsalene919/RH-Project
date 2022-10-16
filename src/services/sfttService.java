/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.sfaaa;
import entities.sftt;
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
public class sfttService {
    Connection  conn;
    
    public sfttService(){
        conn = MyConnexion.getInstance().getCnx();
    }
    
    public int ajoutSfaaa(sftt sft){
        String sql = "INSERT INTO `sftt___a`(`Matricule`, `Nom`, `CNSS`, `DateNaissance`, `Sbase`, `Libelle`, `DateRec`, `Effet1`, `Effet2`, `Service`, `CIN`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, sft.getMatricule());
            ste.setString(2, sft.getNom());
            ste.setString(3, sft.getCnss());
            ste.setDate(4, sft.getDateNaissance());
            ste.setString(5, sft.getSbase());
            ste.setString(6, sft.getLibelle());
            ste.setDate(7, sft.getDateRec());
            ste.setString(8, sft.getEffet1());
            ste.setString(9, sft.getEffet2());
            ste.setString(10, sft.getService());
            ste.setString(11, sft.getCIN());

            int value = ste.executeUpdate();
            if (value > 0) {
                System.out.println("Personnel added successfully");
                String query = "SELECT MAX(Matricule) from sftt___a where Matricule=" + sft.getMatricule();
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
    
    public List<sftt> afficherSftt() {
        List<sftt> personnel = new ArrayList<>();
        String query = "SELECT * FROM `sftt___a`";
        try {
            PreparedStatement ste = conn.prepareStatement(query);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                sftt sft = new sftt();
                sft.setMatricule(rs.getString("Matricule"));
                sft.setNom(rs.getString("Nom"));
                sft.setCnss(rs.getString("CNSS"));
                sft.setDateNaissance(rs.getDate("DateNaissance"));
                sft.setSbase(rs.getString("Sbase"));
                sft.setLibelle(rs.getString("Libelle"));
                sft.setDateRec(rs.getDate("DateRec"));
                sft.setEffet1(rs.getString("Effet1"));
                sft.setEffet2(rs.getString("Effet2"));
                sft.setService(rs.getString("Service"));
                sft.setCIN(rs.getString("CIN"));

                personnel.add(sft);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnel;
    }
    
     public void UpdateSftt(sftt sft, String Matricule) {
        String sql = "UPDATE `sftt___a` SET `Matricule`=?,`CNSS`=?, `DateNaissance`=?, `Sbase`=?, `Libelle`=?, `DateRec`=?, `Effet1`=?, `Effet2`=?, `Service`=?, `CIN`=? "
                + " WHERE Matricule= ?";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, sft.getMatricule());
            ste.setString(3, sft.getCnss());
            ste.setDate(4, sft.getDateNaissance());
            ste.setString(5, sft.getSbase());
            ste.setString(6, sft.getLibelle());
            ste.setDate(7, sft.getDateRec());
            ste.setString(8, sft.getEffet1());
            ste.setString(9, sft.getEffet2());
            ste.setString(10, sft.getService());
            ste.setString(11, sft.getCIN());
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
        public void DeleteSftt(String Matricule) {
        System.out.println(Matricule);
        String sql = "DELETE FROM `sftt___a` WHERE Matricule=?";
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
