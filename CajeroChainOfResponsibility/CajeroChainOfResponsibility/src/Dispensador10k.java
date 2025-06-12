// src/Dispensador10k.java

public class Dispensador10k implements IDispensador {
    private IDispensador next;
    private final int DENOMINACION = 10000;

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

            if (restante > 0 && this.next != null) {
                this.next.dispensar(restante);
            }
        } else if (this.next != null) {
            this.next.dispensar(monto);
        }
    }
}