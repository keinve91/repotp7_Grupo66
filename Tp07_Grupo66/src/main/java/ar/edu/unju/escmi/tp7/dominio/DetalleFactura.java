package ar.edu.unju.escmi.tp7.dominio;

import javax.persistence.*;

@Entity
@Table(name = "detalles_factura")
public class DetalleFactura extends Factura{
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	private int cantidad;
	
	private double subTotal;
	
	public DetalleFactura() {
		// TODO Auto-generated constructor stub
	}

	public DetalleFactura(Producto producto, int cantidad, double subTotal) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "DetalleFactura [producto=" + producto + ", cantidad=" + cantidad + ", subTotal=" + subTotal + "]";
	}
	
	
	
}
