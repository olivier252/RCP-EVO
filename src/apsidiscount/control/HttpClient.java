package apsidiscount.control;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

import apsidiscount.models.Article;
import apsidiscount.models.Category;
import apsidiscount.models.Manufacturer;

public class HttpClient {
	
	private Client client = ClientBuilder.newClient();
	private final static String uriArt = "http://localhost:8081/apsidiscountweb/api/allarticle";
	private final static String uriCat = "http://localhost:8081/apsidiscountweb/api/allcategory";
	private final static String uriMan = "http://localhost:8081/apsidiscountweb/api/allmanufacturer";
	private final static String uriOneArt = "http://localhost:8081/apsidiscountweb/api/article/{id}";
	
	private WebTarget createWebTarget(String uri) {
		
		client.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "INFO");
		WebTarget register = client.target(uri).register(new MoxyJsonFeature());
		return register;
	}
	
	public List<Article> getAllArticle() {

		WebTarget register = createWebTarget(uriArt);
		List<Article> articles = register.request().get(new ListArticleType());
		return articles;


	}
	
	public Article getArticleById(long id) {
		
		WebTarget register = createWebTarget(uriOneArt);
		Article article = register.resolveTemplate("id", id).request().get(Article.class);
		return article;
	}



	public List<Category> getAllCategory() {

		WebTarget register = createWebTarget(uriCat);
		List<Category> categories = register.request().get(new ListCategoryType());
		return categories;


	}

	public List<Manufacturer> getAllManufacturer() {

		WebTarget register = createWebTarget(uriMan);
		List<Manufacturer> manufacturers = register.request().get(new ListManufacturerType());
		return manufacturers;


	}
	
	public void modifiedArticle(Article a) { 
		
		WebTarget register = createWebTarget(uriOneArt);
		register.resolveTemplate("id", a.getId()).request().put(Entity.entity(a, MediaType.APPLICATION_JSON));
		
	}
	

//	public static void main(String[] args) {
//
//		Article articles =  new HttpClient().getArticleById(5);
//		System.out.println(articles.getDescription());
//
//	}
	
	public static void main(String[] args) {
		HttpClient hc = new HttpClient();
		Article a =  hc.getArticleById(5);
		a.setDescription("hjkbhvjvb");
		hc.modifiedArticle(a);
		System.out.println(a.getDescription());

	}
}
