package logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logic.Retorno.Resultado;

public class ISistemaTest {
	
	private ISistema sis;

	
	@Before
	public void setUp() throws Exception {
		sis = new Sistema(2);
	}

	@Test
	public void testCrearSistemaMensajes() {
		
		Retorno ret = sis.crearSistemaMensajes();
		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testDestruirSistemaMensajes() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.destruirSistemaMensajes();
		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testInsertarLinea() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testInsertarLineaEnPosicion() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLineaEnPosicion(1);
		assertEquals(Resultado.OK, ret.resultado);
	}
	
	@Test
	public void testInsertarLineaEnPosicionFueraDeRango() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLineaEnPosicion(486);
		assertEquals(Resultado.ERROR_1, ret.resultado);
	}
	
	@Test
	public void testInsertarLineaEnPosicionIgualA0() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLineaEnPosicion(0);
		assertEquals(Resultado.ERROR_1, ret.resultado);
	}

	@Test
	public void testBorrarLinea() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.BorrarLinea(1);
		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testBorrarLineaIgualA0() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.BorrarLinea(0);
		assertEquals(Resultado.ERROR_1, ret.resultado);
	}
	
	@Test
	public void testBorrarLineaMayorRango() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.BorrarLinea(6541);
		assertEquals(Resultado.ERROR_1, ret.resultado);
	}
	
	@Test
	public void testBorrarTodo() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.BorrarTodo();
		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testBorrarOcurrenciasPalabraEnTexto() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "PEPE");
		ret = sis.InsertarPalabraEnLinea(2, 1, "CACA");
		ret = sis.InsertarPalabraEnLinea(2, 2, "Sape");
		ret = sis.BorrarOcurrenciasPalabraEnTexto("CACA");
		
		assertEquals(Resultado.OK, ret.resultado);
	}
	
	@Test
	public void testBorrarOcurrenciasPalabraEnTextoSinOcurrencia() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "PEPE");
		ret = sis.InsertarPalabraEnLinea(2, 1, "SOSO");
		ret = sis.InsertarPalabraEnLinea(2, 2, "Sape");
		ret = sis.BorrarOcurrenciasPalabraEnTexto("ASASDASDSAD");
		
		assertEquals(Resultado.ERROR_1, ret.resultado);
	}

	@Test
	public void testImprimirTexto() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(2, 1, "Palabra2");
		ret = sis.InsertarLinea();
		ret = sis.ImprimirTexto();
		
		assertEquals(Resultado.OK, ret.resultado);
	}
	
	@Test
	public void testImprimirTextoVacio() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(2, 1, "Palabra2");
		ret = sis.InsertarLinea();
		ret = sis.BorrarTodo();
		ret = sis.ImprimirTexto();
		
		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testInsertarPalabraEnLinea() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 2, "Palabra2");
		
		assertEquals(Resultado.OK, ret.resultado);
	}
	
	@Test
	public void testInsertarPalabraEnLineaFueraDeRango() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(5, 3, "Palabra2");
		
		assertEquals(Resultado.ERROR_1, ret.resultado);
	}
	
	@Test
	public void testInsertarPalabraEnLineaSinPalabraEnPosMayorA1() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 3, "Palabra2");
		
		assertEquals(Resultado.ERROR_2, ret.resultado);
	}

	@Test
	public void testInsertarPalabraEnLineaPalabraFueraDeRango() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 2, "Palabra2");
		ret = sis.InsertarPalabraEnLinea(1, 3, "Palabra2");
		
		assertEquals(Resultado.ERROR_3, ret.resultado);
	}
	
	@Test
	public void testInsertarPalabraYDesplazar() {
		sis = new Sistema(3);
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraYDesplazar(1, 1, "Palabra1");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra3");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra2");
		
		assertEquals(Resultado.OK, ret.resultado);
	}
	
	@Test
	public void testInsertarPalabraYDesplazarLineaFueraDeRango() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraYDesplazar(15, 1, "Palabra1");
		
		assertEquals(Resultado.ERROR_1, ret.resultado);
	}
	
	@Test
	public void testInsertarPalabraYDesplazarPalabraFueraDeRango() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraYDesplazar(1, 56, "Palabra1");
		
		assertEquals(Resultado.ERROR_2, ret.resultado);
	}

	@Test
	public void testBorrarPalabra() {
		Retorno ret = sis.crearSistemaMensajes(), aux_ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarLinea();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		ret = sis.InsertarPalabraEnLinea(1, 2, "Palabra2");
		ret = sis.InsertarPalabraEnLinea(2, 1, "Palabra3");
		ret = sis.InsertarPalabraEnLinea(3, 1, "Palabra4");
		ret = sis.InsertarPalabraEnLinea(3, 2, "Palabra5");
		ret = sis.BorrarPalabra(2, 1);
		aux_ret = sis.ImprimirTexto();
		
		assertEquals(Resultado.OK, ret.resultado);
	}
	
	@Test
	public void testBorrarPalabraLineaFueraDeRango() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraYDesplazar(1, 1, "Palabra1");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra3");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra2");
		ret = sis.BorrarPalabra(0, 1);
		
		assertEquals(Resultado.ERROR_1, ret.resultado);
	}
	
	@Test
	public void testBorrarPalabraFueraDeRango() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraYDesplazar(1, 1, "Palabra1");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra3");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra2");
		ret = sis.BorrarPalabra(1, 3);
		
		assertEquals(Resultado.ERROR_2, ret.resultado);
	}

	@Test
	public void testImprimirLinea() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraYDesplazar(1, 1, "Palabra1");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra3");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra2");
		ret = sis.ImprimirLinea(1);
		
		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testImprimirLineaFueraDeRango() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraYDesplazar(1, 1, "Palabra1");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra3");
		ret = sis.InsertarPalabraYDesplazar(1, 2, "Palabra2");
		ret = sis.ImprimirLinea(7);
		
		assertEquals(Resultado.ERROR_1, ret.resultado);
	}
	
	@Test
	public void testIngresarPalabraDiccionario() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.IngresarPalabraDiccionario("Palabra1");

		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testIngresarPalabraDiccionarioPalabraYaExistente() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.IngresarPalabraDiccionario("Palabra1");
		ret = sis.IngresarPalabraDiccionario("Palabra1");

		assertEquals(Resultado.ERROR_1, ret.resultado);
	}
	
	@Test
	public void testBorrarPalabraDiccionario() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.IngresarPalabraDiccionario("Palabra1");
		ret = sis.BorrarPalabraDiccionario("Palabra1");

		assertEquals(Resultado.OK, ret.resultado);
	}
	
	@Test
	public void testBorrarPalabraDiccionarioPalabranoExistente() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.IngresarPalabraDiccionario("Palabra1");
		ret = sis.BorrarPalabraDiccionario("Palabra 1");

		assertEquals(Resultado.ERROR_1, ret.resultado);
	}

	@Test
	public void testImprimirDiccionario() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.IngresarPalabraDiccionario("Palabra1");
		ret = sis.IngresarPalabraDiccionario("Palabra2");
		ret = sis.IngresarPalabraDiccionario("Palabra3");
		ret = sis.ImprimirDiccionario();
		
		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testImprimirTextoIncorrecto() {
		Retorno ret = sis.crearSistemaMensajes();
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		ret = sis.InsertarLinea();
		ret = sis.InsertarPalabraEnLinea(2, 1, "Palabra2");
		ret = sis.InsertarLinea();
		
		ret = sis.IngresarPalabraDiccionario("Palabra1");
		ret = sis.ImprimirTextoIncorrecto();
		
		assertEquals(Resultado.OK, ret.resultado);
	}

}
