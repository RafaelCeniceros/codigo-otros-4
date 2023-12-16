package org.generation;

import java.util.Scanner; // Se importó Scanner

public class RevisionCodigoOtros4 {

    // Se declaró el Scanner como variable de clase para que sea accesible en toda la clase
	// se agregaron funciones para mejorar la estructura del codigo
	// se agrego una validacion a lo que se ingresa para evitar errores
	// se encerro el programa en un Do While para que se puedan jugar varias partidas hasta que el usuario decida.
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            playGame();

            System.out.print("¿Desea seguir jugando? (si/no): ");
            Scanner answer = new Scanner(System.in);
            String continuar = answer.nextLine().toLowerCase();
            answer.close();

            // Salir del bucle si la respuesta no es "si"
            if (!continuar.equals("si")) {
                System.out.println("¡Gracias por jugar! Hasta luego.");
                break;
            }

        } while (true);

    }

    private static void playGame() {
        String[] opcionesValidas = {"piedra", "papel", "tijeras"};

        System.out.print("Turno del jugador 1 (introduzca piedra, papel o tijeras): ");
        Scanner optionPlayer1 = new Scanner(System.in);
        String j1 = validarOpcion(optionPlayer1.nextLine(), opcionesValidas);
        optionPlayer1.close(); // Cerrar Scanner después de usarlo

        System.out.print("Turno del jugador 2 (introduzca piedra, papel o tijeras): ");
        Scanner optionPlayer2 = new Scanner(System.in);
        String j2 = validarOpcion(optionPlayer2.nextLine(), opcionesValidas);
        optionPlayer2.close(); // Cerrar Scanner después de usarlo

        if (j1.equals(j2)) {
            System.out.println("Empate");
        } else {
            int gameWinner = 2;
            switch (j1) {
                case "piedra":
                    if (j2.equals("tijeras")) {
                        gameWinner = 1;
                    }
                    break;

                case "papel":
                    if (j2.equals("piedra")) {
                        gameWinner = 1;
                    }
                    break;

                case "tijeras":
                    if (j2.equals("papel")) {
                        gameWinner = 1;
                    }
                    break;

                default:
            }
            System.out.println("Gana el jugador " + gameWinner);
        }
    }

    private static String validarOpcion(String opcion, String[] opcionesValidas) {
        Scanner optionPlayer = new Scanner(System.in);
        while (!esOpcionValida(opcion, opcionesValidas)) {
            System.out.print("Opción no válida. Introduzca piedra, papel o tijeras: ");
            opcion = optionPlayer.nextLine();
        }
        optionPlayer.close(); // Cerrar Scanner después de usarlo
        return opcion;
    }

    private static boolean esOpcionValida(String opcion, String[] opcionesValidas) {
        for (String opcionValida : opcionesValidas) {
            if (opcionValida.equals(opcion)) {
                return true;
            }
        }
        return false;
    }
}