package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.pedidos.PedidoPeligroso;

public class TratamientoPedidoPeligroso implements TratamientoPedido {
    public TratamientoPedidoPeligroso(PedidoPeligroso pedidoConPeligro) {
    }

    public boolean tratar() {
        return false;
    }
}
