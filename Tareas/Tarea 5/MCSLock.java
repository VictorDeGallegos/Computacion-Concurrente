import java.util.concurrent.atomic.AtomicReference;

/**
 * CLHLock implementa un candado basado en CLH
 *
 */
public class MCSLock implements Lock {
    // Cola de los nodos
    AtomicReference<QNode> tail;
    // Nodo actual
    ThreadLocal<QNode> myNode;

    /**
     * Constructor de la clase
     */

    public MCSLock() {
        // Inicializa la cola de nodos a null
        tail = new AtomicReference<QNode>(null);
        // Inicializa el nodo actual
        myNode = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode();
            }
        };
    }

    /**
     * bloquea el candado
     * 
     */
    @Override
    public void lock() {
        // obtiene el nodo actual
        QNode qnode = myNode.get();
        // lo encola
        QNode pred = tail.getAndSet(qnode);
        // si el nodo antecesor no es nulo
        if (pred != null) {
            // Se bloquea el nodo actual
            // indicando que se dispondra del recurso
            qnode.locked = true;
            // el nodo antecesor apunta al nodo actual
            pred.next = qnode;
            // mientras el nodo actual no este desbloqueado
            while (qnode.locked)
                Thread.yield(); // se espera
        }
    }

    /**
     * desbloquea el candado
     */
    @Override
    public void unlock() {
        // obtiene el nodo actual
        QNode qnode = myNode.get();
        // si el nodo actual no tiene sucesor
        // la cola se encuentra vacia
        if (qnode.next == null) {
            if (tail.compareAndSet(qnode, null))
                return;
            // mientras el nodo actual no tenga sucesor
            while (qnode.next == null)
                Thread.yield(); // se espera
        }
        qnode.next.locked = false; // se desbloquea el nodo
        qnode.next = null; // se elimina el nodo
    }

    // Metodo para imprimir el tiempo de ejecucion del candado
    // Metodo para imprimir el tiempo de ejecucion del candado
    public static long MCSLockTiempo() {
        // Inicializa el candado
        MCSLock lock = new MCSLock();
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
        // Nanosegundos a segundos usando double
        double seconds = (double) MCSLockTiempo() / 1000000000.0;
        System.out.println("Tiempo de ejecucion del candado MCSLock: " + seconds + " segundos");

    }

}