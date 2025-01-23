package com.example.restcicd.web;

import com.example.restcicd.data.Car;
import com.example.restcicd.data.Dates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RentalWebService {

    List<Car> cars = new ArrayList<Car>();

    Logger logger = LoggerFactory.getLogger(RentalWebService.class);

    public RentalWebService() {
        Car car = new Car("11AA22", 2000);
        cars.add(car);
        car = new Car("Mercedes-AMG", 15000);
        cars.add(car);
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return cars;
    }

    @PutMapping(value = "/cars/{plaque}")
    public void rent(
            @PathVariable("plaque") String plateNumber,
            @RequestParam(value="rent", required = true)boolean rent,
            @RequestBody Dates dates) throws CarNotFoundException {

        logger.info("Plate number: " + plateNumber);
        logger.info("Rent: " + rent);
        logger.info("Dates: " + dates);

        Car car = cars.stream().filter(aCar -> aCar.getPlateNumber().equals(plateNumber)).findFirst().orElse(null);
        if(car != null){
            if(rent == true){
                car.setRented(true);
                car.getDates().add(dates);
            } else {
                car.setRented(false);
            }
        } else {
            logger.error("Car not found: " + plateNumber);
            throw new CarNotFoundException(plateNumber);
        }

    }

}