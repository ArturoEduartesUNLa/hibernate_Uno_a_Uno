package test;

/* COMPLETE 
 * 
 */
public class Test_Integral {

	public static void main(String[] args) {

		System.out.println("Test Integral hibernate Uno a Uno\n");

		TestAgregarCliente.main(args);
		TestAgregarContacto.main(args);

		TestModificarContacto.main(args);
		TestModificarCliente.main(args);

		TestEliminarContacto.main(args);
		TestEliminarCliente.main(args);

	}
}
