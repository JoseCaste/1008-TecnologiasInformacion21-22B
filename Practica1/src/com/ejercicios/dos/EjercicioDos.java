package com.ejercicios.dos;

public class EjercicioDos {

	public static void main(String[] args) {
		
		byte [][] matriz = new byte [3][3];
		fullMatriz(matriz);
		printMatrizValues(matriz);
		System.out.println("****Numero mayor y ocurrencias****");
		printMajorNumberAndHowMany(matriz);
		System.out.println("****Numero menor y ocurrencias****");
		printLessNumberAndHowMany(matriz);
		System.out.println("****Numeros primos****");
		printPrimeNumbers(matriz);
		System.out.println("****Numeros pares****");
		printPairNumbers(matriz);
		System.out.println("****Promedio****");
		printAverage(matriz);
		System.out.println("****Suma de diagonales****");
		System.out.println("-___>Diagonal de izq a der");
		printLeftToRigthSumDiagonal(matriz);
		System.out.println("-___>Diagonal de der a izq");
		printRigtToLeftSumDiagonal(matriz);
		System.out.println("****Suma de la última diagonal****");
		printSumToFinalRow(matriz);
		System.out.println("****Cubo mágico****");
		//loadMagicCube(matriz);
		verifyIfItsMagicCube(matriz);
		
	}

	private static void loadMagicCube(byte[][] matriz) {
		// TODO Auto-generated method stub
		matriz[0][0] = 8;
		matriz[0][1] = 1;
		matriz[0][2] = 6;
		
		matriz[1][0] = 3;
		matriz[1][1] = 5;
		matriz[1][2] = 7;
		
		matriz[2][0] = 4;
		matriz[2][1] = 9;
		matriz[2][2] = 2;
	}

	private static void verifyIfItsMagicCube(final byte[][] matriz) {
		
		//normal iteration
		short countNormal = 0;
		short countReverse= 0;
		boolean flag= true;
		
		for (byte i = 0; i < matriz.length; i++) {
			
			for (byte j = 0; j < matriz.length; j++) {
				
				countNormal += (short) (matriz[i][j]);
				
				countReverse += (short) (matriz[j][i]);
			}
			if(countNormal != 15) {
				
				flag= !flag;
				break;
			}
			if(countReverse != 15) {
				
				flag= !flag;
				break;
			}
			countNormal = 0;
			countReverse = 0;
			
		}
		countNormal = 0;
		if(flag) {
			for (int i = 0; i < matriz.length; i++) {
				
				countNormal += (short) (matriz[i][i]);
				
			}
			
			if(countNormal != 15)
				flag= !flag;
			
		}
		if(!flag)
			System.out.println("____No es cúbo mágico");
		else
			System.out.println("____Es cúbo mágico");
	}

	private static void printSumToFinalRow(final byte[][] matriz) {
		
		byte finalRow= (byte) (matriz[0].length-1);
		short sum= 0;
		for (int i = 0; i < matriz.length; i++) {
			sum = (short) (sum+ matriz[finalRow][i]);
		}
		System.out.println("La suma de la ultima fila es: "+sum);
	}

	private static void printRigtToLeftSumDiagonal(final byte[][] matriz) {
		short sum = 0;
		byte indexI = 0;
		for (int i = matriz.length-1; i >= 0; i--) {
			sum = (short) (sum + matriz[indexI++][i]);
		}
		System.out.println("La suma es: "+sum);
	}

	private static void printLeftToRigthSumDiagonal(final byte[][] matriz) {
		short sum= 0;
		for (byte i = 0; i < matriz.length; i++) {
			sum = (short) (sum + matriz[i][i]);
		}
		System.out.println("La suma es: "+sum);
	}

	private static void printAverage(final byte[][] matriz) {
		int sum = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				sum = (sum + matriz[i][j]);
			}
		}
		final byte totalValues = (byte) (matriz.length * matriz[0].length); 
		final float promedio = (float) sum / totalValues;
		System.out.printf("El total de valores son %d, la suma es %d y el promedio es %f ", sum, totalValues, promedio);
	}

	private static void printPairNumbers(byte[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				
				if(matriz [i][j] % 2 == 0) {
					System.out.printf("[%d, %d] = %d es par",i,j, matriz[i][j]);
					System.out.println();
				}
			}
		}
		
	}

	private static void printPrimeNumbers(final byte[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				
				final byte actualValue = matriz[i][j];
				byte count = 0;
				for (int z = 1; z <= 100; z++) {
					//checking divisors
					if((actualValue % z) == 0)
						count++;
					
					if(count > 2 )
						break;
				}
				if(count == 2) {
					System.out.printf("[%d, %d] = %d es primo",i,j, matriz[i][j]);
					System.out.println();
				}
				count = 0;	
			}
		}
		
	}

	private static void printLessNumberAndHowMany(final byte[][] matriz) {
		byte count = 0;
		byte major = 125;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if(matriz[i][j] == major )
					count ++;
				
				if(matriz[i][j]< major) {
					major = matriz[i][j];
					count= 1;
				}
				
			}
			
		}
		System.out.printf("El número mayor es %d y sus ocurrencias son %d ",major,count);
		System.out.println();
	}

	private static void printMajorNumberAndHowMany(final byte[][]matriz) {
		byte count = 0;
		byte major = 1;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if(matriz[i][j] == major )
					count ++;
				
				if(matriz[i][j]> major) {
					major = matriz[i][j];
					count= 1;
				}
				
			}
			
		}
		System.out.printf("El número mayor es %d y sus ocurrencias son %d ",major,count);
		System.out.println();
		
	}

	private static void printMatrizValues(final byte[][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.printf("[%d, %d] = %d ", i,j, matriz[i][j]);
			}
			System.out.println();
		}
		
	}

	private static void fullMatriz(byte[][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = (byte) (Math.random() * (100-1) - 1);
			}
		}
	}

}
