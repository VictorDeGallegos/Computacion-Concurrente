package practica2.filtros;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Filtro {

    private Color[] rgb;
    private int ancho; // ancho de la imagen
    private int alto; // alto de la imagen

    private int num_hilos; // numero de hilos que se van a crear

    // Constructor
    public Filtro(Color[] rgbFiltro, int alto, int ancho) {
        this.rgb = rgbFiltro;
        this.ancho = ancho;
        this.alto = alto;
    }

    /**
     * Metodo que aplica el filtro
     * 
     * @param op        - opcion del filtro
     * @param sec       - si es secuencial o concurrente
     * @param num_hilos - numero de hilos de manera concurrente
     */
    public void aplicarFiltro(int op, boolean sec, int num_hilos) {
        UnaryOperator<Color> f;
        this.num_hilos = num_hilos;
        switch (op) {
            case 1:
                // Filtro: Escala de gris (promedio)
                f = c -> {
                    int prom = validarRango((c.getRed() + c.getGreen() + c.getBlue()) / 3);
                    return new Color(prom, prom, prom);
                };
                if (sec) {
                    this.doPorPixel(f);
                } else {
                    this.doConcurrente(null, f, "0");
                }
                break;
            case 2:
                // Filtro: Escala de gris (correctud)
                f = (c) -> {
                    int r = validarRango(c.getRed() * .03);
                    int g = validarRango(c.getGreen() * .59);
                    int b = validarRango(c.getBlue() * 0.11);
                    return new Color(r, g, b);
                };
                if (sec) {
                    this.doPorPixel(f);
                } else {
                    this.doConcurrente(null, f, "0");
                }
                break;
            case 3:
                // Filtro: Escala de gris (correctud 2)
                f = (c) -> {
                    int r = validarRango(c.getRed() * .21);
                    int g = validarRango(c.getGreen() * .72);
                    int b = validarRango(c.getBlue() * 0.07);
                    return new Color(r, g, b);
                };
                if (sec) {
                    this.doPorPixel(f);
                } else {
                    this.doConcurrente(null, f, "0");
                }
                break;
            case 4:
                // Filtro: Escala de gris (single color)
                f = (c) -> {
                    // Aqui va el codigo
                    return new Color(c.getRed(), c.getRed(), c.getRed());
                };
                if (sec) {
                    this.doPorPixel(f);
                } else {
                    this.doConcurrente(null, f, "0");
                }
                break;
            case 5:
                // Filtro: Alto contraste
                f = (c) -> {
                    // Aqui va el codigo
                    return c; // eliminar esta linea cuando implemente el filtro
                };
                if (sec) {
                    this.doPorPixel(f);
                } else {
                    this.doConcurrente(null, f, "0");
                }
                break;
            case 6:
                System.out.println("Ingresa las constantes a sumar R G B: ");
                Scanner entrada = new Scanner(System.in);
                int rVal = entrada.nextInt();
                int gVal = entrada.nextInt();
                int bVal = entrada.nextInt();
                f = c -> {
                    int r = validarRango(c.getRed() & rVal);
                    int g = validarRango(c.getGreen() & gVal);
                    int b = validarRango(c.getBlue() & bVal);
                    return new Color(r, g, b);
                };
                if (sec)
                    this.doPorPixel(f);
                else
                    this.doConcurrente(null, f, "0");
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                // Filtro: Matriz de Convolución (Blur o Sharpen)
                System.out.println("Filtro: Matriz de Convolución (Blur o Sharpen)");
                this.selecConvolucion(op - 7, sec);
                break;
            default:
                throw new IllegalArgumentException("Opción no valida");
        }
    }

    /**
     * @desc Valida que el valor este ente 0 y 255
     * @return {number} valor RGB del pixel
     */
    private int validarRango(double valor) {
        if (valor > 255) {
            return 255;
        } else if (valor < 0) {
            return 0;
        } else {
            return (int) valor;
        }
    }

    private void doPorPixel(UnaryOperator<Color> f) {
        for (var alfa = 0; alfa < this.rgb.length; alfa++) {
            this.rgb[alfa] = f.apply(this.rgb[alfa]);
        }
    }

    public void doConcurrente(double[][] matrix, UnaryOperator<Color> f, String op) {
        try {
            FiltroConcurrente mc = new FiltroConcurrente(this.rgb, matrix, f);
            List<Thread> hilosh = new ArrayList<>();
            int hilos = num_hilos;

            for (int i = 0; i < alto; i++) {
                Thread t = new Thread(mc, op + "-" + i);
                hilosh.add(t);
                t.start();
                if (hilosh.size() == hilos) {
                    for (Thread threads : hilosh) {
                        threads.join();
                    }
                    hilosh.clear();
                }
            }

            for (Thread threads : hilosh) {
                threads.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public float getFactor(double[][] matrix) {
        float suma = 0;
        for (int alfa = 0; alfa < matrix.length; alfa++)
            for (int beta = 0; beta < matrix.length; beta++) {
                suma += matrix[alfa][beta];
            }
        suma = suma == 0 ? 1 : 1 / suma;
        return suma;
    }

    private int[] applyMatrix(double[][] matrix, int alfa, int beta) {
        int[] valor = { 0, 0, 0 }; // [0] - r, [1] - g, [2] - b
        int length = matrix.length;
        for (int i = 0; i < length; i++)
            for (var j = 0; j < length; j++) {
                // alto y ancho (ubicación del pixel)
                int x = alfa + i - (length / 2);
                int y = beta + j - (length / 2);
                int site = Math.floorMod(this.ancho * x + y, this.rgb.length);
                valor[0] += this.rgb[site].getRed() * matrix[i][j];
                valor[1] += this.rgb[site].getGreen() * matrix[i][j];
                valor[2] += this.rgb[site].getBlue() * matrix[i][j];
            }
        return valor;
    }

    public void doConvolucion(double[][] matrix) {
        float factor = this.getFactor(matrix);
        for (int i = 0; i < this.rgb.length; i++) {
            // se calcula el alto y el ancho
            int h = i / this.alto;
            int w = i % this.ancho;
            int[] valor = this.applyMatrix(matrix, w, h);// se le aplica a la matriz
            int r = this.validarRango(factor * valor[0]);
            int g = this.validarRango(factor * valor[1]);
            int b = this.validarRango(factor * valor[2]);
            this.rgb[w * this.ancho + h] = new Color(r, g, b);
        }
    }

    /**
     * @desc Selecciona y aplica una matriz de convolución
     * @param op  - nos indica que matriz queremos aplicar
     * @param sec - indica si se va aplicar de manera secuencial o concurrente
     */

    public void selecConvolucion(int op, boolean sec) {
        double[][][] matriz = {
                // Blur 1, op 7 aqui va el codigo de blur
                { {},
                        {},
                        {} },

                // Blur 2, op 8 aqui va el codigo de blur
                { {},
                        {},
                        {},
                        {},
                        {}, },
                // Blur 3, op 9 aqui va el codigo de blur
                { {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {},
                        {} },
                // Sharpen , op 10
                { { -1, -1, -1 },
                        { -1, 9, -1 },
                        { -1, 1, -1 } }
        };
        if (sec)
            this.doConvolucion(matriz[op]);
        else
            this.doConcurrente(matriz[op], null, "1");

    }

    class FiltroConcurrente implements Runnable {

        private Color[] salida;
        private double[][] matrix;
        private UnaryOperator<Color> f;

        public FiltroConcurrente(Color[] salida, double[][] matrix, UnaryOperator<Color> f) {
            this.salida = salida;
            this.matrix = matrix;
            this.f = f;
        }

        public void convolucionConcurrente(int posicion) {
            float factor = getFactor(this.matrix);
            for (int i = 0; i < ancho; i++) {
                // Calculamos alto y ancho (ubicación del pixel)
                int h = (posicion * ancho + i) / alto;
                int w = (posicion * ancho + i) % alto;
                int[] valor = applyMatrix(this.matrix, w, h); // aplicamos la matriz
                // Asignamos los nuevos valores
                int r = validarRango(factor * valor[0]);
                int g = validarRango(factor * valor[1]);
                int b = validarRango(factor * valor[2]);
                this.salida[w * ancho + h] = new Color(r, g, b);
            }
        }

        public void doPorPixelConcurrente(int posicion) {
            for (int i = 0; i < ancho; i++) {
                this.salida[posicion * ancho + i] = f.apply(rgb[posicion * ancho + i]);
            }
        }

        @Override
        public void run() {
            String[] banderas = Thread.currentThread().getName().split("-");
            if (banderas[0].equals("0"))
                this.doPorPixelConcurrente(Integer.parseInt(banderas[1]));
            else
                this.convolucionConcurrente(Integer.parseInt(banderas[1]));
        }

    }

}
