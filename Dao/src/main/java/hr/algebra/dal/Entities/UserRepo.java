/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.Entities;

import hr.algebra.dal.Repository;
import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.model.User;
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
public class UserRepo implements Repository<User>{
    
    private static final String ID_USER = "ID";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String ADMIN = "Admin";



    private static final String CREATE_USER = "{ CALL CreateUser (?,?,?,?) }";
    private static final String GET_USER = "{ CALL GetUser (?) }";
    private static final String GET_ALL_USERS = "{ CALL GetAllUsers }";
    private static final String UPDATE_USER = "{ CALL UpdateUser (?,?) }";
    private static final String DELETE_USER = "{ CALL DeleteUser (?) }";
    private static final String DELETE_ALL_USERS = "{ CALL DeleteAllUsers }";

    @Override
    public int create(User item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_USER)) {

            stmt.setInt(ID_USER, item.getId());
            stmt.setString(USERNAME, item.getUsername());
            stmt.setString(PASSWORD, item.getPassword());
            stmt.setBoolean(ADMIN, item.isAdmin());


            stmt.executeUpdate();
            return stmt.getInt(ID_USER);
        }        }

    @Override
    public void createMany(List<User> items) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, User item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_USER)) {

            stmt.setInt(ID_USER, item.getId());
            stmt.setString(USERNAME, item.getUsername());
            stmt.setString(PASSWORD, item.getPassword());


            stmt.executeUpdate();
        }         }

    @Override
    public void delete(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_USER)) {

            stmt.setInt(ID_USER, id);

            stmt.executeUpdate();
        }            }

    @Override
    public void deleteAll(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_USERS)) {
            stmt.execute();
        }         }

    @Override
    public Optional<User> select(int id) throws Exception {
        User user = null;
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_USER)) {
            
            stmt.setInt(ID_USER, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    user = new User(
                            rs.getInt(ID_USER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getBoolean(ADMIN));

                }
            }
        }
        if (user == null) {
            return Optional.empty();
        }

        return Optional.of(user);        }

    @Override
    public List<User> selectAll() throws Exception {
        List<User> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_ALL_USERS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                            rs.getInt(ID_USER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getBoolean(ADMIN)));
            }
        }
        return users;         }
    
}
