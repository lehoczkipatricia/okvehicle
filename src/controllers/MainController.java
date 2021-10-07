/*
 * File: MainController.java
 * Created Date: 2021-09-24 22:21:42
 * Author: Lehoczki Patrícia
 * Original: revehicle by Sallai Andras
 * Github: https://github.com/lehoczkipatricia
 * -----
 * Last Modified: 2021-10-05
 * Modified By: Lehoczki Patrícia
 * -----
 * Copyright (c) 2021 Lehoczki Patrícia
 * 
 * GNU GPL v2
 */

package controllers;

import java.util.ArrayList;

import models.LoadVehicle;
import models.Vehicle;
import views.MainWindow;

public class MainController {
    MainWindow mainWindow;
    LoadVehicle loadVehicle;
    String ordinal = "";
    String brand = "";
    String year = "";

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        loadVehicleList();
        // TODO A névtelen metódus tartalmát ki kell szervezni
        addEventToAddButton();
        addEventToDelButton();
        addEventToSaveButton();
        
    }
    
    public void loadVehicleList(){
        this.loadVehicle = new LoadVehicle();
        ArrayList<Vehicle> vehicleList = this.loadVehicle.load();
        for (Vehicle vehicle : vehicleList) {
            this.mainWindow.vehicleModel.addRow(new Object[] { vehicle.ordinal, vehicle.brand, vehicle.year });
        }
    }

    public void addEventToAddButton(){
        this.mainWindow.addButton.addActionListener(event -> {
            System.out.println("Hozzáadás...");
            getSetTexts(ordinal, brand, year);
            this.mainWindow.vehicleModel.addRow(new Object[] { ordinal, brand, year });
        });
    }
    public void getSetTexts(String ordinal, String brand, String year) {
        ordinal = this.mainWindow.ordinalField.getText();
        brand = this.mainWindow.brandField.getText();
        year = this.mainWindow.yearField.getText();
        this.mainWindow.ordinalField.setText("");
        this.mainWindow.brandField.setText("");
        this.mainWindow.yearField.setText("");
    }

    public void addEventToDelButton(){
        // TODO: Törlés megvalósítása
        this.mainWindow.delButton.addActionListener(event -> {
            System.out.println("Törlés...");
        });
    }
    public void addEventToSaveButton(){
        // TODO: Mentés megvalósítása
        this.mainWindow.saveButton.addActionListener(event -> {
            System.out.println("Mentés...");
        });
    }

    

    

}
