package ar.edu.unju.escmi.tp7.dao.impl;

import ar.edu.unju.escmi.tp7.config.EmfSingleton;
import ar.edu.unju.escmi.tp7.dao.ProductoDAO;
import ar.edu.unju.escmi.tp7.dominio.Producto;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class ProductoDAOImpl implements ProductoDAO {
    private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
    
    @Override
    public void guardar(Producto producto) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(producto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo guardar el producto");
        }
    }

    @Override
    public void actualizar(Producto producto) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(producto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo actualizar el producto");
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Producto producto = manager.find(Producto.class, id);
            if (producto != null) {
                manager.remove(producto);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("No se pudo eliminar el producto");
        }
    }

    @Override
    public List<Producto> obtenerProductos() {
        TypedQuery<Producto> query = manager.createQuery("SELECT p FROM Producto p", Producto.class);
        return query.getResultList();
    }

    @Override
    public Producto obtenerProducto(Long id) {
        return manager.find(Producto.class, id);
    }
}
