package com.example.demo.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.commons.GlobalConstants.API_CATEGORIAS;

import com.example.demo.entity.CategoriasEntity;
import com.example.demo.service.CategoriasService;



@RestController
@RequestMapping(API_CATEGORIAS)
public class CategoriasController {

	@Autowired
	private CategoriasService categoriasService;

	@GetMapping("/all")
	public List<CategoriasEntity> listar() {
		return categoriasService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriasEntity> listar2(@PathVariable("id") long id) {
		CategoriasEntity cate = categoriasService.read(id);
		if (cate!=null) {
			return new ResponseEntity<>(cate, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/add")
	  public ResponseEntity<CategoriasEntity> createTutorial(@Valid @RequestBody CategoriasEntity c) {
	    try {
	    	CategoriasEntity cate = categoriasService.create(c);

	      return new ResponseEntity<>(cate, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<CategoriasEntity> updateTutorial(@PathVariable("id") long id, @RequestBody CategoriasEntity cate) {
		CategoriasEntity categorias = categoriasService.read(id);

	    if (categorias!=null) {
	    	categorias.setId(cate.getId());
	    	categorias.setCategoria(cate.getCategoria());
	    	
	      return new ResponseEntity<>(categoriasService.create(categorias), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteCategorias(@PathVariable("id") long id) {
	    try {
	    	categoriasService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
