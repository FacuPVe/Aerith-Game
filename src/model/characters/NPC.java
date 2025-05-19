/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.characters;

/**
 * Clase que representa a un personaje no jugable (NPC)
 * que puede interactuar con el jugador.
 * 
 * @author Facundo Vera y Hector Iranzo
 */
import interfaces.Interactable;
import model.items.Item;
import model.Inventory;

public class NPC extends Character implements Interactable {
    private String dialogue;
    private Item reward;
    private Inventory playerInventory;
    private int x, y;

    /**
     * Constructor con diálogo personalizado.
     * 
     * @param name Nombre del NPC
     * @param dialogue Diálogo que muestra el NPC
     * @param reward Recompensa que da el NPC
     * @param playerInventory Inventario del jugador donde se añade la recompensa
     */
    public NPC(String name, String dialogue, Item reward, Inventory playerInventory) {
        super(name, 100, 0);
        this.dialogue = dialogue;
        this.reward = reward;
        this.playerInventory = playerInventory;
    }
    
    /**
     * Constructor simplificado con diálogo generado automáticamente.
     * 
     * @param name Nombre del NPC
     * @param playerInventory Inventario del jugador donde se añade la recompensa
     * @param reward Recompensa que da el NPC
     */
    public NPC(String name, Inventory playerInventory, Item reward) {
        super(name, 100, 0);
        this.reward = reward;
        this.playerInventory = playerInventory;
        
        if (reward != null) {
            this.dialogue = "¡Hola viajero! Toma este(a) " + reward.getName() + " para tu aventura.";
        } else {
            this.dialogue = "¡Hola viajero! Buena suerte en tu aventura.";
        }
    }

    @Override
    public void interact() {
        System.out.println(getName() + ": " + dialogue);
        if (reward != null) {
            playerInventory.addItem(reward);
            System.out.println(getName() + " te ha dado un(a) " + reward.getName() + "!");
        }
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " es un NPC y no puede atacar.");
    }

    /**
     * Mueve el NPC a la posición especificada.
     * 
     * @param newX Nueva coordenada x
     * @param newY Nueva coordenada y
     */
    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * Obtiene la coordenada x del NPC.
     * 
     * @return Coordenada x
     */
    public int getX() { return x; }
    
    /**
     * Obtiene la coordenada y del NPC.
     * 
     * @return Coordenada y
     */
    public int getY() { return y; }
}