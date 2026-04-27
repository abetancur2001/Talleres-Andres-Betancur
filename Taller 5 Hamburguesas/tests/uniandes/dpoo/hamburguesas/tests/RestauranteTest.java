package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoFaltanteException;
import uniandes.dpoo.hamburguesas.excepciones.ProductoRepetidoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {

	private Restaurante restaurante;

	@BeforeEach
	public void setUp() {
		restaurante = new Restaurante();
	}

	@Test
	@DisplayName("Iniciar Pedido")
	public void testIniciarPedido() throws YaHayUnPedidoEnCursoException {

		restaurante.iniciarPedido("Andres", "Calle 1");

		assertTrue(restaurante.getPedidoEnCurso() != null, "No se creó correctamente el pedido");

	}

	@Test
	@DisplayName("Cerrar y Guardar Pedido")
	public void testCerrarYGuardarPedido()
			throws NoHayPedidoEnCursoException, IOException, YaHayUnPedidoEnCursoException {

		restaurante.iniciarPedido("Andres", "Calle 1");
		int idPedido = restaurante.getPedidoEnCurso().getIdPedido();
		restaurante.cerrarYGuardarPedido();

		File arch = new File("./facturas/" + "factura_" + idPedido + ".txt");

		assertTrue(arch.exists(), "No se creó el archivo de la factura");
		assertTrue(restaurante.getPedidoEnCurso() == null, "No se cerró correctamente el pedido");

	}

	@Test
	@DisplayName("Cargar Informacion Restaurante")
	public void testCargarInformacionRestaurante() throws NumberFormatException, HamburguesaException, IOException {
		
		File ingredientes = new File("data/ingredientes.txt");
		File menu = new File("data/menu.txt");
		File combos = new File("data/combos.txt");
		
		restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
		
		
		
		assertTrue(restaurante.getIngredientes().size() != 0, "No se agregaron los ingredientes");
		assertTrue(restaurante.getMenuCombos().size() != 0, "No se agregaron los combos");
		assertTrue(restaurante.getMenuBase().size() != 0, "No se agregaron los productos al menú");
		
	}
	
	@Test
	@DisplayName("Ingredientes Repetidos Exception")
	public void testIngredienteRepetidoException() throws NumberFormatException, HamburguesaException, IOException {
		
		assertThrows(IngredienteRepetidoException.class, () -> {
		    File ingredientes = new File("data/ingredientes_repetidos.txt");
		    File menu = new File("data/menu.txt");
		    File combos = new File("data/combos.txt");
		    restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
		});	
	}
	
	@Test
	@DisplayName("No Hay Pedido En Curso Exception")
	public void testNoHayPedidoEnCursoException() throws NoHayPedidoEnCursoException, IOException {
		
		assertThrows(NoHayPedidoEnCursoException.class, () -> {
			restaurante.cerrarYGuardarPedido();
		});	
		
	}
	
	@Test
	@DisplayName("Producto Faltante Exception")
	public void testProductoFaltanteException() {
		
		assertThrows(ProductoFaltanteException.class, () -> {
		    File ingredientes = new File("data/ingredientes.txt");
		    File menu = new File("data/menu_pruebas.txt");
		    File combos = new File("data/combos_pruebas.txt");
		    restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
		});	
		
	}
	
	@Test
	@DisplayName("Producto Repetido Exception")
	public void testProductoRepetidoException() throws NumberFormatException,ProductoRepetidoException, HamburguesaException, IOException {
		
		assertThrows(ProductoRepetidoException.class, () -> {
		    File ingredientes = new File("data/ingredientes.txt");
		    File menu = new File("data/menu_repetidos.txt");
		    File combos = new File("data/combos.txt");
		    restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
		});	
	}
	
	
	@Test
	@DisplayName("Ya Hay Un Pedido En Curso Exception")
	public void testYaHayUnPedidoEnCursoExceptionn() throws YaHayUnPedidoEnCursoException, IOException {
			
		assertThrows(YaHayUnPedidoEnCursoException.class, () -> {
			restaurante.iniciarPedido("Andres", "Calle 1");
			restaurante.iniciarPedido("Felipe", "Calle 2");
		});	
		
	}
	

}
