import java.util.concurrent.atomic.AtomicBoolean;

/**
 * TTASLock implementa un candado TTAS
 */

public class TTASLock implements Lock {
    // Variable de estado del candado
    // Variable atomic booleana que indica si el candado esta libre o no
    private AtomicBoolean state = new AtomicBoolean(false);

    /**
     * Intenta adquirir el candado.
     * 
     * @return true si el candado se adquiere, false en caso contrario.
     */
    @Override
    public void lock() {
        while (true) {
            while (state.get()) // Si el candado esta ocupado, espera
                ;
            if (!state.getAndSet(true)) { // Si el candado esta libre, lo adquiere
                return;
            }
        }
    }

    /**
     * Libera el candado.
     */
    @Override
    public void unlock() {
        state.set(false);
    }

    // Metodo para imprimir el tiempo de ejecucion del candado
    public static long TTASLockTiempo() {
        // Inicializa el candado
        TTASLock lock = new TTASLock();
        // Inicializa el contador de tiempo
        long startTime = System.nanoTime();
        // Inicializa el numero de hilos
        int numThreads = 3;
        // Inicializa el numero de iteraciones
        int numIterations = 1000;
        // Inicializa el arreglo de hilos
        Thread[] threads = new Thread[numThreads];

        // Crea los hilos
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    // Realiza el numero de iteraciones
                    for (int i = 0; i < numIterations; i++) {
                        // Adquiere el candado
                        lock.lock();
                        // Libera el candado
                        lock.unlock();
                    }
                }
            });
        }

        // Inicia los hilos
        for (int i = 0; i < numThreads; i++) {
            threads[i].start();
        }

        // Espera a que terminen los hilos
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Regresa el tiempo de ejecucion
        return System.nanoTime() - startTime;
    }

    // Metodo main
    public static void main(String[] args) {
        System.out.println("Tiempo de ejecucion del candado TTASLock: " + TTASLock.TTASLockTiempo() + " nanosegundos");

        // Nanosegundos a segundos usando double
        double seconds = (double) TTASLockTiempo() / 1000000000.0;
        System.out.println("Tiempo de ejecucion del candado TTASLock: " + seconds + " segundos");

    }
}