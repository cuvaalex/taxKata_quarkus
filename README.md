# tax-kata-spock
Resolution of the Tax-kata with Java 8 and Spock

This kata was first done during one of our GenevaJUG Dojo

Write a program that computes the annual road tax (vehicle excise duty) charges for three types of vehicles:  vans, cars and motorcycles.
The road tax rate is calculated as follows for each type of vehicle:

**Vans**
Light goods vehicles weighing less than 3500kg are charged at 165 GBP (British Pounds); otherwise they are charged at 190 GBP.

**Cars**
All cars registered on or before 1 March 2001 are charged according to their engine size (in cc).  A car with an engine size of less than or equal to 1550cc is charged at 110 GBP; otherwise it is charged at 165 GBP.
If the date of car’s registration is after 1 March 2001, the annual road tax charge is calculated according to the CO2 emission of the vehicle.  The table below displays the different road tax charges for this criterion.
(Hint: see the API documentation for the Date and DateFormat class)

                              Petrol Car
CO2 Emission Figure (g/km)            12 months rate in GBP
-----------------------------        ------------------------
            Up to 100                         65.00    
            101 to 120                        75.00    
            121 – 150                        105.00  
            151 – 165                        125.00  
            166 – 185                        145.00  
            Over 185                         160.00 

Table 1:  Road tax charges for private vehicles registered on or after 1 March 2001

For the data-entry enthusiasts who only believe in entering real and precise data, there is a website (http://www.vcacarfueldata.org.uk/ved/index.asp ) that can calculate for you the real CO2 emission for different models of cars, but you don’t need this information.  Remember, this program is only meant to represent a model solution that works for this problem.

**Motorcycles*
Motorcycles are charged according to their engine size (in cc).  The following table displays the list of road tax charges according to this criterion.

                             Motorcycles  
Motorcycles (with or without sidecar)      12 months rate in GBP
-------------------------------        ------------------------------
            Not Over 150cc                         15.00    
            151cc - 400cc                          30.00    
            401cc - 600cc                          45.00    
            All other motorcycles                  60.00   

Table 2:  Road tax charges for motorcycles

Task
Create an invoicing system that will ask the user to input a vehicle’s
a)         Manufacturer name (e.g. Toyota)
b)         Model (e.g. Avensis)
c)         Date of registration (e.g. 17/12/2002)

Depending on the type of vehicle (van, car or motorcycle), the program should proceed to produce an invoice containing the above input details as well as the amount of road tax charge to be paid for that particular vehicle.


# QuarkusTax project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/QuarkusTax-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
