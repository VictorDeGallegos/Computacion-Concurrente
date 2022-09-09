package practica2.sumas;

public class SumaSecuencial {

    int[][] matrizA;
    int[][] matrizB;
    int[][] matrizResultante;

    //Constructor de nuestra Suma secuencial
    public SumaSecuencial(int[][] matrizA, int[][] matrizB){
        this.matrizA=matrizA;
        this.matrizB=matrizB;
        this.matrizResultante= new int[matrizA.length][matrizA.length];
    }

    //metodo para hacer la suma de dos matrices 
    public void hazSuma(){
        for(int i=0;i<matrizA.length;i++){
            for(int j=0;j<matrizB.length;j++){
                matrizResultante[i][j]= matrizA[i][j]+matrizB[i][j];
            }
        }
    }

    //Imprimimos el resultado de la suma 
    public void muestra(){
        for(int i=0;i<matrizA.length;i++){
            for(int j=0;j<matrizB.length;j++){
                System.out.print(matrizResultante[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
    //Main
    public static void main(String[] args){
        int[][] MatrizA={{3,5},{2,1}};
        int[][] MatrizB={{5,6},{1,5}};
        SumaSecuencial s= new SumaSecuencial(MatrizA,MatrizB);
        s.hazSuma();
        s.muestra();
    }
    
}
