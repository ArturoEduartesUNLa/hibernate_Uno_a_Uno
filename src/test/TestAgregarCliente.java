package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Contacto;
import negocio.ClienteABM;

/*COMPLETE ver en la definicion del metodo agregar la estrategia utilizada en cada caso
 * con y sin contacto asociado
 */
public class TestAgregarCliente {

	public static void main(String[] args) {

		System.out.println("UC 1 - agregar Cliente\n");
		ClienteABM abmCliente = new ClienteABM();

		// COMMENT agregar cliente con contacto
		try {
			System.out.println(
					abmCliente.traer(abmCliente.agregar("Franz", "Ferdinand", 45454545 + LocalTime.now().getSecond(),
							LocalDate.now(), false, new Contacto("licsistemas@unla.com", "movil", "fijo"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// COMMENT agregar cliente sin contacto
		try {
			System.out.println(abmCliente.traer(abmCliente.agregar("Claude", "Debussy",
					9898980 + LocalTime.now().getSecond(), LocalDate.now(), false, null)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
