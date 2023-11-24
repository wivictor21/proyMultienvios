package modelo;

import java.util.ArrayList;

/**
 * Clase Aereo hereda de la clase Envio y permite que se pueda diferencial que
 * tipo de envio es del sisma Multienvios
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class Aereo extends Envio {

    /**
     * Un objeto de tipo Aereo hereda todos los parametros de la clase envio
     *
     * @param numeroEnvio : numero de envio
     * @param descripcion : descripcion del envio
     * @param listaMercancia : lista de todas las mercancioas den envio
     * @param origen : origen del envio
     * @param destino : destino del envio
     * @param destinatario : persona a la de se le envio la mercancia
     */
    public Aereo(String numeroEnvio, String descripcion, ArrayList<Mercancia> listaMercancia, String origen, String destino, Persona destinatario) {
        super(numeroEnvio, descripcion, listaMercancia, origen, destino, destinatario);
    }

    /**
     * Crea objeto de tipo Envio con datos nulos heredados
     */
    public Aereo() {
        super();
    }

    /**
     * Retorna el tipo de Envio Aereo en una cadena de caracteres
     *
     * @return String
     */
    @Override
    public String tipo() {
        return "Aereo";
    }

    /**
     * Retorna el porcentage extra del valor del Envio aereo en un valor de tipo
     * double
     *
     * @return double
     */
    @Override
    public double valorEnvio() {
        return 0.1;
    }
}
