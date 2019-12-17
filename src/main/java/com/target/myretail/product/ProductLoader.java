package com.target.myretail.product;

import com.target.myretail.product.beans.Product;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ProductLoader {

	public static Map<String, Product> productData = new HashMap<>();

	@PostConstruct
	public static void loadProduct() {

		productData.put("15117729", Product.builder().id("15117729").name("The Big Lebowski (Blu-ray)").build());
		productData.put("15117730", Product.builder().id("15117730").name("SOME GIRLS:LIVE IN TEXAS 78 (DVD)").build());
		productData.put("15117731", Product.builder().id("15117731").name("Progressive Power Yoga: Sedona Experience Culmination (DVD)").build());
		productData.put("15117732", Product.builder().id("15117732").name("Black Country Communion: Live Over Europe (Blu-ray))").build());
		productData.put("15117733", Product.builder().id("15117733").name("Final Destination 5 (dvd_video)").build());
		productData.put("15117734", Product.builder().id("15117734").name("Revolutionary Girl Utena: Apocalypse Saga Collection (DVD)").build());
	}

}
