package practica2.sopas;

/**
 * Clase para probar la busqueda de palbras en un sopa de letras, de manera concurrente y tambien de 
 * manera secuencial.
 * @author Juan Carlos Bautista Sandoval.
 */
public class SopaDeLetras {
    public static void main(String[] args) {
        long inicio = System.nanoTime();
        SopaDeLetrasSecuencial sopaDeLetras = new SopaDeLetrasSecuencial("turuta/sopa3","turuta/palabra3");
        sopaDeLetras.muestraSopa();
        sopaDeLetras.encuentraPalabras();
        sopaDeLetras.muestraLetras();
        long fin = System.nanoTime();
        double tiempo = (double) ((fin - inicio)/1e6);
        System.out.println(tiempo +" milisegundos");
    }
}
