package apaw.p2.sport.controllers;

import java.util.ArrayList;
import java.util.List;

import apaw.p2.sport.daos.DaoFactory;
import apaw.p2.sport.entities.Sport;
import apaw.p2.sport.entities.User;
import apaw.p2.sport.wrappers.UserNicksWrapper;
import apaw.p2.sport.wrappers.UserWrapper;
import apaw.p2.sport.wrappers.UsersWrapper;

public class UserController {
	public UsersWrapper users() {
		List<User> users = DaoFactory.getFactory().getUserDao().findAll();
		List<UserWrapper> userWrappers = new ArrayList<>();
		for (User user : users) {
			userWrappers.add(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return new UsersWrapper(userWrappers);
	}

	public UserNicksWrapper findUserNicknamesBySport(String sportName) {
		List<User> users = DaoFactory.getFactory().getUserDao().findUsersBySport(sportName);
		List<String> userNicks = new ArrayList<>();
		for (User user : users) {
			userNicks.add(user.getNick());
		}
		return new UserNicksWrapper(userNicks);
	}
	
	public boolean addSportToUser(String nick, String sportName) {
        User user = this.findUserByNick(nick);
        if (!user.practiceSport(sportName)) {
            Sport sport = DaoFactory.getFactory().getSportDao().findSportByName(sportName);
            user.setSport(sport);
            return true;
        } 
        return false;
	}

	public boolean createUser(String nickname, String email) {
        if (this.findUserByNick(nickname) == null) {
        	User user = new User();
        	user.setNick(nickname);
        	user.setEmail(email);
            DaoFactory.getFactory().getUserDao().create(user);
            return true;
        }
        return false;
	}
	
	public User findUserByNick(String nickname) {
		return DaoFactory.getFactory().getUserDao().findUserByNick(nickname);
	}
}
