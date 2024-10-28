package ar.edu.unju.escmi.tp7.dao;

import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.DetalleFactura;

public interface DetalleFacturaDAO {
	void guardar(DetalleFactura detalleFactura);
    DetalleFactura buscarPorId(Long id);
    List<DetalleFactura> obtenerTodos();
    void actualizar(DetalleFactura detalleFactura);
    void eliminar(Long id);
}
