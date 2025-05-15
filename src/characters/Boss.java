/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package characters;

import exceptions.MaxValuesException;

/**
 *
 * @author Facundo Vera y Hector Iranzo
 */
public class Boss extends Enemy {

    public Boss() throws MaxValuesException {
        super("Belcebú", 100, 25);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " unleashes a deadly attack on " + target.getName() + "!");
        target.takeDamage(getDamage() + 5);
    }
}
