package org.mvpigs.commandpattern.procesadores;

import org.mvpigs.commandpattern.pedidos.Pedido;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedido;

/**
 * La interfaz procesador implementa el metodo:
 * 
 * recibe
 * @param  TratamientoPedido 
 * @return   boolean
 *           true si es posible tratar el pedido
 *           false si no es posible tratar el pedido 
 */

public interface Procesador {

    public boolean procesa(TratamientoPedido tratamientoPedido);

    public String printarStatus(boolean procesa, Pedido pedido);
}