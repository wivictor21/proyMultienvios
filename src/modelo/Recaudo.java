package modelo;

import java.util.ArrayList;

/**
 * Clase Recaudo permite definir enlistar las posibles facturas de envios del
 * sisma Multienvios
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class Recaudo {

    private ArrayList<Factura> listaFactura;

    /**
     * Un objeto de tipo Recaudo utiliza los siguientes parametros
     *
     * @param listaFactura : lista de facturas de envios
     */
    public Recaudo(ArrayList<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    /**
     * Crea una lista de tipo Factura con datos nulos
     */
    public Recaudo() {
        this.listaFactura = new ArrayList<>();
    }

    /**
     * Retorna lista de Facturas en una cadena de una listas
     *
     * @return ArrayList
     */
    public ArrayList<Factura> getListaFactura() {
        return listaFactura;
    }

    /**
     * Establece o modifica lista de facturas del objeto del Factura a partir de
     * una lista de facturas
     *
     * @param listaFactura : lista de facturas
     */
    public void setListaFactura(ArrayList<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    /**
     * Retorna total de recaudo de todas Facturas en un un dato double
     *
     * @return double
     */
    public double totalRecaudo() {
        double suma = 0;
        for (int i = 0; i < listaFactura.size(); i++) {
            suma = suma + listaFactura.get(i).total();
        }
        return suma;
    }

    /**
     * Retorna total de listas de Facturas en una cadena de caracteres
     *
     * @return String
     */
    @Override
    public String toString() {
        String datos = "";
        for (int i = 0; i < listaFactura.size(); i++) {
            datos = datos + listaFactura.get(i).toString() + "\n";
        }
        return datos;
    }
}