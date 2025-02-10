/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
/**
 *
 * @author Facundo Vera
 */
import characters.Player;
import characters.Enemy;
import characters.Boss;
import characters.NPC;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final int SIZE = 10;
    private static char[][] map = new char[SIZE][SIZE];
    private static NPC[] npcs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Player player = new Player("Aerith", 100, 15, 0, 0);
        
        // Crear NPCs y colocarlos en el mapa
        npcs = new NPC[] {
            GameUtils.generateNPC(player.getInventory()),
            GameUtils.generateNPC(player.getInventory())
        };
        npcs[0].move(random.nextInt(SIZE), random.nextInt(SIZE));
        npcs[1].move(random.nextInt(SIZE), random.nextInt(SIZE));

        generateMap();
        
        while (player.isAlive()) {
            printMap(player);
            System.out.println("Move (WASD) or interact (E): ");
            char action = scanner.next().charAt(0);
            
            if (action == 'e') {
                interactWithNPC(player);
            } else {
                movePlayer(player, action);
                if (GameUtils.isBossStage(player.getX(), player.getY())) {
                    Boss boss = new Boss();
                    battle(player, boss);
                    if (!player.isAlive()) break;
                } else if (Math.random() < 0.3) {
                    Enemy enemy = GameUtils.generateRandomEnemy();
                    battle(player, enemy);
                }
            }
        }
        System.out.println("Game Over.");
    }

    private static void generateMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = '.';
        map[9][9] = 'B';  // Boss Final
    }

    private static void printMap(Player player) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == player.getX() && j == player.getY()) System.out.print("P ");
                else if (isNPCPosition(i, j)) System.out.print("N ");
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isNPCPosition(int x, int y) {
        for (NPC npc : npcs) {
            if (npc.getX() == x && npc.getY() == y) return true;
        }
        return false;
    }

    private static void movePlayer(Player player, char move) {
        int x = player.getX(), y = player.getY();
        switch (move) {
            case 'w': if (x > 0) player.move(x - 1, y); break;
            case 's': if (x < SIZE - 1) player.move(x + 1, y); break;
            case 'a': if (y > 0) player.move(x, y - 1); break;
            case 'd': if (y < SIZE - 1) player.move(x, y + 1); break;
        }
    }

    private static void interactWithNPC(Player player) {
        for (NPC npc : npcs) {
            if (npc.getX() == player.getX() && npc.getY() == player.getY()) {
                npc.interact();
                return;
            }
        }
        System.out.println("No hay nadie aquí para interactuar.");
    }

    private static void battle(Player player, Enemy enemy) {
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) enemy.attack(player);
        }
    }
}