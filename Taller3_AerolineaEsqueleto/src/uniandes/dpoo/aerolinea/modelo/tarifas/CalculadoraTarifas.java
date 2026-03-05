package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;


public abstract class CalculadoraTarifas {

	static double	IMPUESTO = 0.28;

	public CalculadoraTarifas() {
		super();
	}
	
	protected abstract int calcularCostoBase​(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento​(Cliente cliente);
	
	protected int calcularDistanciaVuelo​(Ruta ruta) {
		Aeropuerto or = ruta.getOrigen();
		Aeropuerto des = ruta.getDestino();
		
		return Aeropuerto.calcularDistancia(or, des);
		
	}
	
	public int calcularTarifa​(Vuelo vuelo, Cliente cliente) {
		int descuento = (int)(calcularCostoBase​(vuelo, cliente) * calcularPorcentajeDescuento​(cliente));
		int costDes = (int)(calcularCostoBase​(vuelo, cliente) - descuento);
		return costDes + calcularValorImpuestos​(costDes);
	}
	
	protected int calcularValorImpuestos​(int costoBase) {
		return (int)(costoBase * IMPUESTO);
	}
	
	
}
