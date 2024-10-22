package hr.algebra.dal.sql;


import hr.algebra.dal.Context;
import hr.algebra.dal.Repositories.ConservationRepo;
import hr.algebra.dal.Repositories.FamilyRepo;
import hr.algebra.dal.Repositories.LightRepo;
import hr.algebra.dal.Repositories.PlantRepo;
import hr.algebra.dal.Repositories.ZoneRepo;
import hr.algebra.dal.Repositories.UserRepo;


/**
 *
 * @author lorena
 */
public class SqlContext extends Context {
        public SqlContext() {
        super( new PlantRepo(), new FamilyRepo(), new ConservationRepo(), new ZoneRepo(), new LightRepo(), new UserRepo());
    } }
