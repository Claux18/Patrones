// Interfaz Strategy
interface MetodoPago {
    void pagar(double cantidad);
}
// Estrategia 1: Pago con tarjeta
class PagoTarjeta implements MetodoPago {
    @Override
    public void pagar(double cantidad) {
        System.out.println("Pago realizado con tarjeta por $" + cantidad);
    }
}
// Estrategia 2: Pago con PayPal
class PagoPayPal implements MetodoPago {

    @Override
    public void pagar(double cantidad) {
        System.out.println("Pago realizado con PayPal por $" + cantidad);
    }
}
// Estrategia 3: Transferencia bancaria
class PagoTransferencia implements MetodoPago {

    @Override
    public void pagar(double cantidad) {
        System.out.println("Pago realizado por transferencia por $" + cantidad);
    }
}
// Clase contexto
class ProcesadorPago {
    private MetodoPago metodoPago;

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void procesarPago(double cantidad) {
        metodoPago.pagar(cantidad);
    }
}
// Clase principal
public class MainStrategy {
    public static void main(String[] args) {

        ProcesadorPago pago = new ProcesadorPago();

        // Cliente paga con tarjeta
        pago.setMetodoPago(new PagoTarjeta());
        pago.procesarPago(600);

        // Cliente paga con PayPal
        pago.setMetodoPago(new PagoPayPal());
        pago.procesarPago(450);

        // Cliente paga con transferencia
        pago.setMetodoPago(new PagoTransferencia());
        pago.procesarPago(900);
    }
}