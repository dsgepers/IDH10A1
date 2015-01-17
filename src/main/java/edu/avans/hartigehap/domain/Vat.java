package edu.avans.hartigehap.domain;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance
@DiscriminatorColumn(name="VAT_TYPE")
@Table(name="VAT")
abstract public class Vat extends DomainObject {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="vat")
	private List<IRoom> rooms;
	
    protected static Vat _instance = null;

    protected Vat () {}

    public static Vat getInstance () {
        return _instance;
    }

    public abstract Double calculateVat(Double price);

}
