package tests;

import main.ProcesadorEntrada;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProcesadorEntradaTests {

	@Test
	public void testProcesarEspacioDigitos_ValorValido() {
		String entrada;
		int esperado;
		int dado;
		
		entrada = "0";
		esperado = 0;
		dado = ProcesadorEntrada.procesarEspacioDigitos(entrada);
		assertEquals(esperado, dado);
		
		entrada = "5";
		esperado = 5;
		dado = ProcesadorEntrada.procesarEspacioDigitos(entrada);
		assertEquals(esperado, dado);
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testProcesarEspacioDigitos_ValorMenorAlRango() {
		String entrada;
		
		entrada = "-1";
		ProcesadorEntrada.procesarEspacioDigitos(entrada);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProcesarEspacioDigitos_ValorMayorAlRango() {
		String entrada;
		
		entrada = "6";
		ProcesadorEntrada.procesarEspacioDigitos(entrada);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProcesarEspacioDigitos_EntradaVacia() {
		String entrada;
		
		entrada = "";
		ProcesadorEntrada.procesarEspacioDigitos(entrada);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProcesarEspacioDigitos_EntradaNoValida() {
		String entrada;
		
		entrada = "*";
		ProcesadorEntrada.procesarEspacioDigitos(entrada);
	}


	@Test
	public void testFinComandos_EsUltimoComando() {
		String comando;
		
		comando = "0,0";		
		assertTrue(ProcesadorEntrada.finComandos(comando));
	}
	
	@Test
	public void testFinComandos_NoEsUltimoComando() {
		String comando;
		
		comando = "";		
		assertFalse(ProcesadorEntrada.finComandos(comando));
		
		comando = "0,1";
		assertFalse(ProcesadorEntrada.finComandos(comando));
		
		comando = "t,0";
		assertFalse(ProcesadorEntrada.finComandos(comando));
		
		comando = "2,1";
		assertFalse(ProcesadorEntrada.finComandos(comando));
	}

	@Test
	public void testProcesarComando_ComandoValido() {
		String comando;
		String[] parametros;
		String parametro0, parametro1;
		
		comando = "3,5";
		parametro0 = "3";
		parametro1 = "5";
		parametros = ProcesadorEntrada.procesarComando(comando);
		
		assertEquals(2, parametros.length);
		assertEquals(parametro0, parametros[0]);
		assertEquals(parametro1, parametros[1]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProcesarComando_ComandoMasLargo() {
		String comando;
		
		comando = "3,5,8";
		ProcesadorEntrada.procesarComando(comando);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProcesarComando_ComandoSinSeparador() {
		String comando;
		
		comando = "3 8";
		ProcesadorEntrada.procesarComando(comando);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProcesarComando_ComandoMasCorto() {
		String comando;
		
		comando = "3,";
		ProcesadorEntrada.procesarComando(comando);	
	}

	@Test
	public void testProcesarSize_ValorValido() {
		String entrada;
		int size;
		
		entrada = "1";
		size = 1;
		
		assertEquals(size, ProcesadorEntrada.procesarSize(entrada));
		
		entrada = "10";
		size = 10;
		
		assertEquals(size, ProcesadorEntrada.procesarSize(entrada));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProcesarSize_ValorMayorAlRango() {
		String entrada;
		
		entrada = "11";
		ProcesadorEntrada.procesarSize(entrada);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProcesarSize_ValorMenorAlRango() {
		String entrada;
		
		entrada = "0";
		ProcesadorEntrada.procesarSize(entrada);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProcesarSize_EntradaNoVacia() {
		String entrada;
		
		entrada = "";
		ProcesadorEntrada.procesarSize(entrada);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProcesarSize_EntradaNoValida() {
		String entrada;
		
		entrada = "*";
		ProcesadorEntrada.procesarSize(entrada);
	}

	@Test
	public void testProcesarNumero_ValorValido() {
		String entrada;
		int numero;
		
		entrada = "12345678";
		numero = 12345678;
				
		assertEquals(numero, ProcesadorEntrada.procesarNumero(entrada));
		
		entrada = "0";
		numero = 0;
		
		assertEquals(numero, ProcesadorEntrada.procesarNumero(entrada));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProcesarNumero_NumeroNegativo() {
		String entrada;
		
		entrada = "-12345678";
		ProcesadorEntrada.procesarNumero(entrada);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProcesarNumero_EntradaVacia() {
		String entrada;
		
		entrada = "";
		ProcesadorEntrada.procesarNumero(entrada);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProcesarNumero_EntradaNoValida() {
		String entrada;
		
		entrada = "123*5678";
		ProcesadorEntrada.procesarNumero(entrada);		
	}

}
