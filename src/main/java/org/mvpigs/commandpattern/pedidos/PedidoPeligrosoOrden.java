package org.mvpigs.commandpattern.pedidos;

public class PedidoPeligrosoOrden implements PedidoPeligroso {
    private final Object precaucion;
    private Integer id;
    private String destino;
    private int peso;


    public PedidoPeligrosoOrden(String destino, String precaucion) {
        this.destino=destino;
        this.precaucion=precaucion;
    }

    public Object getPrecaucion() {
        return precaucion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }


    public void setPeso(int peso) {
        this.peso = peso;
    }





    public String instrucciones() {
        return null;
    }

    public int peso() {
        return this.peso;
    }

    public String destino() {
        return this.destino;
    }

    public Integer getId() {
        return this.id;
    }
}
