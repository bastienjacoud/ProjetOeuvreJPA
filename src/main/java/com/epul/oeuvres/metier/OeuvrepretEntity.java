package com.epul.oeuvres.metier;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "oeuvrepret", schema = "baseoeuvre")
public class OeuvrepretEntity {

    @Id
    @Column(name = "id_oeuvrepret")
    private int idOeuvrepret;

    @Column(name = "titre_oeuvrepret")
    private String titreOeuvrepret;

    @ManyToOne
    @JoinColumn(name = "id_proprietaire")
    private ProprietaireEntity proprietaire;

    public int getIdOeuvrepret() {
        return idOeuvrepret;
    }

    public void setIdOeuvrepret(int idOeuvrepret) {
        this.idOeuvrepret = idOeuvrepret;
    }

    public String getTitreOeuvrepret() {
        return titreOeuvrepret;
    }

    public void setTitreOeuvrepret(String titreOeuvrepret) {
        this.titreOeuvrepret = titreOeuvrepret;
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
        OeuvrepretEntity that = (OeuvrepretEntity) o;
        return idOeuvrepret == that.idOeuvrepret &&
                Objects.equals(titreOeuvrepret, that.titreOeuvrepret) &&
                Objects.equals(proprietaire.getIdProprietaire(), that.proprietaire.getIdProprietaire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOeuvrepret, titreOeuvrepret, proprietaire.getIdProprietaire());
    }
}
