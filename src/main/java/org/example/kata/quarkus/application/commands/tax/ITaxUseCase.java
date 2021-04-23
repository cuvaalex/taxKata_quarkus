package org.example.kata.quarkus.application.commands.tax;

import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.vehicules.IVehicle;

public interface ITaxUseCase {
    Tax computeTax(IVehicle vehicle);
}
