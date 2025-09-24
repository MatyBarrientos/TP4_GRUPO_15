package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoSeguro {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "SegurosGroup";

	public int agregarSeguro(Seguro seguro) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int filas = 0;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement consulta = conn.prepareStatement(
					"Insert into seguros (descripcion,idTipo,costoContratacion,costoAsegurado) values (?,?,?,?)");
			consulta.setString(1, seguro.getDescripcion());
			consulta.setInt(2, seguro.getIdTipo());
			consulta.setFloat(3, seguro.getCostoContratacion());
			consulta.setFloat(4, seguro.getCostoAsegurado());
			filas = consulta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public ArrayList<Seguro> obtenerSeguros() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();

			ResultSet rs = st
					.executeQuery("Select idSeguro,descripcion,idTipo,costoContratacion,costoAsegurado FROM seguros");

			while (rs.next()) {

				Seguro seguroRs = new Seguro();
				seguroRs.setIdSeguro(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setIdTipo(rs.getInt("idTipo"));
				seguroRs.setCostoContratacion(rs.getFloat("costoContratacion"));
				seguroRs.setCostoAsegurado(rs.getFloat("costoAsegurado"));
				lista.add(seguroRs);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return lista;
	}
	
	public ArrayList<String> obtenerTipoSeguro() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> lista = new ArrayList<String>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("Select descripcion FROM tiposeguros");

			while (rs.next()) {

				String descripcion=rs.getString("descripcion");
				lista.add(descripcion);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return lista;
	}
	
	public ArrayList<Seguro> obtenerSegurosID(int IDseguro) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = conn.prepareStatement("Select idSeguro,descripcion,idTipo,costoContratacion,costoAsegurado FROM seguros where idTipo=?");
			miSentencia.setInt(1, IDseguro); // Cargo el ID recibido
			ResultSet rs = miSentencia.executeQuery();
			
			while (rs.next()) {

				Seguro seguroRs = new Seguro();
				seguroRs.setIdSeguro(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setIdTipo(rs.getInt("idTipo"));
				seguroRs.setCostoContratacion(rs.getFloat("costoContratacion"));
				seguroRs.setCostoAsegurado(rs.getFloat("costoAsegurado"));
				lista.add(seguroRs);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public Integer obtenerUltimoIdSeguro() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String consulta = "SELECT MAX(idSeguro) AS ultimoId FROM seguros";
	    try {
	    	Connection c = DriverManager.getConnection(host+dbName, user, pass);
	         PreparedStatement ps = c.prepareStatement(consulta);
	         ResultSet rs = ps.executeQuery();
	        if (rs.next()) return rs.getInt("ultimoId");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return (Integer) null;
	}
	

}