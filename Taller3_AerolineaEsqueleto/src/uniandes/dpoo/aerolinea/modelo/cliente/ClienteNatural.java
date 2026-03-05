package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class ClienteNatural extends Cliente{
	
	public static java.lang.String	NATURAL = "NATURAL";
	private java.lang.String	nombre;
	
	
	
	public ClienteNatural(String nombre) {
		super();
		this.nombre = nombre;
	}



	public java.lang.String getIdentificador() {
		return nombre;
	
	}
		
	public java.lang.String getTipoCliente(){
		return NATURAL;
	}
	
	
	
	
	

}
