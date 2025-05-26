package exceptions;

public class InvalidSymbolException extends RuntimeException {
    public InvalidSymbolException() {
        super("Invalid symbol : use O or X");
    }
}
