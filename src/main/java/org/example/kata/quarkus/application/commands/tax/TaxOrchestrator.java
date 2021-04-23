package org.example.kata.quarkus.application.commands.tax;

import org.example.kata.quarkus.domain.Taxs.Tax;
import org.example.kata.quarkus.domain.vehicules.Car;
import org.example.kata.quarkus.domain.vehicules.Van;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Objects;

@ApplicationScoped
public class TaxOrchestrator {

    @Inject
    Instance<ITaxUseCase> useCases;

    public Tax computeTax(Van van){
        return Objects.requireNonNull(getUseCase(TaxVanUseCase.class)).computeTax(van);
    }

    public Tax computeTax(Car van){
        return Objects.requireNonNull(getUseCase(TaxCarUseCase.class)).computeTax(van);
    }

    private ITaxUseCase getUseCase(Class inst){
        return useCases
                .stream()
                .filter(uc -> inst.isInstance(uc))
                .findFirst().get();
    }
}
