package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
	private Cliente	cliente;
	private java.lang.String	codigo;
	private int	tarifa;
	private boolean	usado;
	private Vuelo	vuelo;
	
	
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		super();
		this.cliente = clienteComprador;
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.usado = usado;
		this.vuelo = vuelo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public java.lang.String getCodigo() {
		return codigo;
	}
	public int getTarifa() {
		return tarifa;
	}
	public boolean esUsado() {
		return usado;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	
	public void marcarComoUsado() {
		if (!esUsado()) {
			usado = true;
		}
	}
	
	
	
	

}
