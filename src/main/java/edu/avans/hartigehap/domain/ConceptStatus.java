package edu.avans.hartigehap.domain;

import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import java.util.List;

@Entity
@Configurable
@DiscriminatorValue("CONCEPT")
public class ConceptStatus extends IReservationStatus {

    @Transient
    private Reservation reservation;

    @Override
    public void makeFinal(Reservation reservation) {
        List<FinalStatus> finalStatuses = finalStatusService.findAll();
        reservation.setStatus(finalStatuses.get(0));
        this.reservationService.save(reservation);
    }

    @Override
    public void makeConcept(Reservation reservation) {

    }
}
