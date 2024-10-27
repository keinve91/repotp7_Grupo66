package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Producto;

public class ProductoCollection {
	public static List<Producto> productos = new ArrayList<Producto>();
	
	private static long idProducto=0; 
	public static Long incrementar(long id) {
		id++;
	    return id;
	}
public static void agregarProducto(Producto producto) {
    	
    	try {
    		idProducto=incrementar(idProducto);
    		producto.setId(idProducto);
    		producto.setEstado(true);
    		productos.add(producto);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR EL PRODUCTO");
		}
        
    }

    public static Producto buscarProducto(long id) {
        Producto productoEncontrado = null;

        try {
            for (Producto pro : productos) {
                if (pro.getId() == id && pro.isEstado()) {
                    productoEncontrado = pro;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el Producto.");
            return null;
        }

        return productoEncontrado;
    }
    
    
    public static void eliminarProducto(long id) {
        Producto producto = buscarProducto(id); // Busca el producto por ID

        if (producto != null) {
            if (producto.isEstado()) {
                producto.setEstado(false);
                System.out.println("Producto con ID " + id + " ha sido marcado como no disponible.");
            } else {
                System.out.println("Producto con ID " + id + " está disponible y tiene cantidad suficiente, no se realizaron cambios.");
            }
        } else {
            System.out.println("Producto con ID " + id + " no encontrado.");
        }
    }
    
    public static void mostrarDatos() {
        System.out.println("\nLista de Clientes:");
        for (Producto pro : productos) {
            System.out.println(pro); 
        }
    }

	
	
}
