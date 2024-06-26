package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

/* COMPLETE el metodo agregar no guarda el contacto como atributo, aunque si necesita el
 * identificador (ID) de un contacto existente porque las reglas de negocio de la base de datos
 * no permiten registrar un contacto huerfano
 */
public class TestAgregarContacto {

	public static void main(String[] args) {

		System.out.println("UC 1 - agregar Contacto\n");
		ClienteABM abmCliente = new ClienteABM();
		ContactoABM abmContacto = new ContactoABM();

		Cliente cliente = abmCliente.traer(4L);

		try {
			System.out.println("\nTest agregar Contacto");
			abmContacto.agregar("rgarcia@unla.edu.ar", "99-9999-9999", "099-9999-9999", cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(abmContacto.traer());

	}
}
