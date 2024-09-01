/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model;

import hr.algebra.model.Plant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author lorena
 */
public class PlantDropdownModel implements ComboBoxModel<Plant> {

    private List<Plant> plants;
    private Plant slectedPlant;
    private List<ListDataListener> ls = new ArrayList<>();

    public PlantDropdownModel(List<Plant> obj) {
        plants = obj;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        slectedPlant = (Plant) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return slectedPlant;
    }

    @Override
    public int getSize() {
        return plants.size();
    }

    @Override
    public Plant getElementAt(int index) {
        return plants.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        ls.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        ls.remove(l);
    }

}
