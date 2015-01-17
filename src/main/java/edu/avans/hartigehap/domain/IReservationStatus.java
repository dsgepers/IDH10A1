package edu.avans.hartigehap.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Getter
@DiscriminatorColumn(name="TYPE")
@Table(name = "RESERVATION_STATUS", uniqueConstraints =
@UniqueConstraint(name="type_unique", columnNames={"TYPE"})
)
public abstract class IReservationStatus extends DomainObject
{
    @Transient
    protected Reservation reservation;

    @Column(name = "TYPE", insertable = false, updatable = false)
    private String type;

    public abstract void makeFinal(Reservation reservation) throws InvalidReservationStatusActionException;

    public abstract void makeConcept(Reservation reservation) throws InvalidReservationStatusActionException;

    @Override
    public String toString() {
        return this.type;
    }
}
