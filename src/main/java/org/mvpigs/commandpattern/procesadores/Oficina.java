package org.mvpigs.commandpattern.procesadores;

import org.mvpigs.commandpattern.pedidos.Pedido;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedido;

public class Oficina implements Procesador{
    public boolean procesa(TratamientoPedido pedido) {
        return pedido.tratar(); }

    public String printarStatus(boolean procesa, Pedido pedido) {
       String mensaje;
        if (procesa){
            mensaje= pedido.destino()+" "+STATUS.ACEPTADO.name();
        } else {
            mensaje= pedido.destino()+" "+STATUS.RECHAZADO.name();
        }
        return mensaje;
    }
}
