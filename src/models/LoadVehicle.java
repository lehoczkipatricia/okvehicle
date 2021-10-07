/*
 * File: LoadVehicle.java
 * Created Date: 2021-09-25 00:46:41
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

package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadVehicle {
    ArrayList<String> vehicles;

    public LoadVehicle() {
        vehicles = new ArrayList<>();
    }

    public ArrayList<Vehicle> load() {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        try {
            vehicleList = tryLoad(vehicleList);
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található");
        }
        return vehicleList;
    }

    public ArrayList<Vehicle> tryLoad(ArrayList<Vehicle> vehicleList) throws FileNotFoundException {
        FileReader fileReader = new FileReader("data.txt");
        Scanner scanner = new Scanner(fileReader);
        
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(":");
            Vehicle vehicle = new Vehicle();
            vehicle.ordinal = lineArray[0];
            vehicle.brand = lineArray[1];
            vehicle.year = lineArray[2];
            vehicleList.add(vehicle);
        }
        scanner.close();
        return vehicleList;
    }
   
        
        
    }


