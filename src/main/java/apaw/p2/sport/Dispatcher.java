package apaw.p2.sport;

import apaw.p2.sport.api.SportResource;
import apaw.p2.sport.api.UserResource;
import apaw.p2.sport.exceptions.RequestNotHandledException;
import apaw.p2.sport.utils.web.http.HttpRequest;
import apaw.p2.sport.utils.web.http.HttpResponse;
import apaw.p2.sport.utils.web.http.HttpStatus;

public class Dispatcher {
	UserResource userResource;
	SportResource sportResource;

	public Dispatcher() {
		userResource = new UserResource();
		sportResource = new SportResource();
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		String pathRequest = request.getPath();
		if (pathRequest.equals("users")) {
			response.setBody(userResource.users().toString());
		} else if (request.paths()[0].equals("users") && request.paths()[1].equals("search")) {

				String sportName = request.getParams().get("sport");
				try {
					response.setBody(userResource.findUsersBySport(sportName).toString());
				} catch (Exception e) {
					responseError(response, e);
				}		
		} else {
			responseError(response, new RequestNotHandledException(pathRequest));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		String requestPath = request.getPath();
		String requestBody = request.getBody();
		switch (requestPath) {
		case "users":
			String nickname = requestBody.split(":")[0];
			String email = requestBody.split(":")[1];
			try {
				userResource.createUser(nickname, email);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				this.responseError(response, e);
			}
			break;
		case "sports":
			try {
				sportResource.createSport(requestBody);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new RequestNotHandledException(requestPath));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		String[] requestPaths = request.paths();
		if (requestPaths[0].equals("users") && requestPaths[2].equals("sport")) {
			try {
				userResource.addSportToUser(requestPaths[1], request.getBody());
			} catch (Exception e) {
				responseError(response, e);
			}
		} else {
			responseError(response, new RequestNotHandledException(request.getPath()));
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		String requestPath = request.getPath();
		switch (requestPath) {
		default:
			responseError(response, new RequestNotHandledException(requestPath));
			break;
		}
	}

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}
}
