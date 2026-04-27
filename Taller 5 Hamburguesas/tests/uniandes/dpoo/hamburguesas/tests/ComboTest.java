package uniandes.dpoo.hamburguesas.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class ComboTest {
	
	private Combo combo;
	
	@BeforeEach
	public void setUp() {
		ProductoMenu prod1 = new ProductoMenu ("papas", 10000);
		ProductoMenu prod2 = new ProductoMenu ("hamburguesa", 20000);
		ArrayList<ProductoMenu> items = new ArrayList<>(); 
		items.add(prod1);
		items.add(prod2);
		combo = new Combo("Especial", 0.2, items);
	}
	
	@Test
	@DisplayName("Calcular Precio")
	public void testGetPrecio() {
		assertEquals(24000, combo.getPrecio(), "No es el precio correct del combo");
	}
	
	@Test
	@DisplayName("Generar Texto Factura")
	public void testGenerarTextoFactura() {
		assertEquals("Combo: " + combo.getNombre() + "\n" + 
					" Descuento: " + combo.getDescuento() + "\n" +
					" Precio: " + combo.getPrecio() + "\n", combo.generarTextoFactura(), "El texto generado no es el correct");
	}
}
