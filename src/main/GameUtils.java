package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Facundo Vera
 */
import characters.Enemy;
import characters.Boss;
import characters.NPC;
import items.Item;
import items.Potion;
import items.Weapon;
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
        String[] dialogues = {
            "¡Hola viajero! Toma esta poción para tu aventura.",
            "No es seguro andar solo, llévate esta espada.",
            "El infierno está lleno de peligros, prepárate bien."
        };
        Item reward = random.nextBoolean() ? generatePotion() : generateWeapon();
        return new NPC("Sabio", dialogues[random.nextInt(dialogues.length)], reward, playerInventory);
    }

    public static boolean isBossStage(int x, int y) {
        return x == 9 && y == 9;
    }
}