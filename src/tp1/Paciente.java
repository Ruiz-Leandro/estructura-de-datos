package tp1;

public class Paciente {
    private String nombre;
    private String dni;
    private double peso;   // en kilogramos
    private double altura; // en metros

    // a) Métodos Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public double getAltura() { return altura; }
    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        }
    }

    // b) Método para calcular el IMC
    public double calcularIMC() {
        if (this.altura == 0) return 0; // Evitar división por cero
        return this.peso / (this.altura * this.altura);
    }

    // c) Método para obtener el estado nutricional
    public String obtenerEstadoNutricional() {
        double imc = calcularIMC();
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc < 25.0) {
            return "Normal";
        } else if (imc >= 25 && imc < 30.0) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}