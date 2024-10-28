package ar.edu.unju.escmi.tp7.dao;

import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Producto;

public interface ProductoDAO {
	public void guardar(Producto producto);
    public void actualizar(Producto producto);
    public void eliminar(Long id);
    public List<Producto> obtenerProductos();
    public Producto obtenerProducto(Long id);
}
