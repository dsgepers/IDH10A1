package edu.avans.hartigehap.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("NONE")
public class VatNone extends Vat {

    private Double vat = 0.00;

    protected static Vat _instance = new VatNone();

    @Override
    public Double calculateVat(Double price) {
        return price * this.vat;
    }
}
