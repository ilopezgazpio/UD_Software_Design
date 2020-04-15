package es.deusto.ingenieria.sd.server.db;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.Article;
import es.deusto.ingenieria.sd.auctions.server.data.Bid;
import es.deusto.ingenieria.sd.auctions.server.data.Category;
import es.deusto.ingenieria.sd.auctions.server.data.User;

public class DBManager {
	
	private static DBManager instance;
	
	private List<Category> categoriesCache;
	private List<Article> articlesCache;
	private List<User> usersCache;
	private List<Bid> bidsCache;
	
	private DBManager()
	{
		this.categoriesCache = new ArrayList<>();
		this.articlesCache = new ArrayList<>();
		this.usersCache = new ArrayList<>();
		this.bidsCache =  new ArrayList<>();

		User user1 = new User();
		user1.setEmail("sample@gmail.com");
		user1.setNickname("buyer33");
		user1.setPassword("12345");		
		
		User user2 = new User();
		user2.setEmail("troyaikman08@hotmail.com");
		user2.setNickname("troyaikman08");
		user2.setPassword("12345");
		
		this.usersCache.add(user1);
		this.usersCache.add(user2);
		
		Category iPadCat = new Category();
		iPadCat.setName("iPad");
		
		this.categoriesCache.add(iPadCat);
		
		Article iPadCover = new Article();
		iPadCover.setActive(true);
		iPadCover.setCategory(iPadCat);
		iPadCover.setInitialPrice(10.0f);
		iPadCover.setNumber(1);
		iPadCover.setOwner(user2);
		iPadCover.setTitle("iPad 2 Cover");		
		
		iPadCat.addArticle(iPadCover);
		user2.addArticle(iPadCover);
		
		Article iPadStylus = new Article();
		iPadStylus.setActive(true);
		iPadStylus.setCategory(iPadCat);
		iPadStylus.setInitialPrice(15.50f);
		iPadStylus.setNumber(2);
		iPadCover.setOwner(user2);
		iPadStylus.setTitle("iPad Stylus");
		
		iPadCat.addArticle(iPadStylus);
		user2.addArticle(iPadStylus);
		
		this.articlesCache.add(iPadCover);
		this.articlesCache.add(iPadStylus);
	}

	public static DBManager getInstance()
	{
		if (instance == null)
		{
			instance = new DBManager();
		}
		return instance;
	}

	public boolean store(Category category)
	{
		this.categoriesCache.add(category);
		return true;
	}

	public boolean store(Article article)
	{
		this.articlesCache.add(article);
		return true;
	}

	public boolean store(User user)
	{
		this.usersCache.add(user);
		return true;
	}

	public boolean store(Bid bid)
	{
		this.bidsCache.add(bid);
		return true;
	}

	public Category getCategory(String categoryName)
	{
		for (Category category : this.categoriesCache)
		{
			if (category.getName().equalsIgnoreCase(categoryName))
			{
				return category;
			}
		}
		return null;
	}

	public List<Category> getCategories()
	{
		return this.categoriesCache;
	}

	public Article getArticle(long number)
	{
		for (Article article : this.articlesCache)
		{
			if (article.getNumber() == number) {
				return article;
			}
		}
		return null;
	}

	public List<Article> getArticles(String category)
	{
		List<Article> articles = new ArrayList<>();
		
		for (Article article : this.articlesCache)
		{
			if (article.getCategory().getName().equalsIgnoreCase(category))
			{
				articles.add(article);
			}			
		}
		return articles;
	}

	public User getUser(String email)
	{
		for (User user : this.usersCache)
		{
			if (user.getEmail().equalsIgnoreCase(email))
			{
				return user;
			}
		}
		return null;
	}
}