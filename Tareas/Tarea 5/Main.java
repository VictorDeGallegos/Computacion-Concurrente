
public class Main {
    public static void main(String[] args) {

        System.out.println(
                "Tiempo de ejecucion del candado TASLock: " + TASLock.TASLockTiempo() / 1000000000.0 + " segundos");
        System.out.println("Tiempo de ejecucion del candado TTASLock: " + TTASLock.TTASLockTiempo() / 1000000000.0
                + " segundos");
        System.out.println(
                "Tiempo de ejecucion del candado BackoffLock: " + BackoffLock.BackoffLockTiempo() / 1000000000.0
                        + " segundos");
        System.out.println(
                "Tiempo de ejecucion del candado CLHLock: " + CLHLock.CLHLockTiempo() / 1000000000.0 + " segundos");
        System.out.println(
                "Tiempo de ejecucion del candado MCSLock: " + MCSLock.MCSLockTiempo() / 1000000000.0 + " segundos");

    }
}