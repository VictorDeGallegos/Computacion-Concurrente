package baños;

public class Mujer extends Participante {

    public Mujer(Banno banno) {
        super(banno);
    }

    @Override
    public void entraBanno() throws InterruptedException {
        this.banno.entraMujer();

    }

    @Override
    public void salBanno() throws InterruptedException {
        this.banno.salMujer();
    }

    public void start() {// Eliminar si no funciona
        new Thread(this).start();
    }

    public void interrupt() { // Eliminar si no funciona
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