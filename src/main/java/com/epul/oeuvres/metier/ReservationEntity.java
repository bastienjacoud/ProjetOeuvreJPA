package com.epul.oeuvres.metier;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "baseoeuvre", catalog = "")
@IdClass(ReservationEntityPK.class)
public class ReservationEntity {
    private OeuvreventeEntity oeuvrevente;
    private AdherentEntity adherent;
    private Date dateReservation;
    private String statut;

    @Id
    @ManyToOne
    @JoinColumn (name="id_oeuvrevente")
    public OeuvreventeEntity getOeuvrevente() {
        return oeuvrevente;
    }

    public void setOeuvrevente(OeuvreventeEntity oeuvrevente) {
        this.oeuvrevente = oeuvrevente;
    }

    @Id
    @ManyToOne
    @JoinColumn (name="id_adherent")
    public AdherentEntity getAdherent() {
        return adherent;
    }

    public void setAdherent(AdherentEntity adherent) {
        this.adherent = adherent;
    }

    @Basic
    @Column(name = "date_reservation")
    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Basic
    @Column(name = "statut")
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntity that = (ReservationEntity) o;
        return oeuvrevente.getIdOeuvrevente() == that.oeuvrevente.getIdOeuvrevente() &&
                adherent.getIdAdherent() == that.adherent.getIdAdherent() &&
                Objects.equals(dateReservation, that.dateReservation) &&
                Objects.equals(statut, that.statut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oeuvrevente.getIdOeuvrevente(), adherent.getIdAdherent(), dateReservation, statut);
    }
}
