package edu.avans.hartigehap.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FOOD")
public class VatFood extends Vat {

    private Double vat = 0.06;

    @Override
    public Double calculateVat(Double price) {
        return price + (price * this.vat);
    }
}
