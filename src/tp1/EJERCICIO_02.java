package tp1;

import java.util.Scanner;

public class EJERCICIO_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // f) y g) Crear una instancia de CuentaBancaria e inicializarla
        // Ejemplo del enunciado: "Juan Perez", 50000.0, "corriente"
        CuentaBancaria cuenta = new CuentaBancaria("Juan Perez", 50000.0, "corriente");

        System.out.println("¡Bienvenido al Sistema Bancario!");
        System.out.println(cuenta.toString());
        System.out.println();

        // h) Menú interactivo de operaciones que se repite hasta que el usuario decida salir
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    double montoDeposito = leerDoublePositivo(scanner, "Ingrese el monto a depositar: ");
                    cuenta.depositar(montoDeposito);
                    break;

                case 2:
                    double montoRetiro = leerDoublePositivo(scanner, "Ingrese el monto a retirar: ");
                    cuenta.retirar(montoRetiro);
                    break;

                case 3:
                    System.out.println("\nEstado actual de la cuenta:");
                    System.out.println(cuenta.toString());
                    break;

                case 4:
                    System.out.println("Gracias por utilizar nuestros servicios bancarios. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }

            // Mostrar el resumen de la cuenta tras realizar un depósito o retiro
            if (opcion == 1 || opcion == 2) {
                System.out.println("\nEstado actualizado:");
                System.out.println(cuenta.toString());
            }

            System.out.println();

        } while (opcion != 4);

        scanner.close();
    }

    // --- MÉTODOS AUXILIARES PARA LEER Y VALIDAR DATOS POR CONSOLA ---

    private static void mostrarMenu() {
        System.out.println("        MENÚ DE OPCIONES         ");
        System.out.println("=================================");
        System.out.println("1. Depositar dinero");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Ver datos de la cuenta");
        System.out.println("4. Salir");
    }

    /**
     * Lee un número entero validando que no ocurran errores de formato en Scanner.
     */
    private static int leerEntero(Scanner scanner, String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                valido = true;
            } else {
                System.out.println("Error: Por favor ingrese un número entero válido.");
                scanner.next(); // Limpia el buffer del scanner
            }
        }
        return valor;
    }

    /**
     * Lee un número decimal (double) validando que sea mayor a cero.
     */
    private static double leerDoublePositivo(Scanner scanner, String mensaje) {
        double valor = 0.0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor > 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El monto debe ser estrictamente mayor a 0.");
                }
            } else {
                System.out.println("Error: Ingrese un valor numérico válido (ej. 1500.50).");
                scanner.next(); // Limpia la entrada errónea
            }
        }
        return valor;
    }
}
