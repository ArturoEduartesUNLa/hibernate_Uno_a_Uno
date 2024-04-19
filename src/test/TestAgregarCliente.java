package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Contacto;
import negocio.ClienteABM;
import negocio.ContactoABM;

/*COMPLETE ver en la definicion del metodo agregar la estrategia utilizada en cada caso
 * con y sin contacto asociado
 */
public class TestAgregarCliente {

	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();

		// COMMENT agregar cliente sin contacto
		try {
			System.out.println(abmCliente.traer(abmCliente.agregar("Claude", "Debussy", 9898980, LocalDate.now(), false, null)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// COMMENT agregar cliente con contacto
		try {
			System.out.println(abmCliente.traer(abmCliente.agregar("Franz", "Ferdinand", 45454545, LocalDate.now(), false,
					new Contacto("licsistemas@unla.com", "movil", "fijo"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		Cliente cliente = abmCliente.traer(14000001);
		System.out.println(cliente);
		cliente.setNombre("pirulo1");
	
		cliente.setContacto(new Contacto("CharlyG@music", "9876543", "Re_fijo"));
		  try { 
			  abmCliente.modificar(cliente);
		  System.out.println(abmCliente.traer(2L)); } catch (Exception e) {
		  e.printStackTrace(); }
		

		try {
			long idClie = abmCliente.agregar("1", "2", 14000004, LocalDate.of(1960, 9, 10), false,
					new Contacto("jnicholson@unla.edu.ar", "22-2222-2222", "022-2222-2222"));
			System.out.println(abmCliente.traer(idClie));
		} catch (Exception e) {
			e.printStackTrace();
		}

		*/

	}
}
