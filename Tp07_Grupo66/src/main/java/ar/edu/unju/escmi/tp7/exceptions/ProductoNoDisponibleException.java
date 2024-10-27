package ar.edu.unju.escmi.tp7.exceptions;


public class ProductoNoDisponibleException extends Exception {
    private static final long serialVersionUID = 1L; 

    public ProductoNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
