/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.characters;

/**
 *
 * @author Facundo Vera
 */
public class Boss extends Enemy {

    public Boss() {
        super("Belcebú", 100, 25);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " le lanza un ataca mortal a " + target.getName() + "!");
        target.takeDamage(getDamage() + 5);
    }
}
