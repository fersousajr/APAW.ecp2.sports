package apaw.p2.sport.utils.web.http;

public class RequestBuilder {
	HttpRequest request;
	
	public RequestBuilder(){
		request = new HttpRequest();
	}
	
	public RequestBuilder setMethod(HttpMethod httpMethod){
		this.request.setMethod(httpMethod);
		return this;
	}
	
	public RequestBuilder setPath(String path){
		this.request.setPath(path);
		return this;
	}
	
	public RequestBuilder setBody(String body){
		this.request.setBody(body);
		return this;
	}
	
	public HttpRequest build(){
		return this.request;
	}
}
