package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = List.of(
            new Car("BMW", "Black", 2020),
            new Car("Audi", "White", 2021),
            new Car("Mercedes", "Silver", 2019),
            new Car("Toyota", "Red", 2022),
            new Car("Lada", "Blue", 2018)
    );

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count >= 5) {
            return cars;
        }
        return cars.stream().limit(Math.max(count, 0)).collect(Collectors.toList());
    }
}
