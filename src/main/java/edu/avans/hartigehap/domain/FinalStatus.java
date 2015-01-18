package edu.avans.hartigehap.domain;

import edu.avans.hartigehap.repository.ConceptStatusRepository;
import edu.avans.hartigehap.repository.FinalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FINAL")
public class FinalStatus extends IReservationStatus {

    @Autowired
    @Transient
    private static FinalStatusRepository finalStatusRepository;

    @Transient
    private Reservation reservation;

    public void setReservation(Reservation reservation)
    {
        this.reservation = reservation;
    }

    public static IReservationStatus getStatus() {
        return FinalStatus.finalStatusRepository.findAll().iterator().next();
    }

    @Override
    public void makeFinal(Reservation reservation) throws InvalidReservationStatusActionException {
        throw new InvalidReservationStatusActionException("Already finalized.");
    }

    @Override
    public void makeConcept(Reservation reservation) throws InvalidReservationStatusActionException {
        throw new InvalidReservationStatusActionException("Not allowed to be set to concept when final.");
    }
}
