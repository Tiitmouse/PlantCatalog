package hr.algebra.dal.sql;


import hr.algebra.dal.Context;
import hr.algebra.dal.Entities.ConservationRepo;
import hr.algebra.dal.Entities.FamilyRepo;
import hr.algebra.dal.Entities.LightRepo;
import hr.algebra.dal.Entities.PlantRepo;
import hr.algebra.dal.Entities.ZoneRepo;
import hr.algebra.dal.Entities.UserRepo;


/**
 *
 * @author lorena
 */
public class SqlContext extends Context {
        public SqlContext() {
        super( new PlantRepo(), new FamilyRepo(), new ConservationRepo(), new ZoneRepo(), new LightRepo(), new UserRepo());
    } }
