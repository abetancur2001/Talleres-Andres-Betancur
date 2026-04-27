package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;

public class IngredienteTest
{
    private Ingrediente ingrediente1;

    @BeforeEach
    public void setUp( ) throws Exception
    {
        ingrediente1 = new Ingrediente( "tomate", 1000 );
    }

    @AfterEach
    public void tearDown( ) throws Exception
    {
    	
    }

    @Test
    public void testGetNombre( )
    {
        assertEquals( "tomate", ingrediente1.getNombre( ), "El nombre del ingrediente no es el esperado." );
    }

    @Test
    public void testGetCostoAdicional( )
    {
        assertEquals( 1000, ingrediente1.getCostoAdicional( ), "El costo adicional del ingrediente no es el esperado." );
    }

}
