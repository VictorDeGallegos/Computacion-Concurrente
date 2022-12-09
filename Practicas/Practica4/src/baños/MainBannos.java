package baños;

public class MainBannos {
    public static void main(String[] args) throws InterruptedException {
        Banno banno = new Banno();
        Hombre[] hombres = new Hombre[10];
        Mujer[] mujeres = new Mujer[10];

        for (int i = 0; i < 10; i++) {
            hombres[i] = new Hombre(banno);
            hombres[i].start();
            mujeres[i] = new Mujer(banno);
            mujeres[i].start();
        }

        Thread.sleep(100);

        for (int i = 0; i < 10; i++) {
            hombres[i].interrupt();
            mujeres[i].interrupt();
        }

        for (int i = 0; i < 10; i++) {
            hombres[i].join();
            mujeres[i].join();
        }

        System.out.printf("Hombres: %d, Mujeres: %d\n", banno.getTimesMalesEntered(), banno.getTimesFemalesEntered());
        System.out.printf("Hombres dentro: %d, Mujeres dentro: %d\n", banno.getMales(), banno.getFemales());
    }
}
