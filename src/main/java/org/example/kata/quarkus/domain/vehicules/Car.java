package org.example.kata.quarkus.domain.vehicules;

import java.time.LocalDateTime;

public record Car(LocalDateTime registrationDate, int engineSize, int co2) implements IVehicle {
}
