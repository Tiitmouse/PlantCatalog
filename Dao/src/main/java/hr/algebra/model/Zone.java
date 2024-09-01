/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author lorena
 */
public class Zone extends Super implements Comparable<Zone> {

    public Zone(String name) {
        super(name);
    }

    public Zone(int id, String name) {
        super(id, name);
    }   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zone other = (Zone) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Zone other) {
        return Integer.compare(this.id, other.id);    
    }
}
