import java.util.concurrent.atomic.AtomicBoolean;

/**
 * BackoffLock implementa un candado basado en backoff.
 */
public class BackoffLock implements Lock {
    // Variable de estado del candado
    // Variable atomic booleana que indica si el candado esta libre o no
    private AtomicBoolean state = new AtomicBoolean(false);
    // Tiempo minimo de espera
    private static final int MIN_DELAY = 1;
    // Tiempo maximo de espera
    private static final int MAX_DELAY = 100;

    /**
     * Intenta adquirir el candado.
     * 
     * @return true si el candado se adquiere, false en caso contrario.
     */
    public void lock() {
        // Crea un backoff
        Backoff backoff = new Backoff(MIN_DELAY, MAX_DELAY);
        while (true) {
            // Si el candado esta libre, lo adquiere
            while (state.get()) {
            }
            ;

            // si el candado esta ocupado, espera
            if (!state.getAndSet(true)) {
                return;
            } else {
                // Si el candado esta ocupado, espera por un tiempo aleatorio
                try {
                    backoff.backoff();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Libera el candado.
     */
    public void unlock() {
        state.set(false);
    }

    // Metodo para imprimir el tiempo de ejecucion del candado
    public static long BackoffLockTiempo() {
        // Inicializa el candado
        BackoffLock lock = new BackoffLock();
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
        // Espera a que los hilos terminen
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Retorna el tiempo de ejecucion
        return System.nanoTime() - startTime;

    }

    // Metodo main
    public static void main(String[] args) {
        // Nanosegundos a segundos usando double
        double seconds = (double) BackoffLockTiempo() / 1000000000.0;
        // Imprime el tiempo de ejecucion del candado en segundos
        System.out.println("Tiempo de ejecucion del candado BackoffLock: " + seconds + " segundos");

    }

}