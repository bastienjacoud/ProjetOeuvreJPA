package com.epul.oeuvres.metier;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "oeuvrevente", schema = "baseoeuvre", catalog = "")
public class OeuvreventeEntity {
    private int idOeuvrevente;
    private String titreOeuvrevente;
    private String etatOeuvrevente;
    private double prixOeuvrevente;
    //private int idProprietaire;

    @Id
    @Column(name = "id_oeuvrevente")
    public int getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(int idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    @Basic
    @Column(name = "titre_oeuvrevente")
    public String getTitreOeuvrevente() {
        return titreOeuvrevente;
    }

    public void setTitreOeuvrevente(String titreOeuvrevente) {
        this.titreOeuvrevente = titreOeuvrevente;
    }

    @Basic
    @Column(name = "etat_oeuvrevente")
    public String getEtatOeuvrevente() {
        return etatOeuvrevente;
    }

    public void setEtatOeuvrevente(String etatOeuvrevente) {
        this.etatOeuvrevente = etatOeuvrevente;
    }

    @Basic
    @Column(name = "prix_oeuvrevente")
    public double getPrixOeuvrevente() {
        return prixOeuvrevente;
    }

    public void setPrixOeuvrevente(double prixOeuvrevente) {
        this.prixOeuvrevente = prixOeuvrevente;
    }

    /*@Basic
    @Column(name = "id_proprietaire")
    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OeuvreventeEntity that = (OeuvreventeEntity) o;
        return idOeuvrevente == that.idOeuvrevente &&
                Double.compare(that.prixOeuvrevente, prixOeuvrevente) == 0 &&
                Objects.equals(titreOeuvrevente, that.titreOeuvrevente) &&
                Objects.equals(etatOeuvrevente, that.etatOeuvrevente);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOeuvrevente, titreOeuvrevente, etatOeuvrevente, prixOeuvrevente);
    }
}
