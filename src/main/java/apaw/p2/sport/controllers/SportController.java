package apaw.p2.sport.controllers;

import apaw.p2.sport.daos.DaoFactory;
import apaw.p2.sport.entities.Sport;

public class SportController {
	public boolean createSport(String sportName) {
        boolean existingSport = this.findSportByName(sportName);
        if (!existingSport) {
            DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
            return true;
        } else {
            return false;
        }
    }

    public boolean findSportByName(String sportName) {
        Sport sport = DaoFactory.getFactory().getSportDao().findSportByName(sportName);
        return sport != null;
    }
}
