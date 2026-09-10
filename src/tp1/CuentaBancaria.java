package tp1;

// Archivo: CuentaBancaria.java

public class CuentaBancaria {
    // Atributos privados (Encapsulamiento: solo la clase puede acceder directamente a ellos)
    private String titular;
    private double saldo;
    private String tipoCuenta;

    /**
     * a) Constructor predeterminado:
     * Inicializa el titular con "Invitado", saldo en 0 y tipoCuenta en "ahorro".
     */
    public CuentaBancaria() {
        this.titular = "Invitado";
        this.saldo = 0.0;
        this.tipoCuenta = "ahorro";
    }
    /**
     * b) Constructor con argumentos:
     * Permite establecer el titular, saldo inicial y tipo de cuenta al instanciar el objeto.
     */
    public CuentaBancaria(String titular, double saldoInicial, String tipoCuenta) {
        this.titular = titular;
        // Validamos que el saldo inicial no sea negativo
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0.0;
            System.out.println("Advertencia: El saldo inicial no puede ser negativo. Se asignó 0.0.");
        }
        this.tipoCuenta = tipoCuenta;
    }

    // Getters para consultar los datos si fuera necesario
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * c) Método depositar:
     * Simula la adición de fondos a la cuenta. Valida que el monto sea estrictamente positivo.
     */
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println(" Depósito de $" + String.format("%.2f", monto) + " realizado con éxito.");
        } else {
            System.out.println("Error: El monto a depositar debe ser mayor a cero.");
        }
    }

    /**
     * d) Método retirar:
     * Simula la extracción de dinero. Disminuye el saldo y retorna true si la operación es exitosa.
     * Si el monto excede el saldo o es <= 0, muestra error por consola y retorna false.
     */
    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println(" Error: El monto a retirar debe ser mayor a cero.");
            return false;
        }
        
        if (monto > this.saldo) {
            System.out.println(" Error: Saldo insuficiente. Saldo disponible: $" + String.format("%.2f", this.saldo));
            return false;
        }

        this.saldo -= monto;
        System.out.println("Retiro exitoso por el monto de: $" + String.format("%.2f", monto));
        return true;
    }

    /**
     * e) Método toString():
     * Imprime/retorna el titular, tipo de cuenta y saldo actual formateado a 2 decimales.
     */
    @Override
    public String toString() {
        return String.format("--- DETALLES DE LA CUENTA ---\n" +
                             "Titular: %s\n" +
                             "Tipo de Cuenta: %s\n" +
                             "Saldo Actual: $%.2f\n"  ,
                            
                            this.titular, this.tipoCuenta, this.saldo);
    }
}

