package com.siara.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CajeraThread extends Thread{

    private String nombre;
    private Cliente cliente;
    private long inicialTime;

    @Override
    public void run(){
        System.out.println("La cajera " + this.nombre + "Comienza a procesar la compra del cliente: " +
                this.cliente.getNombreCliente() + "En el tiempo: " + (System.currentTimeMillis()-this.inicialTime)/1000 + "Seg");

        for(int i=0; i<this.cliente.getCarroCompra().length;i++){
            this.esperarXSegundo(cliente.getCarroCompra()[i]);
            System.out.println("Procesando producto " + (i+1) + "del cliente " + this.cliente.getNombreCliente() +
                    "-> Tiempo " + (System.currentTimeMillis()-this.inicialTime)/1000 + "Seg") ;
        }

        System.out.println("La Cajera" + this.nombre + "Ha terminado de procesar " + this.cliente.getNombreCliente() +
                "En el tiempo: " + (System.currentTimeMillis()-this.inicialTime)/1000 + "Seg");

    }

    public void esperarXSegundo(long segundos){
        try{
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
