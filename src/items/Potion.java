/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

/**
 *
 * @author Facundo Vera
 */
import characters.Character;

public class Potion extends Item {
    private int healAmount;

    public Potion(String name, int weight, int healAmount) {
        super(name, weight);
        this.healAmount = healAmount;
    }

    @Override
    public void use() {
        System.out.println(getName() + " used! Heals " + healAmount + " HP.");
    }

    public void heal(Character character) {
        character.setHp(character.getHp() + healAmount);
        System.out.println(character.getName() + " healed for " + healAmount + " HP!");
    }
}