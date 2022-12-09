package Filosofos;

import Candados.Semaforo;

/**
 * Clase que simula el problema de los filosofos resolviendolo con el Algoritmo
 * del Filtro
 */
public class FilosofosFiltro extends Filosofos {
    private Semaforo filtro;

    public FilosofosFiltro(Semaforo filtro) {
        super(Integer.valueOf(Thread.currentThread().getName()));
        this.filtro = filtro;
    }

    @Override
    public void entrarALaMesa() throws InterruptedException {
        try {
            filtro.acquire();
            tomaTenedores();
            eat();
            soltarTenedores();
            filtro.release();
        } catch (InterruptedException e) {
        }

    }

    @Override
    public void tomaTenedores() {
        this.tenedorL.tomar();
        this.tenedorD.tomar();

    }

    @Override
    public void soltarTenedores() {
        this.tenedorL.soltar();
        this.tenedorD.soltar();

    }

}