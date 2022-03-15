package com.practica2.ejercicio1;

public class Serie extends General{
	
	private byte numTemporadas;
	
	
	public Serie() {
		super();
		this.numTemporadas = 1;
		
	}
	
	
	public Serie(String titulo, String director) {
		super(titulo, director);
		this.numTemporadas = 1;
	}
	
	


	public Serie(String titulo, byte numTemporadas, String genero, String director, byte duracion) {
		super(titulo, genero, director, duracion);
		this.numTemporadas = numTemporadas;
		
	}

	public byte getNumTemporadas() {
		return numTemporadas;
	}
	public void setNumTemporadas(byte numTemporadas) {
		this.numTemporadas = numTemporadas;
	}
	

	@Override
	public String toString() {
	
		return "Serie ["+super.toString()+"numTemporadas=" + numTemporadas +"]";
	}
	
	
	
}
