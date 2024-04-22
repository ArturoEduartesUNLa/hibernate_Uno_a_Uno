package test;

import datos.Contacto;
import negocio.ContactoABM;

/* COMPLETE
 * 
 */
public class TestEliminarContacto {

	public static void main(String[] args) {

		Contacto eliminarContacto = new ContactoABM().traer(4L);
		System.out.println(eliminarContacto);

		try {
			new ContactoABM().eliminar(eliminarContacto.getIdContacto());
			System.out.println(new ContactoABM().traer());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
