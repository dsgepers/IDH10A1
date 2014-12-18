package edu.avans.hartigehap.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CONCEPT")
public class ConceptStatus extends IReservationStatus {
    @Transient
    private Reservation reservation;

    public void setReservation(Reservation reservation)
    {
        this.reservation = reservation;
    }

    @Override
    public void makeFinal() {

    }

    @Override
    public void makeConcept() {

    }
}
