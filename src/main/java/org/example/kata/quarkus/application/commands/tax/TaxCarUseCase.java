package org.example.kata.quarkus.application.commands.tax;

import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.vehicules.Car;
import org.example.kata.quarkus.domain.vehicules.IVehicle;
import org.example.kata.quarkus.domain.vehicules.Van;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;

@ApplicationScoped
public class TaxCarUseCase implements ITaxUseCase{

    @Override
    public Tax computeTax(IVehicle vehicle) {
        var car = (Car) vehicle;
        if(car.registrationDate().isBefore(LocalDateTime.of(2001,1,1,0,0))){
            if(car.engineSize() > 1550)
                return new Tax(190);
            else
                return new Tax(165);
        }else {
            if(car.co2() <= 100)
                return new Tax(65);
            else if(car.co2() <= 120)
                return new Tax(75);
            else
                return new Tax(105);
        }
    }
}
