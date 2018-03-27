package main;
import java.util.ArrayList;
import java.util.List;
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
	
	// Lista de Comandos, se llena de acuerdo a la entrada del usuario
	private List<Comando> listaComando;
	
    // Cantidad de espacios entre los dígitos a escribir
	private int espacioDigitos;
    
//    public ProcesadorEntrada() throws IllegalArgumentException{ 
//    	listaComando = new ArrayList<>();   
//    	try (Scanner lector = new Scanner(System.in)) {    	        
//	        procesarEspacioDigitos(lector);
//	        procesarListaComando(lector);  
//    	}
//    }
    
    /**
     * Hace la lectura de los espacios que van a separar a los dígitos
     * Se almacena la entrada en espacioDigitos
     * 
     * @param lector Scanner
     * @throws IllegalArgumentException Indica que el valor ingresado no cumple con la restriccion (no es valor numerico)
     */
//    private void procesarEspacioDigitos(Scanner lector) 
//    		throws IllegalArgumentException {
//    	
//        System.out.print("Ingrese el número de espacios "
//        		+ "que desea usar para separar los dígitos (" 
//        		+ MINIMO_ESPACIOS + " a " + MAXIMO_ESPACIOS + "): ");
//    	String entrada = lector.next();		        
//        if (esNumero(entrada)) {
//        	this.espacioDigitos = Integer.parseInt(entrada);        	
//        	verificarEspacios(); 
//        } else { 
//        	throw new IllegalArgumentException("Cadena \"" + entrada
//        			+ "\" no es un entero");
//        }
//    }
    
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
    
    /**
     * Procesa los comandos dados por el usuario que serán almacenados en listaComando
     * Si el usuario ingresa un comando invalido el método se llama a sí mismo para 
     * 	continuar el ciclo hasta encontrar CADENA_FINAL
     * 
     * @param lector Scanner
     */
    private void procesarListaComando(Scanner lector) {
    	try {
    		String entrada = leerEntradaComando(lector);
        	while (!entrada.equalsIgnoreCase(CADENA_FINAL)) {
        		procesarComando(entrada);
        		entrada = leerEntradaComando(lector);
        	}
    	} catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    		procesarListaComando(lector);
    	}    	
    }
    
    /**
     * 
     * Lee un solo comando ingresado pore el usuario
     * 
     * @param lector Scanner
     * @return Comando ingresado (String)
     */
    private String leerEntradaComando(Scanner lector) {
    	System.out.print("Entrada en formato <Size,digitos>: ");
        return lector.next();
    }
    
    
    /**
     * Procesa un comando leido, convirtiendolo del tipo String a Comando
     * 
     * @param entrada Cadena que representa el comando
     * @throws IllegalArgumentException Indica si la cadena dada no cumple con las restricciones para definir un comando
     */
//    private void procesarComando(String entrada) throws IllegalArgumentException {
//    	
//    	int size;
//    	String[] parametros = separarComando(entrada);
//    	validarCantidadParametros(parametros.length, entrada);
//    	size = procesarSize(parametros[0]);
//    	listaComando.add(new Comando(size, parametros[1]));
//    }    
    
    /**
     * Procesa el tamaño de un comando a partir de la cadena dada
     * 
     * @param cadena Cadena
     * @return
     * @throws IllegalArgumentException Indica que la cadena no cumple con las restricciones especificadas
     */
//    private int procesarSize(String cadena) throws IllegalArgumentException{
//    	int size;
//    	if (!esNumero(cadena)) {
//    		throw new IllegalArgumentException("Parametro Size [" + cadena
//                    + "] no es un numero");
//    	}
//    	
//    	size = Integer.parseInt(cadena);
//    	if (!sizeValido(size)) {
//    		throw new IllegalArgumentException("El parametro size [" + size
//                    + "] debe estar entre 1 y 10");
//    	}
//    	
//    	return size;
//    }
    
    /**
     * Getter for espacioDigitos
     * 
     * @return
     */
//    public int getEspacioDigitos() {
//    	return espacioDigitos;
//    }
    
    /**
     * Getter for listaComandos
     * 
     * @return
     */
//    public List<Comando> getListaComando() {
//    	return listaComando;
//    }
}
