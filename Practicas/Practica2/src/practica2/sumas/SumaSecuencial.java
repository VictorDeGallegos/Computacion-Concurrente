package practica2.sumas;


public class SumaSecuencial {

   
    public static void main(String[] args){
       int i;
       int s=0;

       for(i=1;i<=10;i++){
            System.out.print("Proceso " + i);
            s=s+i;
            System.out.println();

       }
       System.out.println("Valor de la suma " + s);
    }
    
}
