/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author lorena
 */
public class Conservation implements Comparable<Conservation> {
    private int id;
    private String conservationName;

    public Conservation(String conservationName) {
        this.conservationName = conservationName;
    }

    public Conservation(int id, String conservationName) {
        this.id = id;
        this.conservationName = conservationName;
    }
    
    

    public int getId() {
        return id;
    }

    public String getConservationName() {
        return conservationName;
    }

    public void setConservationName(String conservationName) {
        this.conservationName = conservationName;
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
        final Conservation other = (Conservation) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Conservation{" + conservationName + '}';
    }

    @Override
    public int compareTo(Conservation other) {
        return Integer.compare(this.id, other.id);    
    }
}
