package org.mvpigs.commandpattern.pedidos;
import java.util.UUID;

public class PedidoInternacional implements Pedido{
    private String id;
    private String destino;
    private int peso;

    public PedidoInternacional(String destino, int peso) {
        this.destino=destino;
        this.peso=peso;
        this.id=UUID.randomUUID().toString();
    }

    public int peso() {
        return this.peso;
    }

    public String destino() {
        return this.destino;
    }

    public String getId() {
        return id;
    }
}
