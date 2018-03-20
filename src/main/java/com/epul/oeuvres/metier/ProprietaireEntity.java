package com.epul.oeuvres.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "proprietaire", schema = "baseoeuvre")
public class ProprietaireEntity {
    @Id
    @Column(name = "id_proprietaire")
    private int idProprietaire;

    @Column(name = "nom_proprietaire")
    private String nomProprietaire;

    @Column(name = "prenom_proprietaire")
    private String prenomProprietaire;

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    public String getPrenomProprietaire() {
        return prenomProprietaire;
    }

    public void setPrenomProprietaire(String prenomProprietaire) {
        this.prenomProprietaire = prenomProprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietaireEntity that = (ProprietaireEntity) o;
        return idProprietaire == that.idProprietaire &&
                Objects.equals(nomProprietaire, that.nomProprietaire) &&
                Objects.equals(prenomProprietaire, that.prenomProprietaire);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProprietaire, nomProprietaire, prenomProprietaire);
    }
}
