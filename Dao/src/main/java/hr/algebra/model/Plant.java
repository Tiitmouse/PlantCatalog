package hr.algebra.model;

/**
 *
 * @author lorena
 */

public class Plant implements Comparable<Plant>{

    private int id;
    private String common_name;
    private String botanical_name;
    private Family family;
    private Conservation conservation_status;
    private String description;
    private String picture_path;
    private Light light;
    private Zone zone;
    private double price;
    private int availability;

    public Plant() {
    }
    
    public Plant(
            String common_name, String botanical_name, Family family, Conservation conservation_status, 
            String description, String picture_path, Zone zone, Light light , double price, int availability) {
        this.common_name = common_name;
        this.botanical_name = botanical_name;
        this.family = family;
        this.conservation_status = conservation_status;
        this.description = description;
        this.picture_path = picture_path;
        this.zone = zone;
        this.light = light;
        this.price = price;
        this.availability = availability;
    }
    
        public Plant(
            int id, String common_name, String botanical_name, Family family, Conservation conservation_status, 
            String description, String picture_path, Zone zone, Light light , double price, int availability) {
        this.id = id;
        this.common_name = common_name;
        this.botanical_name = botanical_name;
        this.family = family;
        this.conservation_status = conservation_status;
        this.description = description;
        this.picture_path = picture_path;
        this.zone = zone;
        this.light = light;
        this.price = price;
        this.availability = availability;
    }

    public Plant(int id, String common_name, String botanical_name, String description, String picture_path, double price, int availability) {
        this.id = id;
        this.common_name = common_name;
        this.botanical_name = botanical_name;
        this.description = description;
        this.picture_path = picture_path;
        this.price = price;
        this.availability = availability;
    }
        
        
        
    
    public int getId() {
        return id;
    }

    public String getCommon_name() {
        return common_name;
    }

    public void setCommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getBotanical_name() {
        return botanical_name;
    }

    public void setBotanical_name(String botanical_name) {
        this.botanical_name = botanical_name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Conservation getConservation_status() {
        return conservation_status;
    }

    public void setConservation_status(Conservation conservation_status) {
        this.conservation_status = conservation_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
    
    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        return hash;
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
        final Plant other = (Plant) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Plant{" + "id=" + id + ", common_name=" + common_name + ", botanical_name=" 
                + botanical_name + ", family=" + family + ", conservation_status=" + conservation_status 
                + ", description=" + description + ", picture_path=" + picture_path + ", light=" + light 
                + ", zone=" + zone + ", price=" + price + ", availability=" + availability + '}';
    }
    

    @Override
    public int compareTo(Plant other) {
        return Integer.compare(this.id, other.id); 
    }

}
