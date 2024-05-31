package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.Comprador;
import model.Galeria;
import model.Pagos;
import model.Pieza;

public class MainWindowComprador extends JFrame {
    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private static String usuario;

    public MainWindowComprador() {
        setTitle("Galería de Arte - Comprador");
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
                        showCompradorMenu();
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
        String archivo = ".\\data\\PersistenciaCompradores.txt";
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos[0].equals(usuario) && datos[1].equals(contrasena)) {
                this.usuario = usuario;
                lector.close();
                return true;
            }
        }
        lector.close();
        return false;
    }

    private void showCompradorMenu() {
        getContentPane().removeAll();
        revalidate();
        repaint();
        
        JPanel menuPanel = new JPanel(new GridLayout(8, 1));
        
        JButton btnComprarPieza = new JButton("Comprar Pieza");
        btnComprarPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					comprarPieza();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        menuPanel.add(btnComprarPieza);
        
        JButton btnEstadoPiezas = new JButton("Consultar Estado de mis Piezas");
        btnEstadoPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					consultarEstadoPiezas();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        menuPanel.add(btnEstadoPiezas);
        
        JButton btnHistorialPiezas = new JButton("Consultar Historial de mis Piezas");
        btnHistorialPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					consultarHistorialPiezas();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        menuPanel.add(btnHistorialPiezas);
        
        JButton btnRealizarPago = new JButton("Realizar Pago");
        btnRealizarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					realizarPago();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        menuPanel.add(btnRealizarPago);
        
        JButton btnHistorialArtista = new JButton("Ver historia artista");
        btnHistorialArtista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarHistorialArtista();
            }
        });
        menuPanel.add(btnHistorialArtista);
        
        JButton btnHistorialPieza = new JButton("Ver historia pieza");
        btnHistorialPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarHistorialPieza();
            }
        });
        menuPanel.add(btnHistorialPieza);
        
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

    private void comprarPieza() throws FileNotFoundException, IOException {
        String[] options = {"Pagar Valor total", "Por Subasta", "Volver"};
        int option = JOptionPane.showOptionDialog(this, "Seleccione método de compra de Pieza:", "Comprar Pieza",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (option) {
            case 0: // Pagar Valor total
                pagarValorTotal();
                break;
            case 1: // Por Subasta
                realizarOfertaSubasta();
                break;
            default: // Volver
                break;
        }
    }

    private void pagarValorTotal() {
        String nombreObra = JOptionPane.showInputDialog(this, "Digite el nombre de la Obra:");
        if (nombreObra != null && !nombreObra.isEmpty()) {
            try {
                contarLineasNombre(nombreObra);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al pagar la obra", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void contarLineasNombre(String nombreObra) throws IOException {
        String archivo = ".\\data\\ObrasdeArte.txt";
        List<String> lineas = new ArrayList<>();
        int contador = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (linea.contains(nombreObra)) {
                    String[] elementos = linea.split(";");
                    List<String> lista = new ArrayList<>(Arrays.asList(elementos));
                    Pieza pieza = new Pieza(lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5), Float.parseFloat(lista.get(6)), lista.get(7), lista.get(8), lista.get(9));
                    if (!lista.get(7).equals("Vendida") && !lista.get(7).equals("Devuelta")) {
                        lista.set(7, "Vendida");
                        linea = String.join(";", lista);

                        Random random = new Random();
                        String id = String.valueOf(random.nextInt(10000));
                        float valorPago = 25000;
                        List<String> info = buscarUsuario();
                        Comprador comprador = new Comprador(usuario, "Comprador", info.get(3), info.get(4), Float.parseFloat(info.get(5)), pieza);
                        Pagos pago = new Pagos(id, valorPago, comprador, pieza, "Transferencia electronica");

                        Pagos.realizarPago(pago);
                    }
                }
                lineas.add(linea);
                contador++;
            }
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            for (String linea : lineas) {
                escritor.write(linea);
                escritor.newLine();
            }
        }
    }

    private List<String> buscarUsuario() throws IOException, FileNotFoundException {
        String archivo = ".\\data\\PersistenciaCompradores.txt";
        FileReader leer = new FileReader(archivo);
        BufferedReader lector1 = new BufferedReader(leer);
        String linea1 = lector1.readLine();
        List<String> lista1 = new ArrayList<>();
        while (linea1 != null) {
            String[] L = linea1.split(";");
            if (L[0].equals(usuario)) {
                lista1 = new ArrayList<>(Arrays.asList(L));
            }
            linea1 = lector1.readLine();
        }
        lector1.close();
        leer.close();
        return lista1;
    }


    private void realizarOfertaSubasta() throws FileNotFoundException, IOException {
        String nombreObra = JOptionPane.showInputDialog(this, "Ingrese el nombre de la obra:");
        if (nombreObra != null && !nombreObra.isEmpty()) {
            Comprador.realizarOfertaSubasta(nombreObra);
            JOptionPane.showMessageDialog(this, "Oferta realizada con éxito");
        }
    }

    private void consultarEstadoPiezas() throws FileNotFoundException, IOException {
        ArrayList<String[]> list = Comprador.estadoPiezas(usuario);
        StringBuilder sb = new StringBuilder();
        for (String[] linea : list) {
            sb.append("Pieza: ").append(linea[2]).append("\n");
            sb.append("Estado: ").append(linea[5]).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Estado de mis Piezas", JOptionPane.INFORMATION_MESSAGE);
    }

    private void consultarHistorialPiezas() throws FileNotFoundException, IOException {
        ArrayList<String[]> l = Comprador.historialCompleto(usuario);
        StringBuilder sb = new StringBuilder();
        sb.append("Historial Piezas de ").append(usuario).append("\n");
        for (String[] linea : l) {
            sb.append("------------------------------------------------------------------\n");
            sb.append("ID: ").append(linea[0]).append("\n");
            sb.append("Autor: ").append(linea[1]).append("\n");
            sb.append("Pieza: ").append(linea[2]).append("\n");
            sb.append("Fecha: ").append(linea[3]).append("\n");
            sb.append("Lugar de creación: ").append(linea[4]).append("\n");
            sb.append("Estado: ").append(linea[5]).append("\n");
            sb.append("Precio: ").append(linea[6]).append("\n");
            sb.append("Disponibilidad: ").append(linea[7]).append("\n");
            sb.append("Método de pago: ").append(linea[8]).append("\n");
            sb.append("Tipo de pieza: ").append(linea[9]).append("\n");
            sb.append("Propietario de la pieza: ").append(linea[10]).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Historial de mis Piezas", JOptionPane.INFORMATION_MESSAGE);
    }

    private void realizarPago() throws FileNotFoundException, IOException {
        String nombreObra = JOptionPane.showInputDialog(this, "Digite el nombre de la Obra:");
        String autorObra = JOptionPane.showInputDialog(this, "Digite el autor de la Obra:");
        String fecha = JOptionPane.showInputDialog(this, "Digite la fecha de la Obra (dd/mm/YYYY):");
        String lugar = JOptionPane.showInputDialog(this, "Digite el lugar de la Obra:");
        String estado = JOptionPane.showInputDialog(this, "Digite el estado de la Obra (Bodega/Exhibido):");
        String valorPagoStr = JOptionPane.showInputDialog(this, "Ingrese el valor del pago:");
        String disponibilidad = JOptionPane.showInputDialog(this, "Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible):");
        String tipoCompra = JOptionPane.showInputDialog(this, "Digite el tipo de Compra de la Obra:");
        String tipoObra = JOptionPane.showInputDialog(this, "Ingrese el tipo de la pieza:");

        if (nombreObra != null && autorObra != null && fecha != null && lugar != null && estado != null && valorPagoStr != null &&
                disponibilidad != null && tipoCompra != null && tipoObra != null) {
            try {
                float valorPago = Float.parseFloat(valorPagoStr);
                Pieza pieza = new Pieza(autorObra, nombreObra, fecha, lugar, estado, valorPago, disponibilidad, tipoCompra, tipoObra);
                Comprador comprador = new Comprador(usuario, "Comprador", "C134", "3211913008", 999999999, pieza);
                Random random = new Random();
                String id = String.valueOf(random.nextInt(10000));
                Pagos pago = new Pagos(id, valorPago, comprador, pieza, tipoCompra);
                Pagos.realizarPago(pago);
                JOptionPane.showMessageDialog(this, "Pago realizado con éxito");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valor de pago inválido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void consultarHistorialArtista() {
        String nombreArtista = JOptionPane.showInputDialog(this, "Digite el nombre del artista:");
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
                new MainWindowComprador().setVisible(true);
            }
        });
    }
}
