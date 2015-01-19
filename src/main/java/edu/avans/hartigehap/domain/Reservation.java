package edu.avans.hartigehap.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "RESERVATION")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter
@ToString(callSuper=true, includeFieldNames=true, of= {})
@NoArgsConstructor
public class Reservation extends DomainObject {
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="reservation")
	private List<IPeriod> periods;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="ROOM_ID")
	private IRoom room;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STATUS_ID")
	private IReservationStatus status;

	@NotEmpty(message = "{validation.reservation.name.NotEmpty.message}")
	private String name;

	@Range(min=1, max=9999, message = "{validation.reservation.groupSize.Range.message}")
	private Integer groupSize;

	@NotEmpty(message = "{validation.reservation.description.NotEmpty.message}")
	private String description;

	public void addPeriod(IPeriod period)
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
