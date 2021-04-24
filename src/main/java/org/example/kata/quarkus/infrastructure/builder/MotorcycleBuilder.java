package org.example.kata.quarkus.infrastructure.builder;

import org.example.kata.quarkus.domain.vehicules.Motorcycle;

public class MotorcycleBuilder {
    private int co2;

    public static MotorcycleBuilder aMotorCycle() {return new MotorcycleBuilder();}


    public MotorcycleBuilder co2(int co2) {
        this.co2 = co2;
        return this;
    }

    public Motorcycle build() {
        return new Motorcycle(this.co2);
    }
}
