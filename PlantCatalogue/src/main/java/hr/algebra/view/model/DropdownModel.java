/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model;

import hr.algebra.model.Super;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author lorena
 */
public class DropdownModel implements ComboBoxModel<Super> {

    private List<Super> items;
    private Super selectedItem;
    private List<ListDataListener> ls = new ArrayList<>();

    public DropdownModel(List<Super> obj) {
        items = obj;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Super) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public Super getElementAt(int index) {
        if(index == -1) return new Super(0, "");
        return items.get(index);
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
