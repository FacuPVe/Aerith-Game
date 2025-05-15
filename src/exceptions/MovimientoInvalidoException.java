package exceptions;

public class MovimientoInvalidoException extends Exception {
    public MovimientoInvalidoException(String move) {
        super("Movimiento inválido: '" + move + "'. Usa W, A, S o D para moverte.");
    }
}