package apaw.p2.sport.api;

import apaw.p2.sport.controllers.SportController;
import apaw.p2.sport.controllers.UserController;
import apaw.p2.sport.exceptions.InvalidSportNameException;
import apaw.p2.sport.exceptions.InvalidUserEmailException;
import apaw.p2.sport.exceptions.InvalidUserNickException;
import apaw.p2.sport.exceptions.SportAlreadyExistsInUserException;
import apaw.p2.sport.exceptions.SportNotFoundException;
import apaw.p2.sport.exceptions.UserAlreadyExistsException;
import apaw.p2.sport.exceptions.UserNotFoundException;
import apaw.p2.sport.wrappers.UsersWrapper;
import apaw.p2.sport.wrappers.UserNicksWrapper;

public class UserResource {
	private UserController userController;

	private SportController sportController;

	public UserResource() {
		userController = new UserController();
		sportController = new SportController();
	}

	public UsersWrapper users() {
		return userController.users();
	}
	
	public UserNicksWrapper findUsersBySport(String sportName)
			throws InvalidSportNameException, SportNotFoundException {
		this.validateSport(sportName);
		return userController.findUserNicknamesBySport(sportName);
	}

	private void validateSport(String sportName) throws InvalidSportNameException, SportNotFoundException {
		if (isFieldEmptyOrNull(sportName)) {
			throw new InvalidSportNameException(sportName);
		}
		if (!sportController.findSportByName(sportName)) {
			throw new SportNotFoundException(sportName);
		}
	}

	public void createUser(String nick, String email)
			throws InvalidUserNickException, InvalidUserEmailException, UserAlreadyExistsException {
		if (isFieldEmptyOrNull(nick)) {
			throw new InvalidUserNickException(nick);
		}
		if (isFieldEmptyOrNull(email)) {
			throw new InvalidUserEmailException(email);
		}
		if (!userController.createUser(nick, email)) {
			throw new UserAlreadyExistsException(nick);
		}
	}

	public void addSportToUser(String nick, String sportName)
			throws InvalidUserNickException, InvalidSportNameException, SportNotFoundException, UserNotFoundException,
			SportAlreadyExistsInUserException {
		if (isFieldEmptyOrNull(nick)) {
			throw new InvalidUserNickException(nick);
		}
		if (isFieldEmptyOrNull(sportName)) {
			throw new InvalidSportNameException(sportName);
		}
		if (userController.findUserByNick(nick) == null) {
			throw new UserNotFoundException(nick);
		}
		if (!sportController.findSportByName(sportName)) {
			throw new SportNotFoundException(sportName);
		}
		if (!userController.addSportToUser(nick, sportName)) {
			throw new SportAlreadyExistsInUserException(sportName);
		}
	}

	private boolean isFieldEmptyOrNull(String field) {
		return field == null || field.isEmpty();
	}
}
