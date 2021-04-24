package org.example.kata.quarkus.application.commands.tax;

import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.vehicules.IVehicle;
import org.example.kata.quarkus.domain.vehicules.Motorcycle;

import javax.enterprise.context.ApplicationScoped;

import static org.example.kata.quarkus.infrastructure.builder.TaxBuilder.aTax;

@ApplicationScoped
public class TaxMotorcycleUseCase implements ITaxUseCase {
    @Override
    public Tax computeTax(IVehicle vehicle) {
        Motorcycle motorcycle = (Motorcycle) vehicle;
        if (motorcycle.co2() <= 150)
            return aTax().taxValue(15).buildTax();
        else
            return aTax().taxValue(30).buildTax();
    }
}
