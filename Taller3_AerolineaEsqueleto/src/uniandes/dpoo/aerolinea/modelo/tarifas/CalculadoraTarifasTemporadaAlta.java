package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	
	protected int	COSTO_POR_KM = 1000;

	public CalculadoraTarifasTemporadaAlta() {
		super();
	}
	
	public int calcularCostoBase​(Vuelo vuelo, Cliente cliente) {
		int distancia = calcularDistanciaVuelo​(vuelo.getRuta());
		return COSTO_POR_KM * distancia;
	}
	
	public double calcularPorcentajeDescuento​(Cliente cliente) {
		return 0;
	}
	
	
	

}
