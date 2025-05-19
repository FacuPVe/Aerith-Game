package main;

import controller.GameController;

/**
 * Clase principal que inicia la aplicación del juego.
 * Sigue el patrón MVC al separar la inicialización del juego de su lógica.
 * 
 * @author Facundo Vera y Hector Iranzo
 */
public class Main {
    
    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Iniciar el controlador del juego
        GameController gameController = new GameController();
        gameController.startGame();
    }
} 