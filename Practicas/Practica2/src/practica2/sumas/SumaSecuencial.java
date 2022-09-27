package practica2.sumas;

import java.util.Scanner;

public class SumaSecuencial {

    // Suma secuencial de los primeros n numeros usando hilos
    public static void main(String[] args) {
        int n = 10; // 10 primeros numeros
        // numero de hilos por Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de hilos: ");
        int hilos = sc.nextInt();
        long inicio_tiempo = System.nanoTime();
        // suma secuencial
        int suma_total = 0;
        int inicio = 0;
        int fin = 0;
        int rango = n / hilos;
        int resto = n % hilos;
        for (int i = 0; i < hilos; i++) {
            inicio = fin;
            fin = inicio + rango;
            if (resto > 0) {
                fin++;
                resto--;
            }
            int suma = 0;
            for (int j = inicio; j < fin; j++) {
                suma += j; // suma de los numeros
            }
            suma_total += suma;

        }
        // Numero de hilos
        System.out.println("Numero de hilos: " + hilos);

        // Imprime suma total
        System.out.println("Suma total: " + suma_total);

        long fin_tiempo = System.nanoTime();
        double tiempo = (double) ((fin_tiempo - inicio_tiempo) / 1e6);
        System.out.println("Tiempo: " + tiempo + " Milisegundos");

    }
}
