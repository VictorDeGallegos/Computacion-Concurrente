import java.util.Random;

public class Backoff {
    // Variables de instancia
    final int minDelay, maxDelay;
    // Limite de espera para el backoff
    int limit;
    // Generador de numeros aleatorios
    final Random random;

    /**
     * Constructor
     * 
     * @param minDelay Tiempo minimo de espera
     * @param maxDelay Tiempo maximo de espera
     */
    public Backoff(int min, int max) {
        minDelay = min;
        maxDelay = max;
        limit = minDelay;
        random = new Random();
    }

    /**
     * Espera un tiempo aleatorio entre minDelay y limit
     * 
     * @return true si el tiempo de espera es menor que maxDelay, false en caso
     *         contrario.
     * @throws InterruptedException si el hilo es interrumpido durante la espera.
     *
     */
    public void backoff() throws InterruptedException {
        int delay = random.nextInt(limit);
        limit = Math.min(maxDelay, 2 * limit);
        Thread.sleep(delay);
    }
}