/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author lorena
 */
public class Light implements Comparable<Light> {
    private int id;
    private String lightName;

    public Light(String lightName) {
        this.lightName = lightName;
    }

    public Light(int id, String lightName) {
        this.id = id;
        this.lightName = lightName;
    }

    public int getId() {
        return id;
    }

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
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
        final Light other = (Light) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Light{" + lightName + '}';
    }

    @Override
    public int compareTo(Light other) {
        return Integer.compare(this.id, other.id);    
    }
}
