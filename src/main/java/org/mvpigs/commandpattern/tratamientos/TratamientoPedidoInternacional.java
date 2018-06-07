package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.pedidos.PedidoInternacional;

public class TratamientoPedidoInternacional implements TratamientoPedido{
    private final PedidoInternacional pedido;

    public TratamientoPedidoInternacional(PedidoInternacional pedidoInt) {
        this.pedido=pedidoInt;
    }

    public boolean tratar() {
        if (this.pedido.destino().equals("Mordor") ){
        return false;
    } else {
        return true;
        }
    }
}
