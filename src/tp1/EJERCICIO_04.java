package tp1;

import java.util.Scanner;

public class EJERCICIO_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // d) Crear instancia
        Paciente paciente = new Paciente();
    
        System.out.println("--- REGISTRO DE PACIENTE ---");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine();

        // e) Validar peso y altura
        double peso = solicitarDoublePositivo(scanner, "Ingrese el peso (kg): ");
        double altura = solicitarDoublePositivo(scanner, "Ingrese la altura (m): ");

        // f) Establecer valores
        paciente.setNombre(nombre);
        paciente.setDni(dni);
        paciente.setPeso(peso);
        paciente.setAltura(altura);

        // g) Mostrar resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("DNI: " + paciente.getDni());
        System.out.printf("IMC: %.2f%n", paciente.calcularIMC());
        System.out.println("Estado Nutricional: " + paciente.obtenerEstadoNutricional());

        scanner.close();
    }

    private static double solicitarDoublePositivo(Scanner scanner, String mensaje) {
        double valor = 0;
        while (valor <= 0) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor <= 0) System.out.println("Error: El valor debe ser mayor a 0.");
            } else {
                System.out.println("Error: Ingrese un valor numérico válido.");
                scanner.next(); 
            }
        }
        return valor;
    }
}