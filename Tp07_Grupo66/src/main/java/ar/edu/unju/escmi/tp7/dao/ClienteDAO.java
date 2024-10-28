package ar.edu.unju.escmi.tp7.dao;

import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Cliente;

public interface ClienteDAO {
	void guardar(Cliente cliente);
    Cliente buscarPorId(Long id);
    List<Cliente> obtenerTodos();
    void actualizar(Cliente cliente);
    void eliminar(Long id);
}
