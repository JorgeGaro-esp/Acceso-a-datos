package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import entidades.GestorCredenciales;
import entidades.Sesion;
import entidades.Usuario;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String ruta = "src/main/resources/credenciales.txt";
		GestorCredenciales gestor = new GestorCredenciales(ruta);
		Sesion sesion = new Sesion(gestor);

		int opcion = -1;

		do {
			
			// Menu básico
			System.out.println("=======CLINICA DENTAL=======");
			System.out.println("1. Log-in");
			System.out.println("2. Log-out");
			System.out.println("3. Salir");
			System.out.print("Eliga una opcion: ");

			opcion = sc.nextInt(); //Opción a elegir del menú
			sc.nextLine(); // Limpiar el buffer
			switch (opcion) {
			case 1: {

				// Login en el main
				try {

					// Pides el usuario
					System.out.print("Usuario: ");
					String usuario = sc.nextLine();

					// Pides la contraseña
					System.out.print("Contraseña: ");
					String password = sc.nextLine();

					// Si el login es correcto, el perfil de usuario cambia de invitado a lo
					// pertinente
					if (sesion.login(usuario, password)) {

						Usuario u = sesion.getUsuarioActual();

						System.out.println("\nLogin correcto");
						System.out.println("Bienvenido/a " + u.getNombrePersona());
						System.out.println("Perfil: " + u.getPerfil() +"\n");

					} else {

						System.out.println("Usuario o contraseña incorrectos.");

					}

				} catch (IOException e) {

					System.out.println("Error leyendo credenciales.txt");

				} catch (IllegalArgumentException | IllegalStateException e) {

					System.out.println(e.getMessage());

				}
				break;
			}
			case 2: {
				sesion.logout();
				break;
			}
			case 3: {
				System.out.println("\nSaliendo del programa");
				break;
			}
			default: {
				System.err.println("\nError, se debe elegir una de las opciones mostradas\n");
				break;
			}
			}
		} while (opcion != 3);

	}
}
