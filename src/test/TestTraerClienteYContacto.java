package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerClienteYContacto {

	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		
		long idCliente = 1;
		Cliente c = abmCliente.traer(idCliente);

		System.out.println("\nCliente y contacto" + c);

	}

}
