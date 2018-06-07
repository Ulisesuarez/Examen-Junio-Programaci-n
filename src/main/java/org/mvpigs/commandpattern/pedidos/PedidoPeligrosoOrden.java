package org.mvpigs.commandpattern.pedidos;

import java.util.UUID;

public class PedidoPeligrosoOrden implements PedidoPeligroso {
    private final String instruccion;
    private String id;
    private String destino;
    private int peso;


    public PedidoPeligrosoOrden(String destino, String precaucion) {
        this.destino=destino;
        this.instruccion=precaucion;
        this.id= UUID.randomUUID().toString();
    }

    public String instrucciones() {
        return this.instruccion;
    }

    public int peso() {
        return this.peso;
    }

    public String destino() {
        return this.destino;
    }

    public String  getId() {
        return this.id;
    }
}
