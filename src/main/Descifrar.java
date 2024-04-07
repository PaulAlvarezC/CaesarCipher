package main;
import java.io.IOException;
import java.util.Scanner;

public class Descifrar {

	public static void main(String[] args) throws IOException {
		try (Scanner sn = new Scanner(System.in)) {
			String frase;
			int rot;
			do {
			    System.out.print("Texto: ");
			    frase = sn.nextLine();
			} while (frase.isEmpty());
			do {
			    System.out.print("Transformación: ");
			    rot = sn.nextInt();
			} while (rot < 1);
			sn.close();
			//Métodos
			String texto = decodificar(frase.toUpperCase(), rot);
			System.out.println("Texto Decodificado: " + texto);
		}
	}
	
	public static String decodificar(String texto, int tr) {
		String textoCodificado = "";
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		texto = texto.toUpperCase();
		char caracter;
		for (int i = 0; i < texto.length(); i++) {
			caracter = texto.charAt(i);
			int pos = letras.indexOf(caracter);
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
