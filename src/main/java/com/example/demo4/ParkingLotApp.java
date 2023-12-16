package com.example.demo4;



        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
        import javafx.stage.Stage;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.collections.ObservableList;


public class ParkingLotApp extends Application {

    private final ParkingArea parkingArea = new ParkingArea();
    private final TextArea outputTextArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Parking Lot Management");

        // Input fields
        TextField plateCarField = new TextField();
        TextField colorCarField = new TextField();
        TextField typeCarField = new TextField();
        TextField entryTimeField = new TextField();
        TextField exitTimeField = new TextField();
        TextField exitPlateField = new TextField();

        Button parkButton = new Button("Park Car");
        Button exitButton = new Button("Exit Car");
        Button statusButton = new Button("Check Status");
        Button carDetailsButton = new Button("Car Details on Spot");

        parkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String plateCar = plateCarField.getText();
                String colorCar = colorCarField.getText();
                String typeCar = typeCarField.getText();
                parkingArea.parkFunction(plateCar, colorCar, typeCar);
                outputTextArea.appendText("Car parked successfully\n");
            }
        });

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String exitPlate = exitPlateField.getText();
                if (parkingArea.exitCar(exitPlate)) {
                    outputTextArea.appendText("Car successfully removed\n");
                } else {
                    outputTextArea.appendText("The plates don't match\n");
                }
            }
        });

        statusButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (parkingArea.carDetailsOnSpot().isEmpty()) {
                    outputTextArea.appendText("There is no car in that spot!\n");
                } else {
                    outputTextArea.appendText("There are cars in the lot\n");
                }
            }
        });

        carDetailsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ObservableList<Car> carsOnSpot = parkingArea.carDetailsOnSpot();
                for (int i = 0; i < carsOnSpot.size(); i++) {
                    Car car = carsOnSpot.get(i);
                    outputTextArea.appendText((i + 1) + " " + car.getTypeCar() + " " + car.getPlateCar() + " " + car.getColorCar() + "\n");
                }
            }
        });

        VBox inputFields = new VBox(
                new Label("Plate Number:"),
                plateCarField,
                new Label("Car Color:"),
                colorCarField,
                new Label("Car Type:"),
                typeCarField,
                new Label("Entry Time (hours):"),
                entryTimeField,
                new Label("Exit Time (hours):"),
                exitTimeField,
                new Label("Exit Plate:"),
                exitPlateField
        );

        HBox buttons = new HBox(parkButton, exitButton, statusButton, carDetailsButton);
        VBox leftLayout = new VBox(inputFields, buttons);

        outputTextArea.setEditable(false);
        outputTextArea.setWrapText(true);

        HBox rightLayout = new HBox(outputTextArea);

        HBox mainLayout = new HBox(leftLayout, rightLayout);

        Scene scene = new Scene(mainLayout, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        //checking some comments !
    }
}