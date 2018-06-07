package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.pedidos.Pedido;

import java.util.Set;

public class TratamientoPedidoMultiple implements TratamientoPedido{
    private final Set<Pedido> pedidos;
    private int numBultos;
    private int pesoTotal;

    public TratamientoPedidoMultiple(Set<Pedido> pedidos) {
        this.pedidos=pedidos;
    }

    public boolean tratar() {
        if (pesoTotal > 0){
            return true;
        }
        return false;
    }

    public void calcularTotalBultos() {
         this.numBultos=this.pedidos.size();

    }

    public int getNumBultos() {
        return this.numBultos;
    }

    public void calcularPesoTotal() {
        for (Pedido pedido : pedidos){
            this.pesoTotal=this.pesoTotal+pedido.peso();
    }
    }

    public double getPesoTotal() {
        return this.pesoTotal;
    }
}
