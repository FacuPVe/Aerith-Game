/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.characters;

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
        try {
            if (target == null) {
                throw new IllegalArgumentException("No se puede atacar a un objetivo nulo");
            }
            if (!target.isAlive()) {
                throw new IllegalStateException("No se puede atacar a un objetivo muerto");
            }
            System.out.println(getName() + " ataca a " + target.getName() + " haciendo " + getDamage() + " de daño!");
            target.takeDamage(getDamage());
        } catch (IllegalArgumentException | IllegalStateException enemyAttackError) {
            System.out.println("Error en el ataque del enemigo: " + enemyAttackError.getMessage());
        }
    }
}
