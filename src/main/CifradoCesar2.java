package main;
import java.io.IOException;
import java.util.Scanner;

public class CifradoCesar2 {

	public static void main(String[] args) throws IOException {
		try (Scanner sn = new Scanner(System.in)) {
			String frase;
			int rot;
			do {
			    System.out.print("Introduce un texto: ");
			    frase = sn.nextLine();
			} while (frase.isEmpty());
			do {
			    System.out.print("Introduce la transformación: ");
			    rot = sn.nextInt();
			} while (rot < 1);
			sn.close();
			//Métodos
			String texto1 = codificar(frase.toUpperCase(), rot);
			System.out.println("Texto codificado: " + texto1);
			String texto2 = decodificar(texto1.toUpperCase(), rot);
			System.out.println("Texto decodificado: " + texto2);
		}
	}
	
	public static String codificar(String texto, int tr) {
		String textoCodificado = "";
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		texto = texto.toUpperCase();
		char caracter;
		for (int i=0; i<texto.length(); i++) {
			caracter = texto.charAt(i);
			//System.out.println("Char: " + caracter);
			int pos = letras.indexOf(caracter);
			//System.out.println("Pos: " + pos);
			if(pos == -1) {
				textoCodificado += caracter;
			} else {
				textoCodificado += letras.charAt((pos + tr) % letras.length());
				//Saco modulo del tamaño de las letras para evitar que se salga de rango
			}
		}
		return textoCodificado.toString();
	}
	
	public static String decodificar(String texto, int tr) {
		String textoCodificado = "";
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		texto = texto.toUpperCase();
		char caracter;
		for (int i = 0; i < texto.length(); i++) {
			caracter = texto.charAt(i);
			//System.out.println("Char: " + caracter);
			int pos = letras.indexOf(caracter);
			//System.out.println("Pos: " + pos);
			if (pos == -1) {
				textoCodificado += caracter;
			} else {
				if (pos - tr < 0) {
					textoCodificado += letras.charAt(letras.length() + (pos - tr));
				} else {					
					textoCodificado += letras.charAt((pos - tr) % letras.length());
				}
			}
		}
		return textoCodificado.toString();
	}
	
}
