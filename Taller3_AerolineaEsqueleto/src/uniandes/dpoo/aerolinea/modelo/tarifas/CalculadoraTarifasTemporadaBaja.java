package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	
	protected int	COSTO_POR_KM_CORPORATIVO = 900;
	protected int	COSTO_POR_KM_NATURAL = 600;
	protected double	DESCUENTO_GRANDES = 0.2;
	protected double	DESCUENTO_MEDIANAS = 0.1;
	protected double	DESCUENTO_PEQ = 0.02;
	public CalculadoraTarifasTemporadaBaja() {
		super();
	}
	
	public int calcularCostoBase​(Vuelo vuelo, Cliente cliente) {
		int distancia = calcularDistanciaVuelo​(vuelo.getRuta());
		double des = 0;
		
		if (cliente.getTipoCliente().equals("CORPORATIVO")) {
			int costoCorp = 900 * distancia;
			ClienteCorporativo clienteCorp = (ClienteCorporativo) cliente;
			clienteCorp.getTamanoEmpresa();
			if (clienteCorp.getTamanoEmpresa() == 1 ) {
				des = costoCorp - (DESCUENTO_GRANDES * costoCorp);
			}
				
			else if (clienteCorp.getTamanoEmpresa() == 2 ) {
				des = costoCorp - (DESCUENTO_MEDIANAS * costoCorp);
				
			}
			
			else if (clienteCorp.getTamanoEmpresa() == 3 ) {
				des = costoCorp - (DESCUENTO_PEQ * costoCorp);
				
			}
			
		}
		
		else {
			des = COSTO_POR_KM_NATURAL * distancia;
		}
		
		return (int)(des);
	}
	
	public double calcularPorcentajeDescuento​(Cliente cliente) {
		ClienteCorporativo clienteCorp = (ClienteCorporativo) cliente;
		double des = 0;
		if (cliente.getTipoCliente().equals("CORPORATIVO")){
			if (clienteCorp.getTamanoEmpresa() == 1) {
				des = DESCUENTO_GRANDES;
			}
			else if(clienteCorp.getTamanoEmpresa() == 2) {
				des = DESCUENTO_MEDIANAS;
			}
			else if(clienteCorp.getTamanoEmpresa() == 3) {
				des = DESCUENTO_PEQ;
			}
			
		}
		return des;
	}

}
