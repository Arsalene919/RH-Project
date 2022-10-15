/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.bcfff;
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
public class bcfffService {
    
    Connection  conn;
    
    public bcfffService(){
        conn = MyConnexion.getInstance().getCnx();
    }
    
    public int ajoutBcfff(bcfff b){
        String sql = "INSERT INTO `bcfff___a`(`Matricule`, `Nom`, `CNSS`, `DateNaissance`, `Sbase`, `Libelle`, `DateRec`, `Effet1`, `Effet2`, `Service`, `CIN`) VALUES (?,?,?,?,?)";
       try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, b.getMatricule());
            ste.setString(2, b.getNom());
            ste.setString(3, b.getCnss());
            ste.setDate(4, b.getDateNaissance());
            ste.setString(5, b.getSbase());
            ste.setString(6, b.getLibelle());
            ste.setDate(7, b.getDateRec());
            ste.setString(8, b.getEffet1());
            ste.setString(9, b.getEffet2());
            ste.setString(10, b.getService());
            ste.setString(11, b.getCIN());

            int value = ste.executeUpdate();
            if (value > 0) {
                System.out.println("Personnel added successfully");
                String query = "SELECT MAX(Matricule) from bcfff___a where Matricule=" + b.getMatricule();
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
    public List<bcfff> afficherBcfff() {
        List<bcfff> personnel = new ArrayList<>();
        String query = "SELECT * FROM `bcfff___a`";
        try {
            PreparedStatement ste = conn.prepareStatement(query);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                bcfff b = new bcfff();
                b.setMatricule(rs.getString("Matricule"));
                b.setNom(rs.getString("Nom"));
                b.setCnss(rs.getString("CNSS"));
                b.setDateNaissance(rs.getDate("DateNaissance"));
                b.setSbase(rs.getString("Sbase"));
                b.setLibelle(rs.getString("Libelle"));
                b.setDateRec(rs.getDate("DateRec"));
                b.setEffet1(rs.getString("Effet1"));
                b.setEffet2(rs.getString("Effet2"));
                b.setService(rs.getString("Service"));
                b.setCIN(rs.getString("CIN"));

                personnel.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnel;
    }
        public void UpdateBcfff(bcfff b, String Matricule) {
        String sql = "UPDATE `bcfff___a` SET `Matricule`=?,`CNSS`=?, `DateNaissance`=?, `Sbase`=?, `Libelle`=?, `DateRec`=?, `Effet1`=?, `Effet2`=?, `Service`=?, `CIN`=? "
                + " WHERE Matricule= ?";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, b.getMatricule());
            ste.setString(3, b.getCnss());
            ste.setDate(4, b.getDateNaissance());
            ste.setString(5, b.getSbase());
            ste.setString(6, b.getLibelle());
            ste.setDate(7, b.getDateRec());
            ste.setString(8, b.getEffet1());
            ste.setString(9, b.getEffet2());
            ste.setString(10, b.getService());
            ste.setString(11, b.getCIN());
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
        public void DeleteBcfff(String Matricule) {
        System.out.println(Matricule);
        String sql = "DELETE FROM `bcfff___a` WHERE Matricule=?";
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
    
