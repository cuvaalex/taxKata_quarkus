package org.example.kata.quarkus.application.commands.tax;

import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.vehicules.IVehicle;
import org.example.kata.quarkus.domain.vehicules.Van;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaxVanUseCase implements ITaxUseCase {
    @Override
    public Tax computeTax(IVehicle vehicle) {
        var van = (Van) vehicle;
        if(van.weight() <= 3500)
            return new Tax(165);
        else
            return new Tax(190);
    }

}
