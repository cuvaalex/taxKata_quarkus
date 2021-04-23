package org.example.kata.quarkus.domain.vehicules;

import java.time.LocalDateTime;

public record Car(LocalDateTime dateTime, int engineSize) implements IVehicle {
}
