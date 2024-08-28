/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.model.Conservation;
import hr.algebra.model.Family;
import hr.algebra.model.Light;
import hr.algebra.model.Plant;
import hr.algebra.model.Zone;

/**
 *
 * @author lorena
 */
public abstract class Context {

    public final Repository<Plant> plants;
    public final Repository<Family> families;
    public final Repository<Conservation> conservations;
    public final Repository<Zone> zones;
    public final Repository<Light> lights;

    public Context(Repository<Plant> plants, Repository<Family> families, Repository<Conservation> conservations, Repository<Zone> zones, Repository<Light> lights) {
        this.plants = plants;
        this.families = families;
        this.conservations = conservations;
        this.zones = zones;
        this.lights = lights;
    }
    
    

}
