package dominio;

import java.util.Objects;

public class Contratacion {

	private int idContratacion;
	private String userName;
	private int idSeguro;
	private float costoAsegurado;
	
	
	

	public Contratacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contratacion(int idContratacion, String userName, int idSeguro, float costoAsegurado) {
		super();
		this.idContratacion = idContratacion;
		this.userName = userName;
		this.idSeguro = idSeguro;
		this.costoAsegurado = costoAsegurado;
	}
	public int getIdContratacion() {
		return idContratacion;
	}
	public void setIdContratacion(int idContratacion) {
		this.idContratacion = idContratacion;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public float getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(costoAsegurado, idContratacion, idSeguro, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contratacion other = (Contratacion) obj;
		return Float.floatToIntBits(costoAsegurado) == Float.floatToIntBits(other.costoAsegurado)
				&& idContratacion == other.idContratacion && idSeguro == other.idSeguro
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "Contratacion [idContratacion=" + idContratacion + ", userName=" + userName + ", idSeguro=" + idSeguro
				+ ", costoAsegurado=" + costoAsegurado + "]";
	}
	
}
