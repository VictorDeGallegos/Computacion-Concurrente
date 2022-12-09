package baños;

public class Hombre extends Participante {

    public Hombre(Banno banno) {
        super(banno);
    }

    @Override
    public void entraBanno() throws InterruptedException {
        this.banno.entraHombre();
    }

    @Override
    public void salBanno() throws InterruptedException {
        this.banno.salHombre();
    }

    public void start() { // Eliminar si no funciona
        new Thread(this).start();
    }

    public void interrupt() {// Eliminar si no funciona
        new Thread(this).interrupt();
    }

    public void join() { // Eliminar si no funciona
        try {
            new Thread(this).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}