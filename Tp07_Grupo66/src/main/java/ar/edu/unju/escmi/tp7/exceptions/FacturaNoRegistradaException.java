package ar.edu.unju.escmi.tp7.exceptions;

public class FacturaNoRegistradaException extends Exception {
    private static final long serialVersionUID = 1L; 

    public FacturaNoRegistradaException(String mensaje) {
        super(mensaje);
    }
}
