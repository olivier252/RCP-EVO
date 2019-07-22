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
	private final static String uriArtbyCat = "http://localhost:8081/apsidiscountweb/api/categorie/{id}/article";
	private final static String uriArtbyMan = "http://localhost:8081/apsidiscountweb/api/manufacturer/{id}/article";
	
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
	
	public List<Article> getArticlebyCat(Long id) {
		
		WebTarget register = createWebTarget(uriArtbyCat);
		List<Article> articles = register.resolveTemplate("id", id).request().get(new ListArticleType());
		return articles;
		
	}
	
	public List<Article> getArticlebyMan(Long id) {
		
		WebTarget register = createWebTarget(uriArtbyMan);
		List<Article> articles = register.resolveTemplate("id", id).request().get(new ListArticleType());
		return articles;
		
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
		System.out.println(a.getDescription());

	}
}
