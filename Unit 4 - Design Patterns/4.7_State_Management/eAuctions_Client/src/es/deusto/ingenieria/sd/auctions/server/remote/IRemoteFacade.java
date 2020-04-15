package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;

public interface IRemoteFacade extends Remote
{
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	public List<CategoryDTO> getCategories() throws RemoteException;
	public List<ArticleDTO> getArticles(String aCategory) throws RemoteException;
	public boolean makeBid(long aArticle, float aBid) throws RemoteException;	
}