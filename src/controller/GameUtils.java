package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Facundo Vera
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

    public static Enemy generateRandomEnemy() {
        return new Enemy("Demonio " + (random.nextInt(5) + 1), 30, 10);
    }

    public static Potion generatePotion() {
        return new Potion("Poción Curativa", 1, 15);
    }

    public static Weapon generateWeapon() {
        return new Weapon("Espada de Luz", 3, 20);
    }

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

    public static boolean isBossStage(int x, int y) {
        return x == 9 && y == 9;
    }
}