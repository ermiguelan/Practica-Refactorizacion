import java.util.List; 
 
public class Calculadora { 
 
    private static final double DESCUENTO_VIP = 0.10;
    private static final double DESCUENTO_NORMAL = 0.05;

	// SMELL: Nombre de método poco claro y parámetros que podrían ser un objeto 
    public void procesarFacturas(List<Double> precios, String nombreClientes, double impuestos, boolean esVip) { 
        double total = 0; 
         
        // SMELL: Lógica de cálculo mezclada con impresión (Método Largo) 
        total = calcularSumaBase(precios, total); 
 
        // SMELL: Código duplicado y números "mágicos" (0.10, 0.05) 
        calcularSumaTotal(nombreClientes, impuestos, esVip, total); 
         
        // SMELL: Más código duplicado (la impresión del nombre) 
    }

	private void calcularSumaTotal(String nombreClientes, double impuestos, boolean esVip, double total) {
		if (esVip) { 
            calcularTotalVip(nombreClientes, total); 
        } else { 
            calcularTotalNoVip(nombreClientes, impuestos, total); 
        }
	}

	private void calcularTotalNoVip(String nombreClientes, double impuestos, double total) {
		total = total + (total * impuestos); 
		System.out.println("Cliente Normal: " + nombreClientes); 
		System.out.println("Total con impuestos: " + total);
	}

	private void calcularTotalVip(String nombreClientes, double total) {
		total = total - (total * DESCUENTO_VIP); 
		System.out.println("Cliente VIP: " + nombreClientes); 
		System.out.println("Total con descuento: " + total);
	}

	private double calcularSumaBase(List<Double> precios, double total) {
		for (Double d : precios) { 
            total += d; 
        }
		return total;
	} 
} 