package apaw.p2.sport.api;

import apaw.p2.sport.controllers.SportController;
import apaw.p2.sport.exceptions.InvalidSportNameException;
import apaw.p2.sport.exceptions.SportAlreadyExistsException;

public class SportResource {
	SportController sportController;

	public SportResource() {
		sportController = new SportController();
	}

	public void createSport(String name) throws InvalidSportNameException, SportAlreadyExistsException {
		if (name == null || name.isEmpty()) {
			throw new InvalidSportNameException(name);
		}
		if (!sportController.createSport(name)) {
			throw new SportAlreadyExistsException(name);
		}
	}
}
