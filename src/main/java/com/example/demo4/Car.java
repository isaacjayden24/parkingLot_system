package com.example.demo4;

public class Car {
    private final String plateCar;
    private final String colorCar;
    private final String typeCar;

    public Car(String plateCar, String colorCar, String typeCar) {
        this.plateCar = plateCar;
        this.colorCar = colorCar;
        this.typeCar = typeCar;
    }

    public String getPlateCar() {
        return plateCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public String getTypeCar() {
        return typeCar;
    }
}

