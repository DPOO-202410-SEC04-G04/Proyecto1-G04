package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pagos {
    //----------------------------------------------
    // CONSTANTS
    //----------------------------------------------


    //----------------------------------------------
    // ATTRIBUTES
    //----------------------------------------------

    private String id;

    private float valorPago;

    private Comprador comprador;
    
    private Pieza piezaComprada;
    
    private String formaPago;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    public Pagos(String ID, float VALORPAGO, Comprador comp, Pieza piezaComprada, String formaPago){
        //TODO: Constructor pagos
    	this.id = ID;
    	this.valorPago = VALORPAGO;
    	this.comprador = comp;
    	this.piezaComprada = piezaComprada;
    	this.formaPago = formaPago;
    }

    //----------------------------------------------
    // METHODS
    //----------------------------------------------
    
    
    public String getID()
    {
    	return this.id;
    }
    
    public float getValorPago()
    {
    	return this.valorPago;
    }
    
    public Comprador getComprador()
    {
    	return this.comprador;
    }
    
    public Pieza getPiezaComprada()
    {
    	return this.piezaComprada;
    }
    
    public void setID(String ID)
    {
    	this.id = ID;
    }
    
    public void setValorPago(float VALORPAGO)
    {
    	this.valorPago = VALORPAGO;
    }
    
    public void setComprador(Comprador comprador)
    {
    	this.comprador = comprador;
    }
    
    public void setPiezaComprada(Pieza PIEZA)
    {
    	this.piezaComprada = PIEZA;
    }
    
    public String getFormaPago()
    {
    	return this.formaPago;
    }
    public void setFormaPago(String forma)
    {
    	this.formaPago = formaPago;
    }
    
    public String lineaPagos()
    {
    	String texto = ";";
    	texto+="\n"+this.id+";"+String.valueOf(this.valorPago)+";"+this.comprador.getNombre()+";"+this.piezaComprada.getTitulo()+";"+this.formaPago;
    	return texto;
    }
    
    public static void realizarPago(Pagos pago) throws FileNotFoundException, IOException
    {
    	
    	float limite = pago.comprador.getValorMaxCompra();
    	float valorPieza = pago.piezaComprada.getPrecio();
    	float valorActual = pago.comprador.getTotalCompras();
    	
    	if((valorActual+valorPieza)>limite)
    	{
    		System.out.println("El valor de la compra excede el limite permitido");
    	}
    	else if(pago.getFormaPago().equals("Tarjeta de Credito")) {
    		List<String> pasarelas = cargarPasarelas();
            System.out.println("Seleccione una pasarela de pago:");
            for (int i = 0; i < pasarelas.size(); i++) {
                System.out.println((i + 1) + ". " + pasarelas.get(i));
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int seleccion = Integer.parseInt(reader.readLine());

            if (seleccion > 0 && seleccion <= pasarelas.size()) {
                String clasePasarela = pasarelas.get(seleccion - 1);
                try {
                    Class<?> clase = Class.forName(clasePasarela);
                    PasarelaPago pasarela = (PasarelaPago) clase.getDeclaredConstructor().newInstance();

                    System.out.print("Ingrese el número de la tarjeta: ");
                    long numeroTarjeta = Long.parseLong(reader.readLine());
                    System.out.print("Ingrese el código de seguridad: ");
                    int codigoSeguridad = Integer.parseInt(reader.readLine());
                    System.out.print("Ingrese la fecha de vencimiento (YYYY-MM-DD): ");
                    String fechaVencimiento = reader.readLine();

                    TarjetaDeCredito tarjeta = new TarjetaDeCredito(pago.getID(), valorPieza, pago.getComprador(), pago.getPiezaComprada(), "Tarjeta de credito", numeroTarjeta, codigoSeguridad, fechaVencimiento);
                    String numeroTransaccion = generarNumeroTransaccion();
                    boolean resultado = pasarela.procesarPago(tarjeta, valorPieza, numeroTransaccion);

                    if (resultado) {
                        pago.comprador.añadirPiezaHistorial(pago.getComprador());
                        Cajero.registrarPago(pago);
                        System.out.println("Pago realizado exitosamente");
                    } else {
                        System.out.println("El pago no fue aprobado por la pasarela");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error al procesar el pago con la pasarela seleccionada");
                }
            } else {
                System.out.println("Selección inválida");
            }
    	}
    	else
    	{
    		pago.comprador.añadirPiezaHistorial(pago.getComprador());;
    		Cajero.registrarPago(pago);
    		System.out.println("Pago realizado exitosamente");
    	}
    }
    
    private static List<String> cargarPasarelas() throws IOException {
        List<String> pasarelas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(".\\data\\pasarelas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                pasarelas.add(linea);
            }
        }
        return pasarelas;
    }

    private static String generarNumeroTransaccion() {
        return UUID.randomUUID().toString();
    }
    
    
    
    
}
