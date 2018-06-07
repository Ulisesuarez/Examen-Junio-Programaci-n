package org.mvpigs.commandpattern.pedidos;

import java.util.UUID;

public class PedidoNacional implements Pedido {
    private String id;
    private int peso;
    private String destino;

    public PedidoNacional(String destino, Integer peso) {
        this.destino=destino;
        this.peso=peso;
        this.id= UUID.randomUUID().toString();
    }

    public int peso() {
        return this.peso;
    }

    public String destino() {
        return this.destino;
    }

    public String getId() {
        return this.id;
    }
}
