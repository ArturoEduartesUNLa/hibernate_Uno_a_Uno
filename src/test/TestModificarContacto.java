package test;

import java.time.LocalTime;

import datos.Contacto;
import negocio.ContactoABM;

/* COMPLETE
 * 
 */
public class TestModificarContacto {

	public static void main(String[] args) {
		
		System.out.println("UC 2 - modificar Contacto\n");
		System.out.println(new ContactoABM().traer(2)); // traer por IdContacto

		// modificar
		Contacto contactoMod = new ContactoABM().traer(2);
		contactoMod.setEmail(contactoMod.getEmail() + "_" + LocalTime.now().getSecond());

		new ContactoABM().modificar(contactoMod);
		System.out.println(new ContactoABM().traer(2)); // traer por IdContacto

	}
}
