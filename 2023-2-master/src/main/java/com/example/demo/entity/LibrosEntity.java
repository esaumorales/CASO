package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="LIBROS")
public class LibrosEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
	@Column(name = "ASIN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
  	@Column(name = "TITULO")
  	private String titulo;
  	
  	@Column(name = "FECHA_LANZAMIENTO")
  	private LocalDate fecha_lanzamiento;
  	
  	@Column(name = "AUTOR")
  	private String autor;

  	@Column(name = "CATEGORIA")
  	private String categoria;
  	
  	@Column(name = "EDITORIAL")
  	private String editorial;

  	@Column(name = "IDIOMA")
  	private String idioma;

  	@Column(name = "PAGINAS")
  	private Integer paginas;
  	
  	@Column(name = "DESCRIPCION")
  	private String descripcion;
  	
  	@Column(name = "PORTADA")
  	private String portada;
  	
  	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "libros")
	@JsonIgnore
	private Set<AlquileresEntity> alquileres;
  	
  	@ManyToOne
    @JoinColumn(name="IdAutor", nullable = false)
    private AutoresEntity autores;

  	@ManyToOne
    @JoinColumn(name="IdCategoria", nullable = false)
    private CategoriasEntity categorias;
  	
  	@ManyToOne
    @JoinColumn(name="IdEditorial", nullable = false)
    private EditorialesEntity editoriales;
}