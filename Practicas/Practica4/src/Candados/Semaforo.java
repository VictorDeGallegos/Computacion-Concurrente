package Candados;

public interface Semaforo {

    /**
     * @return el numero de procesos que pueden estar en la seccion critica a la vez
     */
    public int getPertitsOnCriticalSections();

    /**
     * Para que un hilo lo adquiera
     */
    public void acquire();

    /**
     * Para que un hilo lo libere
     */
    public void release();
}