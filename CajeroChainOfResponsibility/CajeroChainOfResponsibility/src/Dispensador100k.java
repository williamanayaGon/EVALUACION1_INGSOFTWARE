// src/Dispensador100k.java

public class Dispensador100k implements IDispensador {
    private IDispensador next;
    private final int DENOMINACION = 100000;

    @Override
    public void setNext(IDispensador next) {
        this.next = next;
    }

    @Override
    public void dispensar(int monto) {
        // Decide si puede procesar la solicitud. 
        if (monto >= DENOMINACION) {
            int numBilletes = monto / DENOMINACION;
            int restante = monto % DENOMINACION;
            System.out.println("Dispensando " + numBilletes + " billete(s) de $" + DENOMINACION);

            // Si hay un resto, la pasa al siguiente manejador de la cadena. 
            if (restante > 0 && this.next != null) {
                this.next.dispensar(restante);
            }
        } else if (this.next != null) {
            // Si no puede procesar, pasa la solicitud completa al siguiente. 
            this.next.dispensar(monto);
        }
    }
}