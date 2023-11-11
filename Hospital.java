
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jherr
 */
public class Hospital {
    
    private List<Paciente> pacientes;
    private List<Medico> doctores;

    public Hospital() {
        this.pacientes = new ArrayList<>();
        this.doctores = new ArrayList<>();
    }
    
    
    public void registrarPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del paciente:");
        int DNI = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después del nextInt
        System.out.println("Ingrese el nombre del paciente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la dirección del paciente:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese la dirección del paciente:");
    }
    
    
}
