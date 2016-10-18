package apaw.p2.sport.wrappers;

import java.util.List;

public class UsersWrapper {
	private List<UserWrapper> userWrappers;

	public UsersWrapper(List<UserWrapper> userWrappers) {
		this.userWrappers = userWrappers;
	}

	@Override
	public String toString() {
		String usersJSON = "{\"nicknames\":[" + userWrappers.get(0).toString();
		for (UserWrapper userWrapper : userWrappers.subList(1, userWrappers.size())) {
			usersJSON += "," + userWrapper.toString();
		}
		usersJSON += "]}";
		return usersJSON;
	}
}
