package test;

import datos.Cliente;
import negocio.ClienteABM;

/* COMPLETE el metodo traer siempre devuelve, en caso de existir,
 * el contacto asociado a un cliente
 */
public class TestTraerClienteYContacto { 


	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		
		long idCliente = 1;
		Cliente c = abmCliente.traer(idCliente);

		System.out.println("\nCliente y contacto" + c);
		
		System.out.println(abmCliente.traer(14000001));

	}

}
