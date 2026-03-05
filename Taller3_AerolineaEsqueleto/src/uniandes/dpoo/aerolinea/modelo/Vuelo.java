package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import java.util.Map;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public class Vuelo {
	
	private Avion	avion;
	private java.lang.String	fecha;
	private Ruta	ruta;
	private java.util.Map<java.lang.String, Tiquete> tiquetes;
	private boolean realizado = false;
	public Vuelo(Avion avion, String fecha, Ruta ruta, Map<String, Tiquete> tiquetes) {
		super();
		this.avion = avion;
		this.fecha = fecha;
		this.ruta = ruta;
		this.tiquetes = tiquetes;
		this.realizado = realizado;
	}
	public Avion getAvion() {
		return avion;
	}
	public java.lang.String getFecha() {
		return fecha;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public java.util.Map<java.lang.String, Tiquete> getTiquetes() {
		return tiquetes;
	}
	
	public void marcarComoRealizado() {
	    this.realizado = true;
	}
	
	public boolean isRealizado() {
		return realizado;
	}

}
