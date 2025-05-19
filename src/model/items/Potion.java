/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.items;

/**
 *
 * @author Facundo Vera y Hector Iranzo
 */
import model.characters.Character;

public class Potion extends Item {
    private int healAmount;

    public Potion(String name, int weight, int healAmount) {
        super(name, weight);
        try {
            if (healAmount <= 0) {
                throw new IllegalArgumentException("La cantidad de curación debe ser positiva");
            }
            this.healAmount = healAmount;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la creación de la poción: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void use() {
        System.out.println(getName() + " usado! Curación de " + healAmount + " HP.");
    }

    public void heal(Character character) {
        try {
            if (character == null) {
                throw new IllegalArgumentException("No se puede curar a un personaje nulo");
            }
            if (!character.isAlive()) {
                throw new IllegalStateException("No se puede curar a un personaje muerto");
            }
            character.setHp(character.getHp() + healAmount);
            System.out.println(character.getName() + " se ha curado " + healAmount + " HP!");
        } catch (IllegalArgumentException | IllegalStateException healError) {
            System.out.println("Error al curar al personaje: " + healError.getMessage());
        }
    }
}