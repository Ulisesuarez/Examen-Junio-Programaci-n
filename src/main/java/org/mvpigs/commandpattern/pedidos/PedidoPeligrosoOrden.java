package org.mvpigs.commandpattern.pedidos;

import java.util.UUID;

public class PedidoPeligrosoOrden implements PedidoPeligroso {
    private final String instruccion;
    private String id;
    private String destino;
    private int peso;


    public PedidoPeligrosoOrden(String destino, String instruccion) {
        this.destino=destino;
        this.instruccion=instruccion;
        this.id= UUID.randomUUID().toString();
    }

    public String instrucciones() {
        return this.instruccion;
    }

    public int peso() {
        return this.peso;
    }

    public void setPeso(int peso){
        this.peso=peso;
    }

    public String destino() {
        return this.destino;
    }

    public String  getId() {
        return this.id;
    }
}
