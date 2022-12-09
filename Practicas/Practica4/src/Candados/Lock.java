package Candados;

/**
 * Interfaz que define los metodos que debe tener un candado
 */
public interface Lock {

    /**
     * El hilo actual adquiere el candado. Esto servira para que otro Hilo no lo
     * adquiera hasta que el hilo actual lo libere
     */
    public void lock();

    /**
     * El hilo actual deja el candado. Esto servira para que otro Hilo lo adquiera
     */
    public void unlock();
}