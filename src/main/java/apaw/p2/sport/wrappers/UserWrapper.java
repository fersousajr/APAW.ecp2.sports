package apaw.p2.sport.wrappers;

public class UserWrapper {
	private String nickname;

	private String email;

	public UserWrapper(String nickname, String email) {
		this.nickname = nickname;
		this.email = email;
	}

	@Override
	public String toString() {
		return "{\"nickname\":\"" + nickname + "\", \"email\":\"" + email + "\"}";
	}
}
