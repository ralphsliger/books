package com.ralph.sliger.LibrosApp.response;
import java.util.List;

import com.ralph.sliger.LibrosApp.models.Categoria;
public class CategoriaResponse {
	
	private List<Categoria> categoria;
	
	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

}
