package practica2.sopas;

/**
 * Clase para probar la busqueda de palbras en un sopa de letras, de manera concurrente y tambien de 
 * manera secuencial.
 * @author Juan Carlos Bautista Sandoval.
 */
public class SopaDeLetras {
    public static void main(String[] args) {
        SopaDeLetrasSecuencial sopaDeLetras = new SopaDeLetrasSecuencial("Practicas/Practica2/src/practica2/sopas/sopa1","Practicas/Practica2/src/practica2/sopas//palabras1");        
        sopaDeLetras.muestraSopa();
        sopaDeLetras.encuentraPalabras();
        sopaDeLetras.muestraLetras();
    }
}
