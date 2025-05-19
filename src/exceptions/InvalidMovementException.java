/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;


/**
 *
 * @author Facundo Vera y Hector Iranzo
 */

public class InvalidMovementException extends RuntimeException {
    public InvalidMovementException(String message) {
        super(message);
    }
} 