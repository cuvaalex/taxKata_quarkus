package org.example.kata.quarkus.application.commands.tax;

import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.Taxs.TaxBuilder;
import org.example.kata.quarkus.domain.vehicules.IVehicle;
import org.example.kata.quarkus.domain.vehicules.Van;

import javax.enterprise.context.ApplicationScoped;

import static org.example.kata.quarkus.domain.Taxs.TaxBuilder.aTax;

@ApplicationScoped
public class TaxVanUseCase implements ITaxUseCase {
    @Override
    public Tax computeTax(IVehicle vehicle) {
        var van = (Van) vehicle;
        if(van.weight() <= 3500)
            return aTax().taxValue(165).buildTax();
        else
            return aTax().taxValue(190).buildTax();
    }

}
