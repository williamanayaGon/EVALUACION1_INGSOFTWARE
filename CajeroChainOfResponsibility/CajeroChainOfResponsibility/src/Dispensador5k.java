// src/Dispensador5k.java

public class Dispensador5k implements IDispensador {
    private IDispensador next; 
    private final int DENOMINACION = 5000;

    @Override
    public void setNext(IDispensador next) {
        this.next = next;
    }

    @Override
    public void dispensar(int monto) {
        if (monto >= DENOMINACION) {
            int numBilletes = monto / DENOMINACION;
            int restante = monto % DENOMINACION;
            System.out.println("Dispensando " + numBilletes + " billete(s) de $" + DENOMINACION);

            
            if (restante > 0) {
                System.out.println("Error: No se puede dispensar el resto de $" + restante);
            }
        } else if (this.next != null) {

            this.next.dispensar(monto);
        }
    }
}