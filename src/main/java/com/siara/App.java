package com.siara;


import com.siara.entity.Cajera;
import com.siara.entity.CajeraRunnable;
import com.siara.entity.CajeraThread;
import com.siara.entity.Cliente;

public class App
{
    public static void main( String[] args )
    {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        Cajera cajera1 = new Cajera("Cajera 1");
        Cajera cajera2 = new Cajera("Cajera 2");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        /*cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);*/

        /*CajeraThread cajera1= new CajeraThread("Cajera1", cliente1, initialTime);
        CajeraThread cajera2= new CajeraThread("Cajera2", cliente2, initialTime);

        cajera1.start();
        cajera2.start();*/

        Runnable proceso1= new CajeraRunnable(cliente1, cajera1, initialTime);
        Runnable proceso2= new CajeraRunnable(cliente2, cajera2, initialTime);

        new Thread(proceso1).start();
        new Thread(proceso2).start();
    }
}
