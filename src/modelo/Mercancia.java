package modelo;

/**
 * Clase Mercancia permite definir las caracteristicas de la mercancia del sisma
 * Multienvios
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class Mercancia {

    private String serial;
    private String descripcion;
    private int cantidad;
    private double peso;

    /**
     * Un objeto de tipo Factura utiliza los siguientes parametros
     *
     * @param serial : serial de la mercancia
     * @param descripcion : descripcion de la mercancia
     * @param cantidad : cantidad de la mercancia
     * @param peso : peso de la mercancia
     */
    public Mercancia(String serial, String descripcion, int cantidad, double peso) {
        this.serial = serial;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.peso = peso;
    }

    /**
     * Crea objeto de tipo Factura con datos nulos
     */
    public Mercancia() {
        this.serial = "";
        this.descripcion = "";
        this.cantidad = 0;
        this.peso = 0;
    }

    /**
     * Retorna el serial de la mercancia en una cadena de caracteres
     *
     * @return String
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Establece o modifica el serial de la mercancia a partir de una cadena de
     * caracteres
     *
     * @param serial: serial de la mercancia
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * Retorna la descripcion de la mercancia en una cadena de caracteres
     *
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece o modifica la descripcion de la mercancia a partir de una
     * cadena de caracteres
     *
     * @param descripcion : descripcion de la mercancia
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna la cantidad de la mercancia en un dato de tipo entero
     *
     * @return String
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece o modifica la cantidad de la mercancia a partir de un dato de
     * tipo entero
     *
     * @param cantidad : cantidad de la mercancia
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Retorna el peso de la mercancia en un dato entero
     *
     * @return double
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece o modifica peso de la mercancia a partir de un dato de tipo
     * double
     *
     * @param peso: peso de la mercancia
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Retorna el total de peso de la mercancia en un dato de tipo double
     * multiplicando cantidad por peso de la Mercancia
     *
     * @return double
     */
    public double totalPeso() {
        return cantidad * peso;
    }

    /**
     * Retorna en una cadena de caracteres el serial, la descripcion, cantidad y
     * el peso separados por comas
     *
     * @return String
     */
    public String registroMercancia() {
        return serial + ";" + descripcion + ";" + cantidad + ";" + peso;
    }

    /**
     * Retorna todos los datos de la mercancia en una cadena de caracteres
     *
     * @return String
     */
    @Override
    public String toString() {
        return "_________________________"
                +"\nSerial de la mercancia: " + serial
                + "\nDescripcion de la mercancia: " + descripcion
                + "\nCantidad de la mercancia: " + cantidad
                + "\nPeso de la mercancia: " + peso+"\n";
    }
}
