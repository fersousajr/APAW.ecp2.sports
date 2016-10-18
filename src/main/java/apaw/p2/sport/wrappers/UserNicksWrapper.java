package apaw.p2.sport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserNicksWrapper {
	private List<String> nicknames;

	public UserNicksWrapper() {
		this.nicknames = new ArrayList<>();
	}

	public UserNicksWrapper(List<String> nicknames) {
		this.nicknames = nicknames;
	}

	@Override
	public String toString() {
		String nicksJSON = "{\"nicknames\":[" 
							+ nicknames.get(0);
		for(String nickname : nicknames.subList(1, nicknames.size())){
			nicksJSON += "," + nickname;
		}
		nicksJSON += "]}";		
		return nicksJSON;
	}

}
