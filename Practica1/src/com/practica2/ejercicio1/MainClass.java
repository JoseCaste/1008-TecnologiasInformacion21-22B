package com.practica2.ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		Pelicula pelicula = new Pelicula("Avenger", "Ficción", "Jose", LocalDate.now(), (byte) 200);
		Pelicula pelicula2 = new Pelicula("Antman", "Ficción2", "Jose2", LocalDate.now(), (byte) 125);
		Pelicula pelicula3 = new Pelicula("Batman", "Ficción3", "Jose3", LocalDate.now(), (byte) 50);
		Pelicula pelicula4 = new Pelicula("Captain America", "Ficción4", "Jose4", LocalDate.now(), (byte) 80);
		Pelicula pelicula5 = new Pelicula("Hulk", "Ficción5", "Jose5", LocalDate.now(), (byte) 125);
		List<Pelicula> peliculas= new ArrayList<>();
		peliculas.add(pelicula);
		peliculas.add(pelicula2);
		peliculas.add(pelicula3);
		peliculas.add(pelicula4);
		peliculas.add(pelicula5);
		
		peliculas.get(3).marcarVisto();
		peliculas.get(1).marcarVisto();
		
		Serie serie = new Serie("The Wlaking dead", (byte)10, "Ficción", "Joe russo", (byte)120);
		Serie serie2 = new Serie("Barco", (byte)2, "Ficción", "Joel russo", (byte)55);
		Serie serie3 = new Serie("TBBT", (byte)12, "Ficción", "Net Ico", (byte)110);
		Serie serie4 = new Serie("Friends", (byte)8, "Ficción", "Hipolito", (byte)100);
		Serie serie5 = new Serie("Two half men", (byte)15, "Ficción", "Hasi", (byte)120);
		List<Serie> series= new ArrayList<>();
		series.add(serie);
		series.add(serie2);
		series.add(serie3);
		series.add(serie4);
		series.add(serie5);
		
		series.get(3).marcarVisto();
		series.get(1).marcarVisto();
		
		//Peliculas vistas
		System.out.println("Peliculas vistas");
		peliculas.stream().filter(Pelicula::esVisto).forEach(pelicula_->{
			System.out.printf("Pelicula %s con tiempo visto %s",pelicula_.getTitulo(),pelicula_.tiempoVisto());
			System.out.println();
		});
		
		//Serie vistas
		System.out.println("-----Series vistas---");
		series.stream().filter(Serie::esVisto).forEach(serie_->{
			System.out.printf("Pelicula %s con tiempo visto %s",serie_.getTitulo(),serie_.tiempoVisto());
			System.out.println();
		});
	}

}
