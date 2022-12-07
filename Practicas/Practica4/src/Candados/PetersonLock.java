package Candados;

/**
 * Clase que implementa el algoritmo de Peterson visto en clase
 * esto con el fin de generar un CANDADO,
 * con el fin de solucionar el problema de Exclusión Mutua, para 2 hilos.
 */
public class PetersonLock implements Lock {
    volatile boolean[] bandera;
    volatile int victima;

    public PetersonLock() {
        this.bandera = new boolean[2];
        victima = -1;
    }

    @Override
    public void lock() {
        int i = Integer.parseInt(Thread.currentThread().getName()); // 0 o 1
        int j = 1 - i; // El otro hilo
        bandera[i] = true; // Indica que quiere entrar
        victima = i; // El hilo actual es el que tiene la prioridad
        while (bandera[j] && victima == i) {
            // Espera activa
        }
    }

    @Override
    public void unlock() {
        int i = Integer.parseInt(Thread.currentThread().getName()); // 0 o 1
        bandera[i] = false; // Indica que ya no quiere entrar
    }

}