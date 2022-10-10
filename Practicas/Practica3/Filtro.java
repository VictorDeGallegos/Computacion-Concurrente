import interfaces.Semaforo;

public class Filtro implements Semaforo {
    private int n; // numero de procesos
    private int m; // numero de procesos concurrentes
    volatile private int[] level; // nivel de cada proceso
    volatile private int[] turn; // turno de cada proceso

    public Filtro(int n, int m) { // constructor
        this.n = n;
        this.m = m;
        this.level = new int[n];
        this.turn = new int[n - m];

        for (int i = 0; i < n; i++) {
            this.level[i] = -1;
        }
    }

    @Override
    public void acquire() { // entrada
        int i = Integer.parseInt(Thread.currentThread().getName());
        for (int j = 0; j < n - m; j++) {
            this.level[i] = j;
            this.turn[j] = i;
            while ((this.turn[j] == i) && noThreadAboveMe(i, j))
                ;
        }
    }

    private boolean noThreadAboveMe(int i, int j) { // no hay ningun proceso con nivel mayor
        for (int k = 0; k < n; k++) {
            if (k != i && this.level[k] >= j) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void release() { // salida
        int i = Integer.parseInt(Thread.currentThread().getName());
        level[i] = -1;
    }

    @Override
    public int getPertitsOnCriticalSections() { // numero de procesos en la seccion critica
        return m;
    }

}