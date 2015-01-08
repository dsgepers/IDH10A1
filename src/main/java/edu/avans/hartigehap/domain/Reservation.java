package edu.avans.hartigehap.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter
@ToString(callSuper=true, includeFieldNames=true, of= {})
@NoArgsConstructor
public class Reservation extends DomainObject {

	@OneToMany(mappedBy="PERIOD")
	private List<CalendarPeriod> periods;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROOM_ID")
	private IRoom room;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STATUS_ID")
	private IReservationStatus status;

	public void addPeriod(CalendarPeriod period)
	{
		this.periods.add(period);
	}

	public void setRoom(IRoom room)
	{
		this.room = room;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public void setReservationStatus(IReservationStatus status)
	{
		this.status = status;
	}
}
