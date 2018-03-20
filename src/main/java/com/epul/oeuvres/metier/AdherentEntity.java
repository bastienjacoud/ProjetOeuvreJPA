package com.epul.oeuvres.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "adherent", schema = "baseoeuvre")
public class AdherentEntity {

    @Id
    @Column(name = "id_adherent")
    private int idAdherent;

    @Column(name = "nom_adherent")
    private String nomAdherent;

    @Column(name = "prenom_adherent")
    private String prenomAdherent;

    @Column(name = "ville_adherent")
    private String villeAdherent;


    public int getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(int idAdherent) {
        this.idAdherent = idAdherent;
    }

    public String getNomAdherent() {
        return nomAdherent;
    }

    public void setNomAdherent(String nomAdherent) {
        this.nomAdherent = nomAdherent;
    }

    public String getPrenomAdherent() {
        return prenomAdherent;
    }

    public void setPrenomAdherent(String prenomAdherent) {
        this.prenomAdherent = prenomAdherent;
    }

    public String getVilleAdherent() {
        return villeAdherent;
    }

    public void setVilleAdherent(String villeAdherent) {
        this.villeAdherent = villeAdherent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdherentEntity that = (AdherentEntity) o;
        return idAdherent == that.idAdherent &&
                Objects.equals(nomAdherent, that.nomAdherent) &&
                Objects.equals(prenomAdherent, that.prenomAdherent) &&
                Objects.equals(villeAdherent, that.villeAdherent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdherent, nomAdherent, prenomAdherent, villeAdherent);
    }
}
