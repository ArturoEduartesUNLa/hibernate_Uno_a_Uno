package datos;

import java.util.Objects;

public class Contacto {
	private long idContacto;
	private String email;
	private String movil;
	private String fijo;

	public Contacto() {
		super();
	}

	public Contacto(String email, String movil, String fijo) {
		super();
		this.email = email;
		this.movil = movil;
		this.fijo = fijo;
	}

	public long getIdContacto() {
		return idContacto;
	}

	protected void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getFijo() {
		return fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fijo, idContacto, movil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Contacto))
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(email, other.email) && Objects.equals(fijo, other.fijo) && idContacto == other.idContacto
				&& Objects.equals(movil, other.movil);
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", email=" + email + ", movil=" + movil + ", fijo=" + fijo
				+ "]\n";
	}

}
