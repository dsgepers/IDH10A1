package edu.avans.hartigehap.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public abstract class IReservationStatus extends DomainObject
{
    public abstract void setReservation(Reservation reservation);

    public abstract void makeFinal();

    public abstract void makeConcept();
}
