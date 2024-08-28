/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author lorena
 */
public class Family implements Comparable<Family> {
    private int id;
    private String familyName;

    public Family(String familyName) {
        this.familyName = familyName;
    }
    public Family(int id, String familyName){
        this.familyName = familyName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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
    public String toString() {
        return "Family{" + familyName + '}';
    }

    @Override
    public int compareTo(Family other) {
        return Integer.compare(this.id, other.id);    
    }
}
