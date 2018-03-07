package com.epul.oeuvre.metier;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "oeuvrepret", schema = "baseoeuvre", catalog = "")
public class OeuvrepretEntity {
    private int idOeuvrepret;
    private String titreOeuvrepret;
    private Integer idProprietaire;

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

    @Basic
    @Column(name = "id_proprietaire")
    public Integer getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OeuvrepretEntity that = (OeuvrepretEntity) o;
        return idOeuvrepret == that.idOeuvrepret &&
                Objects.equals(titreOeuvrepret, that.titreOeuvrepret) &&
                Objects.equals(idProprietaire, that.idProprietaire);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOeuvrepret, titreOeuvrepret, idProprietaire);
    }
}
