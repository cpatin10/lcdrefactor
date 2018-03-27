package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {
    
	/**
	 * Hace la lectura de un solo comando 
	 * @param lector
	 * @return
	 */
    private static String leerComandoLista(Scanner lector) {
    	System.out.print("Entrada: ");
        return lector.next();
    }

	/**
     * Lee los comandos ingresados por el usuario los cuales almacena en 
     * 	una lista que será retornada al final
     * 
     * @param lector Scanner
     * @return Lista con comandos ingresados por el usuario
     */
	private static List<String> leerListaComando(Scanner lector) {
		String comando;
		List<String> listaComando = new ArrayList<String>();
		System.out.println("Ingrese los comandos size" + ProcesadorEntrada.SEPARADOR + "numero\n"
				+ "Recuerde que size está entre " + ProcesadorEntrada.SIZE_MINIMO 
				+ " y " + ProcesadorEntrada.SIZE_MAXIMO + ","
				+ " y numero debe ser positivo");
		
		comando = leerComandoLista(lector);
		while (!ProcesadorEntrada.finComandos(comando)) {
			listaComando.add(comando);
			comando = leerComandoLista(lector);
		}
		
		return listaComando;
	}
	
	/**
	 * Lectura del valor dado por el usuario para designar
	 * 	la cantidad de espacios que separá a los digitos en el momento de imprimir
	 * 
	 * @param lector Scanner
	 * @return Entero espacioDigitos
	 * @throws IllegalArgumentException Indica si el valor dado no cumple las restricciones para espacioDigitos
	 */
	private static int leerEspacioDigitos(Scanner lector) 
			throws IllegalArgumentException {
		String comando;
		int espacioDigitos;
		System.out.print("Espacio entre Digitos (" + ProcesadorEntrada.MINIMO_ESPACIOS
				+ " a " + ProcesadorEntrada.MAXIMO_ESPACIOS + "): ");
		comando = lector.next();
		
		espacioDigitos = ProcesadorEntrada.procesarEspacioDigitos(comando);
		return espacioDigitos;
	}
    
	/**
	 * Realiza la impresion de un numero encontrado en el comando dado
	 * 
	 * @param espacioDigitos Numero de espacios que separara cada digito
	 * @param impresorLCD Objeto encargado de la impresión
	 * @param comando String del comando
	 * @throws IllegalArgumentException Indica si el comando no cumple con las restricciones prestablecidas
	 */
	private static void imprimirNumero(int espacioDigitos, ImpresorLCD impresorLCD, String comando) 
			throws IllegalArgumentException {
		try 
		{
		    impresorLCD.procesar(comando, espacioDigitos);
		} catch (Exception ex) 
		{
		    System.out.println("Error: "+ex.getMessage());
		}
	}
	
	
    public static void main(String[] args) {

        // Almacena los comandos size,numero ingresados por el usuario
        List<String> listaComando = new ArrayList<>();
        int espacioDigitos;
        
        try {

            try (Scanner lector = new Scanner(System.in)) {                
                espacioDigitos = leerEspacioDigitos(lector);                
                listaComando = leerListaComando(lector);
            }

            ImpresorLCD impresorLCD = new ImpresorLCD();

            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) 
            {
                imprimirNumero(espacioDigitos, impresorLCD, iterator.next());
            }
        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
}
