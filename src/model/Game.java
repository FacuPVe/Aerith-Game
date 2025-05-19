package model;

import model.characters.Player;
import model.characters.NPC;
import model.characters.Boss;
import model.characters.Enemy;

/**
 * Clase principal del modelo que representa el estado del juego.
 * 
 * @author Facundo Vera y Hector Iranzo
 */
public class Game {
    private static final int SIZE = 10;
    private char[][] map;
    private Player player;
    private NPC[] npcs;
    private boolean gameOver;
    
    /**
     * Constructor que inicializa el estado del juego.
     * 
     * @param player Jugador
     * @param npcs NPCs del juego
     */
    public Game(Player player, NPC[] npcs) {
        this.map = new char[SIZE][SIZE];
        this.player = player;
        this.npcs = npcs;
        this.gameOver = false;
        
        // Inicializar mapa
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = '.';
            }
        }
        map[9][9] = 'B';  // Boss Final
    }
    
    /**
     * Obtiene el mapa del juego.
     * 
     * @return Mapa del juego
     */
    public char[][] getMap() {
        return map;
    }
    
    /**
     * Obtiene el jugador.
     * 
     * @return Jugador
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * Obtiene los NPCs.
     * 
     * @return Array de NPCs
     */
    public NPC[] getNpcs() {
        return npcs;
    }
    
    /**
     * Indica si el juego ha terminado.
     * 
     * @return true si el juego ha terminado
     */
    public boolean isGameOver() {
        return gameOver || !player.isAlive();
    }
    
    /**
     * Establece el estado de fin de juego.
     * 
     * @param gameOver true si el juego ha terminado
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    /**
     * Obtiene el tamaño del mapa.
     * 
     * @return Tamaño del mapa
     */
    public int getSize() {
        return SIZE;
    }
} 