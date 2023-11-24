package modelo;

/**
 * Clase Persona permite definir las caracteristicas de los posibles clientes
 * del sisma Multienvios
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class Persona {

    private String nombre;
    private String id;
    private String telefono;

    /**
     * Un objeto de tipo Persona utiliza los siguientes parametros
     *
     * @param nombre : nombre de la persona
     * @param id : identificación de la persona
     * @param telefono : teléfono de contacto de la persona
     */
    public Persona(String nombre, String id, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
    }

    /**
     * Crea objeto de tipo Persona con datos nulos
     */
    public Persona() {
        this.nombre = "";
        this.id = "";
        this.telefono = "";
    }

    /**
     * Retorna el nombre de la Persona en una cadena de caracteres
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece o modifica el nombre del objeto de la Persona a partir de una
     * cadena de caracteres
     *
     * @param nombre: nombre de la Persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la identficacion de la Persona en una cadena de caracteres
     *
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Establece o modifica la identidicacion del objeto de la Persona a partir
     * de una cadena de caracteres
     *
     * @param id: Identificacion de la Persona
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retorna el telefono de la Persona en una cadena de caracteres
     *
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece o modifica numero de telefono del objeto de la Persona a partir
     * de una cadena de caracteres
     *
     * @param telefono : telefono de la Persona
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Retorna en una cadena de caracteres el nombre, id y telefono separados
     * por comas
     *
     * @return String
     */
    public String registroPersona() {
        return nombre + ";" + id + ";" + telefono;
    }

    /**
     * Retorna todos los datos de la persona en una cadena de caracteres
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nIdentificacion: " + id
                + "\nTelefono: " + telefono;
    }
}
