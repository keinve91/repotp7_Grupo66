package ar.edu.unju.escmi.tp7.dao;

import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Factura;

public interface FacturaDAO{
	void guardar(Factura factura);
    Factura buscarPorId(Long id);
    List<Factura> obtenerTodos();
    void actualizar(Factura factura);
    void eliminar(Long id);
}
