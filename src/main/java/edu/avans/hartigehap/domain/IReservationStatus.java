package edu.avans.hartigehap.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
@Table(name = "RESERVATION_STATUS", uniqueConstraints =
@UniqueConstraint(name="type_unique", columnNames={"TYPE"})
)
public abstract class IReservationStatus extends DomainObject
{
    public abstract void setReservation(Reservation reservation);

    public abstract void makeFinal();

    public abstract void makeConcept();
}
