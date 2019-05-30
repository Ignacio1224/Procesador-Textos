
package logic;

public interface ISistema {
	
    public Retorno crearSistemaMensajes();   
    public Retorno destruirSistemaMensajes ();
    public Retorno InsertarLinea(); 
    public Retorno InsertarLineaEnPosicion(int posicionLinea); 
    public Retorno BorrarLinea(int posicionLinea);
    public Retorno BorrarTodo(); 
    public Retorno BorrarOcurrenciasPalabraEnTexto(String palabraABorrar);
    public Retorno ImprimirTexto();
    public Retorno InsertarPalabraEnLinea(int  posicionLinea, int posicionPalabra, String palabraAIngresar);
    public Retorno InsertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar);
    public Retorno BorrarPalabra(int posicionLinea, int posicionPalabra);
    public Retorno ImprimirLinea(int posicionLinea);
    public Retorno IngresarPalabraDiccionario(String palabraAIngresar); 
    public Retorno BorrarPalabraDiccionario(String palabraABorrar);
    public Retorno ImprimirDiccionario();
    public Retorno ImprimirTextoIncorrecto();
    
}
