/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Khach
 */
public class sfaaa {
    
    public String Matricule, Nom, Cnss, DateNaissance, Sbase, Libelle,
            DateRec, Effet1, Effet2, Service, CIN;
    
    public sfaaa(){
    
    }

    public sfaaa(String Matricule, String Nom, String Cnss, String DateNaissance, String Sbase, String Libelle, String DateRec, String Effet1, String Effet2, String Service, String CIN) {
        this.Matricule = Matricule;
        this.Nom = Nom;
        this.Cnss = Cnss;
        this.DateNaissance = DateNaissance;
        this.Sbase = Sbase;
        this.Libelle = Libelle;
        this.DateRec = DateRec;
        this.Effet1 = Effet1;
        this.Effet2 = Effet2;
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

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(String DateNaissance) {
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

    public String getDateRec() {
        return DateRec;
    }

    public void setDateRec(String DateRec) {
        this.DateRec = DateRec;
    }

    public String getEffet1() {
        return Effet1;
    }

    public void setEffet1(String Effet1) {
        this.Effet1 = Effet1;
    }

    public String getEffet2() {
        return Effet2;
    }

    public void setEffet2(String Effet2) {
        this.Effet2 = Effet2;
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
        return "sfaaa{" + "Matricule=" + Matricule + ", Nom=" + Nom + ", Cnss=" + Cnss + ", DateNaissance=" + DateNaissance + ", Sbase=" + Sbase + ", Libelle=" + Libelle + ", DateRec=" + DateRec + ", Effet1=" + Effet1 + ", Effet2=" + Effet2 + ", Service=" + Service + ", CIN=" + CIN + '}';
    }
    
    
    
}
