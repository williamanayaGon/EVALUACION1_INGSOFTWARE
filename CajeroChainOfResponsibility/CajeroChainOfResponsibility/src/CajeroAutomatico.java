import java.util.Scanner;

public class CajeroAutomatico {

    private final IDispensador primerManejador;

    public CajeroAutomatico() {
        
        IDispensador d100k = new Dispensador100k();
        IDispensador d50k = new Dispensador50k();
        IDispensador d20k = new Dispensador20k();
        IDispensador d10k = new Dispensador10k();
        IDispensador d5k = new Dispensador5k();

        d100k.setNext(d50k);
        d50k.setNext(d20k);
        d20k.setNext(d10k);
        d10k.setNext(d5k);

        this.primerManejador = d100k;
    }

    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico();
        
        Scanner scanner = new Scanner(System.in);
        
        
        while (true) {
            System.out.println("\n==============================================");
            System.out.println("==        CAJERO AUTOMÁTICO VIRTUAL       ==");
            System.out.println("==============================================");
            System.out.println("1. Realizar un retiro");
            System.out.println("2. Salir");
            System.out.println("==============================================");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.next(); 
                continue; 
            }

            
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese la cantidad a retirar: ");
                    try {
                        int monto = scanner.nextInt();
                        if (monto <= 0) {
                            System.out.println("Error: La cantidad debe ser un valor positivo.");
                            continue;
                        }

                        if (monto % 5000 != 0) {
                            System.out.println("Error: La cantidad debe ser un múltiplo de 5.000.");
                        } else {
                            System.out.println("\nProcesando su solicitud de $" + monto + "...");
                            cajero.primerManejador.dispensar(monto);
                            System.out.println("\nRetiro completado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Cantidad inválida. Por favor, ingrese un número.");
                        scanner.next(); 
                    }
                    break; 

                case 2:
                    System.out.println("\nGracias por usar el Cajero Automático Virtual. ¡Hasta pronto!");
                    scanner.close(); 
                    System.exit(0); 
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}