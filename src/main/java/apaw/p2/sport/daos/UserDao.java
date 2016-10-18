package apaw.p2.sport.daos;

import java.util.List;

import apaw.p2.sport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
	public List<User> findUsersBySport(String sportName);

	public User findUserByNick(String nickname);
}
