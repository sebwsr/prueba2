import java.util.Scanner;

public class Validaciones {
    private Scanner scanner = new Scanner(System.in);

    public Validaciones(Scanner scanner) {
        this.scanner = scanner;
    }

     public int pedirOpcionMenu(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            if (entrada.matches("\\d+")) {
                int opcion = Integer.parseInt(entrada);
                if (opcion >= min && opcion <= max) {
                    return opcion;
                }
            }
            System.out.printf("Opción no válida. Ingrese un número del %d al %d.%n", min, max);
        }
    }

    public String pedirNombre(String mensaje) {
        String nombre;
        do {
            System.out.print(mensaje);
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (nombre.isEmpty());
        return nombre;
    }

    public String pedirCorreo() {
        String correo;
        do {
            System.out.print("Ingrese el correo electrónico: ");
            correo = scanner.nextLine().trim();
            if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Correo no válido. Intente de nuevo.");
            }
        } while (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
        return correo;
    }

    public int pedirEnteroPositivo(String mensaje) {
        int numero = -1;
        while (numero <= 0) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                if (numero <= 0) {
                    System.out.println("Debe ingresar un número mayor que cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debe ingresar un número.");
            }
        }
        return numero;
    }

    public double pedirDoublePositivo(String mensaje) {
        double numero = -1;
        while (numero <= 0) {
            System.out.print(mensaje);
            try {
                numero = Double.parseDouble(scanner.nextLine());
                if (numero <= 0) {
                    System.out.println("El número debe ser mayor que cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debe ingresar un número decimal.");
            }
        }
        return numero;
    }
}
