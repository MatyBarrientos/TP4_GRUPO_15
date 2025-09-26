package servlets;


import java.math.BigDecimal;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import dominio.DaoSeguro;
import dominio.Seguro;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletSeguro() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		// los dejo aca arriba, me van a ser de ayuda.

		DaoSeguro daoSeguro = new DaoSeguro();
		if(request.getParameter("Param") !=null) {
			
			
			// 1ero devuelvo el ultimo Id
			int proximoID = daoSeguro.obtenerUltimoIdSeguro() + 1;
			request.setAttribute("proximoID", proximoID);
			//2do vamos con los tipos de seguros
			ArrayList<String> listaTipoSeguro = daoSeguro.obtenerTipoSeguro();
			request.setAttribute("listaTipoSeguro", listaTipoSeguro);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Seguro seguro = new Seguro();
		DaoSeguro daoSeguro = new DaoSeguro();
		
		
		
		//es el filtro del listarSeguros.jsp
		if(request.getParameter("btnFiltrar") != null) {
			int ID=Integer.parseInt(request.getParameter("TipoDeSeguro"));
			ArrayList<Seguro> listaSegurosID = daoSeguro.obtenerSegurosID(ID);
			request.setAttribute("listaSeguros", listaSegurosID);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}
		


		// 3ro agregar Seguro nuevo
		if (request.getParameter("btnAceptar") != null) {
			
			int filas = 0;
			
			String costoContrStr = request.getParameter("txtCostoContratacion");
			String costoMaxStr   = request.getParameter("txtCostoMaximoAsegurado");

			// Quitamos separadores de miles "." y cambia coma decimal por punto y un trim() por las dudas
			String normContr = costoContrStr.replace(".", "").replace(",", ".").trim();
			String normMax   = costoMaxStr.replace(".", "").replace(",", ".").trim();

			BigDecimal costoContr = new BigDecimal(normContr);
			BigDecimal costoMax   = new BigDecimal(normMax);
		    
			seguro.setIdSeguro(daoSeguro.obtenerUltimoIdSeguro() + 1);
			seguro.setIdTipo(Integer.parseInt(request.getParameter("TipoDeSeguro")));
			seguro.setDescripcion(request.getParameter("txtDescripcionSeguro"));
			seguro.setCostoContratacion(costoContr);
			seguro.setCostoAsegurado(costoMax);
			
			filas = daoSeguro.agregarSeguro(seguro);
			
			//los repetí acá para cuando agrego un seguro no me tire error.
			//esto se hace en el doGet en realidad
			int proximoID = daoSeguro.obtenerUltimoIdSeguro() + 1;
			request.setAttribute("proximoID", proximoID);
			
			ArrayList<String> listaTipoSeguro = daoSeguro.obtenerTipoSeguro();
			request.setAttribute("listaTipoSeguro", listaTipoSeguro);
			/////////////////////////////////////////////////////////////
			//para la banderita
			request.setAttribute("fila", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
			rd.forward(request, response);
		}

	}

}
