package org.example.kata.quarkus.application.commands.tax;

import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.vehicules.Car;
import org.example.kata.quarkus.domain.vehicules.IVehicle;
import org.example.kata.quarkus.domain.vehicules.Van;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaxCarUseCase implements ITaxUseCase{

    @Override
    public Tax computeTax(IVehicle vehicle) {
        var car = (Car) vehicle;
        if(car.engineSize() > 1550)
            return new Tax(190);
        else
            return new Tax(165);
    }
}
