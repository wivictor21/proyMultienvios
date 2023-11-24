package modelo;

import java.util.ArrayList;

/**
 * Clase Envio es una clase abstracta y permite definir las caracteristicas de
 * los posibles envios del sisma Multienvios
 *
 * @author Victor Huertas
 * @version 1.0
 */
public abstract class Envio {

    protected String numeroEnvio;
    protected String descripcion;
    protected ArrayList<Mercancia> listaMercancia;
    protected String origen;
    protected String destino;
    protected Persona destinatario;

    /**
     * Un objeto de tipo Envio utiliza los siguientes parametros
     *
     * @param numeroEnvio : numero de envio
     * @param descripcion : descripcion del envio
     * @param listaMercancia : lista de todas las mercancioas den envio
     * @param origen : origen del envio
     * @param destino : destino del envio
     * @param destinatario : persona a la de se le envio la mercancia
     */
    public Envio(String numeroEnvio, String descripcion, ArrayList<Mercancia> listaMercancia, String origen, String destino, Persona destinatario) {
        this.numeroEnvio = numeroEnvio;
        this.descripcion = descripcion;
        this.listaMercancia = listaMercancia;
        this.origen = origen;
        this.destino = destino;
        this.destinatario = destinatario;
    }

    /**
     * Crea objeto de tipo Envio con datos nulos
     */
    public Envio() {
        this.numeroEnvio = "";
        this.descripcion = "";
        this.listaMercancia = new ArrayList<Mercancia>();
        this.origen = "";
        this.destino = "";
        this.destinatario = new Persona();
    }

    /**
     * Retorna el numero del Envio en una cadena de caracteres
     *
     * @return String
     */
    public String getNumeroEnvio() {
        return numeroEnvio;
    }

    /**
     * Establece o modifica el numero de envio a partir de una cadena de
     * caracteres
     *
     * @param numeroEnvio : numero del envio
     */
    public void setNumeroEnvio(String numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }

    /**
     * Retorna la descripcion del Envio en una cadena de caracteres
     *
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece o modifica la descripcion del objeto del envio a partir de una
     * cadena de caracteres
     *
     * @param descripcion : descripcion del envio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna toda la mercancia del Envio en una Lista de Mercancia
     *
     * @return ArrayList
     */
    public ArrayList<Mercancia> getListaMercancia() {
        return listaMercancia;
    }

    /**
     * Establece o modifica la lista de mercancias del objeto del envio a partir
     * de una cadena de una lista
     *
     * @param listaMercancia : lista de mercancia del envio
     */
    public void setListaMercancia(ArrayList<Mercancia> listaMercancia) {
        this.listaMercancia = listaMercancia;
    }

    /**
     * Retorna el origen del Envio en una cadena de caracteres
     *
     * @return String
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Establece o modifica el origen del objeto del envio a partir de una
     * cadena de caracteres
     *
     * @param origen: origen del envio
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * Retorna el destino del Envio en una cadena de caracteres
     *
     * @return String
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Establece o modifica el destino del objeto del envio a partir de una
     * cadena de caracteres
     *
     * @param destino: destino del envio
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Retorna los datos del destinario del Envio en forma de objeto persona
     *
     * @return Persona
     */
    public Persona getDestinatario() {
        return destinatario;
    }

    /**
     * Establece o modifica los datos del destinantario del objeto del envio a
     * partir de una clase persona
     *
     * @param destinatario: datos del destinatario del envio
     */
    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Retorna el total de todos los pesos de todas las mercancias del Envio en
     * forma de valor de tipo double
     *
     *
     * @return double
     */
    public double totalPesoMercancias() {
        double suma = 0;
        for (int i = 0; i < listaMercancia.size(); i++) {
            suma = suma + listaMercancia.get(i).totalPeso();
        }
        return suma;
    }

    /**
     * Retorna el total de todas las mercancias del Envio a partir de una cadena
     * de caracteres
     *
     *
     * @return String
     */
    public String totalMercancias() {
        String suma = "";
        for (int i = 0; i < listaMercancia.size(); i++) {
            suma = suma + "Mercancia #" + (i + 1) + listaMercancia.toString();
        }
        return suma;
    }

    /**
     * Prototipo de funcion abstracta que retorna el tipo de Envio en una cadena
     * de caracteres
     *
     * @return String
     */
    public abstract String tipo();

    /**
     * Prototipo de funcion abstracta que retorna el porcentage de valor del
     * Envio en un valor de tipo double
     *
     * @return double
     */
    public abstract double valorEnvio();

    /**
     * Retorna en una cadena de caracteres el tipo de envio, numero de envio,
     * descripcion, origen, destino y nombre del destinatario separados por
     * comas
     *
     * @return String
     */
    public String registroEnvio() {
        return tipo() + ";" + numeroEnvio + ";" + origen + ";" + destino + ";" + destinatario.getNombre();
    }

    /**
     * Retorna total de datos de Envio en una cadena de carcteres
     *
     * @return String
     */
    @Override
    public String toString() {
        String datos = "";
        for (int i = 0; i < listaMercancia.size(); i++) {
            datos = datos + listaMercancia.get(i).toString() + "\n";
        }
        return "\n------------------------------------\n"
                +"------------------------------------\n"
                +"\nNumero de Envio: " + numeroEnvio
                + "\nTipo de Envio: " + tipo()
                + "\nDescripcion: " + descripcion
                + "\nOrigen: " + origen
                + "\nDestino: " + destino
                + "\nDestinatario: " + destinatario.getNombre()
                +"\n\n_________________________\n"
                + "\nLista de Mercancia: \n" + datos;
    }
}