package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrecuenciaCifrado {

	public static void main(String[] args) {
		try (Scanner sn = new Scanner(System.in)) {
			String text;
			String letters = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
			int alphSize = letters.length();
			//INGRESO EL DICCIONARIO DE FRECUENCIAS WIKI
			Map<String, Double> map = new HashMap<String, Double>();
			map.put("A", 12.53);map.put("B", 1.42);map.put("C", 4.68);
			map.put("D", 5.86);map.put("E", 13.68);map.put("F", 0.69);
			map.put("G", 1.01);map.put("H", 0.70);map.put("I", 6.25);
			map.put("J", 0.44);map.put("K", 0.02);map.put("L", 4.97);
			map.put("M", 3.15);map.put("N", 6.71);map.put("Ñ", 0.31);
			map.put("O", 8.68);map.put("P", 2.51);map.put("Q", 0.88);
			map.put("R", 6.87);map.put("S", 7.98);map.put("T", 4.63);
			map.put("U", 3.93);map.put("V", 0.90);map.put("W", 0.01);
			map.put("X", 0.22);map.put("Y", 0.90);map.put("Z", 0.52);
			double valorMax = -1;
			String key = "";
			
			//DEL DICCIONARIO OBTENGO EL VALOR CON MAYOR PORCENTAJE
			for (Map.Entry<String, Double> entry : map.entrySet()) {
				final double valorActual = entry.getValue();
				String keyItem = entry.getKey();
				if(valorActual > valorMax) {					
					valorMax = valorActual;
					key = keyItem; 
				}
			}
			System.out.println("Letra Mayor Frecuencia: " + key);
			System.out.println("Porcentaje Frecuencia: " + valorMax + " %");
			System.out.println("TABLA DE FRECUENCIA:");
	        System.out.println("==========================");
	        System.out.println("ALPHABET\tFREQUENCY");

	        //RECORRO EL DICCIONARIO PARA IMPRIMIRLO
	        map.forEach((keyy, value) -> System.out.println(keyy + "\t\t" + value + " %"));
	        System.out.println("==========================");
			do {
			    System.out.print("TEXTO CIFRADO: ");
			    text = sn.nextLine();
			} while (text.isEmpty());
			sn.close();
			
			text = text.toUpperCase();
			int textSize = text.length();
			
			char alphabet[] = new char[alphSize];
			int frequency[] = new int[alphSize];
			
			char c = 'A';
			for (int i = 0; i < alphSize; i++) {
				alphabet[i] = c;
				frequency[i] = 0;
				c++;
			}
			System.out.println("OUTPUT:");
	        System.out.println("==========================");
	        System.out.println("ALPHABET\tFREQUENCY");
	        System.out.println("==========================");
	        
	        char ch = ' ';
	        for (int i = 0; i < alphSize; i++) {
	        	for (int j = 0; j < textSize; j++) {
	        		ch = text.charAt(j);
	        		if (ch == alphabet[i]) {
	        			frequency[i]++;
	        		}
	        	}
	        }
	        Map<String, Double> newMap = new HashMap<String, Double>();
	        //IMPRIMO CON FORMATO
	        for (int i = 0; i < alphSize; i++) {
	        	if (frequency[i] != 0) {
	        		double d = frequency[i];
					newMap.put(String.valueOf(alphabet[i]), d);
	        		System.out.println(" " + alphabet[i] + "\t\t   " + frequency[i]);
	        	}
	        }

	        //SABER LA FRECUENCIA MAYOR
	        int mayor = frequency[0];
	        char letra = 0;
	        for (int x = 1; x < frequency.length; x++) {
				if (frequency[x] > mayor) {
					mayor = frequency[x];
					letra = alphabet[x];
				}
			}
	        
	        int intIndex = letters.indexOf(letra);
	        
	        System.out.println("");
	        System.out.println("");
	        System.out.println("==========================");
	        System.out.println("LETRA FRECUENCIA: " + letra);
			System.out.println("MAYOR FRECUENCIA: " + mayor);
			System.out.println("TRANSFORMACIÓN: " + intIndex);
	        System.out.println("==========================");
	        System.out.println("TEXTO CODIFICADO");
	        System.out.println(text);
	        System.out.println("==========================");
	        System.out.println("TEXTO DECODIFICADO");
	        for (int x = 1; x <= intIndex; x++) {
	        	System.out.println(decodificar(text.toUpperCase(), x));
			}
	        System.out.println("==========================");
			
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
