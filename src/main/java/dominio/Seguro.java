package dominio;

import java.math.BigDecimal;
import java.util.Objects;

public class Seguro {

	
private int idSeguro;
private String descripcion;
private int idTipo;
private BigDecimal costoContratacion;
private BigDecimal costoAsegurado;




public Seguro(int idSeguro, String descripcion, int idTipo, BigDecimal costoContratacion, BigDecimal costoAsegurado) {
	super();
	this.idSeguro = idSeguro;
	this.descripcion = descripcion;
	this.idTipo = idTipo;
	this.costoContratacion = costoContratacion;
	this.costoAsegurado = costoAsegurado;
}


public Seguro() {
	super();
	// TODO Auto-generated constructor stub
}





public int getIdSeguro() {
	return idSeguro;
}


public void setIdSeguro(int idSeguro) {
	this.idSeguro = idSeguro;
}


public String getDescripcion() {
	return descripcion;
}


public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


public int getIdTipo() {
	return idTipo;
}


public void setIdTipo(int idTipo) {
	this.idTipo = idTipo;
}


public BigDecimal getCostoContratacion() {
	return costoContratacion;
}


public void setCostoContratacion(BigDecimal costoContratacion) {
	this.costoContratacion = costoContratacion;
}


public BigDecimal getCostoAsegurado() {
	return costoAsegurado;
}


public void setCostoAsegurado(BigDecimal costoAsegurado) {
	this.costoAsegurado = costoAsegurado;
}


@Override
public int hashCode() {
	return Objects.hash(costoAsegurado, costoContratacion, descripcion, idSeguro, idTipo);
}

/*
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Seguro other = (Seguro) obj;
	return Float.floatToIntBits(costoAsegurado) == Float.floatToIntBits(other.costoAsegurado)
			&& Float.floatToIntBits(costoContratacion) == Float.floatToIntBits(other.costoContratacion)
			&& Objects.equals(descripcion, other.descripcion) && idSeguro == other.idSeguro && idTipo == other.idTipo;
}

*/
@Override
public String toString() {
	return "Seguro [idSeguro=" + idSeguro + ", descripçion=" + descripcion + ", idTipo=" + idTipo
			+ ", costoContratacion=" + costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
}


}
