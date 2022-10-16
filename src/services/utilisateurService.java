/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.utilisateur;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import tools.MyConnexion;

/**
 *
 * @author Khach
 */
public class utilisateurService {
    Connection cnx;
    
    public utilisateurService() {
        cnx = MyConnexion.getInstance().getCnx();
    }
    public static utilisateur currentUser = new utilisateur();
    
    public String Seconnecter(String userName, String password)throws IOException{
        String sql = "SELECT * FROM `utilisateur` WHERE userName =?";
        String result = "";
        try{
            PreparedStatement ste = cnx.prepareStatement(sql);

            ste.setString(1, userName);
            ResultSet rs = ste.executeQuery();
            if (rs.next()) {
                String pwd = rs.getString("password");
                utilisateur u = new utilisateur();
                u.setUserName(rs.getString("userName"));
                u.setPassword(rs.getString("password"));
                Session(u);
            }else{
                JOptionPane.showMessageDialog(null,"Le nom d'utilisateur est invalide", "Erreur", ERROR_MESSAGE);
            }
        
    }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
               return result;
    }

    public void Session(utilisateur u){
        currentUser.setIdUser(u.getIdUser());
        currentUser.setUserName(u.getUserName());
        currentUser.setPassword(u.getPassword());
    }
    
    public int ajouterUtilisateurs(utilisateur U) {//autoincrement
        int resultat = 0;
        String sql = "INSERT INTO `utilisateur`(`userName`, `password`) VALUES(?,?)";
        try{
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, U.getUserName());
            ste.setString(2, U.getPassword());
            int value = ste.executeUpdate();
                if (value > 0) {
                    System.out.println("Camper ajoutée avec succées");
                    resultat = 1;
                }
        }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        return resultat;
    }
    //Affichage de la table entiere 
    public List<utilisateur> afficherUtilisateur() {
        List<utilisateur> users = new ArrayList<>();
        String query = "Select idUser,userName,password from utilisateur";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                utilisateur u = new utilisateur();
                u.setIdUser(rs.getInt("idUser"));
                u.setUserName(rs.getString("userName"));
                u.setPassword(rs.getString("password"));
                users.add(u);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;

    }
   public boolean getUtilisateurByEmail(String username) {
        boolean exist = false;

        try {
            String sql = "SELECT * FROM utilisateur where userName=?";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, username);

            ResultSet rs = ste.executeQuery();//resultat requete sql
            if (rs.first()) {
                exist = true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return exist;

    }
   //Fonction de hachage mot de passe md5 
    public String mdpconvert(String p) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(p.getBytes());
            BigInteger pwd = new BigInteger(1, messageDigest);
            String hashpwd = pwd.toString(16);
            return hashpwd;

        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}    
    
