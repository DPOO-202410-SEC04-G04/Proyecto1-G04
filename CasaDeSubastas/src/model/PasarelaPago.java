package model;

public interface PasarelaPago {
	boolean procesarPago(TarjetaDeCredito tarjeta, float monto, String numeroTransaccion) throws Exception;
}
