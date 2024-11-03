package ar.edu.unju.escmi.tp7.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import ar.edu.unju.escmi.tp7.config.EmfSingleton;
import ar.edu.unju.escmi.tp7.dao.ClienteDAO;
import ar.edu.unju.escmi.tp7.dominio.Cliente;

public class ClienteDAOImpl implements ClienteDAO {
    private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
    
    @Override
    public void guardar(Cliente cliente) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo guardar el cliente");
        }
    }
    
    @Override
    public Cliente buscarPorId(Long id) {
        return manager.find(Cliente.class, id);
    }
    
    @Override
    public List<Cliente> obtenerTodos() {
        TypedQuery<Cliente> query = manager.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }
    
    @Override
    public void actualizar(Cliente cliente) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo actualizar el cliente");
        }
    }
    
    @Override
    public void eliminar(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Cliente cliente = manager.find(Cliente.class, id);
            if (cliente != null) {
                manager.remove(cliente);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo eliminar el cliente");
        }
    }
}
