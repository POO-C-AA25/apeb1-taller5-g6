import java.util.ArrayList;
import java.util.Scanner;

public class Problema4_Fiscalia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CasoCorrupcion> casos = new ArrayList<>();

        System.out.println("--- APP FISCALIA ---");

        String opcion;
        do {
            System.out.print("Nombre del caso: ");
            String nombre = sc.nextLine();

            System.out.print("Fecha de inicio (AAAA-MM-DD): ");
            String fechaInicio = sc.nextLine();

            System.out.print("Detalles del caso: ");
            String detalles = sc.nextLine();

            CasoCorrupcion caso = new CasoCorrupcion(nombre, fechaInicio, detalles);

            String opcionPersona;
            do {
                System.out.println("\n--- Agregar persona implicada ---");
                System.out.print("Nombre: ");
                String nombreP = sc.nextLine();

                System.out.print("Edad: ");
                int edad = Integer.parseInt(sc.nextLine());

                System.out.print("Ocupacion: ");
                String ocupacion = sc.nextLine();

                System.out.print("Nivel de implicacion (acusado, testigo, victima): ");
                String nivel = sc.nextLine();

                PersonaImplicada p = new PersonaImplicada(nombreP, edad, ocupacion, nivel);

                if (nivel.equalsIgnoreCase("acusado")) {
                    System.out.print("Desea colaborar con la justicia? (s/n): ");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        p.colaborar();
                        System.out.print("Ingrese los anios de condena: ");
                        double sentencia = Double.parseDouble(sc.nextLine());
                        p.reducirPena(sentencia);

                        if (sentencia < 1) {
                            System.out.print("Ingrese danio economico causado al Estado: ");
                            double dano = Double.parseDouble(sc.nextLine());
                            double fianza = p.pagarFianza(dano);
                            if (fianza >= 0) {
                                System.out.println("Fianza aceptada. Monto a pagar: $" + fianza);
                            } else {
                                System.out.println("No cumple condiciones para pagar fianza.");
                            }
                        }
                    }
                }

                caso.agregarPersona(p);

                System.out.print("Agregar otra persona al caso? (s/n): ");
                opcionPersona = sc.nextLine();
            } while (opcionPersona.equalsIgnoreCase("s"));

            caso.actualizarEstado();
            casos.add(caso);

            System.out.print("\nDesea registrar otro caso? (s/n): ");
            opcion = sc.nextLine();
        } while (opcion.equalsIgnoreCase("s"));

        System.out.println("\n--- CASOS REGISTRADOS ---");
        for (CasoCorrupcion c : casos) {
            c.mostrarResumen();
        }

        sc.close();
    }
}
class CasoCorrupcion {
    public String nombre;
    public String fechaInicio;
    public String estado;
    public String detalles;
    public ArrayList<PersonaImplicada> personas;

    public CasoCorrupcion(String nombre, String fechaInicio, String detalles) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.detalles = detalles;
        this.estado = "Iniciado";
        this.personas = new ArrayList<>();
    }

    public void agregarPersona(PersonaImplicada p) {
        personas.add(p);
    }

    public void actualizarEstado() {
        int dias = calcularDiasDesdeInicio();
        if (dias > 14) {
            estado = "Urgente";
        } else if (dias > 7) {
            estado = "Alerta";
        }
    }

    private int calcularDiasDesdeInicio() {
        String[] partes = fechaInicio.split("-");
        int anio = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);

        java.util.Calendar hoy = java.util.Calendar.getInstance();
        java.util.Calendar inicio = java.util.Calendar.getInstance();
        inicio.set(anio, mes - 1, dia);

        long diferencia = hoy.getTimeInMillis() - inicio.getTimeInMillis();
        int dias = (int)(diferencia / (1000 * 60 * 60 * 24));
        return dias;
    }

    public void mostrarResumen() {
        System.out.println("\nCaso: " + nombre);
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Estado: " + estado);
        System.out.println("Detalles: " + detalles);
        System.out.println("Personas implicadas:");
        for (PersonaImplicada p : personas) {
            p.mostrarInfo();
        }
    }
}

class PersonaImplicada {
    public String nombre;
    public int edad;
    public String ocupacion;
    public String nivelImplicacion;
    public boolean colaborador;

    public PersonaImplicada(String nombre, int edad, String ocupacion, String nivel) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.nivelImplicacion = nivel;
        this.colaborador = false;
    }

    public void colaborar() {
        this.colaborador = true;
    }

    public void reducirPena(double sentencia) {
        if (colaborador) {
            double reducida = sentencia * 0.5;
            System.out.println("Pena reducida a: " + reducida + " años.");
        } else {
            System.out.println("No aplica reducción de pena.");
        }
    }

    public double pagarFianza(double danoEconomico) {
        if (colaborador) {
            return danoEconomico * 0.5;
        }
        return -1;
    }

    public void mostrarInfo() {
        System.out.println("- Nombre: " + nombre + ", Edad: " + edad + ", Ocupacion: " + ocupacion +
                ", Nivel: " + nivelImplicacion + ", Colaborador?: " + (colaborador ? "Si" : "No"));
    }
}
