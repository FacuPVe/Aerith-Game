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
        this.attackBonus = attackBonus;
    }

    @Override
    public void use() {
        System.out.println(getName() + " equipped! Attack bonus: " + attackBonus);
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}