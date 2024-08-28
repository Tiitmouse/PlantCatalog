/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.model.Article;
import hr.algebra.model.Conservation;
import hr.algebra.model.Family;
import hr.algebra.model.Light;
import hr.algebra.model.Plant;
import hr.algebra.model.Zone;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lorena
 */


public interface Repository<T> {
    int create(T item) throws Exception;
    void createMany(List<T> items) throws Exception;
    void update(int id, T item) throws Exception;
    void delete(int id) throws Exception;
    void deleteAll(int id) throws Exception;
    Optional<T> select(int id) throws Exception;
    List<T> selectAll() throws Exception;
}




//
//public interface Repository {
//
//    int createArticle(Article article) throws Exception;
//
//    void createArticles(List<Article> articles) throws Exception;
//
//    void updateArticle(int id, Article data) throws Exception;
//
//    void deleteArticle(int id) throws Exception;
//
//    Optional<Article> selectArticle(int id) throws Exception;
//
//    List<Article> selectArticles() throws Exception;
//    
//   // plant
//    
//    int createPlant(Plant plant) throws Exception;
//
//    void createPlants(List<Plant> plants) throws Exception;
//    
//    void updatePlant(int id, Plant data) throws Exception;
//
//    void deletePlant(int id) throws Exception;
//    
//    void deleteAllPlants() throws Exception;
//
//    Optional<Plant> getPlant(int id) throws Exception;
//    
//    List<Plant> getAllPlants() throws Exception;
//    
//    // family
//    
//    int createFamily(Family family) throws Exception;
//    
//    Optional<Family> getFamily(int id) throws Exception;
//    
//    List<Family> getAllFamilies() throws Exception;
//    
//    void updateFamily(int id, Family data) throws Exception;
//    
//    void deleteFamily(int id) throws Exception;
//    
//    void deleteAllFamilies() throws Exception;
//    
//    // conservation
//    
//    int createConservation(Conservation conservation) throws Exception;
//    
//    Optional<Conservation> getConservation(int id) throws Exception;
//    
//    List<Conservation> getAllConservations() throws Exception;
//    
//    void updateConservation(int id, Conservation data) throws Exception;
//    
//    void deleteConservation(int id) throws Exception;
//    
//    void deleteAllConservations() throws Exception;
//    
//    
//    // zone
//    
//    int createZone(Zone zone) throws Exception;
//    
//    Optional<Zone> getZone(int id) throws Exception;
//    
//    List<Zone> getAllZones() throws Exception;
//    
//    void updateZone(int id, Zone data) throws Exception;
//    
//    void deleteZone(int id) throws Exception;
//    
//    void deleteAllZones() throws Exception;
//    
//    // light
//    
//    int createLight(Light light) throws Exception;
//    
//    Optional<Light> getLight(int id) throws Exception;
//    
//    List<Light> getAllLights() throws Exception;
//    
//    void updateLight(int id, Light data) throws Exception;
//    
//    void deleteLight(int id) throws Exception;
//    
//    void deleteAllLights() throws Exception;
//    
//    
//}
