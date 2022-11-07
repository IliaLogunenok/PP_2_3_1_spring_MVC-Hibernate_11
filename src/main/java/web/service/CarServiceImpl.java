package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    public List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car("BMW", 2001, 1));
        carList.add(new Car("Audi", 1999, 2));
        carList.add(new Car("Jaguar", 2015, 3));
        carList.add(new Car("Bugatti", 2010, 4));
        carList.add(new Car("Cadillac", 1986, 5));
    }

    @Override
    public List<Car> listCars(int count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
