/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.Repositories;

import hr.algebra.dal.Repository;
import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.model.Family;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author lorena
 */
public class FamilyRepo implements Repository<Family> {

    private static final String ID_FAMILY = "ID";
    private static final String FAMILYNAME = "FamilyName";

    private static final String CREATE_FAMILY = "{ CALL CreateFamily (?,?) }";
    private static final String GET_FAMILY = "{ CALL GetFamily (?) }";
    private static final String GET_ALL_FAMILIES = "{ CALL GetAllFamilies }";
    private static final String UPDATE_FAMILY = "{ CALL UpdateFamily (?,?) }";
    private static final String DELETE_FAMILY = "{ CALL DeleteFamily (?) }";
    private static final String DELETE_ALL_FAMILIES = "{ CALL DeleteAllFamilies }";
    
    @Override
    public int create(Family item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_FAMILY)) {

            stmt.setString(FAMILYNAME, item.getName());
            stmt.registerOutParameter(ID_FAMILY, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(ID_FAMILY);
        }    }

    @Override
    public void createMany(List<Family> items) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Family item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_FAMILY)) {

            stmt.setInt(ID_FAMILY, id);
            stmt.setString(FAMILYNAME, item.getName());

            stmt.executeUpdate();
        }     }

    @Override
    public void delete(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_FAMILY)) {

            stmt.setInt(ID_FAMILY, id);

            stmt.executeUpdate();
        }        }

    @Override
    public void deleteAll() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_FAMILIES)) {
            stmt.execute();
        }     }

    @Override
    public Optional<Family> select(int id) throws Exception {
        Family family = null;
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_FAMILY)) {
            
            stmt.setInt(ID_FAMILY, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    family = new Family(
                            rs.getInt(ID_FAMILY),
                            rs.getString(FAMILYNAME));  
                }
            }
        }
        if (family == null) {
            return Optional.empty();
        }

        return Optional.of(family);    }

    @Override
    public List<Family> selectAll() throws Exception {
        List<Family> families = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_ALL_FAMILIES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                families.add(new Family(
                            rs.getInt(ID_FAMILY),
                            rs.getString(FAMILYNAME)));
            }
        }
        return families;     }
    
}
