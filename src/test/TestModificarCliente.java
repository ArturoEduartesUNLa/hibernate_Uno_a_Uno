package test;

import java.time.LocalTime;

import datos.Cliente;
import negocio.ClienteABM;

/* COMPLETE
 * 
 */
public class TestModificarCliente {

	public static void main(String[] args) {
		
		System.out.println("UC 2 - modificar Cliente\n");
		System.out.println(new ClienteABM().traer(4L)); // traer por IdCliente

		// modificar
		Cliente clienteMod = new ClienteABM().traer(4L);
		clienteMod.setNombre(clienteMod.getNombre() + "_" + LocalTime.now().getSecond());

		try {
			new ClienteABM().modificar(clienteMod);
			System.out.println(new ClienteABM().traer(4L)); // traer por IdCliente
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
