package org.mvpigs.commandpattern.procesadores;

import org.mvpigs.commandpattern.pedidos.Pedido;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedido;

public class Oficina implements Procesador{
    public boolean procesa(TratamientoPedido pedido) {
        return false;
    }

    public String printarStatus(boolean procesa, Pedido pedido) {
       String mensaje;
        if (procesa){
            mensaje= pedido.destino()+" ACEPTADO";
        } else {
            mensaje= pedido.destino()+" RECHAZADO";
        }
        return mensaje;
    }
}
