/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.sall;
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
public class sallService {
    
    Connection  conn;
    
    public sallService(){
        conn = MyConnexion.getInstance().getCnx();
    }
    
    public int ajoutSall(sall s){
        String sql = "INSERT INTO `sall___a`(`Matricule`, `Nom`, `CNSS`, `DateNaissance`, `Sbase`, `Libelle`, `DateRec`, `Effet1`, `Effet2`, `Service`, `CIN`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, s.getMatricule());
            ste.setString(2, s.getNom());
            ste.setString(3, s.getCnss());
            ste.setString(4, s.getDateNaissance());
            ste.setString(5, s.getSbase());
            ste.setString(6, s.getLibelle());
            ste.setString(7, s.getDateRec());
            ste.setString(8, s.getEffet1());
            ste.setString(9, s.getEffet2());
            ste.setString(10, s.getService());
            ste.setString(11, s.getCIN());

            int value = ste.executeUpdate();
            if (value > 0) {
                System.out.println("Personnel added successfully");
                String query = "SELECT MAX(Matricule) from sall___a where Matricule=" + s.getMatricule();
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
    
    public List<sall> afficherSall() {
        List<sall> personnel = new ArrayList<>();
        String query = "SELECT * FROM `sall___a`";
        try {
            PreparedStatement ste = conn.prepareStatement(query);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                sall s = new sall();
                s.setMatricule(rs.getString("Matricule"));
                s.setNom(rs.getString("Nom"));
                s.setCnss(rs.getString("CNSS"));
                s.setDateNaissance(rs.getString("DateNaissance"));
                s.setSbase(rs.getString("Sbase"));
                s.setLibelle(rs.getString("Libelle"));
                s.setDateRec(rs.getString("DateRec"));
                s.setEffet1(rs.getString("Effet1"));
                s.setEffet2(rs.getString("Effet2"));
                s.setService(rs.getString("Service"));
                s.setCIN(rs.getString("CIN"));

                personnel.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnel;
    }
    
     public void UpdateSall(sall s, String Matricule) {
        String sql = "UPDATE `sall___a` SET `Matricule`=?,`CNSS`=?, `DateNaissance`=?, `Sbase`=?, `Libelle`=?, `DateRec`=?, `Effet1`=?, `Effet2`=?, `Service`=?, `CIN`=? "
                + " WHERE Matricule= ?";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, s.getMatricule());
            ste.setString(3, s.getCnss());
            ste.setString(4, s.getDateNaissance());
            ste.setString(5, s.getSbase());
            ste.setString(6, s.getLibelle());
            ste.setString(7, s.getDateRec());
            ste.setString(8, s.getEffet1());
            ste.setString(9, s.getEffet2());
            ste.setString(10, s.getService());
            ste.setString(11, s.getCIN());
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
        public void DeleteSall(String Matricule) {
        System.out.println(Matricule);
        String sql = "DELETE FROM `sall___a` WHERE Matricule=?";
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
