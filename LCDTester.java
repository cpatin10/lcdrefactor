import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        
    	//List<String> listaComando = new ArrayList<>();
    	List<Comando> listaComando = new ArrayList<>();
        int espacioDigitos;
        
        try {

        	ProcesadorEntrada procesadorEntrada = new ProcesadorEntrada();
        	espacioDigitos = procesadorEntrada.getEspacioDigitos();
        	listaComando = procesadorEntrada.getListaComando();           

            ImpresorLCD impresorLCD = new ImpresorLCD();

            Iterator<Comando> iterator = listaComando.iterator();
            while (iterator.hasNext()) 
            {
                imprimirComando(espacioDigitos, impresorLCD, iterator);
            }
        } catch (Exception ex) 
        {
            System.out.println("Error: " + ex.getMessage());
        }

    }

	private static void imprimirComando(int espacioDigitos, ImpresorLCD impresorLCD, Iterator<Comando> iterator) {
		try {
		    impresorLCD.procesar(iterator.next(), espacioDigitos);
		} catch (Exception ex) {
		    System.out.println("Error: " + ex.getMessage());
		}
	}

}
