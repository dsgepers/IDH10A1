package edu.avans.hartigehap.domain;

import edu.avans.hartigehap.service.ConceptStatusService;
import edu.avans.hartigehap.service.FinalStatusService;
import edu.avans.hartigehap.service.ReservationService;
import edu.avans.hartigehap.service.impl.ConceptStatusServiceImpl;
import edu.avans.hartigehap.service.impl.FinalStatusServiceImpl;
import edu.avans.hartigehap.service.impl.ReservationServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;

@Entity
@Configurable
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Getter @Setter
@DiscriminatorColumn(name="TYPE")
@Table(name = "RESERVATION_STATUS", uniqueConstraints =
@UniqueConstraint(name="type_unique", columnNames={"TYPE"})
)
public abstract class IReservationStatus extends DomainObject
{
    @Autowired
    @Transient
    protected FinalStatusService finalStatusService;

    @Autowired
    @Transient
    protected ConceptStatusService conceptStatusService;

    @Autowired
    @Transient
    protected ReservationService reservationService;

    @Transient
    protected Reservation reservation;

    @Column(name = "TYPE", insertable = false, updatable = false)
    private String type;

    public abstract void makeFinal(Reservation reservation) throws InvalidReservationStatusActionException;

    public abstract void makeConcept(Reservation reservation) throws InvalidReservationStatusActionException;

    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
