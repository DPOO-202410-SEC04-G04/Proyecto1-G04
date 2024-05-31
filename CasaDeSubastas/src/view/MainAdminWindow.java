package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Administrador;
import model.Comprador;
import model.Galeria;

public class MainAdminWindow extends JFrame {
    private JTextField usuarioField;
    private JPasswordField contrasenaField;

    public MainAdminWindow() {
        setTitle("Galería de Arte - Administración");
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
                        showAdminMenu();
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
        String archivo = ".\\data\\PersistenciaAdmins.txt";
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

    private void showAdminMenu() {
        getContentPane().removeAll();
        revalidate();
        repaint();
        
        JPanel menuPanel = new JPanel(new GridLayout(8, 1));
        
        JButton btnRegistrarPieza = new JButton("Registrar Pieza");
        btnRegistrarPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					registrarPieza();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        menuPanel.add(btnRegistrarPieza);
        
        JButton btnAumentarLimite = new JButton("Aumentar Límite de Compras");
        btnAumentarLimite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarLimiteCompras();
            }
        });
        menuPanel.add(btnAumentarLimite);
        
        JButton btnVerHistoriaComprador = new JButton("Ver Historia Comprador");
        btnVerHistoriaComprador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					verHistoriaComprador();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        menuPanel.add(btnVerHistoriaComprador);
        
        JButton btnRegistrarComprador = new JButton("Registrar Comprador");
        btnRegistrarComprador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarComprador();
            }
        });
        menuPanel.add(btnRegistrarComprador);
        
        JButton btnHistorialArtista = new JButton("Consultar Historial de un Artista");
        btnHistorialArtista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarHistorialArtista();
            }
        });
        menuPanel.add(btnHistorialArtista);
        
        JButton btnHistorialPieza = new JButton("Consultar Historial de una Pieza");
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

    private void registrarPieza() throws IOException {
        String[] options = {"Escultura", "Pintura", "Video", "Otro", "Volver"};
        int option = JOptionPane.showOptionDialog(this, "Seleccione tipo de Pieza a registrar:", "Registrar Pieza",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (option) {
            case 0: // Escultura
                registrarEscultura();
                break;
            case 1: // Pintura
                registrarPintura();
                break;
            case 2: // Video
                registrarVideo();
                break;
            case 3: // Otro
                registrarOtraPieza();
                break;
            default: // Volver
                break;
        }
    }

    private void registrarEscultura() throws IOException {
        Galeria galeria = new Galeria("Uniandes");

		String nombreObra = JOptionPane.showInputDialog(this, "Digite el nombre de la Obra:");
		String autorObra = JOptionPane.showInputDialog(this, "Digite el autor de la Obra:");
		String fecha = JOptionPane.showInputDialog(this, "Digite la fecha de la Obra (dd/mm/YYYY):");
		String lugar = JOptionPane.showInputDialog(this, "Digite el lugar de la Obra:");
		String estado = JOptionPane.showInputDialog(this, "Digite el estado de la Obra:");
		String precio = JOptionPane.showInputDialog(this, "Digite el precio de la Obra:");
		String disponibilidad = JOptionPane.showInputDialog(this, "Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible):");
		String tipoCompra = JOptionPane.showInputDialog(this, "Digite el tipo de Compra de la Obra:");
		String tipoPieza = "Escultura";
		String dimensiones = JOptionPane.showInputDialog(this, "Digite las dimensiones (Formato: AltoxAnchoxProfundidad) de la Obra:");
		String materiales = JOptionPane.showInputDialog(this, "Digite los materiales de la Obra:");
		String peso = JOptionPane.showInputDialog(this, "Digite el peso de la Obra en kilogramos:");
		String necesidadElectricidad = JOptionPane.showInputDialog(this, "¿Necesita de electricidad? (true/false):");
		String tipoArte = JOptionPane.showInputDialog(this, "Digite el tipo de Arte de la Obra:");
		String detallesAdicionales = JOptionPane.showInputDialog(this, "Digite detalles adicionales:");

		galeria.addEscultura(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza, dimensiones, materiales, peso,
		        Boolean.parseBoolean(necesidadElectricidad), tipoArte, detallesAdicionales);

		JOptionPane.showMessageDialog(this, "Se ha registrado la escultura con éxito");
    }

    private void registrarPintura() throws IOException {
        Galeria galeria = new Galeria("Uniandes");

		String nombreObra = JOptionPane.showInputDialog(this, "Digite el nombre de la Obra:");
		String autorObra = JOptionPane.showInputDialog(this, "Digite el autor de la Obra:");
		String fecha = JOptionPane.showInputDialog(this, "Digite la fecha de la Obra (dd/mm/YYYY):");
		String lugar = JOptionPane.showInputDialog(this, "Digite el lugar de la Obra:");
		String estado = JOptionPane.showInputDialog(this, "Digite el estado de la Obra:");
		String precio = JOptionPane.showInputDialog(this, "Digite el precio de la Obra:");
		String disponibilidad = JOptionPane.showInputDialog(this, "Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible):");
		String tipoCompra = JOptionPane.showInputDialog(this, "Digite el tipo de Compra de la Obra:");
		String tipoPieza = "Pintura";
		String dimensiones = JOptionPane.showInputDialog(this, "Digite las dimensiones (Formato: AltoxAnchoxProfundidad) de la Obra:");
		String detallesAdicionales = JOptionPane.showInputDialog(this, "Digite detalles adicionales:");

		galeria.addPintura(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza, dimensiones, detallesAdicionales);

		JOptionPane.showMessageDialog(this, "Se ha registrado la pintura con éxito");
    }

    private void registrarVideo() throws IOException {
        Galeria galeria = new Galeria("Uniandes");

		String nombreObra = JOptionPane.showInputDialog(this, "Digite el nombre de la Obra:");
		String autorObra = JOptionPane.showInputDialog(this, "Digite el autor de la Obra:");
		String fecha = JOptionPane.showInputDialog(this, "Digite la fecha de la Obra (dd/mm/YYYY):");
		String lugar = JOptionPane.showInputDialog(this, "Digite el lugar de la Obra:");
		String estado = JOptionPane.showInputDialog(this, "Digite el estado de la Obra:");
		String precio = JOptionPane.showInputDialog(this, "Digite el precio de la Obra:");
		String disponibilidad = JOptionPane.showInputDialog(this, "Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible):");
		String tipoCompra = JOptionPane.showInputDialog(this, "Digite el tipo de Compra de la Obra:");
		String tipoPieza = "Video";
		String duracion = JOptionPane.showInputDialog(this, "Digite la duración en segundos:");
		String espacioDeMemoria = JOptionPane.showInputDialog(this, "Digite el espacio de memoria de la Obra (en MB):");
		String detallesAdicionales = JOptionPane.showInputDialog(this, "Digite detalles adicionales:");

		galeria.addVideo(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza, Float.parseFloat(duracion), Float.parseFloat(espacioDeMemoria), detallesAdicionales);

		JOptionPane.showMessageDialog(this, "Se ha registrado el video con éxito");
    }

    private void registrarOtraPieza() throws IOException {
        Galeria galeria = new Galeria("Uniandes");

		String nombreObra = JOptionPane.showInputDialog(this, "Digite el nombre de la Obra:");
		String autorObra = JOptionPane.showInputDialog(this, "Digite el autor de la Obra:");
		String fecha = JOptionPane.showInputDialog(this, "Digite la fecha de la Obra (dd/mm/YYYY):");
		String lugar = JOptionPane.showInputDialog(this, "Digite el lugar de la Obra:");
		String estado = JOptionPane.showInputDialog(this, "Digite el estado de la Obra (Bodega/Exhibida):");
		String precio = JOptionPane.showInputDialog(this, "Digite el precio de la Obra:");
		String disponibilidad = JOptionPane.showInputDialog(this, "Digite la disponibilidad de la Obra (Vendida/Devuelta/Subastada/Disponible):");
		String tipoCompra = JOptionPane.showInputDialog(this, "Digite el tipo de Compra de la Obra (Efectivo/Transferencia electrónica/Tarjeta de crédito):");
		String tipoPieza = JOptionPane.showInputDialog(this, "Digite el tipo de pieza de la Obra:");

		galeria.addPieza(autorObra, nombreObra, fecha, lugar, estado, Float.parseFloat(precio), disponibilidad, tipoCompra, tipoPieza);

		JOptionPane.showMessageDialog(this, "Se ha registrado la pieza con éxito");
    }


    private void aumentarLimiteCompras() {
        String usuarioComprador = JOptionPane.showInputDialog(this, "Ingrese el usuario del comprador:");
        if (usuarioComprador != null && !usuarioComprador.isEmpty()) {
            Administrador.cambiarValorMaximoCompras(usuarioComprador);
            JOptionPane.showMessageDialog(this, "Límite de compras aumentado exitosamente");
        }
    }

    private void verHistoriaComprador() throws FileNotFoundException, IOException {
        String usuarioComprador = JOptionPane.showInputDialog(this, "Ingrese el usuario del comprador:");
        if (usuarioComprador != null && !usuarioComprador.isEmpty()) {
            ArrayList<String[]> historial = Comprador.historialCompleto(usuarioComprador);
            StringBuilder sb = new StringBuilder();
            for (String[] linea : historial) {
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
            JOptionPane.showMessageDialog(this, sb.toString(), "Historial de Comprador", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void registrarComprador() {
        String usuario = JOptionPane.showInputDialog(this, "Ingrese el usuario del comprador:");
        String clave = JOptionPane.showInputDialog(this, "Ingrese la clave del comprador:");
        String ID = JOptionPane.showInputDialog(this, "Ingrese el ID del comprador:");
        String cel = JOptionPane.showInputDialog(this, "Ingrese el celular del comprador:");
        String limite = JOptionPane.showInputDialog(this, "Ingrese el límite de compras del comprador:");
        
        if (usuario != null && clave != null && ID != null && cel != null && limite != null) {
            String archivo = ".\\data\\PersistenciaCompradores.txt";
            String linea = "\n" + usuario + ";" + clave + ";comprador;" + ID + ";" + cel + ";" + limite;
            Galeria.agregarlinea(archivo, linea);
            
            String nom = usuario.split("@")[0];
            String ruta = ".\\data\\Comprador" + nom + ".txt";
            
            File file = new File(ruta);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                    JOptionPane.showMessageDialog(this, "Comprador registrado exitosamente");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        String linea;
        StringBuilder sb = new StringBuilder();
        
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainAdminWindow().setVisible(true);
            }
        });
    }
}
