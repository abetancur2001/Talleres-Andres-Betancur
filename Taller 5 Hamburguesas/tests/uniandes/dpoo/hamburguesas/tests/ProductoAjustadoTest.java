package uniandes.dpoo.hamburguesas.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import java.util.ArrayList;

public class ProductoAjustadoTest {
	
	private ProductoAjustado ajustado;
	private Ingrediente i1 = new Ingrediente("queso", 5000);
	private Ingrediente i2 = new Ingrediente("paprika", 2000);
	
	@BeforeEach
	public void setUp() {
		ProductoMenu base = new ProductoMenu("papas", 10000); 
		ajustado = new ProductoAjustado(base);
		ajustado.getAgregados().add(i1);
		ajustado.getAgregados().add(i2);
		
	}
	
	@Test
	@DisplayName("Obtener Precio")
	public void testGetPrecio() {
		
		assertEquals(17000, ajustado.getPrecio(), "No se calculó correctamente el precio ajusado");
		
	}
	
	@Test
	@DisplayName("Generar Texto Factura")
	public void testGenerarTextoFactura() {
	
		assertEquals(ajustado.getProductoBase() +
				"nombre:  " + i1.getNombre() + "\n" +
				"precio:                " + i1.getCostoAdicional( )+ "\n" +
				"nombre:  " + i2.getNombre() + "\n" +
				"precio:                " + i2.getCostoAdicional( )+ "\n" , ajustado.generarTextoFactura(), "No se creó correctamente el texto de la factura"
				);
	}


}
