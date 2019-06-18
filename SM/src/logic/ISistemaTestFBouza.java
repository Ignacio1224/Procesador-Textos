package logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logic.Retorno.Resultado;

public class ISistemaTestFBouza {

	private ISistema sis;
	private Retorno ret;

	@Before
	public void setUp() throws Exception {
		sis = new Sistema(3);
	}

	@Test
	public void testCrearSistemaMensajes() {
		assertEquals(Resultado.OK, sis.crearSistemaMensajes().resultado);
	}

	@Test
	public void testDestruirSistemaMensajes() {
		sis.crearSistemaMensajes();
		assertEquals(Resultado.OK, sis.destruirSistemaMensajes().resultado);
	}

	@Test
	public void testInsertarLinea() {
		sis.crearSistemaMensajes();

		assertEquals(Resultado.OK, sis.InsertarLinea().resultado);
		assertEquals(Resultado.OK, sis.InsertarLinea().resultado);
		assertEquals(Resultado.OK, sis.InsertarLinea().resultado);
	}

	@Test
	public void testInsertarLineaEnPosicion() {
		sis.crearSistemaMensajes();

		assertEquals(Resultado.ERROR_1, sis.InsertarLineaEnPosicion(2).resultado);
		assertEquals(Resultado.OK, sis.InsertarLineaEnPosicion(1).resultado);
		assertEquals(Resultado.OK, sis.InsertarLineaEnPosicion(2).resultado);
		assertEquals(Resultado.ERROR_1, sis.InsertarLineaEnPosicion(4).resultado);
		assertEquals(Resultado.OK, sis.InsertarLineaEnPosicion(1).resultado);
		assertEquals(Resultado.OK, sis.InsertarLineaEnPosicion(3).resultado);

	}

	@Test
	public void testBorrarLinea() {
		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		assertEquals(Resultado.ERROR_1, sis.BorrarLinea(5).resultado);
		assertEquals(Resultado.OK, sis.BorrarLinea(4).resultado);
		assertEquals(Resultado.ERROR_1, sis.BorrarLinea(4).resultado);
		assertEquals(Resultado.OK, sis.BorrarLinea(1).resultado);
		assertEquals(Resultado.OK, sis.BorrarLinea(1).resultado);
		assertEquals(Resultado.OK, sis.BorrarLinea(1).resultado);
		assertEquals(Resultado.ERROR_1, sis.BorrarLinea(1).resultado);

	}

	@Test
	public void testBorrarTodo() {
		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		assertEquals(Resultado.OK, sis.BorrarTodo().resultado);

		// Al borrar todo, no deben quedar líneas disponibles
		assertEquals(Resultado.ERROR_1, sis.BorrarLinea(1).resultado);
	}

	@Test
	public void testBorrarOcurrenciasPalabraEnTexto() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(1, 2, "Palabra2");
		sis.InsertarPalabraEnLinea(2, 1, "Palabra2");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra2");

		assertEquals(Resultado.OK, sis.BorrarOcurrenciasPalabraEnTexto("Palabra2").resultado);

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith("1: Palabra1\n2:\n3: Palabra1"));
	}

	@Test
	public void testImprimirTexto() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(1, 2, "Palabra2");
		sis.InsertarPalabraEnLinea(2, 1, "Palabra2");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra2");

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith("1: Palabra1 Palabra2\n2: Palabra2\n3: Palabra2 Palabra1"));
	}

	@Test
	public void testInsertarPalabraEnLinea() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		assertEquals(Resultado.OK, sis.InsertarPalabraEnLinea(1, 1, "Palabra1").resultado);
		assertEquals(Resultado.OK, sis.InsertarPalabraEnLinea(1, 2, "Palabra2").resultado);
		assertEquals(Resultado.OK, sis.InsertarPalabraEnLinea(2, 1, "Palabra2").resultado);
		assertEquals(Resultado.OK, sis.InsertarPalabraEnLinea(3, 1, "Palabra1").resultado);
		assertEquals(Resultado.OK, sis.InsertarPalabraEnLinea(3, 1, "Palabra2").resultado);

		assertEquals(Resultado.ERROR_1, sis.InsertarPalabraEnLinea(1891, 1, "PalabraNO").resultado);
		assertEquals(Resultado.ERROR_1, sis.InsertarPalabraEnLinea(4, 1, "PalabraNO").resultado);
		assertEquals(Resultado.ERROR_2, sis.InsertarPalabraEnLinea(2, 3, "PalabraNO").resultado);
		assertEquals(Resultado.OK, sis.InsertarPalabraEnLinea(1, 1, "PalabraSI").resultado);
		assertEquals(Resultado.ERROR_3, sis.InsertarPalabraEnLinea(1, 1, "PalabraNO").resultado);

	}

	@Test
	public void testInsertarPalabraYDesplazar() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(1, 2, "Palabra2");
		sis.InsertarPalabraEnLinea(2, 1, "Palabra2");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra2");

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith("1: Palabra1 Palabra2\n2: Palabra2\n3: Palabra2 Palabra1"));

		assertEquals(Resultado.ERROR_1, sis.InsertarPalabraYDesplazar(1891, 1, "PalabraNO").resultado);
		assertEquals(Resultado.ERROR_1, sis.InsertarPalabraYDesplazar(4, 1, "PalabraNO").resultado);
		assertEquals(Resultado.ERROR_2, sis.InsertarPalabraYDesplazar(2, 3, "PalabraNO").resultado);
		assertEquals(Resultado.OK, sis.InsertarPalabraYDesplazar(1, 2, "Palabra3").resultado);

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith("1: Palabra1 Palabra3 Palabra2\n2: Palabra2\n3: Palabra2 Palabra1"));

		assertEquals(Resultado.OK, sis.InsertarPalabraYDesplazar(1, 2, "Palabra4").resultado);

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString
				.startsWith("1: Palabra1 Palabra4 Palabra3\n2: Palabra2 Palabra2\n3: Palabra2 Palabra1"));

		assertEquals(Resultado.OK, sis.InsertarPalabraYDesplazar(1, 2, "Palabra5").resultado);

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString
				.startsWith("1: Palabra1 Palabra5 Palabra4\n2: Palabra3 Palabra2 Palabra2\n3: Palabra2 Palabra1"));

		assertEquals(Resultado.OK, sis.InsertarPalabraYDesplazar(2, 1, "Palabra6").resultado);

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith(
				"1: Palabra1 Palabra5 Palabra4\n2: Palabra6 Palabra3 Palabra2\n3: Palabra2 Palabra2 Palabra1"));

		assertEquals(Resultado.OK, sis.InsertarPalabraYDesplazar(2, 2, "Palabra7").resultado);

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith(
				"1: Palabra1 Palabra5 Palabra4\n2: Palabra6 Palabra7 Palabra3\n3: Palabra2 Palabra2 Palabra2\n4: Palabra1"));

	}

	@Test
	public void testBorrarPalabra() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(1, 2, "Palabra2");
		sis.InsertarPalabraEnLinea(2, 1, "Palabra2");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra2");

		assertEquals(Resultado.ERROR_1, sis.BorrarPalabra(1891, 1).resultado);
		assertEquals(Resultado.ERROR_1, sis.BorrarPalabra(4, 1).resultado);
		assertEquals(Resultado.ERROR_2, sis.BorrarPalabra(2, 2).resultado);
		assertEquals(Resultado.OK, sis.BorrarPalabra(2, 1).resultado);

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith("1: Palabra1 Palabra2\n2:\n3: Palabra2 Palabra1"));

		assertEquals(Resultado.ERROR_2, sis.BorrarPalabra(2, 1).resultado);
		assertEquals(Resultado.OK, sis.BorrarPalabra(1, 1).resultado);

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith("1: Palabra2\n2:\n3: Palabra2 Palabra1"));

	}

	@Test
	public void testImprimirLinea() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		sis.InsertarPalabraEnLinea(1, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(1, 2, "Palabra2");
		sis.InsertarPalabraEnLinea(2, 1, "Palabra2");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra1");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra2");

		assertEquals(Resultado.ERROR_1, sis.ImprimirLinea(1891).resultado);
		assertEquals(Resultado.ERROR_1, sis.ImprimirLinea(4).resultado);

		ret = sis.ImprimirLinea(1);
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith("1: Palabra1 Palabra2"));

		ret = sis.ImprimirLinea(2);
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith("2: Palabra2"));

		ret = sis.ImprimirLinea(3);
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith("3: Palabra2 Palabra1"));

	}

	@Test
	public void testIngresarPalabraDiccionario() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("Mi").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("corazón").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("palpita").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("y").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("se").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("extremece").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("cuando").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("me").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("envuelve").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("el").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("mirasol").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("de").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("tu").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("bandera").resultado);
		assertEquals(Resultado.ERROR_1, sis.IngresarPalabraDiccionario("y").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("esta").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("pasión").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("que").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("cada").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("dia").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("crece").resultado);
		assertEquals(Resultado.ERROR_1, sis.IngresarPalabraDiccionario("y").resultado);
		assertEquals(Resultado.ERROR_1, sis.IngresarPalabraDiccionario("crece").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("como").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("vos").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("siempre").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("florece").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("año").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("a").resultado);
		assertEquals(Resultado.ERROR_1, sis.IngresarPalabraDiccionario("año").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("en").resultado);
		assertEquals(Resultado.OK, sis.IngresarPalabraDiccionario("primavera").resultado);

	}

	@Test
	public void testBorrarPalabraDiccionario() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		sis.IngresarPalabraDiccionario("Mi");
		sis.IngresarPalabraDiccionario("corazón");
		sis.IngresarPalabraDiccionario("palpita");
		sis.IngresarPalabraDiccionario("y");
		sis.IngresarPalabraDiccionario("se");
		sis.IngresarPalabraDiccionario("extremece");
		sis.IngresarPalabraDiccionario("cuando");
		sis.IngresarPalabraDiccionario("me");
		sis.IngresarPalabraDiccionario("envuelve");
		sis.IngresarPalabraDiccionario("el");
		sis.IngresarPalabraDiccionario("mirasol");
		sis.IngresarPalabraDiccionario("de");
		sis.IngresarPalabraDiccionario("tu");
		sis.IngresarPalabraDiccionario("bandera");
		sis.IngresarPalabraDiccionario("esta");
		sis.IngresarPalabraDiccionario("pasión");
		sis.IngresarPalabraDiccionario("que");
		sis.IngresarPalabraDiccionario("cada");
		sis.IngresarPalabraDiccionario("dia");
		sis.IngresarPalabraDiccionario("crece");
		sis.IngresarPalabraDiccionario("como");
		sis.IngresarPalabraDiccionario("vos");
		sis.IngresarPalabraDiccionario("siempre");
		sis.IngresarPalabraDiccionario("florece");
		sis.IngresarPalabraDiccionario("año");
		sis.IngresarPalabraDiccionario("a");
		sis.IngresarPalabraDiccionario("en");
		sis.IngresarPalabraDiccionario("primavera");

		assertEquals(Resultado.OK, sis.BorrarPalabraDiccionario("Mi").resultado);
		assertEquals(Resultado.ERROR_1, sis.BorrarPalabraDiccionario("Mi").resultado);
		assertEquals(Resultado.OK, sis.BorrarPalabraDiccionario("que").resultado);
		assertEquals(Resultado.ERROR_1, sis.BorrarPalabraDiccionario("que").resultado);

		assertEquals(Resultado.ERROR_1, sis.BorrarPalabraDiccionario("parque").resultado);
		assertEquals(Resultado.ERROR_1, sis.BorrarPalabraDiccionario("minoría").resultado);

	}

	@Test
	public void testImprimirDiccionario() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		sis.IngresarPalabraDiccionario("Mi");
		sis.IngresarPalabraDiccionario("corazón");
		sis.IngresarPalabraDiccionario("palpita");
		sis.IngresarPalabraDiccionario("y");
		sis.IngresarPalabraDiccionario("se");
		sis.IngresarPalabraDiccionario("extremece");
		sis.IngresarPalabraDiccionario("cuando");
		sis.IngresarPalabraDiccionario("me");
		sis.IngresarPalabraDiccionario("envuelve");
		sis.IngresarPalabraDiccionario("el");
		sis.IngresarPalabraDiccionario("mirasol");
		sis.IngresarPalabraDiccionario("de");
		sis.IngresarPalabraDiccionario("tu");
		sis.IngresarPalabraDiccionario("bandera");
		sis.IngresarPalabraDiccionario("esta");
		sis.IngresarPalabraDiccionario("pasión");
		sis.IngresarPalabraDiccionario("que");
		sis.IngresarPalabraDiccionario("cada");
		sis.IngresarPalabraDiccionario("dia");
		sis.IngresarPalabraDiccionario("crece");
		sis.IngresarPalabraDiccionario("como");
		sis.IngresarPalabraDiccionario("vos");
		sis.IngresarPalabraDiccionario("siempre");
		sis.IngresarPalabraDiccionario("florece");
		sis.IngresarPalabraDiccionario("año");
		sis.IngresarPalabraDiccionario("a");
		sis.IngresarPalabraDiccionario("en");
		sis.IngresarPalabraDiccionario("primavera");

		ret = sis.ImprimirDiccionario();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(ret.valorString.startsWith(
				"Mi\na\naño\nbandera\ncada\ncomo\ncorazón\ncrece\ncuando\nde\ndia\nel\nen\nenvuelve\nesta\nextremece\nflorece\nme\nmirasol\npalpita\npasión\nprimavera\nque\nse\nsiempre\ntu\nvos\ny"));

	}

	@Test
	public void testImprimirTextoIncorrecto() {

		sis.crearSistemaMensajes();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();

		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarLinea();
		sis.InsertarPalabraEnLinea(2, 1, "Palabra21");
		sis.InsertarPalabraEnLinea(2, 2, "Palabra22");
		sis.InsertarPalabraEnLinea(1, 1, "Palabra11");
		sis.InsertarPalabraEnLinea(1, 2, "Palabra12");
		sis.InsertarPalabraEnLinea(1, 3, "Palabra13");
		sis.InsertarPalabraEnLinea(3, 1, "Palabra31");

		ret = sis.ImprimirTexto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(
				ret.valorString.startsWith("1: Palabra11 Palabra12 Palabra13\n2: Palabra21 Palabra22\n3: Palabra31"));

		sis.IngresarPalabraDiccionario("Palabra12");
		sis.IngresarPalabraDiccionario("Palabra21");
		sis.IngresarPalabraDiccionario("Palabra22");

		ret = sis.ImprimirTextoIncorrecto();
		assertEquals(Resultado.OK, ret.resultado);
		assertTrue(
				ret.valorString.startsWith("1: Palabra11 Palabra13\n2:\n3: Palabra31"));

	}


}
