package org.mvpigs.commandpattern.pedidos;

public class PedidoNacional implements Pedido {
    private Integer id;
    private int peso;
    private String destino;

    public PedidoNacional(String destino, Integer peso) {
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
        return this.id;
    }
}
