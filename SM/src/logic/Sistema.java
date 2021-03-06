
package logic;

import listas.*;
import logic.Retorno.Resultado;

public class Sistema implements ISistema {

	private int MAX_CANT_PALABRAS_X_LINEA;

	private Lista<ILista<String>> texto; // Unordered List
	private ListaOrd<String> diccionario; // Ordered List

	public Sistema(int MAX_CANT_PALABRAS_X_LINEA) {
		this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
	}

	@Override
	public Retorno crearSistemaMensajes() {
		this.texto = new Lista<ILista<String>>();
		this.diccionario = new ListaOrd<String>();
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno destruirSistemaMensajes() {
		for (ILista<String> linea : texto) {
			linea.empty();
		}

		texto.empty();
		texto = null;
		diccionario.empty();
		diccionario = null;

		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno InsertarLinea() {
		texto.addLast(new Lista<String>());
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno InsertarLineaEnPosicion(int posicionLinea) {

		if (posicionLinea < 1 || posicionLinea > texto.length() + 1) {
			return new Retorno(Resultado.ERROR_1);
		}

		texto.addAtPosition(new Lista<String>(), posicionLinea - 1);

		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno BorrarLinea(int posicionLinea) {
		if (posicionLinea < 1 || posicionLinea >= texto.length() + 1) {
			return new Retorno(Resultado.ERROR_1);
		}

		texto.deleteAtPosition(posicionLinea - 1);

		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno BorrarTodo() {
		for (ILista<String> linea : texto) {
			linea.empty();
		}
		texto.empty();
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno BorrarOcurrenciasPalabraEnTexto(String palabraABorrar) {

		boolean deleted = false;

		for (ILista<String> l : texto) {
			if (l.exists(palabraABorrar)) {
				l.delete(palabraABorrar);
				deleted = true;
			}
		}

		if (!deleted) {
			return new Retorno(Resultado.ERROR_1);
		}

		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno ImprimirTexto() {
		int numero_linea = 1;
		String text = "";

		for (ILista<String> l : texto) {
			text += numero_linea++ + ":";
			for (String s : l) {
				text += " " + s;
			}
			text += "\n";
		}

		if (numero_linea == 1) {
			return new Retorno(Resultado.OK, 0, "Texto vacío");
		}

		return new Retorno(Resultado.OK, 0, text);
	}

	@Override
	public Retorno InsertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
		if (posicionLinea < 1 || posicionLinea >= texto.length() + 1) {
			return new Retorno(Resultado.ERROR_1);
		}

		ILista<String> linea = texto.getObject(posicionLinea - 1);

		if (posicionPalabra < 1 || posicionPalabra > linea.length() + 1) {
			return new Retorno(Resultado.ERROR_2);
		}

		if (linea.isFull(MAX_CANT_PALABRAS_X_LINEA - 1)) {
			return new Retorno(Resultado.ERROR_3);
		}

		linea.addAtPosition(palabraAIngresar, posicionPalabra - 1);

		return new Retorno(Resultado.OK);

	}

	@Override
	public Retorno InsertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar) {

		if (posicionLinea < 1 || posicionLinea >= texto.length() + 1) {
			return new Retorno(Resultado.ERROR_1);
		}

		ILista<String> linea = texto.getObject(posicionLinea - 1);

		if (posicionPalabra < 1 || posicionPalabra >= MAX_CANT_PALABRAS_X_LINEA) {
			return new Retorno(Resultado.ERROR_2);
		}

		linea.addAtPosition(palabraAIngresar, posicionPalabra - 1);

		while (linea.isFull(MAX_CANT_PALABRAS_X_LINEA)) {

			String ultima_palabra = linea.getObject(MAX_CANT_PALABRAS_X_LINEA);
			linea.deleteAtPosition(MAX_CANT_PALABRAS_X_LINEA);

			if (++posicionLinea <= texto.length()) {
				linea = texto.getObject(posicionLinea - 1);
				linea.addFirst(ultima_palabra);

			} else {
				texto.addLast(new Lista<String>());
				linea = texto.getObject(posicionLinea - 1);
				linea.addFirst(ultima_palabra);
			}
		}

		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno BorrarPalabra(int posicionLinea, int posicionPalabra) {
		if (posicionLinea < 1 || posicionLinea >= texto.length() + 1) {
			return new Retorno(Resultado.ERROR_1);
		}

		ILista<String> linea = texto.getObject(posicionLinea - 1);

		if (posicionPalabra < 1 || posicionPalabra > linea.length()) {
			return new Retorno(Resultado.ERROR_2);
		}

		linea.deleteAtPosition(posicionPalabra - 1);

		/*
		 * Para reacomodar el texto, es decir, para mover todas las palabras del texto hacia adelante
		 * 
			if (linea.isEmpty()) {
				texto.deleteAtPosition(posicionLinea - 1);
			} else {
	
				while (++posicionLinea <= texto.length()) {
					ILista<String> lineaSig = texto.getObject(posicionLinea - 1);
	
					while (!linea.isFull(MAX_CANT_PALABRAS_X_LINEA - 1)) {
						String primerPalabraLineaSig = lineaSig.getObject(0);
						linea.addLast(primerPalabraLineaSig);
						lineaSig.deleteFirst();
					}
					linea = lineaSig;
				}
	
				texto.deleteLast();
			}
			
		 */
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno ImprimirLinea(int posicionLinea) {
		if (posicionLinea < 1 || posicionLinea >= texto.length() + 1) {
			return new Retorno(Resultado.ERROR_1);
		}

		ILista<String> linea = texto.getObject(posicionLinea - 1);
		String texto_linea = posicionLinea + ":";

		for (String s : linea) {
			texto_linea += " " + s;
		}

		return new Retorno(Resultado.OK, 0, texto_linea);
	}

	@Override
	public Retorno IngresarPalabraDiccionario(String palabraAIngresar) {

		if (diccionario.exists(palabraAIngresar)) {
			return new Retorno(Resultado.ERROR_1);
		}

		diccionario.addInOrder(palabraAIngresar);

		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno BorrarPalabraDiccionario(String palabraABorrar) {

		if (!diccionario.exists(palabraABorrar)) {
			return new Retorno(Resultado.ERROR_1);
		}

		diccionario.delete(palabraABorrar);

		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno ImprimirDiccionario() {

		String palabras_diccionario = "";

		for (String p : diccionario) {
			palabras_diccionario += p + "\n";
		}

		return new Retorno(Resultado.OK, 0, palabras_diccionario);
	}

	@Override
	public Retorno ImprimirTextoIncorrecto() {

		String texto_i = "";

		int index_line = 1;
		for (ILista<String> linea_texto : texto) {
			texto_i += index_line + ":";

			for (String p_t : linea_texto) {
				if (!diccionario.exists(p_t)) {
					texto_i += " " + p_t;
				}

			}

			texto_i += "\n";

			index_line++;
		}

		if (index_line == 1) {
			return new Retorno(Resultado.OK, 0, "No hay errores");
		}

		return new Retorno(Resultado.OK, 0, texto_i);
	}

}
