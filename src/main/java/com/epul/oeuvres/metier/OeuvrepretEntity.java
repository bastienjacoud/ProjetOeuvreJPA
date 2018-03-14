package com.epul.oeuvres.metier;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "oeuvrepret", schema = "baseoeuvre", catalog = "")
public class OeuvrepretEntity {
    private int idOeuvrepret;
    private String titreOeuvrepret;
    private ProprietaireEntity proprietaire;

    @Id
    @Column(name = "id_oeuvrepret")
    public int getIdOeuvrepret() {
        return idOeuvrepret;
    }

    public void setIdOeuvrepret(int idOeuvrepret) {
        this.idOeuvrepret = idOeuvrepret;
    }

    @Basic
    @Column(name = "titre_oeuvrepret")
    public String getTitreOeuvrepret() {
        return titreOeuvrepret;
    }

    public void setTitreOeuvrepret(String titreOeuvrepret) {
        this.titreOeuvrepret = titreOeuvrepret;
    }

    @ManyToOne
    @JoinColumn (name="id_proprietaire")
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
