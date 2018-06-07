package org.mvpigs.commandpattern.pedidos;

public class PedidoInternacional implements Pedido{
    private Integer id;
    private String destino;
    private int peso;

    public PedidoInternacional(String destino, int peso) {
        this.destino=destino;
        this.peso=peso;
    }

    public int peso() {
        return this.peso;
    }

    public String destino() {
        return this.destino;
    }

    public Integer getId() {
        return id;
    }
}
