package ar.edu.unju.escmi.tp7.main;
import ar.edu.unju.escmi.tp7.dominio.*;
import ar.edu.unju.escmi.tp7.collections.*;
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Cliente con sus atributos
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan");
        cliente1.setApellido("Pérez");
        cliente1.setDomicilio("Calle Falsa 123");
        cliente1.setDni(12345678);

        // Agregar cliente usando el método agregarCliente, que asignará ID y estado automáticamente
        ClienteCollection.agregarCliente(cliente1);

        // Crear otra instancia de Cliente y agregarla de la misma forma
        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Ana");
        cliente2.setApellido("García");
        cliente2.setDomicilio("Av. Siempre Viva 742");
        cliente2.setDni(87654321);

        ClienteCollection.agregarCliente(cliente2);
        

        ClienteCollection.mostrarDatos();
        
    }
}
