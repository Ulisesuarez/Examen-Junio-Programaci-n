package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.pedidos.PedidoPeligroso;

public class TratamientoPedidoPeligroso implements TratamientoPedido {
    private final PedidoPeligroso pedidoPeligroso;

    public TratamientoPedidoPeligroso(PedidoPeligroso pedidoConPeligro) {
        this.pedidoPeligroso=pedidoConPeligro;
    }

    public boolean tratar() {
        if(this.pedidoPeligroso.instrucciones().equals("no ponerselo en el dedo")){
            return false;
        } else {
            return true;
        }
    }
}
