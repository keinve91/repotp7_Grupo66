package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;

public abstract class Factura {
	protected Long id;
	protected LocalDate fechaActual;
	protected Cliente cliente;
	protected double total; 
	protected boolean estado;
	@Override
	public String toString() {
		return "Factura [id=" + id + ", fechaActual=" + fechaActual + ", cliente=" + cliente + ", total=" + total
				+ ", estado=" + estado + "]";
	} 
	
}
