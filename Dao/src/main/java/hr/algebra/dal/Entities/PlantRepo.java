
package hr.algebra.dal.Entities;

import hr.algebra.dal.Repository;
import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.model.Conservation;
import hr.algebra.model.Family;
import hr.algebra.model.Light;
import hr.algebra.model.Plant;
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
public class PlantRepo implements Repository<Plant> {

    private static final String ID_PLANT = "ID";
    private static final String COMMON = "Common";
    private static final String BOTANICAL = "Botanical";
    private static final String FAMILYID = "FamilyID";
    private static final String CONSERVATIONID = "ConservationID";
    private static final String DESCRIPTION = "Description";
    private static final String PICTURE = "Picture";
    private static final String ZONEID = "ZoneID";
    private static final String LIGHTID = "LightID";
    private static final String PRICE = "Price";
    private static final String AVAILABILITY = "Availability";

    private static final String CREATE_PLANT = "{ CALL CreatePlant (?,?,?,?,?,?,?,?,?,?,?) }";
    private static final String UPDATE_PLANT = "{ CALL UpdatePlant (?,?,?,?,?,?,?,?,?,?,?) }";
    private static final String DELETE_PLANT = "{ CALL DeletePlant (?) }";
    private static final String DELETE_ALL_PLANTS = "{ CALL DeleteAllPlants (?) }";
    private static final String GET_PLANT = "{ CALL GetPlant (?) }";
    private static final String GET_ALL_PLANTS = "{ CALL GetAllPlants }";
    
    private static final String FAMILYNAME = "FamilyName";
    private static final String CONSERVATIONNAME = "ConservationName";
    private static final String ZONENAME = "ZoneName";
    private static final String LIGHTNAME = "LightName";

    @Override
    public int create(Plant item) throws Exception {
       DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_PLANT)) {

            stmt.setString(COMMON, item.getCommon_name());
            stmt.setString(BOTANICAL, item.getBotanical_name());
            stmt.setInt(FAMILYID, item.getFamily().getId());
            stmt.setInt(CONSERVATIONID, item.getConservation_status().getId());
            stmt.setString(DESCRIPTION, item.getDescription());
            stmt.setString(PICTURE, item.getPicture_path());
            stmt.setInt(ZONEID, item.getZone().getId());
            stmt.setInt(LIGHTID, item.getLight().getId());
            stmt.setDouble(PRICE, item.getPrice());
            stmt.setInt(AVAILABILITY, item.getAvailability());
            stmt.registerOutParameter(ID_PLANT,Types.INTEGER);
            
            
            stmt.executeUpdate();
            return stmt.getInt(ID_PLANT);
        }    }

    @Override
    public void createMany(List<Plant> items) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_PLANT)) {

            for (Plant plant : items) {
                stmt.setString(COMMON, plant.getCommon_name());
                stmt.setString(BOTANICAL, plant.getBotanical_name());
                stmt.setInt(FAMILYID, plant.getFamily().getId());
                stmt.setInt(CONSERVATIONID, plant.getConservation_status().getId());
                stmt.setString(DESCRIPTION, plant.getDescription());
                stmt.setString(PICTURE, plant.getPicture_path());
                stmt.setInt(ZONEID, plant.getZone().getId());
                stmt.setInt(LIGHTID, plant.getLight().getId());
                stmt.setDouble(PRICE, plant.getPrice());
                stmt.setInt(AVAILABILITY, plant.getAvailability());

                stmt.executeUpdate();
            }
        }    }

    @Override
    public void update(int id, Plant item) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_PLANT)) {

            stmt.setInt(ID_PLANT, id);
            stmt.setString(COMMON, item.getCommon_name());
            stmt.setString(BOTANICAL, item.getBotanical_name());
            stmt.setInt(FAMILYID, item.getFamily().getId());
            stmt.setInt(CONSERVATIONID, item.getConservation_status().getId());
            stmt.setString(DESCRIPTION, item.getDescription());
            stmt.setString(PICTURE, item.getPicture_path());
            stmt.setInt(ZONEID, item.getZone().getId());
            stmt.setInt(LIGHTID, item.getLight().getId());
            stmt.setDouble(PRICE, item.getPrice());
            stmt.setInt(AVAILABILITY, item.getAvailability());

            stmt.executeUpdate();
        }    }

    @Override
    public void delete(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_PLANT)) {

            stmt.setInt(ID_PLANT, id);

            stmt.executeUpdate();
        }    }

    @Override
    public void deleteAll(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_PLANTS)) {
            stmt.execute();
        }    }

    @Override
    public Optional<Plant> select(int id) throws Exception {
        Plant plant = null;
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_PLANT)) {

            stmt.setInt(ID_PLANT, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    plant = new Plant(
                            rs.getInt(ID_PLANT),
                            rs.getString(COMMON),
                            rs.getString(BOTANICAL),
                            new Family(rs.getInt(FAMILYID), rs.getString(FAMILYNAME)),
                            new Conservation(rs.getInt(CONSERVATIONID), rs.getString(CONSERVATIONNAME)),
                            rs.getString(DESCRIPTION),
                            rs.getString(PICTURE),
                            new Zone(rs.getInt(ZONEID), rs.getString(ZONENAME)),
                            new Light(rs.getInt(LIGHTID), rs.getString(LIGHTNAME)),                            
                            rs.getDouble(PRICE),
                            rs.getInt(AVAILABILITY));
                }
            }
        }

        if (plant == null) {
            return Optional.empty();
        }

        return Optional.of(plant);    }

    @Override
    public List<Plant> selectAll() throws Exception {
        List<Plant> plants = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(GET_ALL_PLANTS); )
        { 
            ResultSet rs = stmt.executeQuery();
    

            while (rs.next()) {
                plants.add(new Plant(
                            rs.getInt(ID_PLANT),
                            rs.getString(COMMON),
                            rs.getString(BOTANICAL),
                            new Family(rs.getInt(FAMILYID), rs.getString(FAMILYNAME)),
                            new Conservation(rs.getInt(CONSERVATIONID), rs.getString(CONSERVATIONNAME)),
                            rs.getString(DESCRIPTION),
                            rs.getString(PICTURE),
                            new Zone(rs.getInt(ZONEID), rs.getString(ZONENAME)),
                            new Light(rs.getInt(LIGHTID), rs.getString(LIGHTNAME)),                            
                            rs.getDouble(PRICE),
                            rs.getInt(AVAILABILITY)));
            }
        }
        return plants;    }

}
