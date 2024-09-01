/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author lorena
 */
public class Family extends Super implements Comparable<Family> {

    public Family(String name) {
        super(name);
    }

    public Family(int id, String name) {
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
        final Family other = (Family) obj;
        return this.id == other.id;
    }


    @Override
    public int compareTo(Family other) {
        return Integer.compare(this.id, other.id);
    }
}
