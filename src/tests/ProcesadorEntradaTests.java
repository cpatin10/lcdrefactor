package tests;

import main.ProcesadorEntrada;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProcesadorEntradaTests {

	@Test
	public void procesarEspacioDigitos_ValorMinimo() {		
		assertEquals(0, ProcesadorEntrada.procesarEspacioDigitos("0"));
	}

	@Test
	public void procesarEspacioDigitos_ValorMaximo() {		
		assertEquals(5, ProcesadorEntrada.procesarEspacioDigitos("5"));
	}	

	@Test
	public void procesarEspacioDigitos_ValorMedio() {		
		assertEquals(3, ProcesadorEntrada.procesarEspacioDigitos("3"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void procesarEspacioDigitos_ValorMenorAlRango() {
		ProcesadorEntrada.procesarEspacioDigitos("-1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void procesarEspacioDigitos_ValorMayorAlRango() {
		ProcesadorEntrada.procesarEspacioDigitos("6");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void procesarEspacioDigitos_EntradaVacia() {
		ProcesadorEntrada.procesarEspacioDigitos("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void procesarEspacioDigitos_EntradaNoValida() {
		ProcesadorEntrada.procesarEspacioDigitos("*");
	}


	@Test
	public void finComandos_EsUltimoComando() {
		assertTrue(ProcesadorEntrada.finComandos("0,0"));
	}
	
	@Test
	public void finComandos_ComandoVacio() {
		assertFalse(ProcesadorEntrada.finComandos(""));
	}
	
	@Test
	public void finComandos_ComandoValidoNoUltimo() {
		assertFalse(ProcesadorEntrada.finComandos("0,1"));
	}
	
	@Test
	public void finComandos_ComandoConCaracterNoValido() {
		assertFalse(ProcesadorEntrada.finComandos("t,0"));
	}

	@Test
	public void procesarComando_ComandoValido() {
		String[] parametros = ProcesadorEntrada.procesarComando("3,5");
		
		assertEquals(2, parametros.length);
		assertEquals("3", parametros[0]);
		assertEquals("5", parametros[1]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void procesarComando_ComandoMasLargo() {
		ProcesadorEntrada.procesarComando("3,5,8");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void procesarComando_ComandoSinSeparador() {
		ProcesadorEntrada.procesarComando("3 8");	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void procesarComando_ComandoMasCorto() {
		ProcesadorEntrada.procesarComando("3,");	
	}

	@Test
	public void procesarSize_ValorMinimo() {		
		assertEquals(1, ProcesadorEntrada.procesarSize("1"));
	}

	@Test
	public void procesarSize_ValorMaximo() {
		assertEquals(10, ProcesadorEntrada.procesarSize("10"));
	}

	@Test
	public void procesarSize_ValorMedio() {
		assertEquals(4, ProcesadorEntrada.procesarSize("4"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void procesarSize_ValorMayorAlRango() {
		ProcesadorEntrada.procesarSize("11");
	}

	@Test(expected = IllegalArgumentException.class)
	public void procesarSize_ValorMenorAlRango() {
		ProcesadorEntrada.procesarSize("0");
	}

	@Test(expected = IllegalArgumentException.class)
	public void procesarSize_EntradaNoVacia() {
		ProcesadorEntrada.procesarSize("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void procesarSize_EntradaNoValida() {
		ProcesadorEntrada.procesarSize("*");
	}

	@Test
	public void procesarNumero_ValorValido() {
		assertEquals(12345678, ProcesadorEntrada.procesarNumero("12345678"));
	}

	@Test
	public void procesarNumero_ValorMinimo() {
		assertEquals(0, ProcesadorEntrada.procesarNumero("0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void procesarNumero_ValorNegativo() {
		ProcesadorEntrada.procesarNumero("-12345678");		
	}

	@Test(expected = IllegalArgumentException.class)
	public void procesarNumero_EntradaVacia() {
		ProcesadorEntrada.procesarNumero("");		
	}

	@Test(expected = IllegalArgumentException.class)
	public void procesarNumero_EntradaNoValida() {
		ProcesadorEntrada.procesarNumero("123*5678");		
	}

}
