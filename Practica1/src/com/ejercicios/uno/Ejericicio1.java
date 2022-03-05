package com.ejercicios.uno;

import java.util.ArrayList;
import java.util.List;

public class Ejericicio1 {

	public static void main(String[] args) {
		byte [] values= new byte[17];
		
		for (int i = 0; i < values.length; i++) {
			values[i]= (byte)((Math.random()* (100-1)+1));
		}
		System.out.println("****Imprimiendo valores****");
		printValues(values);
		System.out.println("****Número mayor****");
		printMajorNumber(values);
		System.out.println("****Número menor****");
		printLessNumber(values);
		System.out.println("****Números primos****");
		printPrimeNumber(values);
		System.out.println("****Números pares****");
		printPairNumber(values);
		System.out.println("****Arreglo ordenado ASC****");
		printOrderByASC(values);
		System.out.println("****Suma el primer y ultimo valor del arreglo****");
		printAddFirtAndSecondValue(values);
		
	}
	
	private static void printAddFirtAndSecondValue(final byte[] values) {
		final byte first = values[0];
		final byte final_ = values[values.length-1];
		
		System.out.printf("Suma de %d y %d es %d",first, final_, first + final_);
	}

	private static void printOrderByASC(final byte[] values) {
		List<Byte> values_ = new ArrayList<>();
		for (byte b : values) {
			values_.add(b);
		}
		
		values_.stream().sorted().forEach(value->{
			System.out.print(value +" ");
		});
		System.out.println();
		printAverage(values_);
	}

	private static void printAverage(final List<Byte> values_) {
		
		final int sum = values_.stream().map(value->{
			return (int)value;
		}).reduce(0, Integer::sum);
		
		final float promedio = sum / values_.stream().count();
		System.out.println("****Promedio****");
		System.out.println("Promedio es  "+promedio);
	}

	private static void printPairNumber(final byte[] values) {
		
		for (byte b : values) {
			if(b % 2 == 0) {
				System.out.printf("%d es primo", b);
				System.out.println();
			}
		}
		
	}

	private static void printPrimeNumber(final byte[] values) {
		for (int i = 0; i < values.length; i++) {
			final byte actualValue = values[i];
			byte count = 0;
			for (int j = 1; j <= 100; j++) {
				//checking divisors
				if((actualValue % j) == 0)
					count++;
				
				if(count > 2 )
					break;
			}
			if(count == 2) {
				System.out.printf("[%d] = %d es primo",i, values[i]);
				System.out.println();
			}
			count = 0;
		}
		
	}

	private static void printLessNumber(final byte[] values) {
		byte less= 120;
		for (int i = 0; i < values.length; i++) {
			
			if(i +1 < values.length)
				
			if(values[i]< less ) less = values[i];
			
		}
		System.out.printf("El número menos es: %d", less);
		System.out.println();
	}

	public static void printValues(final byte [] values){
		for (int i =0; i<values.length;i++) {
			System.out.println(String.format("[%d] = %d", i,values[i] ));
		}
	}
	
	public static void printMajorNumber(final byte [] values) {
		byte major=0;
		
		for (byte b : values) {
			
			if (b > major) major = b;
			
		}
		System.out.printf("El número mayor es: %d", major);
		System.out.println();
	}
}
