/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package hr.algebra.test;

import hr.algebra.dal.ContextFactory;
import hr.algebra.model.Family;
import hr.algebra.model.Plant;
import hr.algebra.model.User;
import java.util.List;

/**
 *
 * @author lorena
 */
public class Test {

    public static void main(String[] args) {

        var repo = ContextFactory.getRepository();

        try {
            List<Family> families = repo.families.selectAll();
            List<Plant> plants = repo.plants.selectAll();
            List<User> users = repo.users.selectAll();

            

            families.forEach(f -> System.out.println(f.getFamilyName()));
            plants.forEach(f -> System.out.println(f.toString()));
            users.forEach(f -> System.out.println(f.toString()));


        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
