package com.example.carAPI;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository car_repository;

    @InjectMocks
    private CarService sut_car_service;

    @Test
    public void getCarDetails_returnsCarInfo() {

        given(car_repository.findByName("prius"))
                .willReturn(new Car("prius", "toyota"));

        Car car = sut_car_service.getCarDetails("prius");

        Assertions.assertThat(car.getName()).isEqualTo("prius");
        Assertions.assertThat(car.getMaker()).isEqualTo("toyota");
    }
}