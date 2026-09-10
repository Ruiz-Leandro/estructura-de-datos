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


// RESPUESTAS 

// a) Los valores de entrada son las dimensiones del cilindro  (radio y altura) que el usuario ingresa por consola.)
// y los de salida son el volumen y el área de la superficie del cilindro
// las informaciones que deben mantenerse durante toda la ejecucion las dimensiones del cilindro
// y la informcion que solo son temporales son los valores de entrada y salida que se muestran en la consola

// b) Lo que ocurre si el usuario ingresa valores negativos es que el programa le pedirá nuevamente que ingrese un valor positivo
// tambien garantizamos que el valor ingresado sea numerico con el metodo hasNextDouble()

// c) se muestra en el programa

// d) Implementar los cálculos de volumen y área como métodos en la clase Cilindro tiene ventajas como:
// encapsulamiento, reutilización de código y mantenimiento más sencillo.


