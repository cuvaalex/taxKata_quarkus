package org.example.kata.quarkus.api;

import org.example.kata.quarkus.application.commands.tax.TaxOrchestrator;
import org.example.kata.quarkus.application.commands.tax.TaxVanUseCase;
import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.vehicules.Car;
import org.example.kata.quarkus.domain.vehicules.Van;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;

@Path("/taxVehicule")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaxControler {

    @Inject
    TaxOrchestrator service;

    @GET
    @Path("van")
    public Tax van(Van van) {
        return service.computeTax(van);
    }

    @GET
    @Path("car")
    public Tax car(Car car) {
        return service.computeTax(car);
    }

}
