package tp1;
// Archivo: MainEjercicio1.java
import java.util.Scanner;

public class EJERCICIO_01 { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // e) Crear una única instancia
        Cilindro cilindro = new Cilindro();

        // f) Pedir datos validados
        double radio = solicitarNumeroPositivo(scanner, "Ingrese el radio (mayor a 0): ");
        double altura = solicitarNumeroPositivo(scanner, "Ingrese la altura (mayor a 0): ");

        // g) Establecer dimensiones con setters
        cilindro.setRadio(radio);
        cilindro.setAltura(altura);

        // h) Mostrar resultados formateados a 2 decimales
        System.out.printf("Volumen del cilindro: %.2f%n", cilindro.calcularVolumen());
        System.out.printf("Área de la superficie: %.2f%n", cilindro.calcularArea());

        scanner.close();
    }

    // Método auxiliar para modularizar y validar el Scanner por consola
    private static double solicitarNumeroPositivo(Scanner scanner, String mensaje) {
        double valor = 0;
        while (valor <= 0) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("Error: El número debe ser estrictamente mayor a 0.");
                }
            } else {
                System.out.println("Error: Entrada no válida. Ingrese un número.");
                scanner.next(); // Limpia la entrada errónea
            }
        }
        return valor;
    }
}
