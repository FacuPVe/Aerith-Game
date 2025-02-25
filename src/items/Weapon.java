/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

/**
 *
 * @author Facundo Vera
 */
public class Weapon extends Item {
    private int attackBonus;

    public Weapon(String name, int weight, int attackBonus) {
        super(name, weight);
        try {
            if (attackBonus < 0) {
                throw new IllegalArgumentException("El bonus de ataque no puede ser negativo");
            }
            this.attackBonus = attackBonus;
        } catch (IllegalArgumentException weaponError) {
            System.out.println("Error al crear arma: " + weaponError.getMessage());
            throw weaponError;
        }
    }

    @Override
    public void use() {
        System.out.println(getName() + " equipada! Ataque bonus: " + attackBonus);
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}