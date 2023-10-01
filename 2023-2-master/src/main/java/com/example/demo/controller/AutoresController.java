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

import static com.example.demo.commons.GlobalConstants.API_AUTORES;

import com.example.demo.entity.AutoresEntity;
import com.example.demo.service.AutoresService;



@RestController
@RequestMapping(API_AUTORES)
public class AutoresController {

	@Autowired
	private AutoresService autoresService;

	@GetMapping("/all")
	public List<AutoresEntity> listar() {
		return autoresService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AutoresEntity> listar2(@PathVariable("id") long id) {
		AutoresEntity auto = autoresService.read(id);
		if (auto!=null) {
			return new ResponseEntity<>(auto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/add")
	  public ResponseEntity<AutoresEntity> createTutorial(@Valid @RequestBody AutoresEntity a) {
	    try {
	    	AutoresEntity auto = autoresService.create(a);

	      return new ResponseEntity<>(auto, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<AutoresEntity> updateTutorial(@PathVariable("id") long id, @RequestBody AutoresEntity auto) {
		AutoresEntity autores = autoresService.read(id);

	    if (autores!=null) {
	    	autores.setId(auto.getId());
	    	autores.setAutor(auto.getAutor());
	    	    	
	      return new ResponseEntity<>(autoresService.create(autores), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteAutores(@PathVariable("id") long id) {
	    try {
	    	autoresService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
