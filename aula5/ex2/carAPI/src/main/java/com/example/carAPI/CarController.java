package com.example.carAPI;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarController {

    private CarService car_service;

    public CarController(CarService car_service) {
        this.car_service = car_service;
    }

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return car_service.getCarDetails(name);
    }
}
