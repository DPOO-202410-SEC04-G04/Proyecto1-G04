package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Galeria;

public class MainWindowEmpleado extends JFrame {
    private JTextField usuarioField;
    private JPasswordField contrasenaField;

    public MainWindowEmpleado() {
        setTitle("Galería de Arte - Empleado");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout());
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        
        loginPanel.add(new JLabel("Usuario:"));
        usuarioField = new JTextField();
        loginPanel.add(usuarioField);
        
        loginPanel.add(new JLabel("Contraseña:"));
        contrasenaField = new JPasswordField();
        loginPanel.add(contrasenaField);
        
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String usuario = usuarioField.getText();
                    String contrasena = new String(contrasenaField.getPassword());
                    if (contarUsuarios(usuario, contrasena)) {
                        showEmpleadoMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Acceso denegado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(loginPanel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        add(panel);
    }

    private boolean contarUsuarios(String usuario, String contrasena) throws IOException {
        String archivo = ".\\data\\PersistenciaEmpleados.txt";
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos[0].equals(usuario) && datos[1].equals(contrasena)) {
                lector.close();
                return true;
            }
        }
        lector.close();
        return false;
    }

    private void showEmpleadoMenu() {
        getContentPane().removeAll();
        revalidate();
        repaint();
        
        JPanel menuPanel = new JPanel(new GridLayout(4, 1));
        
        JButton btnHistorialPieza = new JButton("Consultar Historial de una Pieza");
        btnHistorialPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarHistorialPieza();
            }
        });
        menuPanel.add(btnHistorialPieza);
        
        JButton btnHistorialArtista = new JButton("Consultar Historial de un Artista");
        btnHistorialArtista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarHistorialArtista();
            }
        });
        menuPanel.add(btnHistorialArtista);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuPanel.add(btnSalir);
        
        add(menuPanel);
        revalidate();
        repaint();
    }

    private void consultarHistorialPieza() {
        String nombrePieza = JOptionPane.showInputDialog(this, "Ingrese el nombre de la pieza:");
        if (nombrePieza != null && !nombrePieza.isEmpty()) {
            try {
                contarPiezas(nombrePieza);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al consultar el historial de la pieza", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void contarPiezas(String nombrePieza) throws IOException {
        String directoryPath = ".\\data\\";

        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("Comprador") && name.endsWith(".txt");
            }
        });

        if (listOfFiles != null) {
            StringBuilder sb = new StringBuilder();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    sb.append("Revisando archivo: ").append(file.getName()).append("\n");
                    searchArtworkInFile(file, nombrePieza, sb);
                }
            }
            JOptionPane.showMessageDialog(this, sb.toString(), "Historial de Pieza", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron archivos o el directorio no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchArtworkInFile(File file, String nombrePieza, StringBuilder sb) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.contains(nombrePieza)) {
                    String[] items = line.split(";");
                    sb.append(nombrePieza).append(" encontrada en ").append(file.getName()).append(": ").append(Arrays.toString(items)).append("\n");
                    found = true;
                }
            }
            if (!found) {
                sb.append(nombrePieza).append(" no encontrada en ").append(file.getName()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void consultarHistorialArtista() {
        String nombreArtista = JOptionPane.showInputDialog(this, "Ingrese el nombre del artista:");
        if (nombreArtista != null && !nombreArtista.isEmpty()) {
            try {
                contarArtistas(nombreArtista);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al consultar el historial del artista", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void contarArtistas(String nombreArtista) throws IOException {
        String archivo = ".\\data\\ObrasdeArte.txt";
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        StringBuilder sb = new StringBuilder();
        String linea;
        
        while ((linea = lector.readLine()) != null) {
            if (linea.contains(nombreArtista)) {
                String[] elementos = linea.split(";");
                List<String> lista = new ArrayList<>(Arrays.asList(elementos));

                // Asume un ancho predeterminado para cada columna basado en tus datos
                int[] columnWidths = new int[]{20, 12, 20, 10};
                String[][] tabla = new String[1][4];
                tabla[0][0] = lista.get(2);
                tabla[0][1] = lista.get(3);
                tabla[0][2] = lista.get(4);
                tabla[0][3] = lista.get(6);

                // Línea de separación y encabezados
                printLine(columnWidths, sb);
                sb.append(String.format("| %-" + columnWidths[0] + "s | %-" + columnWidths[1] + "s | %-" + columnWidths[2] + "s | %" + columnWidths[3] + "s |%n", "Nombre", "Fecha", "Lugar", "Precio"));
                printLine(columnWidths, sb);
                
                // Datos de la tabla
                for (String[] fila : tabla) {
                    sb.append(String.format("| %-" + columnWidths[0] + "s | %-" + columnWidths[1] + "s | %-" + columnWidths[2] + "s | %" + columnWidths[3] + "s |%n", fila[0], fila[1], fila[2], fila[3]));
                }
                printLine(columnWidths, sb);
            }
        }
        
        lector.close();
        JOptionPane.showMessageDialog(this, sb.toString(), "Historial del Artista", JOptionPane.INFORMATION_MESSAGE);
    }

    private void printLine(int[] widths, StringBuilder sb) {
        sb.append("+");
        for (int width : widths) {
            for (int i = 0; i < width + 2; i++) { // +2 para los espacios extra alrededor del texto
                sb.append("-");
            }
            sb.append("+");
        }
        sb.append("\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindowEmpleado().setVisible(true);
            }
        });
    }
}
