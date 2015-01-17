package edu.avans.hartigehap.domain;

import com.google.common.collect.Iterables;
import edu.avans.hartigehap.repository.ConceptStatusRepository;
import edu.avans.hartigehap.repository.FinalStatusRepository;
import edu.avans.hartigehap.service.FinalStatusService;
import edu.avans.hartigehap.service.ReservationService;
import edu.avans.hartigehap.service.impl.ConceptStatusServiceImpl;
import edu.avans.hartigehap.service.impl.FinalStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("CONCEPT")
public class ConceptStatus extends IReservationStatus {

    @Autowired
    @Transient
    protected ConceptStatusRepository conceptStatusRepository;

    @Autowired
    @Transient
    protected FinalStatusService finalStatusService;

    @Autowired
    @Transient
    protected ReservationService reservationService;

    @Transient
    private Reservation reservation;

    @Override
    public void makeFinal(Reservation reservation) {
        List<FinalStatus> finalStatuses = this.finalStatusService.findAll();
        reservation.setStatus(finalStatuses.get(0));
        this.reservationService.save(reservation);
    }

    @Override
    public void makeConcept(Reservation reservation) {

    }
}
