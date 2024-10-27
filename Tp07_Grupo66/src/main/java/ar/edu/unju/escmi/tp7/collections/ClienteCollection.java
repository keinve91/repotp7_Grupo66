package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.*;
public class ClienteCollection {
	
	
	public static List<Cliente> clientes = new ArrayList<Cliente>();
	private static long idCliente=0; 
	


	public static Long incrementar(long id) {
		id++;
	    return id;
	}
	
    public static void agregarCliente(Cliente cliente) {
    	
    	try {
    		idCliente=incrementar(idCliente);
    		cliente.setId(idCliente);
    		cliente.setEstado(true);
    		clientes.add(cliente);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR EL CLIENTE");
		}
        
    }

    public static Cliente buscarCliente(long id) {
        Cliente clienteEncontrado = null;

        try {
            for (Cliente cli : clientes) {
                if (cli.getId() == id && cli.isEstado()) {
                    clienteEncontrado = cli;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar cliente.");
            return null;
        }

        return clienteEncontrado;
    }
   

    public static void mostrarDatos() {
        System.out.println("\nLista de Clientes:");
        for (Cliente cli : clientes) {
            System.out.println(cli); 
        }
    }
}
