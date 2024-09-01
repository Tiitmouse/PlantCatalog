/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model;

import hr.algebra.model.Plant;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lorena
 */
public class PlantsTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Id", "Common", "Botanical",
        "Family", "Conservation", "Zone", "Light", "Price", "Availability"};

    private List<Plant> plants;

    public PlantsTableModel(List<Plant> plants) {
        this.plants = plants;
    }

    public void setPlants(List<Plant> plantts) {
        this.plants = plantts;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return plants.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return plants.get(rowIndex).getId();
            case 1:
                return plants.get(rowIndex).getCommon_name();
            case 2:
                return plants.get(rowIndex).getBotanical_name();
            case 3:
                return plants.get(rowIndex).getFamily().getName();
            case 4:
                return plants.get(rowIndex).getConservation_status().getName();
            case 5:
                return plants.get(rowIndex).getZone().getName();
            case 6:
                return plants.get(rowIndex).getLight().getName();
            case 7:
                return plants.get(rowIndex).getPrice();
            case 8:
                return plants.get(rowIndex).getAvailability();
            default:
                throw new RuntimeException("Nonexistant column");
        }
    }
    
        @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }


    // important for the id ordering
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex); 
    }

}
