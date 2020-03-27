package com.example.carAPI;


import org.springframework.stereotype.Service;


@Service
public class CarService {

    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Car getCarDetails(String name) {
        return repository.findByName(name);
    }
}
