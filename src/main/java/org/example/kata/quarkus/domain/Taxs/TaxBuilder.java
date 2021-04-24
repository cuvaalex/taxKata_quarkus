package org.example.kata.quarkus.domain.Taxs;

public class TaxBuilder {
    private int taxValue;

    public static TaxBuilder aTax(){
        return new TaxBuilder();
    }

    public TaxBuilder taxValue(int taxValue){
        this.taxValue = taxValue;
        return this;
    }

    public Tax buildTax() {
        return new Tax(this.taxValue);
    }


}
