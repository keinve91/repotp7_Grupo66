package ar.edu.unju.escmi.tp7.dao.impl;

import ar.edu.unju.escmi.tp7.config.EmfSingleton;
import ar.edu.unju.escmi.tp7.dao.DetalleFacturaDAO;
import ar.edu.unju.escmi.tp7.dominio.DetalleFactura;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DetalleFacturaDAOImpl implements DetalleFacturaDAO {
    private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
    
    @Override
    public void guardar(DetalleFactura detalleFactura) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(detalleFactura);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo guardar el detalle de la factura");
        }
    }
    
    @Override
    public DetalleFactura buscarPorId(Long id) {
        return manager.find(DetalleFactura.class, id);
    }

    @Override
    public List<DetalleFactura> obtenerTodos() {
        TypedQuery<DetalleFactura> query = manager.createQuery("SELECT d FROM DetalleFactura d", DetalleFactura.class);
        return query.getResultList();
    }

    @Override
    public void actualizar(DetalleFactura detalleFactura) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(detalleFactura);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo actualizar el detalle de la factura");
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            DetalleFactura detalleFactura = manager.find(DetalleFactura.class, id);
            if (detalleFactura != null) {
                manager.remove(detalleFactura);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo eliminar el detalle de la factura");
        }
    }
}
