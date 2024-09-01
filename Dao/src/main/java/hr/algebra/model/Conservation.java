/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author lorena
 */
public class Conservation extends Super implements Comparable<Conservation> {

    public Conservation(String name) {
        super(name);
    }

    public Conservation(int id, String name) {
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
        final Conservation other = (Conservation) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Conservation other) {
        return Integer.compare(this.id, other.id);    
    }
}
