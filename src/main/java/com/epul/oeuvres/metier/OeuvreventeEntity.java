package com.epul.oeuvres.metier;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "oeuvrevente", schema = "baseoeuvre")
public class OeuvreventeEntity {

    @Id
    @Column(name = "id_oeuvrevente")
    private int idOeuvrevente;

    @Column(name = "titre_oeuvrevente")
    private String titreOeuvrevente;

    @Column(name = "etat_oeuvrevente")
    private String etatOeuvrevente;

    @Column(name = "prix_oeuvrevente")
    private double prixOeuvrevente;

    @ManyToOne
    @JoinColumn(name = "id_proprietaire")
    private ProprietaireEntity proprietaire;

    public int getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(int idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    public String getTitreOeuvrevente() {
        return titreOeuvrevente;
    }

    public void setTitreOeuvrevente(String titreOeuvrevente) {
        this.titreOeuvrevente = titreOeuvrevente;
    }

    public String getEtatOeuvrevente() {
        return etatOeuvrevente;
    }

    public void setEtatOeuvrevente(String etatOeuvrevente) {
        this.etatOeuvrevente = etatOeuvrevente;
    }

    public double getPrixOeuvrevente() {
        return prixOeuvrevente;
    }

    public void setPrixOeuvrevente(double prixOeuvrevente) {
        this.prixOeuvrevente = prixOeuvrevente;
    }

    public ProprietaireEntity getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(ProprietaireEntity proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OeuvreventeEntity that = (OeuvreventeEntity) o;
        return idOeuvrevente == that.idOeuvrevente &&
                Double.compare(that.prixOeuvrevente, prixOeuvrevente) == 0 &&
                Objects.equals(titreOeuvrevente, that.titreOeuvrevente) &&
                Objects.equals(etatOeuvrevente, that.etatOeuvrevente) &&
                Objects.equals(proprietaire.getIdProprietaire(), that.proprietaire.getIdProprietaire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOeuvrevente, titreOeuvrevente, etatOeuvrevente, prixOeuvrevente, proprietaire.getIdProprietaire());
    }
}
