package com.ralph.sliger.LibrosApp.controllers;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ralph.sliger.LibrosApp.service.ICategoriaService;
import com.ralph.sliger.LibrosApp.response.CategoriaResponseRest;

@RestController
@RequestMapping("/v1")
public class CategoriaRestController {
	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/categorias")
	public ResponseEntity<CategoriaResponseRest> consultarCategoria() {
		ResponseEntity<CategoriaResponseRest> response = service.buscarCategorias();
		return response;
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<CategoriaResponseRest> consultarCategoriaPorId(Long id){
		ResponseEntity<CategoriaResponseRest> response = service.consultarCategoriaPorId(id);
		return response;
		
	}
	
}
