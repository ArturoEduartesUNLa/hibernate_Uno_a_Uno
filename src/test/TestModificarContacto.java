package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Contacto;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestModificarContacto {

	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		ContactoABM abmContacto = new ContactoABM();

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

		

	}
}
