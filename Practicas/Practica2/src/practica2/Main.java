package practica2;

import javax.imageio.ImageIO;
// Por lo general, necesitarás paquetes Swing y Awt
// incluso si estás trabajando con solo swings.
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;

import practica2.filtros.Imagen;
import practica2.matrices.Matriz;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String args[]) {

        // Creando el Marco
        JFrame frame = new JFrame("Practica 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Creando MenuBar y agregando componentes
        // ARCHIVO
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Archivo");
        mb.add(m1);
        JMenuItem m11 = new JMenuItem("Nuevo Archivo");
        JMenuItem m22 = new JMenuItem("Guardar como");
        m1.add(m11);
        m1.add(m22);

        // MATRICES
        JMenu menuOption = new JMenu("Matriz");
        menuOption.setMnemonic(KeyEvent.VK_P);
        mb.add(menuOption);

        // Crear ButtonGroup para los radio button D, E, F
        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButtonMenuItem jRadioButtonMenuItem_10 = new JRadioButtonMenuItem("10");
        jRadioButtonMenuItem_10.setMnemonic(KeyEvent.VK_A);
        menuOption.add(jRadioButtonMenuItem_10);
        buttonGroup.add(jRadioButtonMenuItem_10);

        JRadioButtonMenuItem jRadioButtonMenuItem_100 = new JRadioButtonMenuItem("100");
        jRadioButtonMenuItem_100.setMnemonic(KeyEvent.VK_B);
        menuOption.add(jRadioButtonMenuItem_100);
        buttonGroup.add(jRadioButtonMenuItem_100);

        JRadioButtonMenuItem jRadioButtonMenuItem_1000 = new JRadioButtonMenuItem("1000");
        jRadioButtonMenuItem_1000.setMnemonic(KeyEvent.VK_C);
        menuOption.add(jRadioButtonMenuItem_1000);
        buttonGroup.add(jRadioButtonMenuItem_1000);

        // FILTROS
        JMenu menuOptionF = new JMenu("Filtros");
        menuOptionF.setMnemonic(KeyEvent.VK_P);
        mb.add(menuOptionF);

        // Crear ButtonGroup para los FILTROS
        ButtonGroup buttonGroupCS = new ButtonGroup();

        JRadioButtonMenuItem jRadioButtonMenuItem_RGB3 = new JRadioButtonMenuItem("Gray = (Red+Green+Blue)/3");
        jRadioButtonMenuItem_RGB3.setMnemonic(KeyEvent.VK_D);
        menuOptionF.add(jRadioButtonMenuItem_RGB3);
        buttonGroupCS.add(jRadioButtonMenuItem_RGB3);

        JRadioButtonMenuItem jRadioButtonMenuItem_RGB11 = new JRadioButtonMenuItem(
                "Gray = (Red*.03+Green0.59+Blue*0.11)");
        jRadioButtonMenuItem_RGB11.setMnemonic(KeyEvent.VK_E);
        menuOptionF.add(jRadioButtonMenuItem_RGB11);
        buttonGroupCS.add(jRadioButtonMenuItem_RGB11);

        JRadioButtonMenuItem jRadioButtonMenuItem_RGB07 = new JRadioButtonMenuItem(
                "Gray = (Red*.2126+Green0.7152+Blue*0.0722)");
        jRadioButtonMenuItem_RGB07.setMnemonic(KeyEvent.VK_F);
        menuOptionF.add(jRadioButtonMenuItem_RGB07);
        buttonGroupCS.add(jRadioButtonMenuItem_RGB07);

        JRadioButtonMenuItem jRadioButtonMenuItem_PR = new JRadioButtonMenuItem(
                "Gray = pixel.getRed()");
        jRadioButtonMenuItem_PR.setMnemonic(KeyEvent.VK_G);
        menuOptionF.add(jRadioButtonMenuItem_PR);
        buttonGroupCS.add(jRadioButtonMenuItem_PR);

        JRadioButtonMenuItem jRadioButtonMenuItem_AC = new JRadioButtonMenuItem(
                "Alto Contraste");
        jRadioButtonMenuItem_AC.setMnemonic(KeyEvent.VK_H);
        menuOptionF.add(jRadioButtonMenuItem_AC);
        buttonGroupCS.add(jRadioButtonMenuItem_AC);

        JRadioButtonMenuItem jRadioButtonMenuItem_RGBC = new JRadioButtonMenuItem(
                "Componentes RGB");
        jRadioButtonMenuItem_RGBC.setMnemonic(KeyEvent.VK_I);
        menuOptionF.add(jRadioButtonMenuItem_RGBC);
        buttonGroupCS.add(jRadioButtonMenuItem_RGBC);

        JRadioButtonMenuItem jRadioButtonMenuItem_BLUR3 = new JRadioButtonMenuItem(
                "Blur 3x3");
        jRadioButtonMenuItem_BLUR3.setMnemonic(KeyEvent.VK_J);
        menuOptionF.add(jRadioButtonMenuItem_BLUR3);
        buttonGroupCS.add(jRadioButtonMenuItem_BLUR3);

        JRadioButtonMenuItem jRadioButtonMenuItem_BLUR5 = new JRadioButtonMenuItem(
                "Blur 5x5");
        jRadioButtonMenuItem_BLUR5.setMnemonic(KeyEvent.VK_K);
        menuOptionF.add(jRadioButtonMenuItem_BLUR5);
        buttonGroupCS.add(jRadioButtonMenuItem_BLUR5);

        JRadioButtonMenuItem jRadioButtonMenuItem_BLUR9 = new JRadioButtonMenuItem(
                "Blur 9x9");
        jRadioButtonMenuItem_BLUR9.setMnemonic(KeyEvent.VK_L);
        menuOptionF.add(jRadioButtonMenuItem_BLUR9);
        buttonGroupCS.add(jRadioButtonMenuItem_BLUR9);

        JRadioButtonMenuItem jRadioButtonMenuItem_SHARPEN = new JRadioButtonMenuItem(
                "Sharpen");
        jRadioButtonMenuItem_SHARPEN.setMnemonic(KeyEvent.VK_M);
        menuOptionF.add(jRadioButtonMenuItem_SHARPEN);
        buttonGroupCS.add(jRadioButtonMenuItem_SHARPEN);

        // SECUENCIAL/CONCURRENTE
        JMenu menuOptionSC = new JMenu("Secuencial/Concurrente");
        menuOptionSC.setMnemonic(KeyEvent.VK_P);
        mb.add(menuOptionSC);

        // Crear ButtonGroup para los radio button D, E, F
        ButtonGroup buttonGroupSC = new ButtonGroup();

        JRadioButtonMenuItem jRadioButtonMenuItem_S = new JRadioButtonMenuItem("Secuencial");
        jRadioButtonMenuItem_S.setMnemonic(KeyEvent.VK_N);
        menuOptionSC.add(jRadioButtonMenuItem_S);
        buttonGroupSC.add(jRadioButtonMenuItem_S);

        JRadioButtonMenuItem jRadioButtonMenuItem_C = new JRadioButtonMenuItem("Concurrente");
        jRadioButtonMenuItem_C.setMnemonic(KeyEvent.VK_O);
        menuOptionSC.add(jRadioButtonMenuItem_C);
        buttonGroupSC.add(jRadioButtonMenuItem_C);

        // APLICAR FILTRO
        JMenu menuOptionAF = new JMenu("Aplicar filtro");
        menuOptionAF.setMnemonic(KeyEvent.VK_P);
        mb.add(menuOptionAF);

        // Área de texto en el centro deshabilitada
        JTextArea ta = new JTextArea();
        ta.setEnabled(false);

        // Agregar componentes al marco.

        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);

        // Abirir archivos en formato imagen
        m11.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Selecciona una imagen");
            // abrir solo archivos en formato imagen
            FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG, JPGE & PNG Imagenes", "jpg", "png",
                    "jpeg");
            fileChooser.setFileFilter(imgFilter);
            int userSelection = fileChooser.showOpenDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToOpen = fileChooser.getSelectedFile();
                System.out.println("Archivo seleccionado: " + fileToOpen.getAbsolutePath());
            }

            // Copiar imagen en directorio imagenes
            Path srcFile = Paths.get(fileChooser.getSelectedFile().getAbsolutePath());
            Path destDir = Paths.get("Practicas/Practica2/imagenes");
            try {
                Files.copy(srcFile, destDir.resolve(srcFile.getFileName()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("Imagen copiada en el directorio: " + destDir.resolve(srcFile.getFileName()));

            // Mostrar ruta de la imagen copiada en el área de texto
            if (fileChooser.getSelectedFile() != null) {
                ta.setText(destDir.resolve(srcFile.getFileName()).toString());
            }
            // Mostrar imagen en el marco 50x50 píxeles
            try {
                frame.getContentPane().add(BorderLayout.SOUTH, new JLabel(new ImageIcon(ImageIO.read(new File(
                        destDir.resolve(srcFile.getFileName()).toString()))
                        .getScaledInstance(500, 500, Image.SCALE_SMOOTH))));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        // Guardar archivo en formato IMG
        m22.addActionListener(e1 -> {
            JFileChooser fileChooser1 = new JFileChooser();
            fileChooser1.setDialogTitle("Guardar imagen");
            // abrir solo archivos en formato imagen
            FileNameExtensionFilter imgFilter1 = new FileNameExtensionFilter("jpg", "jpg");
            fileChooser1.setFileFilter(imgFilter1);
            int userSelection1 = fileChooser1.showSaveDialog(frame);
            if (userSelection1 == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser1.getSelectedFile();
                System.out.println("Archivo Guardado: " + fileToSave.getAbsolutePath());
            }
        });

        // Aplicar filtro con opciones seleccionadas
        menuOptionAF.addActionListener(e2 -> {
            // Obtener ruta de la imagen
            String ruta = ta.getText();
            // Obtener filtro seleccionado
            int filtro = 0;
            // Obtener modo de ejecución seleccionado
            String modo = "";
            // Obtener número de hilos seleccionado
            int num_hilos = Integer.parseInt(args[4]);

            boolean sec = false;

            if (jRadioButtonMenuItem_BLUR3.isSelected()) {
                filtro = 1;
            } else if (jRadioButtonMenuItem_BLUR5.isSelected()) {
                filtro = 2;
            } else if (jRadioButtonMenuItem_BLUR9.isSelected()) {
                filtro = 3;
            } else if (jRadioButtonMenuItem_SHARPEN.isSelected()) {
                filtro = 4;
            }
            // Obtener la matriz seleccionada de la clase Matriz
            System.out.println("--- Multiplicación de matrices ---");
            Matriz a = new Matriz(args[0]);

            long timestamp = System.nanoTime();
            Matriz mul;
            mul = sec ? a.multiplica(a) : a.multiplicaConcurrente(a, num_hilos);
            long ms = System.nanoTime() - timestamp;
            System.out.println("Tiempo transcurrido: " + ms);
            // Obtener modo de ejecución seleccionado
            if (jRadioButtonMenuItem_S.isSelected()) {
                modo = "secuencial";
            } else if (jRadioButtonMenuItem_C.isSelected()) {
                modo = "concurrente";
            }
            // Aplicar filtro
            try {
                Imagen img = new Imagen(ruta);
                String cadena = sec ? "secuencial" : "concurrente";
                System.out.println("\nAplicando filtro " + cadena);
                img.aplicarFiltro(filtro, sec, num_hilos);
                img.mostrarImagen();
                img.reset();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        });

    }

}
