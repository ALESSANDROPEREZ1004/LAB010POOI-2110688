import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static final List<Paciente> listaPacientes = new ArrayList<>();
    private static final List<Medico> listaMedicos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar los datos de los pacientes");
            System.out.println("2. Eliminar los datos de un paciente");
            System.out.println("3. Modificar los datos de un paciente");
            System.out.println("4. Mostrar el peso que más se repite");
            System.out.println("5. Mostrar la cantidad de pacientes que tienen el peso que más se repite");
            System.out.println("6. Mostrar el peso mayor y menor");
            System.out.println("7. Dividir el rango de pesos por 4");
            System.out.println("8. Mostrar la lista de pacientes ordenados por apellidos");
            System.out.println("9. Dado un paciente, indicar qué doctor lo atendió");
            System.out.println("10. Buscar doctores por especialidad");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> registrarPaciente();
                case 2 -> eliminarPaciente();
                case 3 -> modificarPaciente();
                case 4 -> mostrarPesoMasRepite();
                case 5 -> mostrarCantidadPacientesPesoRepite();
                case 6 -> mostrarPesoMayorYMenor();
                case 7 -> dividirRangoPesos();
                case 8 -> mostrarListaPacientesOrdenados();
                case 9 -> mostrarDoctorQueAtendio();
                case 10 -> buscarDoctoresPorEspecialidad();
            }
        } while (opcion != 0);
    }


    private static void registrarPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese DNI del paciente:");
        String dni = scanner.next();
        System.out.println("Ingrese nombre del paciente:");
        String nombre = scanner.next();
        System.out.println("Ingrese dirección del paciente:");
        String direccion = scanner.next();
        System.out.println("Ingrese peso del paciente:");
        double peso = scanner.nextDouble();
        System.out.println("Ingrese temperatura del paciente:");
        double temperatura = scanner.nextDouble();
        Medico medico = null;


        Paciente paciente = new Paciente(dni, nombre, direccion, peso, temperatura, medico);
        listaPacientes.add(paciente);
        System.out.println("Paciente registrado con éxito.");
    }

    private static void eliminarPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la posición del paciente a eliminar:");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < listaPacientes.size()) {
            listaPacientes.remove(posicion);
            System.out.println("Paciente eliminado con éxito.");
        } else {
            System.out.println("Posición inválida.");
        }
    }

    private static void modificarPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la posición del paciente a modificar:");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < listaPacientes.size()) {
            Paciente paciente = listaPacientes.get(posicion);

            System.out.println("Ingrese nueva dirección del paciente:");
            String nuevaDireccion = scanner.next();
            System.out.println("Ingrese nuevo peso del paciente:");
            double nuevoPeso = scanner.nextDouble();
            System.out.println("Ingrese nueva temperatura del paciente:");
            double nuevaTemperatura = scanner.nextDouble();

            paciente.setDireccion(nuevaDireccion);
            paciente.setPeso(nuevoPeso);
            paciente.setTemperatura(nuevaTemperatura);

            System.out.println("Datos del paciente modificados con éxito.");
        } else {
            System.out.println("Posición inválida.");
        }
    }

    private static void mostrarPesoMasRepite() {
        Map<Double, Integer> frecuenciaPesos = new HashMap<>();
        for (Paciente paciente : listaPacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepite = Collections.max(frecuenciaPesos.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("El peso que más se repite es: " + pesoMasRepite);
    }

    private static void mostrarCantidadPacientesPesoRepite() {
        Map<Double, Integer> frecuenciaPesos = new HashMap<>();
        for (Paciente paciente : listaPacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepite = Collections.max(frecuenciaPesos.entrySet(), Map.Entry.comparingByValue()).getKey();
        int cantidadPacientes = frecuenciaPesos.get(pesoMasRepite);
        System.out.println("La cantidad de pacientes que tienen el peso que más se repite es: " + cantidadPacientes);
    }

    private static void mostrarPesoMayorYMenor() {
        if (listaPacientes.isEmpty()) {
            System.out.println("La lista de pacientes está vacía.");
            return;
        }

        double pesoMayor = Double.MIN_VALUE;
        double pesoMenor = Double.MAX_VALUE;

        for (Paciente paciente : listaPacientes) {
            double peso = paciente.getPeso();
            if (peso > pesoMayor) {
                pesoMayor = peso;
            }
            if (peso < pesoMenor) {
                pesoMenor = peso;
            }
        }

        System.out.println("El peso mayor en la lista es: " + pesoMayor);
        System.out.println("El peso menor en la lista es: " + pesoMenor);
    }

    private static void dividirRangoPesos() {
        if (listaPacientes.isEmpty()) {
            System.out.println("La lista de pacientes está vacía.");
            return;
        }

        double pesoMaximo = Collections.max(listaPacientes, Comparator.comparing(Paciente::getPeso)).getPeso();
        double pesoMinimo = Collections.min(listaPacientes, Comparator.comparing(Paciente::getPeso)).getPeso();

        double rango = (pesoMaximo - pesoMinimo) / 4;

        Map<Integer, Integer> conteoRangos = new HashMap<>();

        for (Paciente paciente : listaPacientes) {
            double peso = paciente.getPeso();
            int rangoActual = (int) ((peso - pesoMinimo) / rango) + 1;
            conteoRangos.put(rangoActual, conteoRangos.getOrDefault(rangoActual, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : conteoRangos.entrySet()) {
            System.out.println("Rango " + entry.getKey() + ": " + entry.getValue() + " pacientes");
        }
    }

    private static void mostrarListaPacientesOrdenados() {
        if (listaPacientes.isEmpty()) {
            System.out.println("La lista de pacientes está vacía.");
            return;
        }

        List<Paciente> listaOrdenada = new ArrayList<>(listaPacientes);

        for (Paciente paciente : listaOrdenada) {
            System.out.println(paciente);
        }
    }

    private static void mostrarDoctorQueAtendio() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del paciente:");
        String dniPaciente = scanner.next();

        for (Paciente paciente : listaPacientes) {
            if (paciente.getDNI().equals(dniPaciente)) {
                System.out.println("El paciente fue atendido por el Dr. " + paciente.getMedico().getNombre());
                return;
            }
        }

        System.out.println("Paciente no encontrado.");
    }

    private static void buscarDoctoresPorEspecialidad() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la especialidad a buscar:");
        String especialidadBuscar = scanner.next();

        List<Medico> doctoresEncontrados = new ArrayList<>();

        for (Medico medico : listaMedicos) {
            if (medico.getEspecialidad().equalsIgnoreCase(especialidadBuscar)) {
                doctoresEncontrados.add(medico);
            } else {
            }
        }

        if (doctoresEncontrados.isEmpty()) {
            System.out.println("No se encontraron doctores con esa especialidad.");
        } else {
            System.out.println("Doctores encontrados:");
            for (Medico doctor : doctoresEncontrados) {
                System.out.println(doctor);
            }
        }
    }
}