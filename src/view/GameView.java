package view;

import model.characters.Player;
import model.characters.NPC;

/**
 * Vista del juego que maneja la presentación
 * de información al usuario.
 * 
 * @author Facundo Vera
 */
public class GameView {
    
    /**
     * Constructor por defecto.
     */
    public GameView() {
        // Constructor vacío
    }
    
    /**
     * Muestra el mapa del juego con todos los elementos.
     * 
     * @param map Matriz que representa el mapa
     * @param player Jugador en el mapa
     * @param npcs Array de NPCs en el mapa
     */
    public void displayMap(char[][] map, Player player, NPC[] npcs) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == player.getX() && j == player.getY()) {
                    System.out.print("P ");
                } else if (isNPCPosition(npcs, i, j)) {
                    System.out.print("N ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Verifica si hay un NPC en la posición especificada.
     * 
     * @param npcs Array de NPCs
     * @param x Coordenada x
     * @param y Coordenada y
     * @return true si hay un NPC en la posición
     */
    private boolean isNPCPosition(NPC[] npcs, int x, int y) {
        for (NPC npc : npcs) {
            if (npc != null && npc.getX() == x && npc.getY() == y) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Muestra un mensaje al usuario.
     * 
     * @param message Mensaje a mostrar
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    /**
     * Muestra un mensaje de error al usuario.
     * 
     * @param errorMessage Mensaje de error a mostrar
     */
    public void displayError(String errorMessage) {
        System.out.println("ERROR: " + errorMessage);
    }
    
    /**
     * Muestra un mensaje de solicitud al usuario.
     * 
     * @param prompt Mensaje de solicitud
     */
    public void displayPrompt(String prompt) {
        System.out.print(prompt);
    }
} 