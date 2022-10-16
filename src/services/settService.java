/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.sall;
import entities.sett;
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
public class settService {
    Connection  conn;
    
    public settService(){
        conn = MyConnexion.getInstance().getCnx();
    }
    
    public int ajoutSett(sett st){
        String sql = "INSERT INTO `sett___a`(`Matricule`, `Nom`, `CNSS`, `DateNaissance`, `Sbase`, `Libelle`, `DateRec1`, `DateRec2`, `Service`, `CIN`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, st.getMatricule());
            ste.setString(2, st.getNom());
            ste.setString(3, st.getCnss());
            ste.setDate(4, st.getDateNaissance());
            ste.setString(5, st.getSbase());
            ste.setString(6, st.getLibelle());
            ste.setDate(7, st.getDateRec1());
            ste.setDate(8, st.getDateRec2());
            ste.setString(10, st.getService());
            ste.setString(11, st.getCIN());

            int value = ste.executeUpdate();
            if (value > 0) {
                System.out.println("Personnel added successfully");
                String query = "SELECT MAX(Matricule) from sett___a where Matricule=" + st.getMatricule();
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
    
    public List<sett> afficherSett() {
        List<sett> personnel = new ArrayList<>();
        String query = "SELECT * FROM `sett___a`";
        try {
            PreparedStatement ste = conn.prepareStatement(query);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                sett st = new sett();
                st.setMatricule(rs.getString("Matricule"));
                st.setNom(rs.getString("Nom"));
                st.setCnss(rs.getString("CNSS"));
                st.setDateNaissance(rs.getDate("DateNaissance"));
                st.setSbase(rs.getString("Sbase"));
                st.setLibelle(rs.getString("Libelle"));
                st.setDateRec1(rs.getDate("DateRec1"));
                st.setDateRec2(rs.getDate("DateRec2"));
                st.setService(rs.getString("Service"));
                st.setCIN(rs.getString("CIN"));

                personnel.add(st);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnel;
    }
    
     public void UpdateSett(sett st, String Matricule) {
        String sql = "UPDATE `sett___a` SET `Matricule`=?,`CNSS`=?, `DateNaissance`=?, `Sbase`=?, `Libelle`=?, `DateRec`=?, `Effet1`=?, `Effet2`=?, `Service`=?, `CIN`=? "
                + " WHERE Matricule= ?";
        try {
            PreparedStatement ste = conn.prepareStatement(sql);
            ste.setString(1, st.getMatricule());
            ste.setString(3, st.getCnss());
            ste.setDate(4, st.getDateNaissance());
            ste.setString(5, st.getSbase());
            ste.setString(6, st.getLibelle());
            ste.setDate(7, st.getDateRec1());
            ste.setDate(8, st.getDateRec2());
            ste.setString(10, st.getService());
            ste.setString(11, st.getCIN());
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
        public void DeleteSett(String Matricule) {
        System.out.println(Matricule);
        String sql = "DELETE FROM `sett___a` WHERE Matricule=?";
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
