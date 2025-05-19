package controller;

import model.Game;
import model.characters.Player;
import model.characters.Enemy;
import model.characters.Boss;
import model.characters.NPC;
import view.GameView;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Controlador principal del juego que maneja la lógica del juego
 * y la comunicación entre el modelo y la vista.
 * 
 * @author Facundo Vera y Hector Iranzo
 */
public class GameController {
    private Game gameModel;
    private Scanner scanner;
    private Random random;
    private GameView gameView;
    
    /**
     * Constructor que inicializa los componentes del juego.
     */
    public GameController() {
        scanner = new Scanner(System.in);
        random = new Random();
        
        // Crear el jugador
        Player player = new Player("Aerith", 100, 15, 0, 0);
        
        // Crear NPCs
        NPC[] npcs = new NPC[2];
        try {
            npcs[0] = GameUtils.generateNPC(player.getInventory());
            npcs[1] = GameUtils.generateNPC(player.getInventory());
            npcs[0].move(random.nextInt(10), random.nextInt(10));
            npcs[1].move(random.nextInt(10), random.nextInt(10));
        } catch (NullPointerException generateNpcError) {
            System.err.println("Error al generar NPCs: " + generateNpcError.getMessage());
        }
        
        // Crear modelo del juego y vista
        gameModel = new Game(player, npcs);
        gameView = new GameView();
    }
    
    /**
     * Inicia el bucle principal del juego.
     */
    public void startGame() {
        while (!gameModel.isGameOver()) {
            try {
                gameView.displayMap(
                    gameModel.getMap(), 
                    gameModel.getPlayer(), 
                    gameModel.getNpcs()
                );
                gameView.displayPrompt("Muévete con (WASD) o interactúa con (E): ");
                char action = scanner.next().charAt(0);
                
                if (action == 'e') {
                    interactWithNPC();
                } else {
                    movePlayer(action);
                    checkForEncounters();
                }
            } catch (InputMismatchException playerMoveError) {
                gameView.displayError("Carácter inválido. Usa solo un carácter (WASD o E).");
                scanner.nextLine();
            } catch (Exception gameError) {
                gameView.displayError("Error inesperado: " + gameError.getMessage());
                gameError.printStackTrace();
            }
        }
        gameView.displayMessage("GAME OVER.");
    }

    /**
     * Verifica si hay un NPC en la posición especificada.
     * 
     * @param x Coordenada x
     * @param y Coordenada y
     * @return true si hay un NPC en la posición
     */
    private boolean isNPCPosition(int x, int y) {
        for (NPC npc : gameModel.getNpcs()) {
            if (npc.getX() == x && npc.getY() == y) return true;
        }
        return false;
    }

    /**
     * Mueve al jugador según la entrada del usuario.
     * 
     * @param move Dirección del movimiento (w, a, s, d)
     */
    private void movePlayer(char move) {
        try {
            Player player = gameModel.getPlayer();
            int x = player.getX(), y = player.getY();
            int size = gameModel.getSize();
            
            switch (move) {
                case 'w': if (x > 0) player.move(x - 1, y); break;
                case 's': if (x < size - 1) player.move(x + 1, y); break;
                case 'a': if (y > 0) player.move(x, y - 1); break;
                case 'd': if (y < size - 1) player.move(x, y + 1); break;
                default: throw new IllegalArgumentException("Movimiento inválido");
            }
        } catch (IllegalArgumentException invalidMovement) {
            gameView.displayError(invalidMovement.getMessage());
        }
    }

    /**
     * Maneja la interacción del jugador con un NPC.
     */
    private void interactWithNPC() {
        try {
            Player player = gameModel.getPlayer();
            for (NPC npc : gameModel.getNpcs()) {
                if (npc != null && npc.getX() == player.getX() && npc.getY() == player.getY()) {
                    npc.interact();
                    return;
                }
            }
            gameView.displayMessage("No hay nadie para interactuar.");
        } catch (Exception interactionError) {
            gameView.displayError("Error en interacción: " + interactionError.getMessage());
        }
    }
    
    /**
     * Verifica si hay encuentros con enemigos o el jefe final.
     */
    private void checkForEncounters() {
        Player player = gameModel.getPlayer();
        if (GameUtils.isBossStage(player.getX(), player.getY())) {
            Boss boss = GameUtils.generateBoss();
            battle(boss);
        } else if (Math.random() < 0.3) {
            Enemy enemy = GameUtils.generateRandomEnemy();
            battle(enemy);
        }
    }

    /**
     * Maneja una batalla entre el jugador y un enemigo.
     * 
     * @param enemy El enemigo contra el que luchar
     */
    private void battle(Enemy enemy) {
        try {
            Player player = gameModel.getPlayer();
            gameView.displayMessage("¡Combate contra " + enemy.getName() + "!");
            while (player.isAlive() && enemy.isAlive()) {
                player.attack(enemy);
                if (enemy.isAlive()) enemy.attack(player);
            }
            
            if (player.isAlive()) {
                gameView.displayMessage("Has derrotado a " + enemy.getName() + "!");
            }
        } catch (NullPointerException battleError) {
            gameView.displayError("Error en batalla: no hay ningún objetivo... " + battleError.getMessage());
        } catch (IllegalArgumentException e) {
            gameView.displayError("Ataque inválido: " + e.getMessage());
        }
    }
} 