package apsidiscount.control;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.logging.LoggingFeature;

import apsidiscount.models.Article;

public class HttpClient {

	
	public List<Article> getAllArticle() {
		
		Client client = ClientBuilder.newClient();
		client.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "INFO");


		List<Article> articles = client.target("http://localhost:8081/apsidiscountweb/article/6").request().get(List.class);
		for(Article article : articles) {
			System.out.println(article.getId());
		}
		return articles;
	}
	
	 public static void main(String[] args) { 
		 
		 	Client client = ClientBuilder.newClient();
			client.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "INFO");


			Article article = client.target("http://localhost:8081/apsidiscountweb/api/article/6").request().get(Article.class);
			
				System.out.println(article.getContent());
			
	 }
}