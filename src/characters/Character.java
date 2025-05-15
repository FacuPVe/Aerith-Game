package characters;

import exceptions.MaxValuesException;

/**
 *
@author Facundo Vera y Hector Iranzo
 */

public abstract class Character {
    private String name;
    private int hp;
    private int damage;
    private static final int MAX_DAMAGE = 100;

    public Character(String name, int hp, int damage) throws MaxValuesException {
        this.name = name;
        this.hp = hp;
        setDamage(damage); // Validación del daño inicial
    }

    public abstract void attack(Character target);

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
        System.out.println(name + " took " + damage + " damage. HP left: " + hp);
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

    // Nuevo método para establecer daño con validación
    public void setDamage(int damage) throws MaxValuesException {
        if (damage > MAX_DAMAGE) {
            throw new MaxValuesException(damage);
        }
        this.damage = damage;
    }
}
