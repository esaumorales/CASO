package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ALQUILERES")
public class AlquileresEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
	@Column(name = "IdAlquileres")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
  	@Column(name = "FECHA_ENTRADA")
  	private LocalDate fecha_entrada;
  	
  	@Column(name = "FECHA_SALIDA")
  	private LocalDate fecha_salida;
  	
  	@ManyToOne
    @JoinColumn(name="DNILector", nullable = false)
    private LectoresEntity lectores;
  	
  	@ManyToOne
    @JoinColumn(name="ASIN", nullable = false)
    private LibrosEntity libros;
  	
}