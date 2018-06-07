package org.mvpig.commandpattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mvpigs.commandpattern.pedidos.Pedido;
import org.mvpigs.commandpattern.pedidos.PedidoPeligroso;
import org.mvpigs.commandpattern.pedidos.PedidoInternacional;
import org.mvpigs.commandpattern.pedidos.PedidoNacional;
import org.mvpigs.commandpattern.pedidos.PedidoPeligrosoOrden;
import org.mvpigs.commandpattern.procesadores.Oficina;
import org.mvpigs.commandpattern.procesadores.Procesador;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedido;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoInternacional;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoMultiple;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoPeligroso;

/**
 * NO PUEDES MODIFICAR EL CODIGO DE LOS CASOS TEST 
 */
public class TestPedidos {

    /**
     * Crea una clase TratamientoPedidoInternacional que permita tratar
     * pedidos internacionales.
     * 
     * La clase permite tratar todos los pedidos excepto 
     * los que van a Mordor.
     * 
     * Crea las clases necesarias que se requieren en los casos test
     * respetando los constructores que se exigen.
     */
    @Test
	public void test_Mordor() {

        Pedido pedidoInt = new PedidoInternacional("Mordor", 100);
        assertEquals("Mordor", pedidoInt.destino());

		TratamientoPedido tratamientoKO = new TratamientoPedidoInternacional(
                                                    (PedidoInternacional) pedidoInt);
        assertNotNull(tratamientoKO);
        assertFalse(tratamientoKO.tratar());			
	}

	@Test
	public void test_Comarca() {

        Pedido pedidoInt = new PedidoInternacional("Comarca", 100);
        assertEquals("Comarca", pedidoInt.destino());

		TratamientoPedido tratamientoOK = new TratamientoPedidoInternacional(
                                                    (PedidoInternacional) pedidoInt);
        assertNotNull(tratamientoOK);        
        assertTrue(tratamientoOK.tratar());
    }

    /**
     * Crea una clase TratamientoPedidoPeligroso que permita tratar
     * pedidos peligrosos.
     * 
     * La clase permite tratar todos los pedidos segun sus
     * instrucciones excepto aquellos cuya instruccion sea 
     * "no ponerselo en el dedo". 
     * 
     * Crea las clases necesarias que se requieren en los casos test
     * respetando los constructores que se exigen.
     */
    @Test
    public void test_pedido_peligroso_KO() {

        Pedido pedidoConPeligro = new PedidoPeligrosoOrden("Monte del destino", 
                                                           "no ponerselo en el dedo");
        assertEquals("Monte del destino", pedidoConPeligro.destino());

        TratamientoPedido tratamientoKO = new TratamientoPedidoPeligroso(
                                                    (PedidoPeligroso) pedidoConPeligro);
        assertNotNull(tratamientoKO);
        assertFalse(tratamientoKO.tratar());
    }

    @Test
    public void test_pedido_peligroso_OK() {

        Pedido pedidoConPeligro = new PedidoPeligrosoOrden("Cima de los vientos", 
                                                           "no limpiarse las uñas con este puñal");
        assertEquals("Cima de los vientos", pedidoConPeligro.destino());

        TratamientoPedido tratamientoOK = new TratamientoPedidoPeligroso(
                                                    (PedidoPeligroso) pedidoConPeligro);
        assertTrue(tratamientoOK.tratar());
    }

    /**
     * Añade a las clases PedidoInternacional y PedidoPeligrosoOrden
     * una identificador Id de tipo String
     * autogenerado haciendo uso de la clase UUID de Java
     * https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html
     */
    @Test
    public void test_UUID_generator() {

        PedidoInternacional internacional = new PedidoInternacional("Mordor", 10);
        PedidoPeligrosoOrden peligroso = new PedidoPeligrosoOrden("Cima de los vientos", 
                                                                  "no limpiarse las uñas con este puñal");
        assertNotNull(internacional.getId());
        assertNotNull(peligroso.getId());
       
        assertTrue(internacional.getId() != peligroso.getId());
    }

    /**
     * Añade una clase para los pedidos nacionales.
     */

    @Test
    public void test_pedido_nacional_UUDI() {

        PedidoInternacional internacional = new PedidoInternacional("Mordor", 10);
        assertNotNull(internacional);
        PedidoNacional nacional = new PedidoNacional("Gondor", 50);
        assertNotNull(nacional);
        assertTrue(internacional.getId() != nacional.getId());
    }
    
    /**
     * Construye una oficina que procese todo tipo de pedidos.
     * 
     * La oficina procesa los pedidos en funcion de si
     * es posible tratarlos o no segun las reglas de cada
     * tipo de pedido
     */

    @Test
    public void test_interface_procesador() {
        
        Procesador correos = new Oficina();
        TratamientoPedido pedidoInt = new TratamientoPedidoInternacional(
                                            new PedidoInternacional("Comarca", 100));
        assertTrue(correos.procesa(pedidoInt));

        TratamientoPedido pedidoConPeligro = new TratamientoPedidoPeligroso(
                                                 new PedidoPeligrosoOrden(
                                                        "Cima de los vientos", 
                                                        "no limpiarse las uñas con este puñal"));
        assertTrue(correos.procesa(pedidoConPeligro));
    }

    /**
     * La oficina puede enviar un mensaje que informe del
     * status del pedido, en funcion de si ha sido posible procesarlo.
     * 
     * Hace uso de un tipo enumerado STATUS con las constantes
     * ACEPTADO y RECHAZADO.
     */

    @Test
    public void test_printar_status() {

        Oficina correos = new Oficina();
        PedidoInternacional toComarcaWithLove = new PedidoInternacional("Comarca", 100);
        TratamientoPedido pedidoInt = new TratamientoPedidoInternacional(toComarcaWithLove);

        assertTrue(correos.procesa(pedidoInt));
        assertEquals("Comarca ACEPTADO", correos.printarStatus(
                                            correos.procesa(pedidoInt), toComarcaWithLove));

        PedidoPeligroso pedidoConPeligro = new PedidoPeligrosoOrden("Monte del destino", 
                                                                    "no ponerselo en el dedo");
        TratamientoPedido tratamientoKO = new TratamientoPedidoPeligroso(pedidoConPeligro);

        assertFalse(correos.procesa(tratamientoKO));
        assertEquals("Monte del destino RECHAZADO", correos.printarStatus(
                                                        correos.procesa(tratamientoKO), 
                                                                        pedidoConPeligro));

    }

    /**
     * Crea una clase TratamientoPedidoMultiple que permita tratar
     * pedidos multiples.
     * 
     * La clase permite tratar el pedido multiple si 
     * el peso total de los pedidos es mayor que 0
     * y 
     * el numero de bultos coincide con el numero de
     * pedidos individuales que forman el pedido multiple.
     * 
     * Crea las clases necesarias que se requieren en los casos test
     * respetando los constructores que se exigen.
     */


}