package es.deusto.ingenieria.sd.auctions.server.test;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.Article;
import es.deusto.ingenieria.sd.auctions.server.data.Category;

public class EntitiesTest
{

	public static void main(String[] args)
	{
		Category cPhoto = new Category();
		cPhoto.setName("Cameras & Photography ");
		
		Article article = new Article();
		article.setNumber(0);
		article.setActive(true);		
		article.setTitle("Fuji FinePix S4500 (White)");
		article.setInitialPrice(145.00f);
		article.setOwner(null);
		article.setCategory(cPhoto);		
		cPhoto.addArticle(article);
		
		article = new Article();
		article.setNumber(1);
		article.setActive(true);		
		article.setTitle("Canon PowerShot ELPH 310 HS (Purple)");
		article.setInitialPrice(99.99f);
		article.setOwner(null);
		article.setCategory(cPhoto);		
		cPhoto.addArticle(article);
		
		article = new Article();
		article.setNumber(2);
		article.setActive(true);		
		article.setTitle("Sony Cyber-shot DSC-W650 16MP (Black)");
		article.setInitialPrice(64.99f);
		article.setOwner(null);
		article.setCategory(cPhoto);		
		cPhoto.addArticle(article);
		
		Category cComputer = new Category();
		cComputer.setName("Computers & Tablets ");
				
		article = new Article();
		article.setNumber(3);
		article.setActive(true);		
		article.setTitle("10.1' Android 4.03 ICS Tablet 8GB VC0882");
		article.setInitialPrice(107.98f);
		article.setOwner(null);
		article.setCategory(cComputer);		
		cComputer.addArticle(article);
		
		article = new Article();
		article.setNumber(4);
		article.setActive(true);		
		article.setTitle("Apple iPad mini 64GB, Wi-Fi + 4G (AT&T)");
		article.setInitialPrice(560.00f);
		article.setOwner(null);
		article.setCategory(cComputer);		
		cComputer.addArticle(article);

		article = new Article();
		article.setNumber(5);
		article.setActive(true);		
		article.setTitle("NEW Amazon Kindle Fire HD 32GB");
		article.setInitialPrice(255.50f);
		article.setOwner(null);
		article.setCategory(cComputer);		
		cComputer.addArticle(article);
		
		Category cPhone = new Category();
		cPhone.setName("Cell Phones & Accessories");
		
		article = new Article();
		article.setNumber(6);
		article.setActive(true);		
		article.setTitle("Samsung Galaxy S III (T-Mobile)");
		article.setInitialPrice(349.99f);
		article.setOwner(null);
		article.setCategory(cPhone);		
		cPhone.addArticle(article);
		
		article = new Article();
		article.setNumber(7);
		article.setActive(true);		
		article.setTitle("Apple iPhone 5 32GB (Sprint)");
		article.setInitialPrice(316.00f);
		article.setOwner(null);
		article.setCategory(cPhone);		
		cPhone.addArticle(article);		
		
		article = new Article();
		article.setNumber(8);
		article.setActive(true);		
		article.setTitle("Motorola DROID RAZR XT912 LTE (Verizon)");
		article.setInitialPrice(318.40f);
		article.setOwner(null);
		article.setCategory(cPhone);		
		cPhone.addArticle(article);
		
		
		List<Category> categories = new ArrayList<>();
		categories.add(cPhoto);
		categories.add(cComputer);
		categories.add(cPhone);
		
		for (Category c : categories)
		{
			System.out.println(c);
		}
	}
}