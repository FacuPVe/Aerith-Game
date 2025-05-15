package exceptions;
public class MaxValuesException extends Exception {
    public MaxValuesException(int damage) {
        super("Valor máximo de daño alcanzado: " + damage + ". No se puede aumentar más.");
    }
}