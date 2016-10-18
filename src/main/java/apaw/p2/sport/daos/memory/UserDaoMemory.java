package apaw.p2.sport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import apaw.p2.sport.daos.UserDao;
import apaw.p2.sport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {
	
	public UserDaoMemory(){
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public List<User> findUsersBySport(String sportName) {
		List<User> users = this.findAll();
		List<User> sportUsers = new ArrayList<>();
		for (User user : users) {
			if (user.practiceSport(sportName)) {
				sportUsers.add(user);
			}
		}
		return sportUsers;
	}
	
	@Override
    public User findUserByNick(String nickname) {
        List<User> users = this.findAll();
        for (User user : users) {
            if (user.getNick().equals(nickname)) {
                return user;
            }
        }
        return null;
    }

}
