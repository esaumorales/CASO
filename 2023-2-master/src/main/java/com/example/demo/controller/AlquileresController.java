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

import static com.example.demo.commons.GlobalConstants.API_ALQUILERES;

import com.example.demo.entity.AlquileresEntity;
import com.example.demo.service.AlquileresService;



@RestController
@RequestMapping(API_ALQUILERES)
public class AlquileresController {

	@Autowired
	private AlquileresService alquileresService;

	@GetMapping("/all")
	public List<AlquileresEntity> listar() {
		return alquileresService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AlquileresEntity> listar2(@PathVariable("id") long id) {
		AlquileresEntity libr = alquileresService.read(id);
		if (libr!=null) {
			return new ResponseEntity<>(libr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/add")
	  public ResponseEntity<AlquileresEntity> createTutorial(@Valid @RequestBody AlquileresEntity l) {
	    try {
	    	AlquileresEntity alqu = alquileresService.create(l);

	      return new ResponseEntity<>(alqu, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<AlquileresEntity> updateTutorial(@PathVariable("id") long id, @RequestBody AlquileresEntity alqu) {
		AlquileresEntity alquileres = alquileresService.read(id);

	    if (alquileres!=null) {
	    	alquileres.setId(alqu.getId());
	    	alquileres.setFecha_entrada(alqu.getFecha_entrada());
	    	alquileres.setFecha_salida(alqu.getFecha_salida());
	    	
	      return new ResponseEntity<>(alquileresService.create(alquileres), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteAlquileres(@PathVariable("id") long id) {
	    try {
	    	alquileresService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
