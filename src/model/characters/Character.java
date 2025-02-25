/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.characters;

import exceptions.CharacterDeadException;
import exceptions.CombatException;

/**
 *
 * @author Facundo Vera
 */

public abstract class Character {
    private String name;
    private int hp;
    private int damage;

    public Character(String name, int hp, int damage) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del personaje no puede estar vacío");
        }
        if (hp <= 0) {
            throw new IllegalArgumentException("La salud (HP) debe ser mayor que 0");
        }
        if (damage < 0) {
            throw new IllegalArgumentException("El daño no puede ser negativo");
        }
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public abstract void attack(Character target);

    public void takeDamage(int damage) {
        try {
            if (!isAlive()) {
                throw new CharacterDeadException("No se puede dañar a un personaje muerto: " + getName());
            }
            if (damage < 0) {
                throw new CombatException("El daño no puede ser negativo: " + damage);
            }
            this.hp -= damage;
            if (this.hp < 0) this.hp = 0;
            System.out.println(name + " took " + damage + " damage. HP left: " + hp);
        } catch (CharacterDeadException | CombatException e) {
            System.out.println("Error al aplicar daño: " + e.getMessage());
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}