package logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logic.Retorno.Resultado;

public class ISistemaTest {
	
	private ISistema sis;

	@Before
	public void setUp() throws Exception {
		sis = new Sistema(4);
	}

	@Test
	public void testCrearSistemaMensajes() {
		
		Retorno ret = sis.crearSistemaMensajes();
		assertEquals(Resultado.OK, ret.resultado);
	}

	@Test
	public void testDestruirSistemaMensajes() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarLinea() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarLineaEnPosicion() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrarLinea() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrarTodo() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrarOcurrenciasPalabraEnTexto() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirTexto() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarPalabraEnLinea() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarPalabraYDesplazar() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrarPalabra() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirLinea() {
		fail("Not yet implemented");
	}

	@Test
	public void testIngresarPalabraDiccionario() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrarPalabraDiccionario() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirDiccionario() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirTextoIncorrecto() {
		fail("Not yet implemented");
	}

}
