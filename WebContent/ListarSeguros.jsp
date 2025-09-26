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
	<a href="Inicio.jsp">Inicio</a>   <a href="servletSeguro?Param=1"> Agregar Seguros</a>   <a href="ListarSeguros.jsp"> Listar seguros</a>

<form action="servletSeguro" method="post">
	<br>
	<br>
	<b>"Tipo de seguros en la base de datos"</b>
	<br>
	<br>

	<%
	//No encontré la manera de cargarlo directamente desde el servlet
	DaoSeguro daoSeguro= new DaoSeguro();
	ArrayList<String> listaTipoSeguro = daoSeguro.obtenerTipoSeguro();
	%>

	Busqueda por tipo de seguro:

	<select name="TipoDeSeguro">
		<%
		int indice=1;
		for (String descripcion : listaTipoSeguro) {
		%>
		<option value=<%=indice%>>
			<%=descripcion%>
		</option>
		<%
		indice++;
		}
		%>
	</select>

	<input type="submit" name="btnFiltrar" value="Filtrar">
	<%
			ArrayList<Seguro> listaSeguros=daoSeguro.obtenerSeguros();
		if(request.getParameter("btnFiltrar")!=null){
			listaSeguros = (ArrayList<Seguro>)request.getAttribute("listaSeguros");
		}
	%>

	<table border="1">

		<tr>
			<th>ID Seguro</th>
			<th>Descripción Seguro</th>
			<th>Descripción Tipo Seguro</th>
			<th>Costo Contratación</th>
			<th>Costo Máximo Asegurado</th>
		</tr>
		<%	
		for (Seguro seguro : listaSeguros) {
		%>
		<tr>
			<th><%=seguro.getIdSeguro()%></th>
			<th><%=seguro.getDescripcion()%></th>
			<th><%=seguro.getIdTipo()%></th>
			<th><%=seguro.getCostoContratacion()%></th>
			<th><%=seguro.getCostoAsegurado()%></th>
		</tr>
		<%
		}
		%>

	</table>
	</form>

</body>
</html>