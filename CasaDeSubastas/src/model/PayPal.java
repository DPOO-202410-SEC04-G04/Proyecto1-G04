package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PayPal implements PasarelaPago {
    @Override
    public boolean procesarPago(TarjetaDeCredito tarjeta, float monto, String numeroTransaccion) throws Exception {
        // Lógica de procesamiento del pago simulada
        boolean aprobado = true; // Simulación de aprobación

        // Registro del resultado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PayPal.log", true))) {
            writer.write("Transacción: " + numeroTransaccion + ", Monto: " + monto + ", Aprobado: " + aprobado + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return aprobado;
    }
}
