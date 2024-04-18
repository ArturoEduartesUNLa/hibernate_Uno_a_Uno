package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Contacto;

public class ContactoDao {
	private static Session session;
	private Transaction tx;

	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejarExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("error en la capa de datos: " + he);
	}

	public long agregar(Contacto c) {
		long id = 0;
		try {
			iniciarOperacion();
			id = (long) session.save(c);
			tx.commit();
		} catch (HibernateException he) {
			manejarExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;

	}

	public void actualizar(Contacto c) {
		try {
			iniciarOperacion();
			session.update(c);
			tx.commit();
		} catch (HibernateException he) {
			manejarExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Contacto c) {
		try {
			iniciarOperacion();
			session.delete(c);
			tx.commit();
		} catch (HibernateException he) {
			manejarExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Contacto traer(long idContacto) {
		Contacto c = null;
		try {
			iniciarOperacion();
			c = session.get(Contacto.class, idContacto);
		} finally {
			session.close();
		}
		return c;
	}

	public List<Contacto> traer() {
		List<Contacto> lista = new ArrayList<Contacto>();
		try {
			Query<Contacto> qry = session.createQuery("from Contacto c order by c.idContacto asc", Contacto.class);
			lista = qry.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
}
