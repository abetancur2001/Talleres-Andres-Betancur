package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	private java.util.List<Tiquete>	tiquetesSinUsar;
	private java.util.List<Tiquete>	tiquetesUsados;
	
	public Cliente() {
		super();
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	public abstract java.lang.String getIdentificador();
	public abstract java.lang.String getTipoCliente();
	
	public void agregarTiquete​(Tiquete tiquete) {
		this.tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int total = 0;
		for (Tiquete t: this.tiquetesSinUsar) {
			total += t.getTarifa(); 
		}
		
		return total;
	}
	
	
	
	public java.util.List<Tiquete> getTiquetesSinUsar() {
		return tiquetesSinUsar;
	}

	public java.util.List<Tiquete> getTiquetesUsados() {
		return tiquetesUsados;
	}

	public void usarTiquetes​(Vuelo vuelo) {
		List<Tiquete> use = new ArrayList<>(this.tiquetesSinUsar);
		for (Tiquete t: use) {
			t.marcarComoUsado();
			this.tiquetesSinUsar.remove(t);
			this.tiquetesUsados.add(t);
			
		}
	}
	
	
}
