package modelo;

import Modelo.Fecha;
import java.util.ArrayList;

/**
 * Clase Factura permite definir las caracteristicas de los posibles facturas de
 * envios del sisma Multienvios
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class Factura {

    private String numeroFactura;
    private Fecha fecha;
    private ArrayList<Envio> listaEnvio;
    private Persona persona;

    /**
     * Un objeto de tipo Factura utiliza los siguientes parametros
     *
     * @param numeroFactura : numero de factura
     * @param fecha : fecha del envio
     * @param listaEnvio : tipo de envio
     * @param persona : datos de la persona
     */
    public Factura(String numeroFactura, Fecha fecha, ArrayList<Envio> listaEnvio, Persona persona) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.listaEnvio = listaEnvio;
        this.persona = persona;
    }

    /**
     * Crea objeto de tipo Factura con datos nulos y ademas se genera un numero
     * de factura aleatoriamente
     */
    public Factura() {
        this.numeroFactura = "ME01-" + (int) (Math.random() + 111) * 999;;
        this.fecha = new Fecha();
        this.listaEnvio = new ArrayList<Envio>();
        this.persona = new Persona();
    }

    /**
     * Retorna el numero del Factura en una cadena de caracteres
     *
     * @return String
     */
    public String getNumeroFactura() {
        return numeroFactura;
    }

    /**
     * Establece o modifica el numero del objeto del Factura a partir de una
     * cadena de caracteres
     *
     * @param numeroFactura : numero del Factura
     */
    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    /**
     * Retorna la fecha de facturacion en un objeto de tipo Fecha
     *
     * @return Fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * Establece o modifica la fecha de la Factura a partir de una de un objeto
     * Fecha
     *
     * @param fecha: Fecha de facturacion
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     * Retorna lista de envios de factura en un objeto de lista de tipo envio
     *
     * @return ArrayList
     */
    public ArrayList<Envio> getListaEnvio() {
        return listaEnvio;
    }

    /**
     * Establece o modifica lista de envios de la Factura a partir de una de un
     * objeto de lista de envios
     *
     * @param listaEnvio : Lista de envios en factura
     */
    public void setListaEnvio(ArrayList<Envio> listaEnvio) {
        this.listaEnvio = listaEnvio;
    }

    /**
     * Retorna informacion personal de facturacion en un objeto de tipo persona
     *
     * @return Persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece o modifica los datos de persona del objeto del Factura a partir
     * de un objeto Persona
     *
     * @param persona: datos de la persona facturada
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Retorna subtotal de precio del envio de facturacion en un dato de tipo
     * double
     *
     * @return double
     */
    public double subTotal() {
        double sumaA = 0, sumaB = 0, sumaC = 0;
        for (int i = 0; i < listaEnvio.size(); i++) {
            sumaA = sumaA + (listaEnvio.get(i).totalPesoMercancias() * 6000);
            sumaB = sumaB + (sumaA * listaEnvio.get(i).valorEnvio());
            sumaC = sumaC + sumaA + sumaB;
        }
        return sumaC;
    }

    /**
     * Retorna el iva del envio de facturacion en un dato de tipo double
     *
     * @return double
     */
    public double iva() {
        return subTotal() * 0.1;
    }

    /**
     * Retorna total de precio del envio de facturacion en un dato de tipo
     * double
     *
     * @return double
     */
    public double total() {
        return subTotal() + iva();
    }

    public String registroFactura() {
        return numeroFactura + ";" + fecha;
    }

    /**
     * Retorna total de datos de facturacion en una cadena de carcteres
     *
     * @return String
     */
    @Override
    public String toString() {
        String datos = "";
        for (int i = 0; i < listaEnvio.size(); i++) {
            datos = datos + listaEnvio.get(i).toString() + "\n";
        }
        
        return "\nNumero de Factura: " + numeroFactura
                + "\nFecha: " + fecha.toString()
                + "\n\n" + persona.toString()
                + "\n\nLista de Envios:" + datos;
    }
}
