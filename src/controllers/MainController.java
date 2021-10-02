/*
 * File: MainController.java
 * Created Date: 2021-09-24 22:21:42
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2021-09-24
 * Modified By: Sallai Andras
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 */

package controllers;

// importáljuk az ArrayList osztály:
import java.util.ArrayList;

// Importáljuk a LoadVehicle osztály
import models.LoadVehicle;
// Importáljuk a Vehicle osztályt
import models.Vehicle;
//Importáljuk a MainWindow osztályt
import views.MainWindow;

/**
 * Azért készítettem ezt a MainControllert, mert 
 * célszerű külön tenni a program vezérlést, 
 * elválasztani a megjelenítéstől és az adatok
 * beszerzésétől. Többrészre bonthattam volna,
 * de az majd ha szükséges lesz megteszem. 
 * Nem szüksége előre felbontani több részre. 
 */

public class MainController {
    //A mainWindow tagváltozó
    MainWindow mainWindow;
    //A loadVehicla tagváltozó
    LoadVehicle loadVehicle;
    //Az oszátly konstruktora
    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.loadVehicle = new LoadVehicle();
        //járművek listája:
        ArrayList<Vehicle> vehicleList = this.loadVehicle.load();
        for(Vehicle vehicle : vehicleList) {
            this.mainWindow.vehicleModel.addRow(
                new Object[] {vehicle.ordinal, vehicle.brand, vehicle.year}
            );
        }// A for ciklus vége

         
        //TODO A névtelen metódus tartalmát ki kell szervezni
        //TODO A függvény tartalmát is több részre bontani
        
        this.mainWindow.addButton.addActionListener(event -> {
            System.out.println("Hozzáadás...");
            String ordinal = this.mainWindow.ordinalField.getText();
            String brand = this.mainWindow.brandField.getText();
            String year = this.mainWindow.yearField.getText();
            this.mainWindow.ordinalField.setText("");
            this.mainWindow.brandField.setText("");
            this.mainWindow.yearField.setText("");
            this.mainWindow.vehicleModel.addRow(
                new Object[] {ordinal, brand, year}
            );
        });
        //TODO: Törlés megvalósítása
        this.mainWindow.delButton.addActionListener(event -> {
            System.out.println("Törlés...");
        });
        //TODO: Mentés megvalósítása
        this.mainWindow.saveButton.addActionListener(event -> {
            System.out.println("Mentés...");
        });
    }
    
}
