package com.siara.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cajera {

    private String nombre;

    public void procesarCompra(Cliente cliente, long timeStamp){
        System.out.println("La cajera" + this.nombre + "Comienza a procesar la compra del cliente " + cliente.getNombreCliente()
         + "En el tiempo" + (System.currentTimeMillis()-timeStamp)/1000 + "Seg");

        for(int i=0;i<cliente.getCarroCompra().length;i++){
            this.esperarXSegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesando el producto" + (i+1) + "->Tiempo: " + (System.currentTimeMillis()-timeStamp)/1000 + "Seg");
        }
    }

    private void esperarXSegundos(int segundos){
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
