/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

/**
 *
 * @author Facundo Vera
 */
public abstract class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del item no puede estar vacío");
            }
            if (weight < 0) {
                throw new IllegalArgumentException("El peso no puede ser negativo");
            }
            this.name = name;
            this.weight = weight;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear item: " + e.getMessage());
            throw e; 
        }
    }

    public abstract void use();

    
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}