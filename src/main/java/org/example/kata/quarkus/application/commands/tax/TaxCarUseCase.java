package org.example.kata.quarkus.application.commands.tax;

import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.vehicules.Car;
import org.example.kata.quarkus.domain.vehicules.IVehicle;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.example.kata.quarkus.infrastructure.builder.TaxBuilder.aTax;

@ApplicationScoped
public class TaxCarUseCase implements ITaxUseCase{
    private Map<Integer, Integer> carTaxes = new LinkedHashMap<Integer, Integer>();

    public TaxCarUseCase(){
        carTaxes.put(100, 65);
        carTaxes.put(120, 75);
        carTaxes.put(150, 105);
        carTaxes.put(165, 125);
        carTaxes.put(185,145);
    }

    @Override
    public Tax computeTax(IVehicle vehicle) {
        var car = (Car) vehicle;
        if(car.registrationDate().isBefore(LocalDateTime.of(2001,1,1,0,0))){
            if(car.engineSize() > 1550)
                return createTax(198);
            else
                return createTax(165);
        }else {
            int carCo2 = car.co2();
            for (Integer key : carTaxes.keySet()){
                if(carCo2 <= key){
                    return createTax(carTaxes.get(key));
                }
            }
            return createTax(160);
        }
    }

    private Tax createTax(int taxValue) {
        return aTax().taxValue(taxValue).buildTax();
    }
}
