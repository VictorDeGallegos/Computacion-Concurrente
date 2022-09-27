package practica2.sopas;




/**
 * Clase para probar la busqueda de palbras en un sopa de letras, de manera concurrente y tambien de 
 * manera secuencial.
 * @author Juan Carlos Bautista Sandoval.
 */
public class SopaDeLetrasC {
    public static void main(String[] args) {
        long inicio = System.nanoTime();
        SopaDeLetrasConcurrente sopaDeLetrasC = new SopaDeLetrasConcurrente("/mnt/d/Concurrente/Practicas/Computacion-Concurrente/Practicas/Practica2/src/practica2/sopas/sopa3", "/mnt/d/Concurrente/Practicas/Computacion-Concurrente/Practicas/Practica2/src/practica2/sopas/palabras3");
        sopaDeLetrasC.muestraSopa();
        sopaDeLetrasC.encuentraPalabras();
        sopaDeLetrasC.muestraLetras();
        long fin = System.nanoTime();
        double tiempo = (double) ((fin - inicio)/1e6);
        System.out.println(tiempo +" milisegundos");
    }
}
