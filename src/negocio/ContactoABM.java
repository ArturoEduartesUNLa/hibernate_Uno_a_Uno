package negocio;

import java.util.List;

import dao.ClienteDao;
import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
	ContactoDao dao = new ContactoDao();

	public Contacto traer(long idContacto) {
		return dao.traer(idContacto);

	}

	public List<Contacto> traer(){
		return dao.traer();
	}
	
	public int agregar(String email, String movil, String fijo, Cliente c) throws Exception {
		
		// validar excepciones
		if(c == null)
			throw new Exception("se necesita un cliente al cual agregar el contacto: ");
		
		Cliente cliente = new ClienteABM().traer(c.getDni());

		// lanzar excepcion si cliente no existe
		if (cliente == null) {
			throw new Exception("No existe cliente: " + c.getDni());
		}
		// lanzar excepcion si el cliente ya tiene un contacto
		if (cliente.getContacto() != null) {
			throw new Exception("Cliente Id: " + c.getIdCliente() + " ya posee contacto: " + c.getContacto());
		}
		
		cliente.setContacto(new Contacto(email, movil, fijo));
		return (int) dao.agregar(cliente.getContacto());
		//ClienteABM abmCliente = new ClienteABM();
		//abmCliente.modificar(cliente);
		//return (int) cliente.getIdCliente();
		
	}

	public void modificar(Contacto c) {
		dao.actualizar(c);
	}

	public void eliminar(long IdContacto) throws Exception {
		Contacto eliminaContacto;
		if ((eliminaContacto = traer(IdContacto)) == null) {
			throw new Exception("no existe contacto: " + IdContacto);
		}
		dao.eliminar(eliminaContacto);
	}
}
