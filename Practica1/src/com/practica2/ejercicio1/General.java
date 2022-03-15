package com.practica2.ejercicio1;

public class General implements Visualizable{
	private String titulo;
	private String genero;
	private String director;
	private byte duracion;
	private Boolean visto;

	
	public General() {
		this.visto = false;
		this.titulo = "";
		this.genero = "";
		this.director = "";
		this.duracion = 0;
		
	}

	public General(String titulo, String genero, String director, byte duracion, Boolean visto) {
		this.titulo = titulo;
		this.genero = genero;
		this.director = director;
		this.duracion = duracion;
		this.visto = visto;
	}

	public General(String titulo, String genero, String director, byte duracion) {
		this.titulo = titulo;
		this.genero = genero;
		this.director = director;
		this.duracion = duracion;
		this.visto = false;
	}

	public General(String titulo, String director) {
		this.titulo = titulo;
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public byte getDuracion() {
		return duracion;
	}

	public void setDuracion(byte duracion) {
		this.duracion = duracion;
	}

	public Boolean getVisto() {
		return visto;
	}

	public void setVisto(Boolean visto) {
		this.visto = visto;
	}

	@Override
	public String toString() {
		return "General [titulo=" + titulo + ", genero=" + genero + ", director=" + director + ", duracion=" + duracion
				+ ", visto=" + visto + "]";
	}

	@Override
	public void marcarVisto() {
		this.visto = true;
		
	}

	@Override
	public Boolean esVisto() {
		// TODO Auto-generated method stub
		return this.visto;
	}

	@Override
	public String tiempoVisto() {
		short hours= (short) (this.duracion / 60);
		short minutes = (short) (this.duracion % 60);
		 
		return String.format("%d horas con %d minutos", hours,minutes);
	}
	
	
	
	
	
}
