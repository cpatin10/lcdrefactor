package main;

public class Comando {

	private int size;
	private String digitos;
	
	public Comando(int size, String digitos) {
		this.size = size;
		this.digitos = digitos;
	}
	
	/**
	 * Getter para size
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Getter para digitos
	 * 
	 * @return
	 */
	public String getDigitos() {
		return digitos;
	}
}
