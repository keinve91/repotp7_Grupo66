package ar.edu.unju.escmi.tp7.exceptions;

public class ProductoNoRegistradoException extends Exception {
    private static final long serialVersionUID = 1L; 

    public ProductoNoRegistradoException(String mensaje) {
        super(mensaje);
    }
}
