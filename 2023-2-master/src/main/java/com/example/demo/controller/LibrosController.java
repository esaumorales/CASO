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

import static com.example.demo.commons.GlobalConstants.API_LIBROS;

import com.example.demo.entity.LibrosEntity;
import com.example.demo.service.LibrosService;



@RestController
@RequestMapping(API_LIBROS)
public class LibrosController {

	@Autowired
	private LibrosService librosService;

	@GetMapping("/all")
	public List<LibrosEntity> listar() {
		return librosService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<LibrosEntity> listar2(@PathVariable("id") long id) {
		LibrosEntity libr = librosService.read(id);
		if (libr!=null) {
			return new ResponseEntity<>(libr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/add")
	  public ResponseEntity<LibrosEntity> createTutorial(@Valid @RequestBody LibrosEntity l) {
	    try {
	    	LibrosEntity libr = librosService.create(l);

	      return new ResponseEntity<>(libr, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<LibrosEntity> updateTutorial(@PathVariable("id") long id, @RequestBody LibrosEntity libr) {
		LibrosEntity libros = librosService.read(id);

	    if (libros!=null) {
	    	libros.setId(libr.getId());
	    	libros.setTitulo(libr.getTitulo());
	    	libros.setFecha_lanzamiento(libr.getFecha_lanzamiento());
	    	libros.setAutor(libr.getAutor());
	    	libros.setCategoria(libr.getCategoria());
	    	libros.setEditorial(libr.getEditorial());
	    	libros.setIdioma(libr.getIdioma());
	    	libros.setPaginas(libr.getPaginas());
	    	libros.setDescripcion(libr.getDescripcion());
	    	libros.setPortada(libr.getPortada());
	      return new ResponseEntity<>(librosService.create(libros), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteDocumento(@PathVariable("id") long id) {
	    try {
	    	librosService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
