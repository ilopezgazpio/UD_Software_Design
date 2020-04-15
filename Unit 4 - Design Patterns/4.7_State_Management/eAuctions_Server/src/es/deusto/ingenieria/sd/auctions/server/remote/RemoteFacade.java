package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;
import es.deusto.ingenieria.sd.auctions.server.services.BidService;
import es.deusto.ingenieria.sd.auctions.server.services.EntityDataService;
import es.deusto.ingenieria.sd.auctions.server.services.LoginService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade
{
	private static final long serialVersionUID = 1L;
	private static RemoteFacade instance;
	public User state;

	private RemoteFacade() throws RemoteException
	{
		super();		
	}
	
	public static RemoteFacade getInstance()
	{
		if (instance == null)
		{
			try
			{
				instance = new RemoteFacade();
			}
			catch (Exception ex)
			{
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		
		return instance;
	}

	public boolean login(String email, String password)
	{
		this.state = LoginService.getInstance().login(email, password);
		return state != null;
	}

	public List<CategoryDTO> getCategories()
	{
		return EntityDataService.getInstance().getCategories();
	}

	public List<ArticleDTO> getArticles(String category)
	{
		return EntityDataService.getInstance().getArticles(category);
	}

	public boolean makeBid(long article, float bid)
	{
		if (state != null)
		{
			return BidService.getInstance().makeBid(state, article, bid);
		}
		else
		{
			return false;
		}
	}
}