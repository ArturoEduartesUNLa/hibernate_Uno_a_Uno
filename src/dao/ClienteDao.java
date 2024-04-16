package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cliente;

public class ClienteDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("error en las capa de datos:" + he);
	}

	public int agregar(Cliente c) {
		int id = 0;
		try {
			iniciaOperacion();
			id = (int) session.save(c);
			tx.commit();

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;

	}

	public void actualizar(Cliente c) {
		try {
			iniciaOperacion();
			session.update(c);
			tx.commit();

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}

	}

	public void eliminar(Cliente c) {
		try {
			iniciaOperacion();
			session.delete(c);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Cliente traer(long idCliente) {
		Cliente cliente = null;
		try {
			iniciaOperacion();
			cliente = session.get(Cliente.class, idCliente);

		} finally {
			session.close();
		}
		return cliente;
	}

	public Cliente traer(int dni) {

		Cliente cliente = null;
		try {
			iniciaOperacion();
			cliente = session.createQuery("from Cliente c where c.dni = :dni", Cliente.class).setParameter("dni", dni)
					.uniqueResult();

		} finally {
			session.close();
		}
		return cliente;

	}

	public List<Cliente> traer() {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			iniciaOperacion();
			Query<Cliente> qry = session.createQuery("from Cliente c order by c.idCliente asc", Cliente.class);
			lista = qry.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public Cliente traerClienteYContacto(long idCliente) {
		Cliente c = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c inner join fetch c.contacto where c.IdCliente = :IdCliente";
			c = (Cliente) session.createQuery(hql, Cliente.class).setParameter("idCliente", idCliente);

		} finally {
			session.close();
		}
		return c;
	}
}