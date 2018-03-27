package main;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ListaSegmentos {
	
	/**
	 * Define los segmentos correspondientes a cada digito
	 * 
	 * Si la matriz fuera lo más pequeña posible (5*3), 
	 * 	los segmentos se distribuirían de la siguiente forma:
	 * 
	 * 
	 * |   | 5 |   |
	 * -------------
	 * | 1 |   | 3 |  
	 * -------------
	 * |   | 6 |   |
	 * -------------
	 * | 2 |   | 4 |
	 * -------------
	 * |   | 7 |   |
	 *  
	 */

	private static final HashMap<Integer, List<Integer>> SEGMENTOS_DIGITOS = definirSegmentos(); 
	private static HashMap<Integer, List<Integer>> definirSegmentos() {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		map.put(1, new ArrayList<Integer>());
		map.get(1).add(3);
		map.get(1).add(4);
		
		map.put(2, new ArrayList<Integer>());
		map.get(2).add(2);
		map.get(2).add(3);
		map.get(2).add(5);
		map.get(2).add(6);
		map.get(2).add(7);
		
		map.put(3, new ArrayList<Integer>());
		map.get(3).add(3);
		map.get(3).add(4);
		map.get(3).add(5);
		map.get(3).add(6);
		map.get(3).add(7);
		
		map.put(4, new ArrayList<Integer>());
		map.get(4).add(1);
		map.get(4).add(3);
		map.get(4).add(4);
		map.get(4).add(6);
		
		map.put(5, new ArrayList<Integer>());
		map.get(5).add(1);
		map.get(5).add(4);
		map.get(5).add(5);
		map.get(5).add(6);
		map.get(5).add(7);
		
		map.put(6, new ArrayList<Integer>());
		map.get(6).add(1);
		map.get(6).add(2);
		map.get(6).add(4);
		map.get(6).add(5);
		map.get(6).add(6);
		map.get(6).add(7);
		
		map.put(7, new ArrayList<Integer>());
		map.get(7).add(3);
		map.get(7).add(4);
		map.get(7).add(5);
		
		map.put(8, new ArrayList<Integer>());
		map.get(8).add(1);
		map.get(8).add(2);
		map.get(8).add(3);
		map.get(8).add(4);
		map.get(8).add(5);
		map.get(8).add(6);
		map.get(8).add(7);
		
		map.put(9, new ArrayList<Integer>());
		map.get(9).add(1);
		map.get(9).add(3);
		map.get(9).add(4);
		map.get(9).add(5);
		map.get(9).add(6);
		map.get(9).add(7);
		
		map.put(0, new ArrayList<Integer>());
		map.get(0).add(1);
		map.get(0).add(2);
		map.get(0).add(3);
		map.get(0).add(4);
		map.get(0).add(5);
		map.get(0).add(7);
		return map;
	}
	
	public static List<Integer> getList(int digito) {
		return SEGMENTOS_DIGITOS.get(digito);
	}

}
