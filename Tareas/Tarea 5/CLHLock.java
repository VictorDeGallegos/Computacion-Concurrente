import java.util.concurrent.atomic.AtomicReference;

class QNode {
    // Variable de estado del candado
    // Variable atomic booleana que indica si el candado esta libre o no
    volatile boolean locked = false;
    // puntero al siguiente nodo
    QNode next = null;
}

/**
 * CLHLock implementa un candado basado en CLH
 *
 */
public class CLHLock implements Lock {
    // Cola de los nodos
    AtomicReference<QNode> tail;
    // Nodo antecesor
    ThreadLocal<QNode> myPred;
    // nodo actual
    ThreadLocal<QNode> myNode;

    /**
     * Constructor de la clase
     */
    public CLHLock() {
        // Inicializa la cola de nodos
        tail = new AtomicReference<QNode>(new QNode());
        myNode = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode();
            }
        };
        // Inicializa el nodo antecesor de forma nula
        myPred = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return null;
            }
        };
    }

    /**
     * bloquea el candado
     * 
     */
    public void lock() {
        // obtiene el nodo actual
        QNode qnode = myNode.get();
        // lo bloquea
        qnode.locked = true;
        // lo encola
        QNode pred = tail.getAndSet(qnode);
        // actualiza el nodo antecesor
        myPred.set(pred);
        // espera a que el nodo antecesor se desbloquee
        while (pred.locked)
            Thread.yield();
    }

    /**
     * desbloquea el candado
     */
    public void unlock() {
        // obtiene el nodo actual
        QNode qnode = myNode.get();
        // lo desbloquea
        qnode.locked = false;
        // actualiza el nodo actual
        // el nodo actual como el predecesor
        myNode.set(myPred.get());
    }

    // Metodo para imprimir el tiempo de ejecucion del candado
    public static long CLHLockTiempo() {
        // Inicializa el candado
        CLHLock lock = new CLHLock();
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

        // Calcula el tiempo de ejecucion
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    // Metodo main
    public static void main(String[] args) {
        // Nanosegundos a segundos usando double
        double seconds = (double) CLHLockTiempo() / 1000000000.0;
        // Imprime el tiempo de ejecucion del candado en segundos
        System.out.println("Tiempo de ejecucion del candado: " + seconds + " segundos");
    }

}
