import java.util.List; 
 
public class ProcesadorFacturas { 
 
    // SMELL: Nombre de método poco claro y parámetros que podrían ser un objeto 
    public void p(List<Double> l, String n, double imp, boolean vip) { 
        double t = 0; 
         
        // SMELL: Lógica de cálculo mezclada con impresión (Método Largo) 
        for (Double d : l) { 
            t += d; 
        } 
 
        // SMELL: Código duplicado y números "mágicos" (0.10, 0.05) 
        if (vip) { 
            t = t - (t * 0.10); 
            System.out.println("Cliente VIP: " + n); 
            System.out.println("Total con descuento: " + t); 
        } else { 
            t = t + (t * imp); 
            System.out.println("Cliente Normal: " + n); 
            System.out.println("Total con impuestos: " + t); 
        } 
         
        // SMELL: Más código duplicado (la impresión del nombre) 
    } 
} 