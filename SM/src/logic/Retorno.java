package logic;

public class Retorno {
	
	public enum Resultado{
		OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, NO_IMPLEMENTADA
	}
	
	public Resultado resultado;
	public int valorEntero;
	public boolean valorBooleano;
	public String valorString;
	
	public Retorno(Resultado resultado) {
		this.resultado = resultado;
	}
	
	public Retorno(Resultado resultado, int valorEntero, String valorString) {
		this.resultado = resultado;
		this.valorEntero = valorEntero;
		this.valorString = valorString;
	}
	
	public Retorno(Resultado resultado, int valorEntero, String valorString, boolean valorBooleano) {
		this.resultado = resultado;
		this.valorEntero = valorEntero;
		this.valorString = valorString;
		this.valorBooleano = valorBooleano;
	}
	
	
	
}
