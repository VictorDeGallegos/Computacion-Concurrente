package practica2.filtros;

import java.awt.Color;
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
                   return new Color(c.getRed(),c.getRed(),c.getRed());
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
                // Filtro: Componentes RGB
                // Aqui va codigo
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
            case 7:
            case 8:
            case 9:
            case 10:
                // Filtro: Matriz de Convolución (Blur o Sharpen)
                // Aqui va codigo
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

    private void doConcurrente(Object object, UnaryOperator<Color> f, String string) {
    }

}
