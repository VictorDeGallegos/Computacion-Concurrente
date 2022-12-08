package baños;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banno {
    private volatile long timesMalesEntered;
    private volatile long timesFemalesEntered;

    private volatile long males;
    private volatile long females;

    private boolean used;

    private Lock lock = new ReentrantLock();

    private Condition hombres = lock.newCondition();
    private Condition mujeres = lock.newCondition();

    public Banno() {
        this.timesMalesEntered = 0;
        this.timesFemalesEntered = 0;
        males = females = 0;
        used = false;
    }

    public long getTimesMalesEntered() {
        return timesMalesEntered;
    }

    public long getTimesFemalesEntered() {
        return timesFemalesEntered;
    }

    public long getMales() {
        return males;
    }

    public long getFemales() {
        return females;
    }

    public void entraHombre() throws InterruptedException {
        lock.lock(); // obtenemos el candado
        try {
            while (!used) { // mientras no este ocupado
                hombres.await();
            }
            used = true; // lo ocupamos
            timesMalesEntered++; // incrementamos el número de hombres que han entrado
            males++; // incrementamos el número de hombres que están dentro
        } finally {
            lock.unlock(); // liberamos el candado
        }
    }

    public void salHombre() {
        // Pone candado
        lock.lock();
        try {
            males--; // Decrementa el número de hombres dentro
            if (males == 0) { // Si no hay más hombres
                mujeres.signalAll(); // Despierta a todas las mujeres
                used = false; // Libera el baño
            } else {
                mujeres.signal(); // Despierta a una mujer
            }
        } catch (Exception e) {

        } finally {
            // Desbloquea el candado
            lock.unlock();
        }
    }

    public void entraMujer() throws InterruptedException {
        lock.lock();
        try {
            while (!used) {
                mujeres.await();
            }
            used = true;
            timesFemalesEntered++; // incrementamos el número de mujeres que han entrado
            females++; // incrementamos el número de mujeres que están dentro
        } finally {
            lock.unlock();
        }
    }

    public void salMujer() {

    }
}