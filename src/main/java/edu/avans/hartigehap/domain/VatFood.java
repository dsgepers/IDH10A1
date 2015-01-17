package edu.avans.hartigehap.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FOOD")
public class VatFood extends Vat {

    private Double vat = 0.06;

    protected static Vat _instance = new VatFood();

    @Override
    public Double calculateVat(Double price) {
        return price * this.vat;
    }
}
