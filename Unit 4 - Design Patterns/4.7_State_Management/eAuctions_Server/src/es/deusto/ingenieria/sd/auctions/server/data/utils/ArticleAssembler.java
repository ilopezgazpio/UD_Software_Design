package es.deusto.ingenieria.sd.auctions.server.data.utils;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.Article;
import es.deusto.ingenieria.sd.auctions.server.data.Bid;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;

public class ArticleAssembler {
	
	private static ArticleAssembler instance;

	private ArticleAssembler() { }
	
	public static ArticleAssembler getInstance() {
		if (instance == null) {
			instance = new ArticleAssembler();
		}

		return instance;
	}

	public ArticleDTO entityToDTO(Article article) {
		ArticleDTO dto = new ArticleDTO();
		
		dto.setNumber(article.getNumber());
		dto.setTitle(article.getTitle());
		
		List<Bid> bids = article.getBids();
		
		if (bids.isEmpty()) {
			dto.setActualPrice(article.getInitialPrice());
		} else {
			dto.setActualPrice(bids.get(bids.size()-1).getPrice());
		}
				
		return dto;
	}
	
	public List<ArticleDTO> entityToDTO(List<Article> articles) {
		List<ArticleDTO> dtos = new ArrayList<>();
		
		for (Article article : articles) {
			dtos.add(this.entityToDTO(article));
		}
		
		return dtos;		
	}
}