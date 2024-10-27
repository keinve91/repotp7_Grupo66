package ar.edu.unju.escmi.tp7.exceptions;

public class FacturaNoDisponibleException extends Exception {
    private static final long serialVersionUID = 1L; 

    public FacturaNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
