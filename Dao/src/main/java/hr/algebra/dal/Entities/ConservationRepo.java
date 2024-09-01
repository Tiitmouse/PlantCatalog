/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.Entities;

import hr.algebra.dal.Repository;
import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.model.Conservation;
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
public class ConservationRepo implements Repository<Conservation> {

    private static final String ID_CONSERVATION = "ID";
    private static final String CONSERVATIONNAME = "ConservationName";

    private static final String CREATE_CONSERVATION = "{ CALL CreateConservation (?,?) }";
    private static final String GET_CONSERVATION = "{ CALL GetConservation (?) }";
    private static final String GET_ALL_CONSERVATIONS = "{ CALL GetAllConservations }";
    private static final String UPDATE_CONSERVATION = "{ CALL UpdateConservation (?,?) }";
    private static final String DELETE_CONSERVATION = "{ CALL DeleteConservation (?) }";
    private static final String DELETE_ALL_CONSERVATIONS = "{ CALL DeleteAllConservations }";
    
    @Override
    public int create(Conservation item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_CONSERVATION)) {

            stmt.setString(CONSERVATIONNAME, item.getName());
            stmt.registerOutParameter(ID_CONSERVATION, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(ID_CONSERVATION);
        }    }

    @Override
    public void createMany(List<Conservation> items) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Conservation item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_CONSERVATION)) {

            stmt.setInt(ID_CONSERVATION, id);
            stmt.setString(CONSERVATIONNAME, item.getName());

            stmt.executeUpdate();
        }     }

    @Override
    public void delete(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_CONSERVATION)) {

            stmt.setInt(ID_CONSERVATION, id);

            stmt.executeUpdate();
        }        }

    @Override
    public void deleteAll() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_CONSERVATIONS)) {
            stmt.execute();
        }     }

    @Override
    public Optional<Conservation> select(int id) throws Exception {
        Conservation conservation = null;
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_CONSERVATION)) {
            
            stmt.setInt(ID_CONSERVATION, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    conservation = new Conservation(
                            rs.getInt(ID_CONSERVATION),
                            rs.getString(CONSERVATIONNAME));  
                }
            }
        }
        if (conservation == null) {
            return Optional.empty();
        }

        return Optional.of(conservation);    }

    @Override
    public List<Conservation> selectAll() throws Exception {
        List<Conservation> conservations = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_ALL_CONSERVATIONS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                conservations.add(new Conservation(
                            rs.getInt(ID_CONSERVATION),
                            rs.getString(CONSERVATIONNAME)));
            }
        }
        return conservations;     }
    
}
