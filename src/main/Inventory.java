package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Facundo Vera
 */

import items.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        try {
            if (item == null) {
                throw new IllegalArgumentException("No se puede añadir un item nulo");
            }
            items.add(item);
            System.out.println(item.getName() + " se ha añadido al inventario.");
        } catch (IllegalArgumentException addItemError) {
            System.out.println("Error al añadir item: " + addItemError.getMessage());
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
