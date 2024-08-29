/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.Entities;

import hr.algebra.dal.Repository;
import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.model.Zone;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author lorena
 */
public class ZoneRepo implements Repository<Zone> {

    private static final String ID_ZONE = "ID";
    private static final String ZONENAME = "ZoneName";

    private static final String CREATE_ZONE = "{ CALL CreateZone (?,?) }";
    private static final String GET_ZONE = "{ CALL GetZone (?) }";
    private static final String GET_ALL_ZONES = "{ CALL GetAllFamilies }";
    private static final String UPDATE_ZONE = "{ CALL UpdateZone (?) }";
    private static final String DELETE_ZONE = "{ CALL DeleteZone (?) }";
    private static final String DELETE_ALL_ZONES = "{ CALL DeleteAllFamilies }";
    
    @Override
    public int create(Zone item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_ZONE)) {

            stmt.setString(ZONENAME, item.getZoneName());
            stmt.registerOutParameter(ID_ZONE, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(ID_ZONE);
        }    }

    @Override
    public void createMany(List<Zone> items) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Zone item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_ZONE)) {

            stmt.setInt(ID_ZONE, id);
            stmt.setString(ZONENAME, item.getZoneName());

            stmt.executeUpdate();
        }     }

    @Override
    public void delete(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ZONE)) {

            stmt.setInt(ID_ZONE, id);

            stmt.executeUpdate();
        }        }

    @Override
    public void deleteAll(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_ZONES)) {
            stmt.execute();
        }     }

    @Override
    public Optional<Zone> select(int id) throws Exception {
        Zone family = null;
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_ZONE)) {
            
            stmt.setInt(ID_ZONE, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    family = new Zone(
                            rs.getInt(ID_ZONE),
                            rs.getString(ZONENAME));  
                }
            }
        }
        if (family == null) {
            return Optional.empty();
        }

        return Optional.of(family);    }

    @Override
    public List<Zone> selectAll() throws Exception {
        List<Zone> zones = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_ALL_ZONES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                zones.add(new Zone(
                            rs.getInt(ID_ZONE),
                            rs.getString(ZONENAME)));
            }
        }
        return zones;     }
    
}
