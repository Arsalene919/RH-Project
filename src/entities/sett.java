/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Khach
 */
public class sett {
    public String Matricule, Nom, Cnss, Sbase, Libelle,
             Service, CIN;
    public Date DateNaissance,DateRec1,DateRec2;
    
    public sett(){
        
    }

    public sett(String Matricule, String Nom, String Cnss, Date DateNaissance, String Sbase, String Libelle, Date DateRec1, Date DateRec2, String Service, String CIN) {
        this.Matricule = Matricule;
        this.Nom = Nom;
        this.Cnss = Cnss;
        this.DateNaissance = DateNaissance;
        this.Sbase = Sbase;
        this.Libelle = Libelle;
        this.DateRec1 = DateRec1;
        this.DateRec2 = DateRec2;
        this.Service = Service;
        this.CIN = CIN;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getCnss() {
        return Cnss;
    }

    public void setCnss(String Cnss) {
        this.Cnss = Cnss;
    }

    public Date getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(Date DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public String getSbase() {
        return Sbase;
    }

    public void setSbase(String Sbase) {
        this.Sbase = Sbase;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public Date getDateRec1() {
        return DateRec1;
    }

    public void setDateRec1(Date DateRec) {
        this.DateRec1 = DateRec1;
    }

    public Date getDateRec2() {
        return DateRec2;
    }

    public void setDateRec2(Date DateRec2) {
        this.DateRec2 = DateRec2;
    }

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    @Override
    public String toString() {
        return "sett{" + "Matricule=" + Matricule + ", Nom=" + Nom + ", Cnss=" + Cnss + ", DateNaissance=" + DateNaissance + ", Sbase=" + Sbase + ", Libelle=" + Libelle + ", DateRec1=" + DateRec1 + ", DateRec2=" + DateRec2 + ", Service=" + Service + ", CIN=" + CIN + '}';
    }
    
    
}
