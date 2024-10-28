package ar.edu.unju.escmi.tp7.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected LocalDate fechaActual;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente_id")
	protected Cliente cliente;
	
	protected double total;
	
	@Column(columnDefinition = "BOOLEAN")
	protected boolean estado;
	@Override
	public String toString() {
		return "Factura [id=" + id + ", fechaActual=" + fechaActual + ", cliente=" + cliente + ", total=" + total
				+ ", estado=" + estado + "]";
	} 
	
}
