package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase utilitaria con métodos para generar elementos del juego
 * y realizar verificaciones.
 * 
 * @author Facundo Vera y Hector Iranzo
 */
import model.Inventory;
import model.characters.Enemy;
import model.characters.Boss;
import model.characters.NPC;
import model.items.Item;
import model.items.Potion;
import model.items.Weapon;
import java.util.Random;

public class GameUtils {
    private static Random random = new Random();

    /**
     * Genera un enemigo aleatorio con estadísticas básicas.
     * 
     * @return Un nuevo enemigo con nombre, salud y daño aleatorios
     */
    public static Enemy generateRandomEnemy() {
        String[] names = {"Goblin", "Skeleton", "Slime", "Wolf", "Demonio"};
        String name = names[random.nextInt(names.length)] + " " + (random.nextInt(5) + 1);
        int hp = 20 + random.nextInt(30);
        int damage = 5 + random.nextInt(10);
        
        return new Enemy(name, hp, damage);
    }

    /**
     * Genera una poción de curación estándar.
     * 
     * @return Una nueva poción con valores predeterminados
     */
    public static Potion generatePotion() {
        return new Potion("Poción Curativa", 1, 15);
    }

    /**
     * Genera un arma estándar.
     * 
     * @return Una nueva arma con valores predeterminados
     */
    public static Weapon generateWeapon() {
        return new Weapon("Espada de Luz", 3, 20);
    }

    /**
     * Genera un NPC aleatorio con un objeto en su inventario.
     * Mantiene el manejo de excepciones del código original.
     * 
     * @param playerInventory Inventario del jugador, donde se añadirá un item si interactúa
     * @return Un nuevo NPC o null si ocurre un error
     * @throws IllegalArgumentException si el inventario del jugador es nulo
     */
    public static NPC generateNPC(Inventory playerInventory) {
        try {
            if (playerInventory == null) {
                throw new IllegalArgumentException("El inventario del jugador no puede ser nulo");
            }
            
            String[] dialogues = {
                "¡Hola viajero! Toma esta poción para tu aventura.",
                "No es seguro andar solo, llévate esta espada.",
                "El infierno está lleno de peligros, prepárate bien."
            };
            
            Item reward = random.nextBoolean() ? generatePotion() : generateWeapon();
            return new NPC("Sabio", dialogues[random.nextInt(dialogues.length)], reward, playerInventory);
        } catch (Exception e) {
            System.out.println("Error al generar NPC: " + e.getMessage());
            return null;
        }
    }

    /**
     * Verifica si la posición dada es la del jefe final.
     * 
     * @param x Coordenada x
     * @param y Coordenada y
     * @return true si es la posición del jefe final
     */
    public static boolean isBossStage(int x, int y) {
        return x == 9 && y == 9;
    }
    
    /**
     * Genera un jefe final del juego.
     * 
     * @return Un nuevo jefe
     */
    public static Boss generateBoss() {
        return new Boss();
    }
}