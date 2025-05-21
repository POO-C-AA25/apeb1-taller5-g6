import java.util.ArrayList;
import java.util.Scanner;

public class Problema5_SistemaConflictos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ConflictoInternacional> conflictos = new ArrayList<>();

        System.out.println("--- APP SISTEMA DE CONFLICTOS INTERNACIONALES ---");

        String opcion;
        do {
            System.out.print("Nombre del conflicto: ");
            String nombre = sc.nextLine();

            System.out.print("Fecha de inicio (AAAA-MM-DD): ");
            String fechaInicio = sc.nextLine();

            System.out.print("Detalles del conflicto: ");
            String detalles = sc.nextLine();

            ConflictoInternacional conflicto = new ConflictoInternacional(nombre, fechaInicio, detalles);

        
            String opcionPais;
            do {
                System.out.print("Nombre del pais involucrado: ");
                String pais = sc.nextLine();
                conflicto.agregarPais(pais);

                System.out.print("Agregar otro pais? (s/n): ");
                opcionPais = sc.nextLine();
            } while (opcionPais.equalsIgnoreCase("s"));

            String opcionEvento;
            do {
                System.out.println("\n--- Agregar evento ---");
                System.out.print("Nombre del evento: ");
                String nombreEvento = sc.nextLine();

                System.out.print("Fecha del evento (AAAA-MM-DD): ");
                String fechaEvento = sc.nextLine();

                System.out.print("Ubicación del evento: ");
                String ubicacion = sc.nextLine();

                System.out.print("Descripción del evento: ");
                String descripcion = sc.nextLine();

                System.out.print("Tipo de evento (batalla, tratado, reunion, etc.): ");
                String tipo = sc.nextLine();

                boolean armasNucleares = false;
                int bajas = 0;

                if (tipo.equalsIgnoreCase("batalla")) {
                    System.out.print("¿Se usaron armas nucleares? (s/n): ");
                    armasNucleares = sc.nextLine().equalsIgnoreCase("s");

                    System.out.print("Número de bajas causadas: ");
                    bajas = Integer.parseInt(sc.nextLine());
                }

                Evento evento = new Evento(nombreEvento, fechaEvento, ubicacion, descripcion, tipo, armasNucleares, bajas);
                conflicto.agregarEvento(evento);

                System.out.print("¿Agregar otro evento? (s/n): ");
                opcionEvento = sc.nextLine();
            } while (opcionEvento.equalsIgnoreCase("s"));

            conflicto.actualizarEstado();

            conflictos.add(conflicto);

            System.out.print("\n¿Desea registrar otro conflicto? (s/n): ");
            opcion = sc.nextLine();
        } while (opcion.equalsIgnoreCase("s"));

        System.out.println("\n--- CONFLICTOS REGISTRADOS ---");
        for (ConflictoInternacional c : conflictos) {
            c.mostrarResumen();
        }

        sc.close();
    }
}

class ConflictoInternacional {
    public String nombre;
    public String fechaInicio;
    public String estado;
    public String detalles;
    public ArrayList<String> paisesInvolucrados;
    public ArrayList<Evento> eventos;

    public ConflictoInternacional(String nombre, String fechaInicio, String detalles) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.detalles = detalles;
        this.estado = "Activo";
        this.paisesInvolucrados = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public void agregarPais(String pais) {
        paisesInvolucrados.add(pais);
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void actualizarEstado() {
        int totalPaises = 195;  
        int primerMundo = 30;   

        int batallas = 0;
        int batallasPrimerMundoConNucleares = 0;
        int bajasAltas = 0;

        for (Evento e : eventos) {
            if (e.tipo.equalsIgnoreCase("batalla")) {
                batallas++;

                boolean enPrimerMundo = paisesInvolucrados.contains(e.ubicacion) && primerMundo > 0;
                if (enPrimerMundo && e.armasNucleares) {
                    batallasPrimerMundoConNucleares++;
                }

                if (e.bajas >= 50) {  
                    bajasAltas++;
                }
            }
        }

        double porcentajeBatallas = (double)batallas / totalPaises;

        if (batallasPrimerMundoConNucleares > 0) {
            estado = "Guerra mundial";
        } else if (porcentajeBatallas > 0.5) {
            estado = "Guerra mundial";
        } else if (porcentajeBatallas >= 0.3 && porcentajeBatallas <= 0.5) {
            estado = "Reunión urgente ONU";
        } else if (bajasAltas > 0) {
            estado = "Reunión urgente ONU";
        } else {
            estado = "Activo";
        }
    }

    public void mostrarResumen() {
        System.out.println("\nConflicto: " + nombre);
        System.out.println("Fecha inicio: " + fechaInicio);
        System.out.println("Estado: " + estado);
        System.out.println("Detalles: " + detalles);
        System.out.println("Países involucrados: " + paisesInvolucrados);
        System.out.println("Eventos asociados:");
        for (Evento e : eventos) {
            e.mostrarInfo();
        }
    }
}

class Evento {
    public String nombre;
    public String fecha;
    public String ubicacion;
    public String descripcion;
    public String tipo; 
    public boolean armasNucleares;
    public int bajas;

    public Evento(String nombre, String fecha, String ubicacion, String descripcion, String tipo, boolean armasNucleares, int bajas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.armasNucleares = armasNucleares;
        this.bajas = bajas;
    }

    public void mostrarInfo() {
        System.out.println(" - Evento: " + nombre + " | Fecha: " + fecha + " | Lugar: " + ubicacion);
        System.out.println("   Tipo: " + tipo + " | Descripción: " + descripcion);
        if (tipo.equalsIgnoreCase("batalla")) {
            System.out.println("   Armas nucleares: " + (armasNucleares ? "Sí" : "No") + " | Bajas: " + bajas);
        }
    }
}
