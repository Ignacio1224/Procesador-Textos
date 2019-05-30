
package logic;

public class Sistema implements ISistema {
	
    private int MAX_CANT_PALABRAS_X_LINEA;

    public Sistema(int MAX_CANT_PALABRAS_X_LINEA) {
        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
    }

    @Override
    public Retorno crearSistemaMensajes() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno destruirSistemaMensajes() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno InsertarLinea() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno InsertarLineaEnPosicion(int posicionLinea) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno BorrarLinea(int posicionLinea) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno BorrarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno BorrarOcurrenciasPalabraEnTexto(String palabraABorrar) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno ImprimirTexto() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno InsertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Retorno InsertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        throw new UnsupportedOperationException("Not supported yet."); 
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
