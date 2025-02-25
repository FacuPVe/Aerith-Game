/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

/**
 *
 * @author Facundo Vera
 */
import interfaces.Interactable;
import items.Item;
import main.Inventory;

public class NPC extends Character implements Interactable {
    private String dialogue;
    private Item reward;
    private Inventory playerInventory;
    private int x, y;

    public NPC(String name, String dialogue, Item reward, Inventory playerInventory) {
        super(name, 100, 0);
        this.dialogue = dialogue;
        this.reward = reward;
        this.playerInventory = playerInventory;
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

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}