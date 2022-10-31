import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Taslock implementa un candado o lock basado en test y set.
 */

public class TASLock implements Lock {
    // Variable de estado del candado
    // Variable atomic booleana que indica si el candado esta libre o no
    AtomicBoolean state = new AtomicBoolean(false);

    /**
     * Intenta adquirir el candado.
     * 
     * @return true si el candado se adquiere, false en caso contrario.
     */

    @Override
    public void lock() {
        while (state.getAndSet(true))
            ;

    }

    /**
     * Libera el candado.
     */

    @Override
    public void unlock() {
        state.set(false);

    }

    // Metodo para imprimir el tiempo de ejecucion del candado
    public static long TASLockTiempo() {
        // Inicializa el candado
        TASLock lock = new TASLock();
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
        double seconds = (double) TASLockTiempo() / 1000000000.0;
        // Imprime el tiempo de ejecucion del candado en segundos
        System.out.println("Tiempo de ejecucion del candado TASLock: " + seconds + " segundos");

    }

}
