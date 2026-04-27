package uniandes.dpoo.hamburguesas.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PedidoTest {
	
	private Pedido pedido;
	
	@BeforeEach
	public void setUp() {
		pedido = new Pedido("Andres", "Calle 1");
	}
	
	@Test
	@DisplayName("Agregar Producto")
	public void testAgregarProducto() {
		int tamanioProd = pedido.getProductos().size();
		ProductoMenu prod1 = new ProductoMenu ("papas", 10000);
		pedido.getProductos().add(prod1);
		assertEquals(tamanioProd + 1, pedido.getProductos().size(), "No se añadio el producto al pedido");
		
	}
	
	@Test
	@DisplayName("Get Precio Total")
	public void testGetPrecioNetoPedido() {
		ProductoMenu prod1 = new ProductoMenu ("papas", 10000);
		ProductoMenu prod2 = new ProductoMenu ("hamburguesa", 20000);
		pedido.getProductos().add(prod1);
		pedido.getProductos().add(prod2);
		
		assertEquals(35700, pedido.getPrecioTotalPedido(), "No se calculó correctamente el total del pedido");
	}
	
	@Test
	@DisplayName("Generar Texto Factura")
	public void testGenerarTextoFactura() {
		ProductoMenu prod1 = new ProductoMenu ("papas", 10000);
		ProductoMenu prod2 = new ProductoMenu ("hamburguesa", 20000);
		pedido.getProductos().add(prod1);
		pedido.getProductos().add(prod2);
		assertEquals("Cliente: " + pedido.getNombreCliente() + "\n"+
				    "Dirección: " + pedido.getDireccionCliente() + "\n"+
				    "----------------\n" +
				    "nombre: " + prod1.getNombre() + "\n" +
				    "precio:  " + prod1.getPrecio( ) + "\n" +
				    "nombre: " + prod2.getNombre() + "\n" +
				    "precio:  " + prod2.getPrecio( ) + "\n" +
				    "----------------\n" +
				    "Precio Neto:  " + 30000 + "\n"+
				    "IVA:          " + 5700 + "\n"+
				    "Precio Total: " + pedido.getPrecioTotalPedido() + "\n", pedido.generarTextoFactura(), "No se creo correctamente el texto para generar la factura"
				);
	}
	
	@Test
	@DisplayName("Generar Archivo de Factura")
	public void testGuardarArchivo() throws IOException {
		
		ProductoMenu prod1 = new ProductoMenu ("papas", 10000);
		ProductoMenu prod2 = new ProductoMenu ("hamburguesa", 20000);
		pedido.getProductos().add(prod1);
		pedido.getProductos().add(prod2);
		
		File archivo = File.createTempFile("factura", ".txt");
		pedido.guardarFactura(archivo);

		Scanner sc = new Scanner(archivo);
		String contenido = "";
		while(sc.hasNextLine()) {
		    contenido += sc.nextLine() + "\n";
		}
		sc.close();

		assertEquals(pedido.generarTextoFactura(), contenido);
	}
	

}
