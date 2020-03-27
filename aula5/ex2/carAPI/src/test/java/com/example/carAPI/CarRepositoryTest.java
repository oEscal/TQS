package com.example.carAPI;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    // to avoid the spring boot optimizations and to save data to database right away
    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void getCar_returnsCarDetails() {
        Car save_car = entityManager.persistAndFlush(new Car("prius", "toyota"));

        Car car = repository.findByName("prius");

        Assertions.assertThat(car.getName()).isEqualTo(save_car.getName());
    }
}