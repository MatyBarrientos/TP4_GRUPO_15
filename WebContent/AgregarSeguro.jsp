<%@ page import="dominio.Usuario"%>
<%@ page import="dominio.Seguro"%>
<%@ page import="dominio.DaoSeguro"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<a href="Inicio.jsp"> Inicio </a>
	<a href="servletSeguro?Param=1"> Agregar Seguros</a>
	<a href="ListarSeguros.jsp"> Listar seguros</a>
	<br>
	<br>

	<form action=servletSeguro method="post">


		<%
		
		int proxID = 0;
		if (request.getAttribute("proximoID") != null) {
			proxID = (int) request.getAttribute("proximoID");
		}
		%>
		
		<%
		
		ArrayList<String> listaTipoSeguros = null;
		if (request.getAttribute("listaTipoSeguro") != null)
			listaTipoSeguros = (ArrayList<String>) request.getAttribute("listaTipoSeguro");
		%>

		Id Seguro : <b><i><label><%=proxID%></label></i></b> <br> 
		Decripción: <input type="text" name="txtDescripcionSeguro"><br>
		 Tipo de seguro: <select name="TipoDeSeguro">
			<%
			int indice = 1;
			for (String descripcion : listaTipoSeguros) {
			%>
			<option value=<%=indice%>>
				<%=descripcion%>
			</option>
			<%
			indice++;
			}
			%>
		</select><br> 
		Costo contratación: <input type="text" name="txtCostoContratacion" ><br>
		 Costo Máximo Asegurado <input type="text" name="txtCostoMaximoAsegurado" ><br>
		  <input type="submit" name="btnAceptar">


		<!--Marcos te agregué el label PD: extraño C# para estas cositas ajajaj-->
		
		<%
				int fila = 0;
		if (request.getAttribute("fila") != null) 
			fila = (int) request.getAttribute("fila");
		
		
		if(fila==1){%>
		<br><br><br><label>Seguro agregado con Exito</label>
		<% }%>
		

	</form>

</body>
</html>