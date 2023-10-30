package com.example.demo4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

public class ParkingArea {
    private final int rateFee = 10;
    private ObservableList<Car> storageCars = FXCollections.observableArrayList();

    public void parkFunction(String plateCar, String colorCar, String typeCar) {
        Car carObject = new Car(plateCar, colorCar, typeCar);
        storageCars.add(carObject);
    }

    public boolean exitCar(String exitPlate) {
        Car exitCar = storageCars.stream().filter(car -> car.getPlateCar().equals(exitPlate)).findFirst().orElse(null);
        if (exitCar != null) {
            storageCars.remove(exitCar);
            return true;
        }
        return false;
    }

    public ObservableList<Car> carDetailsOnSpot() {
        return storageCars;
    }
}
