import java.util.ArrayList;
import java.util.Scanner;

public class Problema2_Calificaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        String opcionEst;
        System.out.println("---CALIFICACIONES---");

        do {
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombreEst = sc.nextLine();
            System.out.print("Ingrese la edad del estudiante: ");
            int edadEst = Integer.parseInt(sc.nextLine());
            Estudiante estudiante = new Estudiante(nombreEst, edadEst);

            String opcionMat;
            do {
                System.out.print("Ingrese el nombre de la materia: ");
                String nombreMat = sc.nextLine();
                System.out.print("Ingrese la calificación ACD (sobre 3.5): ");
                double acd = Double.parseDouble(sc.nextLine());
                System.out.print("Ingrese la calificación APE (sobre 3.5): ");
                double ape = Double.parseDouble(sc.nextLine());
                System.out.print("Ingrese la calificación AA (sobre 3): ");
                double aa = Double.parseDouble(sc.nextLine());

                Materia materia = new Materia(nombreMat, acd, ape, aa);
                estudiante.agregarMateria(materia);

                System.out.print("¿Desea agregar otra materia a este estudiante? (s/n): ");
                opcionMat = sc.nextLine();
            } while (opcionMat.equalsIgnoreCase("s"));

            estudiante.verificarAprobacion(sc);
            estudiantes.add(estudiante);

            System.out.print("¿Desea agregar otro estudiante? (s/n): ");
            opcionEst = sc.nextLine();
        } while (opcionEst.equalsIgnoreCase("s"));

        sc.close();
    }
}

class Estudiante {
    public String nombre;
    public int edad;
    public ArrayList<Materia> materias;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.materias = new ArrayList<>();
    }

    public void agregarMateria(Materia materia) {
        this.materias.add(materia);
    }

    public void verificarAprobacion(Scanner sc) {
        if (materias.isEmpty()) {
            System.out.println("\nERROR. No hay materias asignadas.");
            return;
        }
        System.out.println("---VERIFICACION---");
        System.out.println("Estudiante: " + nombre);
        for (Materia materia : materias) {
            System.out.println("-----------------------------------");
            System.out.println("Materia: " + materia.getNombre());
            if (materia.estaAprobado()) {
                System.out.println("¡Aprobado! Calificación final: " + materia.getTotal() + "/10");
            } else {
                System.out.println("NO aprobado. Debe rendir examen de recuperación.");
                System.out.print("Ingrese la nota del examen de recuperación (sobre 3.5): ");
                double recuperacion = Double.parseDouble(sc.nextLine());
                double notaFinal = materia.get60Porciento() + recuperacion;
                if (notaFinal >= 7) {
                    System.out.println("\n¡Aprobado en recuperación! Nota final: " + notaFinal + "/10");
                } else {
                    System.out.println("\nNo aprobado. Nota final: " + notaFinal + "/10");
                }
            }
        }
    }
}

class Materia {
    public String nombre;
    public double acd;
    public double ape;
    public double aa;

    public Materia(String nombre, double acd, double ape, double aa) {
        this.nombre = nombre;
        this.acd = acd;
        this.ape = ape;
        this.aa = aa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTotal() {
        return acd + ape + aa;
    }

    public boolean estaAprobado() {
        double total = getTotal();
        double porcentaje = (total / 10) * 100;
        return porcentaje >= 70;
    }

    public double get60Porciento() {
        return (getTotal() / 10) * 6;
    }
}