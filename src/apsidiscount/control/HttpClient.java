package apsidiscount.control;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

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
	
	private WebTarget setWebTarget(String uri) {
		
		client.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "INFO");
		WebTarget register = client.target(uri).register(new MoxyJsonFeature());
		return register;
	}
	
	public List<Article> getAllArticle() {

		WebTarget register = setWebTarget(uriArt);
		List<Article> articles = register.request().get(new ListArticleType());
		return articles;


	}



	public List<Category> getAllCategory() {

		WebTarget register = setWebTarget(uriCat);
		List<Category> categories = register.request().get(new ListCategoryType());
		return categories;


	}

	public List<Manufacturer> getAllManufacturer() {

		WebTarget register = setWebTarget(uriMan);
		List<Manufacturer> manufacturers = register.request().get(new ListManufacturerType());
		return manufacturers;


	}
	

	public static void main(String[] args) {

		List<Article> articles =  new HttpClient().getAllArticle();
		System.out.println(articles.get(5).getPublished());

	}
}
