import java.util.List; 
 
public class Calculadora { 
 
    // SMELL: Nombre de método poco claro y parámetros que podrían ser un objeto 
    public void procesarFacturas(List<Double> precios, String nombreClientes, double impuestos, boolean esVip) { 
        double total = 0; 
         
        // SMELL: Lógica de cálculo mezclada con impresión (Método Largo) 
        for (Double d : precios) { 
            total += d; 
        } 
 
        // SMELL: Código duplicado y números "mágicos" (0.10, 0.05) 
        if (esVip) { 
            total = total - (total * 0.10); 
            System.out.println("Cliente VIP: " + nombreClientes); 
            System.out.println("Total con descuento: " + total); 
        } else { 
            total = total + (total * impuestos); 
            System.out.println("Cliente Normal: " + nombreClientes); 
            System.out.println("Total con impuestos: " + total); 
        } 
         
        // SMELL: Más código duplicado (la impresión del nombre) 
    } 
} 