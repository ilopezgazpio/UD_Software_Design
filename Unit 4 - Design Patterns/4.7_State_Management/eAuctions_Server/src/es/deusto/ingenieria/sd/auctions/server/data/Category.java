package es.deusto.ingenieria.sd.auctions.server.data;

import java.util.ArrayList;
import java.util.List;

public class Category
{
	
	private String name;
	private List<Article> articles;
	
	public Category()
	{
		this.articles = new ArrayList<>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public List<Article> getArticles()
	{
		return articles;
	}
	
	public void setArticles(List<Article> articles)
	{
		this.articles = articles;
	}
	
	public void addArticle(Article article)
	{
		if (article != null && !this.articles.contains(article))
		{
			this.articles.add(article);
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj != null && obj.getClass().getName().equals(this.getClass().getName()))
		{
			return this.name.equals(((Category)obj).name);
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		StringBuffer result = new StringBuffer();
		
		result.append(this.name);
		result.append("(");
		result.append(this.articles.size());
		result.append(" articles)");
		
		for (Article article : this.articles)
		{
			result.append("\n - ");
			result.append(article);
		}
		
		return result.toString();
	}
}