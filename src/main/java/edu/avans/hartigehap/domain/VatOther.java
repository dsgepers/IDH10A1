package edu.avans.hartigehap.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("OTHER")
public class VatOther extends Vat {

    private Double vat = 0.21;

    protected static Vat _instance = new VatOther();

    @Override
    public Double calculateVat(Double price) {
        return price * this.vat;
    }
}
