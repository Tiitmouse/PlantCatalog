/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author lorena
 */
public class Zone implements Comparable<Zone> {
    private int id;
    private String zoneName;

    public Zone(String zoneName) {
        this.zoneName = zoneName;
    }

    public Zone(int id, String zoneName) {
        this.id = id;
        this.zoneName = zoneName;
    }

    
    
    public int getId() {
        return id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
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
    public String toString() {
        return "Zone{" + zoneName + '}';
    }

    @Override
    public int compareTo(Zone other) {
        return Integer.compare(this.id, other.id);    
    }
}
