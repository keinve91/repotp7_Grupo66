package ar.edu.unju.escmi.tp7.dao.impl;

import ar.edu.unju.escmi.tp7.config.EmfSingleton;
import ar.edu.unju.escmi.tp7.dao.FacturaDAO;
import ar.edu.unju.escmi.tp7.dominio.Factura;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class FacturaDAOImpl implements FacturaDAO {
    private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
    
    @Override
    public void guardar(Factura factura) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(factura);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo guardar la factura");
        }
    }
    
    @Override
    public Factura buscarPorId(Long id) {
        return manager.find(Factura.class, id);
    }
    
    @Override
    public List<Factura> obtenerTodos() {
        TypedQuery<Factura> query = manager.createQuery("SELECT f FROM Factura f", Factura.class);
        return query.getResultList();
    }
    
    @Override
    public void actualizar(Factura factura) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(factura);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo actualizar la factura");
        }
    }
    
    @Override
    public void eliminar(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Factura factura = manager.find(Factura.class, id);
            if (factura != null) {
                manager.remove(factura);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo eliminar la factura");
        }
    }
}
