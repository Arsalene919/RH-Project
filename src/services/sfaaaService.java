/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.sfaaa;
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
public class sfaaaService {
    Connection  conn;
    
    public sfaaaService(){
        conn = MyConnexion.getInstance().getCnx();
    }
    
    public int ajoutSfaaa(sfaaa sf){
        String sql = "INSERT INTO `sfaaa___a`(`Matricule`, `Nom`, `CNSS`, `DateNaissance`, `Sbase`, `Libelle`, `DateRec`, `Effet1`, `Effet2`, `Service`, `CIN`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, sf.getMatricule());
            ste.setString(2, sf.getNom());
            ste.setString(3, sf.getCnss());
            ste.setDate(4, sf.getDateNaissance());
            ste.setString(5, sf.getSbase());
            ste.setString(6, sf.getLibelle());
            ste.setDate(7, sf.getDateRec());
            ste.setString(8, sf.getEffet1());
            ste.setString(9, sf.getEffet2());
            ste.setString(10, sf.getService());
            ste.setString(11, sf.getCIN());

            int value = ste.executeUpdate();
            if (value > 0) {
                System.out.println("Personnel added successfully");
                String query = "SELECT MAX(Matricule) from sfaaa___a where Matricule=" + sf.getMatricule();
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
    
    public List<sfaaa> afficherSfaaa() {
        List<sfaaa> personnel = new ArrayList<>();
        String query = "SELECT * FROM `sfaaa___a`";
        try {
            PreparedStatement ste = conn.prepareStatement(query);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                sfaaa sf = new sfaaa();
                sf.setMatricule(rs.getString("Matricule"));
                sf.setNom(rs.getString("Nom"));
                sf.setCnss(rs.getString("CNSS"));
                sf.setDateNaissance(rs.getDate("DateNaissance"));
                sf.setSbase(rs.getString("Sbase"));
                sf.setLibelle(rs.getString("Libelle"));
                sf.setDateRec(rs.getDate("DateRec"));
                sf.setEffet1(rs.getString("Effet1"));
                sf.setEffet2(rs.getString("Effet2"));
                sf.setService(rs.getString("Service"));
                sf.setCIN(rs.getString("CIN"));

                personnel.add(sf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnel;
    }
    
     public void UpdateSfaaa(sfaaa sf, String Matricule) {
        String sql = "UPDATE `sfaaa___a` SET `Matricule`=?,`CNSS`=?, `DateNaissance`=?, `Sbase`=?, `Libelle`=?, `DateRec`=?, `Effet1`=?, `Effet2`=?, `Service`=?, `CIN`=? "
                + " WHERE Matricule= ?";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, sf.getMatricule());
            ste.setString(3, sf.getCnss());
            ste.setDate(4, sf.getDateNaissance());
            ste.setString(5, sf.getSbase());
            ste.setString(6, sf.getLibelle());
            ste.setDate(7, sf.getDateRec());
            ste.setString(8, sf.getEffet1());
            ste.setString(9, sf.getEffet2());
            ste.setString(10, sf.getService());
            ste.setString(11, sf.getCIN());
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
        public void DeleteSfaaa(String Matricule) {
        System.out.println(Matricule);
        String sql = "DELETE FROM `sfaaa___a` WHERE Matricule=?";
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
