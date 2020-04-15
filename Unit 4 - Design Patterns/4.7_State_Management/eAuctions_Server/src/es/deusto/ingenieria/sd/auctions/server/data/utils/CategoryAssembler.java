package es.deusto.ingenieria.sd.auctions.server.data.utils;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.Category;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;

public class CategoryAssembler {
	private static CategoryAssembler instance;

	private CategoryAssembler() { }
	
	public static CategoryAssembler getInstance() {
		if (instance == null) {
			instance = new CategoryAssembler();
		}
		
		return instance;
	}

	public CategoryDTO entityToDTO(Category category) {
		CategoryDTO dto = new CategoryDTO();		
		dto.setName(category.getName());
		return dto;
	}

	public List<CategoryDTO> entityToDTO(List<Category> categories) {		
		List<CategoryDTO> dtos = new ArrayList<>();
		
		for (Category category : categories) {
			dtos.add(this.entityToDTO(category));
		}
		
		return dtos;
	}
}