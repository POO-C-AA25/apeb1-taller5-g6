import java.util.ArrayList;
import java.util.Scanner;

public class Problema3_Empresa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la empresa: ");
        String nombreEmp = sc.nextLine();
        System.out.print("Ingrese el RUC de la empresa: ");
        String ruc = sc.nextLine();
        System.out.print("Ingrese la dirección de la empresa: ");
        String direccion = sc.nextLine();

        Empresa empresa = new Empresa(nombreEmp, ruc, direccion);

        String opcion;
        do {
            System.out.print("\nIngrese el nombre del departamento: ");
            String nombreDep = sc.nextLine();
            System.out.print("Ingrese el número de empleados: ");
            int empleados = Integer.parseInt(sc.nextLine());
            System.out.print("Ingrese la producción anual: ");
            double produccion = Double.parseDouble(sc.nextLine());

            Departamento dep = new Departamento(nombreDep, empleados, produccion);
            empresa.agregarDepartamento(dep);

            System.out.print("¿Desea agregar otro departamento? (s/n): ");
            opcion = sc.nextLine();
        } while (opcion.equalsIgnoreCase("s"));

        empresa.mostrarDepartamentos();
        sc.close();
    }
}

class Empresa {
    private String nombre;
    private String ruc;
    private String direccion;
    private ArrayList<Departamento> departamentos;

    public Empresa(String nombre, String ruc, String direccion) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Departamento d) {
        departamentos.add(d);
    }

    public void mostrarDepartamentos() {
        System.out.println("\n--- Empresa: " + nombre + " ---");
        for (Departamento d : departamentos) {
            System.out.println(d);
        }
    }
}

class Departamento {
    private String nombre;
    private int numEmpleados;
    private double produccionAnual;
    private String categoria;

    public Departamento(String nombre, int numEmpleados, double produccionAnual) {
        this.nombre = nombre;
        this.numEmpleados = numEmpleados;
        this.produccionAnual = produccionAnual;
        this.categoria = categorizar();
    }

    private String categorizar() {
        if (numEmpleados > 20 && produccionAnual > 1_000_000) {
            return "A";
        } else if (numEmpleados >= 20 && produccionAnual >= 1_000_000) {
            return "B";
        } else if (numEmpleados >= 10 && produccionAnual >= 500_000) {
            return "C";
        } else {
            return "Sin categoría";
        }
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre +
               "\nEmpleados: " + numEmpleados +
               "\nProducción anual: $" + produccionAnual +
               "\nCategoría: " + categoria + "\n";
    }
}