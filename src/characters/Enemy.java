/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

/**
 *
 * @author Facundo Vera
 */
public class Enemy extends Character {
    public Enemy(String name, int hp, int damage) {
        super(name, hp, damage);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " attacks " + target.getName() + " for " + getDamage() + " damage!");
        target.takeDamage(getDamage());
    }
}
