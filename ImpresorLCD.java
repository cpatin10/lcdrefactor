import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImpresorLCD {

    // Puntos fijos
    private final int[] puntoFijo1;
    private final int[] puntoFijo2;
    private final int[] puntoFijo3;
    private final int[] puntoFijo4;
    private final int[] puntoFijo5;
    
    // Matriz para la representación de los digitos
    private String[][] matrizDigitos;

    // Representacion de los caracteres usados para la representacion de los digitos
    private static final String CARACTER_VERTICAL = "|";
    private static final String CARACTER_HORIZONTAL = "-";
    
    // Variables para representar posicion x (filas) o y (columnas)
    private static final String POSICION_X = "X";
    private static final String POSICION_Y = "Y";

    // Tamaño definido para la representación de los digitos
    private int size;

    // Tamaño de cada digito individual
    private int filasDigito;
    private int columnasDigito;
    
    // Tamaño de las filas y columnas de la matrizDigitos
    private int filasMatrizDigitos;
    private int columnasMatrizDigitos;

    public ImpresorLCD() {
        // Inicializa variables
        this.puntoFijo1 = new int[2];
        this.puntoFijo2 = new int[2];
        this.puntoFijo3 = new int[2];
        this.puntoFijo4 = new int[2];
        this.puntoFijo5 = new int[2];
    }

    /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion
     * @param punto Punto Pivote
     * @param posFija Posicion Fija
     * @param size Tamaño Segmento
     * @param caracter Caracter Segmento
     */    
    private void adicionarLinea(String[][] matriz, int[] punto, String posFija,
            int size, String caracter) {

        if (posFija.equalsIgnoreCase(POSICION_X)) 
        {
            for (int y = 1; y <= size; y++) 
            {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        } 
        else 
        {
            for (int x = 1; x <= size; x++) 
            {
                int valor = punto[0] + x;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }

    /**
     *
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */  
    private void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                adicionarLinea(this.matrizDigitos, this.puntoFijo1, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matrizDigitos, this.puntoFijo2, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matrizDigitos, this.puntoFijo5, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matrizDigitos, this.puntoFijo4, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matrizDigitos, this.puntoFijo1, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matrizDigitos, this.puntoFijo2, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLinea(this.matrizDigitos, this.puntoFijo3, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }

    /**
     *
     * Metodo encargado de asignar los segmentos que componen un digito y
     * a partir de los segmentos adicionar la representacion del digito a la matriz
     *
     * @param digito Digito
     */
    private void adicionarDigito(int digito) {
    	
        List<Integer> segList = ListaSegmentos.getList(digito);        

        Iterator<Integer> iterator = segList.iterator();

        while (iterator.hasNext()) {
            adicionarSegmento(iterator.next());
        }
    }
    
    /**
     * Calcula el numero de filas a usar por cada dígito y lo almacena en filasDigitos
     */
    private void calcularFilasDigitos() {
    	this.filasDigito = (2 * this.size) + 3;
    }
    
    /**
     * Calcula el numero de columnas a usar por cada dígito y lo almacena en columnasDigitos
     */
    private void calcularColumnasDigitos() {
    	this.columnasDigito = this.size + 2;
    }
    
    /**
     * Define la matrizDigitos en la que se almacenan todos los digitos a imprimir
     * 
     * @param cantidadDigitos Cantidad de digitos a imprimir
     * @param espacio
     */
    private void definirMatrizDigitos(int cantidadDigitos, int espacio) {
        this.filasMatrizDigitos = this.filasDigito;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.columnasMatrizDigitos = (this.columnasDigito * cantidadDigitos)
                + (espacio * cantidadDigitos);

        this.matrizDigitos = new String[this.filasMatrizDigitos][this.columnasMatrizDigitos];
    }

    /**
     * Inicializa la matrizDigitos con el string " " en cada celda
     */
	private void inicializarMatrizDigitos() {
        for (int i = 0; i < this.filasMatrizDigitos; i++) {
            for (int j = 0; j < this.columnasMatrizDigitos; j++) {
                this.matrizDigitos[i][j] = " ";
            }
        }
	}	

    /**
     * Valida que el caracter dado sea realmente un digito
     * 
     * @param digito Caracter a validar
     * @throws IllegalArgumentException Indica si el caracter no es un digito
     */
	private void validarDigito(char digito) throws IllegalArgumentException {
		if( ! Character.isDigit(digito))
		{
		    throw new IllegalArgumentException("Caracter " + digito
		        + " no es un digito");
		}
	}

    /**
     * Calcula los puntos fijos para la matrizDigitos en el espacio 
     * 	definido por las columnas de un solo digito
     * 
     * @param pivotX Columna de inicio del digito en matrizDigitos
     */
	private void calcularPuntosFijos(int pivotX) {
		this.puntoFijo1[0] = 0;
		this.puntoFijo1[1] = 0 + pivotX;

		this.puntoFijo2[0] = (this.filasDigito / 2);
		this.puntoFijo2[1] = 0 + pivotX;

		this.puntoFijo3[0] = (this.filasDigito - 1);
		this.puntoFijo3[1] = 0 + pivotX;

		this.puntoFijo4[0] = (this.columnasDigito - 1);
		this.puntoFijo4[1] = (this.filasDigito / 2) + pivotX;

		this.puntoFijo5[0] = 0;
		this.puntoFijo5[1] = (this.columnasDigito - 1) + pivotX;
	}

    /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param size Tamaño Segmento Digitos
     * @param numeroAImprimir Numero a Imprimir
     * @param espacio Espacio Entre digitos
     * @throws IllegalArgumentException Indica que alguno de los caracteres en numeroAImprimir no es digito
     */    
    private void imprimirNumero(int size, String numeroAImprimir, int espacio) 
    		throws IllegalArgumentException {
    	
        int pivotX = 0;
        char[] digitos;

        this.size = size;
        // crea el arreglo de digitos
        digitos = numeroAImprimir.toCharArray();

        calcularFilasDigitos();
        calcularColumnasDigitos();

        definirMatrizDigitos(digitos.length, espacio);
        inicializarMatrizDigitos();

        for (char digito : digitos) {
            
            validarDigito(digito);            
            int numero = Integer.parseInt(String.valueOf(digito));

            calcularPuntosFijos(pivotX);
            pivotX = pivotX + this.columnasDigito + espacio;

            adicionarDigito(numero);
        }

        // Imprime matriz
        for (int i = 0; i < this.filasMatrizDigitos; i++) {
            for (int j = 0; j < this.columnasMatrizDigitos; j++) {
                System.out.print(this.matrizDigitos[i][j]);
            }
            System.out.println();
        }
    }

    ///////////////////////////////////////// MODIFICAR
    
     /**
     *
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param comando Entrada que contiene el size del segmento de los digito
     * y el numero a imprimir
     * @param espacioDigitos Espacio Entre digitos
     */  
    public void procesar(Comando comando, int espacioDigitos) throws IllegalArgumentException {       
        imprimirNumero(comando.getSize(), comando.getDigitos(), espacioDigitos);

    }

}
