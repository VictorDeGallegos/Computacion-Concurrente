package practica2.sumas;

public class SumaConcurrente implements Runnable {

    private int inicio;
    private int fin;
    private int[] sumas;
    private int id;

    public SumaConcurrente(int inicio, int fin, int[] sumas, int i) {
        this.inicio = inicio;
        this.fin = fin;
        this.sumas = sumas;
        this.id = i;
    }

    @Override
    public void run() {
        int suma = 0;
        for (int i = inicio; i < fin; i++) {
            suma += i;
        }
        sumas[id] = suma;
    }

    // Suma de los primeros n numeros de manera concurrente
    public static void main(String[] args) {
        int n = 10; // 10 primeros numeros
        int num_hilos = 4; // 4 hilos
        int suma_total = 0;
        int inicio = 0;
        int fin = 0;
        int rango = n / num_hilos;
        int resto = n % num_hilos;
        int[] sumas = new int[num_hilos];
        Thread[] hilos = new Thread[num_hilos];
        for (int i = 0; i < num_hilos; i++) {
            inicio = fin;
            fin = inicio + rango;
            if (resto > 0) {
                fin++;
                resto--;
            }
            hilos[i] = new Thread(new SumaConcurrente(inicio, fin, sumas, i));
            hilos[i].start();

        }
        for (int i = 0; i < num_hilos; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < num_hilos; i++) {
            suma_total += sumas[i];
        }
        System.out.println("Suma total: " + suma_total);
    }
}
