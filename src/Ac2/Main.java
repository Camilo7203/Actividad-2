package Ac2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarJugador();
                    break;
                case 2:
                    buscarJugador();
                    break;
                case 3:
                    editarJugador();
                    break;
                case 4:
                    eliminarJugador();
                    break;
                case 5:
                    listarJugadores();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Agregar jugador");
        System.out.println("2. Buscar jugador");
        System.out.println("3. Editar jugador");
        System.out.println("4. Eliminar jugador");
        System.out.println("5. Listar jugadores");
        System.out.println("6. Salir");
        System.out.print("Elija una opción: ");
    }

    private static void agregarJugador() {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la posición del jugador: ");
        String posicion = scanner.nextLine();
        System.out.print("Ingrese la edad del jugador: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        Jugador jugador = new Jugador(nombre, posicion, edad);
        jugadores.add(jugador);
        listarJugadores();
    }

    private static void buscarJugador() {
        System.out.print("Ingrese el ID del jugador a buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Jugador jugador = encontrarJugadorPorId(id);
        if (jugador != null) {
            System.out.println(jugador);
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void editarJugador() {
        System.out.print("Ingrese el ID del jugador a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Jugador jugador = encontrarJugadorPorId(id);
        if (jugador != null) {
            System.out.print("Ingrese el nuevo nombre del jugador: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva posición del jugador: ");
            String posicion = scanner.nextLine();
            System.out.print("Ingrese la nueva edad del jugador: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); 
            jugador.setNombre(nombre);
            jugador.setPosicion(posicion);
            jugador.setEdad(edad);
            System.out.println("Jugador editado con éxito.");
            listarJugadores();
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void eliminarJugador() {
        System.out.print("Ingrese el ID del jugador a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        Jugador jugador = encontrarJugadorPorId(id);
        if (jugador != null) {
            System.out.print("¿Está seguro que desea eliminar al jugador? (s/n): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                jugadores.remove(jugador);
                System.out.println("Jugador eliminado con éxito.");
                listarJugadores();
            }
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void listarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores en la lista.");
        } else {
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    private static Jugador encontrarJugadorPorId(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;
    }
}
