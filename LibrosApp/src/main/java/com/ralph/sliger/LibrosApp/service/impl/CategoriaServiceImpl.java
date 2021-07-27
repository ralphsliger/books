package com.ralph.sliger.LibrosApp.service.impl;

import com.ralph.sliger.LibrosApp.models.Categoria;
import com.ralph.sliger.LibrosApp.models.dao.ICategoriaDAO;
import com.ralph.sliger.LibrosApp.response.CategoriaResponseRest;
import com.ralph.sliger.LibrosApp.service.ICategoriaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);

	@Autowired
	private ICategoriaDAO categoriaDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoriaResponseRest> buscarCategorias() {
		log.info("Inicio metodo buscarCategorias()");
		CategoriaResponseRest response = new CategoriaResponseRest();
		try {
			List<Categoria> categoria = (List<Categoria>) categoriaDao.findAll();
			response.getCategoriaResponse().setCategoria(categoria);
			response.setMetadata("Respuesta exitosa", "200", "...");
		} catch (Exception e) {
			log.error("Ha ocurrido un error en metodo buscarCategorias() " + e.getMessage());
			response.setMetadata("Respuesta Error", "500", "Respuesta No exitosa");
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoriaResponseRest> consultarCategoriaPorId(Long id) {
		log.info("Inicio metodo consultarCategoriaPorId()");
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> list = new ArrayList<>();
		try {
			Optional<Categoria> categoria = categoriaDao.findById(id);
			
			if(categoria.isPresent()) {
				list.add(categoria.get());
				response.getCategoriaResponse().setCategoria(list);
			}else {
				log.error("Categoria no encontrada");
				response.setMetadata("No se ha encontrado la categoria", "404", "Categoria");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			log.error("Ha ocurrido un error");
			response.setMetadata("Ha ocurrido un error", "500", "Error al consultar categoria");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

}
