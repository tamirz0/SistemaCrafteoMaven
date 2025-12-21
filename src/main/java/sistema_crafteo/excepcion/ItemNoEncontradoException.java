package sistema_crafteo.excepcion;

public class ItemNoEncontradoException extends RuntimeException {
    public ItemNoEncontradoException(String message) {
        super(message);
    }
}
