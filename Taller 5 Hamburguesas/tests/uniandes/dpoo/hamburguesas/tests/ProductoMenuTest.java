package uniandes.dpoo.hamburguesas.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Menu;

public class ProductoMenuTest {
	
	private ProductoMenu prod;
	
	@BeforeEach
	public void setUp() {
		
		prod = new ProductoMenu("papas", 10000);
		
	}
	
	@Test
	@DisplayName("Generar Texto Producto")
	public void testGenerarTextoFactura() {
		assertEquals("nombre: " + prod.getNombre() + "\n"+
				     "precio:  " + prod.getPrecio( ) + "\n"
				, prod.generarTextoFactura(), "No se creó el texto necesario para crear la factura"
				);
	}

}
