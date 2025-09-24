package dominio;

import java.util.Objects;

public class Usuario {

	private String nameUser;
	private String password;
	private int tipoUsuario;
	private String dni;
	private String nombre;
	private String apellido;
	
	
	
	public Usuario(String nameUser, String password, int tipoUsuario, String dni, String nombre, String apellido) {
		super();
		this.nameUser = nameUser;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nameUser=" + nameUser + ", password=" + password + ", tipoUsuario=" + tipoUsuario + ", dni="
				+ dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni, nameUser);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nameUser, other.nameUser);
	}
	
	
	
}
