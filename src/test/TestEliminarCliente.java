package test;

import datos.Cliente;
import negocio.ClienteABM;

/* COMPLETE
 * 
 */
public class TestEliminarCliente {

	public static void main(String[] args) {

		Cliente cliente = new ClienteABM().traer(14000004);
		System.out.println(cliente);

		try {
			new ClienteABM().eliminar(cliente.getIdCliente());
			System.out.println(new ClienteABM().traer());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}