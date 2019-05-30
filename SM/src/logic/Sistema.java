
package logic;
import listas.*;
import logic.Retorno.Resultado;

public class Sistema implements ISistema {
	
    private int MAX_CANT_PALABRAS_X_LINEA;
    
    private Lista<ILista<String>> texto = new Lista<ILista<String>>();
    
    public Sistema(int MAX_CANT_PALABRAS_X_LINEA) {
        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
    }

    @Override
    public Retorno crearSistemaMensajes() {
        this.texto = new Lista<ILista<String>>();
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno destruirSistemaMensajes() {
        for (ILista<String> linea : texto) {
        	linea.empty();
        }
        texto.empty();
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno InsertarLinea() {
        texto.addLast(new Lista<String>()); 
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno InsertarLineaEnPosicion(int posicionLinea) {
        texto.addAtPosition(new Lista<String>(), posicionLinea);
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno BorrarLinea(int posicionLinea) {
        texto.deleteAtPosition(posicionLinea);
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno BorrarTodo() {
        texto.empty();
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno BorrarOcurrenciasPalabraEnTexto(String palabraABorrar) {
    	for (ILista<String> l : texto) {
    		l.delete(palabraABorrar);
    	}
    	return new Retorno(Resultado.OK); 
    }

    @Override
    public Retorno ImprimirTexto() {
    	int numero_linea = 1;
        
    	for (ILista<String> l : texto) {
        	System.out.print(numero_linea++ + ": ");
        	l.show();
        }
        
        if (numero_linea == 1) {
        	System.out.println("Texto vacio");
        }
        
        return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno InsertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        if (posicionLinea < 0 || posicionLinea > texto.length() + 1) {
        	return new Retorno(Resultado.ERROR_1); // La posicion no es valida
        }
    	
    	ILista<String> linea = texto.getObject(posicionLinea);
        
        if (!linea.isFull(MAX_CANT_PALABRAS_X_LINEA)) {
        
        	if (posicionPalabra > 0 && posicionPalabra <= linea.length() + 1) {
        		linea.addAtPosition(palabraAIngresar, posicionPalabra);        		
        	} else {
        		return new Retorno(Resultado.ERROR_2); // Pos no valida
        	}

        } else {
        	return new Retorno(Resultado.ERROR_3); // Esta llena
        }
    	
        return new Retorno(Resultado.OK);

    }

    @Override
    public Retorno InsertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar) {

    	if (posicionLinea < 0 || posicionLinea > texto.length() + 1) {
        	return new Retorno(Resultado.ERROR_1); // La posicion no es valida
        }
    	
    	ILista<String> linea = texto.getObject(posicionLinea);
    	
    	if (posicionPalabra < 0 || posicionPalabra > MAX_CANT_PALABRAS_X_LINEA) {
    		return new Retorno(Resultado.ERROR_2); // La posicion no es valida
    	}
    	
    	linea.addAtPosition(palabraAIngresar, posicionPalabra);
    	
    	while(linea.isFull(MAX_CANT_PALABRAS_X_LINEA)) {
    		String ultima_palabra = linea.getObject(MAX_CANT_PALABRAS_X_LINEA);
    		linea.deleteAtPosition(MAX_CANT_PALABRAS_X_LINEA);
    		if (++posicionLinea <= texto.length()) { // ++posicionLinea le suma 1 a la posicionLinea antes de ejecutar el if
    			linea = texto.getObject(posicionLinea);
    			linea.addFirst(ultima_palabra);
    		} else {
    			texto.addLast(new Lista<String>());
    			linea = texto.getObject(posicionLinea);
    			linea.addFirst(ultima_palabra);
    		}
    	}
    	
    	return new Retorno(Resultado.OK);
    }

    @Override
    public Retorno BorrarPalabra(int posicionLinea, int posicionPalabra) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno ImprimirLinea(int posicionLinea) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno IngresarPalabraDiccionario(String palabraAIngresar) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno BorrarPalabraDiccionario(String palabraABorrar) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno ImprimirDiccionario() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno ImprimirTextoIncorrecto() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
}
