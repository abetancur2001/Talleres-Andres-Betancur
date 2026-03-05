package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
    // TODO completar
	
	private java.lang.String codigoRuta;
	private Aeropuerto	destino;
	private java.lang.String horaLlegada;
	private java.lang.String horaSalida;
	private Aeropuerto origen;
	
    public Ruta(String codigoRuta, Aeropuerto destino, String horaLlegada, String horaSalida, Aeropuerto origen) {
		super();
		this.codigoRuta = codigoRuta;
		this.destino = destino;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.origen = origen;
	}
    
    

	public java.lang.String getCodigoRuta() {
		return codigoRuta;
	}



	public Aeropuerto getDestino() {
		return destino;
	}



	public java.lang.String getHoraLlegada() {
		return horaLlegada;
	}



	public java.lang.String getHoraSalida() {
		return horaSalida;
	}



	public Aeropuerto getOrigen() {
		return origen;
	}



	/**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }
    
    public static int getDuracion (String horaLlegada, String horaSalida) {
    	int minS = getMinutos(horaSalida);
    	int horS = getHoras(horaSalida);
    	int minL = getMinutos(horaLlegada);
    	int horL = getHoras(horaLlegada);
    	
    	int totalHor = (horL - horS) * 60;
    	int totalMin = minL - minS;
    	int total = totalHor + totalMin;
    	
    	return total;
    	
    	
    }

    
}
