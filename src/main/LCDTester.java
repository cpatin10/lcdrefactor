package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LCDTester {
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        String comando;
        int espacioDigitos;
        
        try {

            try (Scanner lector = new Scanner(System.in)) {
                
                System.out.print("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();
                
                espacioDigitos = ProcesadorEntrada.procesarEspacioDigitos(comando);
                
                comando = leerEntradaLista(lector);
                while (!ProcesadorEntrada.finComandos(comando)) {
                	listaComando.add(comando);
                	comando = leerEntradaLista(lector);
                }
            }

            ImpresorLCD impresorLCD = new ImpresorLCD();

            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) 
            {
                try 
                {
                    impresorLCD.procesar(iterator.next(), espacioDigitos);
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }

    }
    
    private static String leerEntradaLista(Scanner lector) {
    	System.out.print("Entrada: ");
        return lector.next();
    }

}
