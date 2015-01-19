package edu.avans.hartigehap.domain;

public class VatFactory {

    public static VatFactory _instance;

    private static Vat food;

    private static Vat other;

    private static Vat none;

    private VatFactory() {};

    public static VatFactory getInstance() {
        if(_instance == null) {
            _instance = new VatFactory();
        }
        return _instance;
    }

    public Vat getVat(String type) {
        if(type == "NONE") {
            if(none == null) {
                none = new VatNone();
            }
            return none;
        } else if(type == "FOOD") {
            if(food == null) {
                food = new VatFood();
            }
            return food;
        }
        if(other == null) {
            other = new VatOther();
        }
        return other;
    }
}
