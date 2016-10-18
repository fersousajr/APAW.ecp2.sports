package apaw.p2.sport;

import apaw.p2.sport.utils.web.http.HttpRequest;
import apaw.p2.sport.utils.web.http.HttpResponse;

public class Server {
	private Dispatcher dispatcher = new Dispatcher();

	public HttpResponse request(HttpRequest request) {
		HttpResponse response = new HttpResponse();
		switch (request.getMethod()) {
		case GET:
			dispatcher.doGet(request, response);
			break;
		case POST:
			dispatcher.doPost(request, response);
			break;
		case PUT:
			dispatcher.doPut(request, response);
			break;
		case DELETE:
			dispatcher.doDelete(request, response);
			break;
		default:
		}
		return response;
	}

}