package main;
import java.util.Scanner;

public class ProcesadorEntrada {

	// Define la cadena que identifica el final de la entrada
	private static final String CADENA_FINAL = "0,0";
	
	// Definen los limites para la cantidad de espacios permitidos
	private static final int MINIMO_ESPACIOS = 0;
	private static final int MAXIMO_ESPACIOS = 5;
	
	// Definen los limites para el tamaño de un comando
	private static final int SIZE_MINIMO = 1;
	private static final int SIZE_MAXIMO = 10;
	
	// Define el separador usado para el tamaño y los digitos en un comando
	private static final String SEPARADOR = ",";
    
    /**
     * Valida si una cadena representa un numero
     * 
     * @param cadena Cadena
     * @return
     */
    private static boolean esNumero(String cadena) {
    	try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    /**
     * Verifica si los espacios asignados por el usuario es un valor valido 
     * Es valido si se encuentra en el rango permitido: [MINIMO_ESPACIOS, MAXIMO_ESPACIOS]
     * 
     * @throws IllegalArgumentException Indica que los espacios asignados está por fuera del rango permitido
     */
    private static void verificarEspacios(int espacioDigitos) 
    		throws IllegalArgumentException {
    	
    	if(espacioDigitos < MINIMO_ESPACIOS || espacioDigitos > MAXIMO_ESPACIOS)
        {
            throw new IllegalArgumentException("El espacio entre "
                    + "digitos debe estar entre  " + MINIMO_ESPACIOS + " y " + MAXIMO_ESPACIOS);
        }
    }
    
    /**
     * Define el valor de los espacios entre los digitos, proveniente de una cadena, 
     * 	el cual cumple con las restricciones dadas
     * 
     * @param cadena Cadena
     * @return Entero
     * @throws IllegalArgumentException Indica si la cadena dada no cumple con las restricciones de los espacios
     */
    public static int procesarEspacioDigitos(String cadena)
    		throws IllegalArgumentException {
    	
    	int espacioDigitos;
    	
    	if (esNumero(cadena)) {
        	espacioDigitos = Integer.parseInt(cadena);        	
        	verificarEspacios(espacioDigitos); 
        } else { 
        	throw new IllegalArgumentException("Cadena \"" + cadena
        			+ "\" no es un entero");
        }
    	
    	return espacioDigitos;
    }
    
    /**
     * Indica si la cadena dada indica es la ultima cadena (fin de los comandos)
     * 
     * @param cadena Cadena
     * @return Verdadero si la cadena es la ultima y falso si no lo es
     */
    public static boolean finComandos(String cadena) {
    	if (cadena.equalsIgnoreCase(CADENA_FINAL)) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * Se separa el comando dado de acuerdo al string SEPARADOR
     * 
     * @param comando Cadena que representa un comando
     * @return
     * @throws IllegalArgumentException Indica que la cadena no se puede serparar ya que no tiene el string SEPARADOR
     */
    private static String[] separarComando(String comando) 
    		throws IllegalArgumentException {  
    	
    	if (!comando.contains(SEPARADOR)) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene la cadena " + SEPARADOR);
        } 
        return comando.split(SEPARADOR);
    }
    
    /**
     * Valida que la cantidad de parametros si sea la esperada
     * 
     * @param cantidadDada Cantidad de parametros
     * @param entrada Cadena original
     * @throws IllegalArgumentException Indica si la cantidad de parametros no es la esperada
     */
    private static void validarCantidadParametros(int cantidadDada, String entrada) 
    		throws IllegalArgumentException {
    	
    	int cantidadEsperado = 2;
    	if(cantidadDada > cantidadEsperado) {
           throw new IllegalArgumentException("Cadena " + entrada
                    + " contiene mas caracter ,"); 
        }      	
        if(cantidadDada < cantidadEsperado) {
           throw new IllegalArgumentException("Cadena " + entrada
                    + " no contiene los parametros requeridos"); 
        }
    } 
    
    /**
     * Recibe un comando y lo separa en sus respectivas partes de acuerdo al SEPARADOR
     * Se asegura que el comando cumple con las restricciones establecidas
     * 
     * @param cadena Comando
     * @return Arreglo de cadenas con las partes del comando
     * @throws IllegalArgumentException Indica que el comando no cumple con el formato predefinido
     */
    public static String[] procesarComando(String cadena) 
    		throws IllegalArgumentException {
    	
    	String[] parametros = separarComando(cadena);
    	validarCantidadParametros(parametros.length, cadena);
    	return parametros;
    }
    
    /**
     * Retorna verdadero si el tamaño dado está en el rango definido y falso de lo contrario
     * 
     * @param size Tamaño
     * @return
     */
    private static boolean sizeValido(int size) {
    	if(size < SIZE_MINIMO || size > SIZE_MAXIMO) {
            return false;
        }
    	return true;
    }
    
    /**
     * Transforma la cadena dada a un entero que representa el tamaño de un digito a imprimir
     * Se valida que el tamaño si cumpla con las restricciones preestablecidas
     * 
     * @param cadena Cadena
     * @return Entero size
     * @throws IllegalArgumentException Indica que el valor dado no cumple con las restricciones para size
     */
    public static int procesarSize(String cadena) 
    		throws IllegalArgumentException {
    	
    	int size;
    	if (!esNumero(cadena)) {
    		throw new IllegalArgumentException("Parametro Size [" + cadena
                    + "] no es un numero");
    	}
    	
    	size = Integer.parseInt(cadena);
    	
    	if (!sizeValido(size)) {
    		throw new IllegalArgumentException("El parametro size [" + size
                    + "] debe estar entre 1 y 10");
    	}
    	
    	return size;
    }
    
    /**
     * Transforma la cadena dada a un entero que representa el numero con los digitos a imprimir
     * Se valida que el numero si cumpla con las restricciones preestablecidas 
     * 
     * @param cadena Cadena
     * @return Entero numero
     * @throws IllegalArgumentException Indica que el valor dado no cumple con las restricciones para size
     */
    public static int procesarNumero(String cadena)
    		throws IllegalArgumentException {
    	
    	int numero;
    	if (!esNumero(cadena)) {
    		throw new IllegalArgumentException("El número dado " + cadena
    		        + " no es un número");
    	}
    	
    	numero = Integer.parseInt(cadena);
    	
    	if (numero < 0) {
    		throw new IllegalArgumentException("El número dado " + cadena
    		        + " debe ser positvio");
    	}
    	
    	return numero;
    }
}
