package apsidiscount.control;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

import apsidiscount.models.Article;

public class HttpClient {

	
	public List<Article> getAllArticle() {
		
		Client client = ClientBuilder.newClient();
		client.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "INFO");


		String uri = "http://localhost:8081/apsidiscountweb/api/allarticle";
		List<Article> articles = client.target(uri).register(new MoxyJsonFeature()).request().get(new ListArticleType());
		return articles;
			
		
	}
	
	 public static void main(String[] args) { 
		 
	 List<Article> articles =  new HttpClient().getAllArticle();
	 System.out.println(articles);
	  
	  


			
				
			
	 }
}
