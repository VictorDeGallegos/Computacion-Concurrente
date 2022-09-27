package practica2.sopas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class SopaDeLetrasConcurrente {
    
    /**
     * Clase que representa una ubicación dentro del sopa de letras,
     * esta ubicacion esta dada por su fila(x) y su columna(y). En caso
     * de que x o y sean -1, significa que dicha ubicacion no esta en el 
     * sopa de letras.
     * @author Juan Carlos Bautista Sandoval and ernt.
     * @version 1.0.0
     */
    public static class Cordenada {
        
        private int x = -1;
        private int y = -1;

        /**
         * Metodo constructor que no recibe parametros, el cual
         * asigna a x e y el valor de -1.
         */
        public Cordenada () {}

        /**
         * Metodo contructor que crea una coordenada.
         * @param x int que nos indica la coordenada x.
         * @param y int que nos indica la coordenada y.
         */
        public Cordenada (int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Metodo get que obtiene la coordenada x.
         * @return int, con el valor de la coordenada x.
         */
        public int getX() {
            return x;
        }

        /**
         * Metodo set que modifica la coordenada x.
         * @param x int, con la nueva coordenada x.
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         * Metodo get que obtiene la coordenada y.
         * @return int, con el valor de la coordenada y.
         */
        public int getY() {
            return y;
        }

        /**
         * Metodo set que modifica la coordenada y.
         * @param y int, con la nueva coordenada y.
         */
        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    /**
     * Clase que representa palabras que seran buscadas en el sopa de letras.
     * @author Juan Carlos Bautista Sandoval.
     * @version 1.0.0
     */
    public static class Palabra {

        char[] letras;
        char[] letrasVolteadas;
        boolean encontrado = false;
        Cordenada inicio = new Cordenada();
        Cordenada fin = new Cordenada();
        int indiceLetras = 0;
        int indiceLetrasVolteadas = 0;

        /**
         * Metodo constructor que recibe un String como parametro, dicho 
         * Strng representara la palabra que sera buscada en el sopa de letras.
         * @param palabra String, con la palabra a buscar en el sopa de letras.
         */
        public Palabra (String palabra) {
            letras = palabra.trim().toCharArray();
            letrasVolteadas = new char[letras.length];
            for (int i = 0; i < letras.length; i++) {
                letrasVolteadas[i] = letras[letras.length-i-1];
            }
        }

        /**
         * Metodo que recibe una letra, de tal forma que si recibe todas las letras,
         * que conforman a la palabra de manera consecutiva, esta palabra se marcara como encontrada, 
         * y nos dara las coordenadas de inicio y fin de la palabra en el sopa de letras, para ello necesitara
         * que se le pase la columna y el renglon de cada letra a verificar, tambien necesitara un 
         * valor booleano que le indicara si se esta buscando de manera horizontal o vertical, ya que
         * de esta manera se obtienen las coordenadas de la palabra, en el caso de ser encontrada.
         * @param letra char, la cual verificaremos si coincide con la letra esperada de la palabra, 
         * para ver si constituye un avance en la busqueda de la palabra o en su defecto un reinicio en la busqueda.
         * @param renglon int con el renglon de la letra.
         * @param columna int con la columna de la letra.
         * @param horizontal boolean, en el caso de que sea true indica que la palabra se esta buscando 
         * de forma horizontal, en caso contrario se busca de manera vertical.
         */
        public void verifica (char letra, int renglon, int columna, boolean horizontal) {
            if (encontrado) return;
            if (letra == letras[indiceLetras]) {
                indiceLetras++;
                if (indiceLetras == letras.length) encontrado = true;
            } else {
                indiceLetras = 0;
            }
            if(letra == letrasVolteadas[indiceLetrasVolteadas]) {
                indiceLetrasVolteadas++;
                if (indiceLetrasVolteadas == letrasVolteadas.length) encontrado = true;
            } else {
                indiceLetrasVolteadas=0;
            }
            if (encontrado) {
                fin = new Cordenada(renglon, columna);
                if (horizontal) {
                    inicio = new Cordenada(renglon, columna-letras.length+1);
                } else {
                    inicio = new Cordenada(renglon-letras.length+1, columna);
                }
            }
        }


      

        @Override
        public String toString() {
            String palabra= "";
            for (char c : letras) {
                palabra += c +"";
            }
            return  "Palabra: " + palabra + "\n" + 
                    "Inicio = " + inicio + "\n" + 
                    "Fin" + fin + "\n" +
                    "Encontrado:" + encontrado + "\n" +
                    "******************************************";
        }

    }

    private String rutaSopa;
    private String rutaPalabras;
    private char[][] sopa;
    private List<Palabra> palabras = new ArrayList<>();

    /**
     * Metodo que carga con todo lo necesario para buscar palabras en un sopa de letras.
     * @param rutaSopa String con la ruta al archivo con el sopa de letras.
     * @param rutaPalabras String con la ruta al archivo con las palabras a buscar en el sopa de letras.
     */
    public SopaDeLetrasConcurrente (String rutaSopa, String rutaPalabras) {
        this.rutaSopa = rutaSopa;
        this.rutaPalabras = rutaPalabras;
        try {
            List<String> lines = Files.readAllLines(Paths.get(rutaSopa));
            sopa = new char[lines.size()][];
            int indice = 0;
            for (String line : lines) {
                sopa[indice++] = line.trim().toCharArray();
            }
            List<String> p = Files.readAllLines(Paths.get(rutaPalabras));
            for (String string : p) {
                palabras.add(new Palabra(string));
            }
        } catch (IOException e) {
            System.out.print("Error el archivo no se pudo leer");
            e.printStackTrace();
        }

    }

    /**
     * Metodo getter que nos regresa la ruta del sopa de letras.
     * @return String con la ruta del sopa de letras.
     */
    public String getRutaSopa() {
        return rutaSopa;
    }

    /**
     * Metodo setter que cambia la ruta del sopa de letras a usar en la busqueda de palabras.
     * @param rutaSopa String, con la nueva ruta del sopa de letras.
     */
    public void setRutaSopa(String rutaSopa) {
        this.rutaSopa = rutaSopa;
    }

    /**
     * Metodo getter que nos regresa la ruta de las palabras a buscar en el sopa de letras.
     * @return String con la ruta de las palbras a buscar en el sopa de letras.
     */
    public String getRutaPalabras() {
        return rutaPalabras;
    }

    /**
     * Metodo setter que cambia la ruta de las palabras que se buscaran del sopa de letras.
     * @param rutaPalabras String con la nueva ruta de las palabras que se buscaran del sopa de letras.
     */
    public void setRutaPalabras(String rutaPalabras) {
        this.rutaPalabras = rutaPalabras;
    }

    /**
     * Metodo que nos regresa el sopa de letras en forma de un arreglo bidimensional.
     * @return char[][] con el sopa de letras de la ruta especificada.
     */
    public char[][] getSopa() {
        return sopa;
    }

    /**
     * Metodo setter que cambia el sopa de letras.
     * @param sopa char[][] con el nuevo sopa de letras.
     */
    public void setSopa(char[][] sopa) {
        this.sopa = sopa;
    }

    /**
     * Metodo getter para obtener la lista de palbras a ser buscado en el sopa de letras.
     * @return List<Palabra> con las palabras a buscar en el sopa de letras.
     */
    public List<Palabra> getPalabras() {
        return palabras;
    }

    /**
     * Metodo setter para cambiar la lista de palabras a ser buscada en el sopa de letras.
     * @param palabras List<Palabra> con las nuevas palabras a ser buscada en el sopa de letras.
     */
    public void setPalabras(List<Palabra> palabras) {
        this.palabras = palabras;
    }

    /**
     * Metodo que muestra por consola el sopa de letras.
     */
    public void muestraSopa () {
        System.out.println("---------------------------------------------");
        System.out.println("-----------------  SOPA ---------------------");
        System.out.println("---------------------------------------------");
        for (char[] cs : sopa) {
            for (char c : cs) {
                System.out.print(c);
            }
            System.out.println("\n");
        }
    }

    /**
     * Metodo que muestra las palabras a ser buscadas en el sopa de letras.
     */
    public void muestraLetras () {
        System.out.println("---------------------------------------------");
        System.out.println("---------- PALABRAS BUSCADAS ----------------");
        System.out.println("---------------------------------------------");
        for (Palabra palabra : palabras) {
            System.out.println(palabra);
        }
    }

    /**
     * Hilo que revisa si las palabras se encuentran en la sopa de letras en forma horizontal.
     */

    class hilohorizontal extends Thread {

        @Override
        public void run() {
            synchronized (sopa){
              for (int i = 0; i < sopa.length; i++) {
            for (int j = 0; j < sopa[i].length; j++) {

                for (Palabra palabra : palabras) {
                  palabra.verifica(sopa[i][j], i, j, true);
                }
            }
        }
        }
    }
    }
 

        class hilovertical extends Thread {

            @Override
            public void run() {
                synchronized (sopa){
                for (int i = 0; i < sopa[1].length; i++) {
                    for (int j = 0; j < sopa.length; j++) {
                        for (Palabra palabra : palabras) {
                            palabra.verifica(sopa[j][i], j, i, false);
                        }
                    }
                }
            }
            }
        }



    /**
     * Metodo que encuentra las palabras en el sopa de letras.
     */
    public void encuentraPalabras() {
        hilohorizontal h1 = new hilohorizontal();
        h1.start();
        hilovertical h2 = new hilovertical();
        h2.start();
        try {
            h1.join();
            System.out.println(h1.getName());
            h2.join();
            System.out.println(h2.getName());
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
    }
    }



