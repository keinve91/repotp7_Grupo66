package ar.edu.unju.escmi.tp7.main;

import ar.edu.unju.escmi.tp7.dao.impl.ClienteDAOImpl;
import ar.edu.unju.escmi.tp7.dao.impl.FacturaDAOImpl;
import ar.edu.unju.escmi.tp7.dao.impl.ProductoDAOImpl;
import ar.edu.unju.escmi.tp7.dominio.Cliente;
import ar.edu.unju.escmi.tp7.dominio.Factura;
import ar.edu.unju.escmi.tp7.dominio.Producto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        ProductoDAOImpl productoDAO = new ProductoDAOImpl();
        FacturaDAOImpl facturaDAO = new FacturaDAOImpl();

        int opcion;
        do {
            System.out.println("Menu de opciones:");
            System.out.println("1 - Alta de cliente");
            System.out.println("2 - Alta de producto");
            System.out.println("3 - Realizar la venta de productos (Alta de una nueva factura)");
            System.out.println("4 - Buscar una factura por número");
            System.out.println("5 - Eliminar una factura (eliminación logica)");
            System.out.println("6 - Eliminar un producto (eliminación logica)");
            System.out.println("7 - Modificar datos de cliente");
            System.out.println("8 - Modificar precio de producto");
            System.out.println("9 - Mostrar todas las facturas");
            System.out.println("10 - Mostrar todos los clientes");
            System.out.println("11 - Mostrar las facturas que superen el total de $500,000");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido del cliente: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese domicilio del cliente: ");
                    String domicilio = scanner.nextLine();
                    System.out.print("Ingrese DNI del cliente: ");
                    int dni = scanner.nextInt();
                    scanner.nextLine();
                    Cliente cliente = new Cliente(nombre, apellido, domicilio, dni, true);
                    clienteDAO.guardar(cliente);
                    System.out.println("Cliente guardado");
                    break;

                case 2:
                    System.out.print("Ingrese descripcion del producto: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese precio unitario: ");
                    double precioUnitario = scanner.nextDouble();
                    System.out.print("Ingrese cantidad: ");
                    Long cantidad = scanner.nextLong();
                    scanner.nextLine();
                    Producto producto = new Producto(descripcion, precioUnitario, cantidad, true);
                    productoDAO.guardar(producto);
                    System.out.println("Producto guardado");
                    break;

                case 3:
                    
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la factura a buscar: ");
                    Long facturaId = scanner.nextLong();
                    Factura factura = facturaDAO.buscarPorId(facturaId);
                    if (factura != null) {
                        System.out.println("Factura encontrada: " + factura);
                    } else {
                        System.out.println("Factura no encontrada");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el ID de la factura a eliminar: ");
                    Long facturaEliminarId = scanner.nextLong();
                    facturaDAO.eliminar(facturaEliminarId);
                    System.out.println("Factura eliminada");
                    break;

                case 6:
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    Long productoEliminarId = scanner.nextLong();
                    productoDAO.eliminar(productoEliminarId);
                    System.out.println("Producto eliminado");
                    break;

                case 7:
                	System.out.print("Ingrese el ID del cliente a modificar: ");
                    Long clienteModId = scanner.nextLong();
                    Cliente clienteMod = clienteDAO.buscarPorId(clienteModId);
                    
                    if (clienteMod == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }             
                    System.out.print("Ingrese nuevo nombre (actual: " + clienteMod.getNombre() + "): ");
                    scanner.nextLine(); 
                    clienteMod.setNombre(scanner.nextLine());                    
                    System.out.print("Ingrese nuevo apellido (actual: " + clienteMod.getApellido() + "): ");
                    clienteMod.setApellido(scanner.nextLine());                   
                    System.out.print("Ingrese nuevo domicilio (actual: " + clienteMod.getDomicilio() + "): ");
                    clienteMod.setDomicilio(scanner.nextLine());                   
                    System.out.print("Ingrese nuevo DNI (actual: " + clienteMod.getDni() + "): ");
                    clienteMod.setDni(scanner.nextInt());                  
                    clienteDAO.actualizar(clienteMod);
                    System.out.println("Datos del cliente actualizados");
                    break;

                case 8:
                	System.out.print("Ingrese el ID del producto a modificar: ");
                    Long productoModId = scanner.nextLong();
                    Producto productoMod = productoDAO.obtenerProducto(productoModId);
                    
                    if (productoMod == null) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }
                    
                    System.out.print("Ingrese nuevo precio unitario (actual: " + productoMod.getPrecioUnitario() + "): ");
                    productoMod.setPrecioUnitario(scanner.nextDouble());
                    
                    productoDAO.actualizar(productoMod);
                    System.out.println("Precio del producto actualizado");
                    break;

                case 9:
                    List<Factura> facturas = facturaDAO.obtenerTodos();
                    facturas.forEach(System.out::println);
                    break;

                case 10:
                    List<Cliente> clientes = clienteDAO.obtenerTodos();
                    clientes.forEach(System.out::println);
                    break;

                case 11:
                    
                    break;

                case 0:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
