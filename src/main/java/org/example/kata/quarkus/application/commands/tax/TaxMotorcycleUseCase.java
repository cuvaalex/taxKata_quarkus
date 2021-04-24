package org.example.kata.quarkus.application.commands.tax;

import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.vehicules.IVehicle;

import javax.enterprise.context.ApplicationScoped;

import static org.example.kata.quarkus.infrastructure.builder.TaxBuilder.aTax;

@ApplicationScoped
public class TaxMotorcycleUseCase implements ITaxUseCase {
    @Override
    public Tax computeTax(IVehicle vehicle) {
        return aTax().taxValue(15).buildTax();
    }
}
