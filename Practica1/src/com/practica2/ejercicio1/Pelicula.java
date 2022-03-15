package com.practica2.ejercicio1;

import java.time.LocalDate;

public class Pelicula extends General {
	private LocalDate año;
	
	public Pelicula() {
		super();
	}
	

	public Pelicula(String titulo, String genero, String director, LocalDate año, byte duracion) {
		super(titulo,genero,director,duracion);
		this.año = año;
	}
	
	public void setAño(LocalDate año) {
		this.año = año;
	}


	@Override
	public String toString() {
		return "Pelicula ["+super.toString()+"año=" + año +"]";
	}

	
	
}
