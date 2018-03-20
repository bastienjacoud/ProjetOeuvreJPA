package com.epul.oeuvres.metier;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "baseoeuvre")
public class ReservationEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_oeuvrevente")
    private OeuvreventeEntity oeuvrevente;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_adherent")
    private AdherentEntity adherent;

    @Column(name = "date_reservation")
    private Date dateReservation;

    @Column(name = "statut")
    private String statut;

    public OeuvreventeEntity getOeuvrevente() {
        return oeuvrevente;
    }

    public void setOeuvrevente(OeuvreventeEntity oeuvrevente) {
        this.oeuvrevente = oeuvrevente;
    }

    public AdherentEntity getAdherent() {
        return adherent;
    }

    public void setAdherent(AdherentEntity adherent) {
        this.adherent = adherent;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

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
