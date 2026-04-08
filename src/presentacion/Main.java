package presentacion;

import logicadenegocio.*;
import entidades.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UsuarioService us = new UsuarioService();
        AccesoService as = new AccesoService();

        int op;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Registrar entrada");
            System.out.println("5. Registrar salida");
            System.out.println("6. Ver historial");
            System.out.println("7. Tiempo total");
            System.out.println("8. Salir");

            op = sc.nextInt();
            sc.nextLine();

            try {
                switch (op) {

                    case 1:
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Rol: ");
                        String rol = sc.nextLine();

                        if (us.registrar(new Usuario(id, nombre, rol)))
                            System.out.println("Usuario registrado");
                        else
                            System.out.println("ID duplicado");
                        break;

                    case 2:
                        for (Usuario u : us.listar()) {
                            System.out.println(u);
                        }
                        break;

                    case 3:
                        System.out.print("ID: ");
                        us.eliminar(sc.nextLine());
                        System.out.println("Eliminado");
                        break;

                    case 4:
                        System.out.print("ID usuario: ");
                        System.out.println(as.registrarEntrada(sc.nextLine())
                                ? "Entrada registrada"
                                : "Error: ya está dentro");
                        break;

                    case 5:
                        System.out.print("ID usuario: ");
                        System.out.println(as.registrarSalida(sc.nextLine())
                                ? "Salida registrada"
                                : "Error: no tiene entrada");
                        break;

                    case 6:
                        System.out.print("ID: ");
                        for (Acceso a : as.historial(sc.nextLine())) {
                            System.out.println(a);
                        }
                        break;

                    case 7:
                        System.out.print("ID: ");
                        System.out.println("Tiempo total (min): " +
                                as.tiempoTotalMinutos(sc.nextLine()));
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (op != 8);
    }
}