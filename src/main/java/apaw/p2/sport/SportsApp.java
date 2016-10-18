package apaw.p2.sport;

import apaw.p2.sport.daos.DaoFactory;
import apaw.p2.sport.daos.memory.DaoFactoryMemory;
import apaw.p2.sport.utils.web.http.HttpMethod;
import apaw.p2.sport.utils.web.http.HttpRequest;
import apaw.p2.sport.utils.web.http.HttpResponse;

public class SportsApp {
	private Server server;

	private HttpRequest request;

	public SportsApp() {
		this.server = new Server();
		this.request = new HttpRequest();
	}

	public void simulate() {
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("uno:uno@gmail.com");
		this.doRequest(); //POST / users body=uno:uno@gmail.com
		request.setBody("dos:dos@gmail.com");
		this.doRequest(); //POST / users body=dos:dos@gmail.com
		request.setBody("uno:tres@gmail.com");
		this.doRequest(); //POST / users body=uno:tres@gmail.com
		request.setMethod(HttpMethod.GET);
		request.setBody("");
		this.doRequest(); //GET / users
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("tenis");
		this.doRequest(); //POST / sports body=tenis
		this.doRequest(); //POST / sports body=tenis
		request.setBody("ajedrez");
		this.doRequest(); //POST / sports body=ajedrez
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/uno/sport");
		request.setBody("tenis");
		this.doRequest(); //PUT / users/uno/sport body=tenis
		request.setBody("noDeporte");
		this.doRequest(); //PUT / users/uno/sport body=noDeporte
		request.setPath("users/dos/sport");
		request.setBody("tenis");
		this.doRequest(); //PUT / users/dos/sport body=tenis
		request.setBody("ajedrez");
		this.doRequest(); //PUT / users/dos/sport body=ajedrez
		request.setMethod(HttpMethod.GET);
		request.setPath("users/search");
		request.addQueryParam("sport", "tenis");
		request.setBody("");
		this.doRequest(); //GET / users/search?sport=tenis
		request.clearQueryParams();
		request.setMethod(HttpMethod.POST);
		request.setPath("noPath");
		this.doRequest(); //POST / noPath
	}

	private void doRequest() {
		System.out.println(request.toString());
		HttpResponse response = server.request(request);
		System.out.println(response);
		System.out.println("===============================================");
	}

	public static void main(String[] args) {
		DaoFactory.setFactory(new DaoFactoryMemory());
		new SportsApp().simulate();
	}
}
