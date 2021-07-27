package com.ralph.sliger.LibrosApp.service;

import org.springframework.http.ResponseEntity;

import com.ralph.sliger.LibrosApp.response.CategoriaResponseRest;

public interface ICategoriaService {

	public ResponseEntity<CategoriaResponseRest> buscarCategorias();
	public ResponseEntity<CategoriaResponseRest> consultarCategoriaPorId(Long id);

}
