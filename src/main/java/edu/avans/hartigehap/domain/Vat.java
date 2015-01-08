package edu.avans.hartigehap.domain;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name="VAT_TYPE")
@Table(name="VAT")
abstract public class Vat extends DomainObject {

    @Id
    private long id;

    protected static Vat _instance = null;

    protected Vat () {}

    public static Vat getInstance () {
        return _instance;
    }

    public abstract Double calculateVat(Double price);

}
