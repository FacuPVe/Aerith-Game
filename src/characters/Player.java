/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

/**
 *
 * @author Facundo Vera
 */
import interfaces.Movable;
import main.Inventory;
import exceptions.InvalidMovementException;

public class Player extends Character implements Movable {

    private int x, y;
    private Inventory inventory;

    public Player(String name, int hp, int damage, int startX, int startY) {
        super(name, hp, damage);
        this.x = startX;
        this.y = startY;
        this.inventory = new Inventory();
    }

    @Override
    public void move(int newX, int newY) {
        try {
            if (newX < 0 || newY < 0) {
                throw new InvalidMovementException("Las coordenadas no pueden ser negativas: (" + newX + "," + newY + ")");
            }
            this.x = newX;
            this.y = newY;
            System.out.println(getName() + " moved to (" + x + "," + y + ")");
        } catch (InvalidMovementException e) {
            System.out.println("Error de movimiento: " + e.getMessage());
        }
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " ataca a " + target.getName() + " causando " + getDamage() + " de daño.");
        target.takeDamage(getDamage());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
