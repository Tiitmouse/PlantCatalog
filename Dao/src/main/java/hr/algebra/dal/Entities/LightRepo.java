/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.Entities;

import hr.algebra.dal.Repository;
import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.model.Light;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author lorena
 */
public class LightRepo implements Repository<Light> {

    private static final String ID_LIGHT = "ID";
    private static final String LIGHTNAME = "LightName";

    private static final String CREATE_LIGHT = "{ CALL CreateLight (?,?) }";
    private static final String GET_LIGHT = "{ CALL GetLight (?) }";
    private static final String GET_ALL_LIGHTS = "{ CALL GetAllFamilies }";
    private static final String UPDATE_LIGHT = "{ CALL UpdateLight (?) }";
    private static final String DELETE_LIGHT = "{ CALL DeleteLight (?) }";
    private static final String DELETE_ALL_LIGHTS = "{ CALL DeleteAllFamilies }";
    
    @Override
    public int create(Light item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_LIGHT)) {

            stmt.setInt(ID_LIGHT, item.getId());
            stmt.setString(LIGHTNAME, item.getLightName());

            stmt.executeUpdate();
            return stmt.getInt(ID_LIGHT);
        }    }

    @Override
    public void createMany(List<Light> items) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Light item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_LIGHT)) {

            stmt.setInt(ID_LIGHT, id);
            stmt.setString(LIGHTNAME, item.getLightName());

            stmt.executeUpdate();
        }     }

    @Override
    public void delete(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_LIGHT)) {

            stmt.setInt(ID_LIGHT, id);

            stmt.executeUpdate();
        }        }

    @Override
    public void deleteAll(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_LIGHTS)) {
            stmt.execute();
        }     }

    @Override
    public Optional<Light> select(int id) throws Exception {
        Light light = null;
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_LIGHT)) {
            
            stmt.setInt(ID_LIGHT, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    light = new Light(
                            rs.getInt(ID_LIGHT),
                            rs.getString(LIGHTNAME));  
                }
            }
        }
        if (light == null) {
            return Optional.empty();
        }

        return Optional.of(light);    }

    @Override
    public List<Light> selectAll() throws Exception {
        List<Light> lights = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_ALL_LIGHTS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lights.add(new Light(
                            rs.getInt(ID_LIGHT),
                            rs.getString(LIGHTNAME)));
            }
        }
        return lights;     }
    
}
