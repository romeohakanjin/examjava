<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />
<%@ page import="java.util.List" %>
<%@ page import="webservice.Commande"%>

<div  class="gestion-commande">
	<div class="container">
		<div id="content">
			<%-- <%
			if (request.getParameter("action") == "commandeDetail") {
			%>	 --%>
				<%
				if (request.getAttribute("commande") != null) {
					Commande commande = (Commande) request.getAttribute("commande");
				%>
				<h2 class="info-perso">Détails de la commande</h2>
				<div id="content">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Date</th>
								<th scope="col">Produit</th>
								<th scope="col">Quantité</th>
								<th scope="col">Prix</th>
								<th scope="col">Nom fournisseur</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row"><%= commande.getId() %></th>
								<td><%= commande.getDate().toString() %></td>
								<td><%= commande.getProduit() %></td>
								<td><%= commande.getQuantite() %></td>
								<td><%= commande.getPrix() %></td>
								<td><%= request.getAttribute("fournisseur") %></td>
							</tr>
						</tbody>
						<a href="ControllerServlet?action=editCommande&idCommande=<%= commande.getId() %>">Modifier</a>
					</table>
					
					<%
					}
					%>
				<%-- <%
				} else if(request.getParameter("action") == "editCommande"){
					%>
					Edit page
					<%
				}
				%> --%>
			</div>            
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />