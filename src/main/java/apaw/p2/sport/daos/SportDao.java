package apaw.p2.sport.daos;

import apaw.p2.sport.entities.Sport;

public interface SportDao extends GenericDao<Sport, Integer>{

	Sport findSportByName(String sportName);

}
