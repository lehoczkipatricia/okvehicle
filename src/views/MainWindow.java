/*
 * File: MainWindow.java
 * Created Date: 2021-09-24 22:18:18
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

package views;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

    public JLabel vehicleLabel;
    public JPanel controlPanel;
    public JPanel formPanel;
    public JPanel buttonPanel;
    public JLabel ordinalLabel;
    public JTextField ordinalField;
    public JLabel brandLabel;
    public JTextField brandField;
    public JLabel yearLabel;
    public JTextField yearField;
    public JButton addButton;
    public JButton delButton;
    public JButton saveButton;

    public DefaultTableModel vehicleModel;
    public JTable vehicleTable;
    public JScrollPane vehicleScrollPane;

    public MainWindow() {
        initVehicleLabel();
        initControlPanel();
        initTable();
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        
    }

    public void initVehicleLabel(){
        this.vehicleLabel = new JLabel("Járművek");
        this.vehicleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.vehicleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(this.vehicleLabel);
    }
    public void initControlPanel() {
        this.controlPanel = new JPanel();
        this.controlPanel.setLayout(new BoxLayout(this.controlPanel, BoxLayout.LINE_AXIS));
        this.controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        initFormPanel();      
        initButtonPanel();
        this.add(this.controlPanel);
        
    }

    public void initFormPanel() {
        this.formPanel = new JPanel();
        this.formPanel.setLayout(new GridLayout(3, 2));
        initOrdinal();      
        initBrand();
        initYear();
        this.controlPanel.add(this.formPanel);
    }

    public void initOrdinal() {
        this.ordinalLabel = new JLabel("Rendszám");
        this.ordinalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.ordinalLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        this.ordinalField = new JTextField();
        this.formPanel.add(this.ordinalLabel);
        this.formPanel.add(this.ordinalField);
    }

    public void initBrand() {
        this.brandLabel = new JLabel("Márka");
        this.brandLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.brandLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        this.brandField = new JTextField();
        this.formPanel.add(this.brandLabel);
        this.formPanel.add(this.brandField);
    }

    public void initYear() {
        
        this.yearLabel = new JLabel("Év");
        this.yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.yearLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        this.yearField = new JTextField();
        this.formPanel.add(this.yearLabel);
        this.formPanel.add(this.yearField);
    }

    public void initButtonPanel() {
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.PAGE_AXIS));
        this.addButton = new JButton("Hozzáadás");
        this.delButton = new JButton("Törlés");
        this.saveButton = new JButton("Mentés");
        
        this.buttonPanel.add(this.addButton);
        this.buttonPanel.add(this.delButton);
        this.buttonPanel.add(this.saveButton);
        this.controlPanel.add(this.buttonPanel);  
    }

    public void initTable() {
        this.vehicleModel = new DefaultTableModel();
        this.vehicleTable = new JTable(vehicleModel);
        this.vehicleScrollPane = new JScrollPane(this.vehicleTable);
        this.vehicleScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Object[] tableLabels = { "Rendszám", "Márka", "Év" };
        this.vehicleModel.setColumnIdentifiers(tableLabels);
        this.add(this.vehicleScrollPane);
    }

}
