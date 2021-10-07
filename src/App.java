/*
 * File: App.java
 * Created Date: 2021-09-24 22:13:27
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


import controllers.MainController;
import views.MainWindow;

public class App {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        new MainController(mainWindow);
        mainWindow.setVisible(true);
    }
}
