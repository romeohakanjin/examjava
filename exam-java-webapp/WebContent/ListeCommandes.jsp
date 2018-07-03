<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Commande"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Liste des commandes</h2>
				<%
					List<Commande> commandesList = (List<Commande>) request.getAttribute( "commandesList" );
					List<String> nomFournisseursList = (List<String>) request.getAttribute("fournisseursList");
	
					if (commandesList.size() == 0) {
				%>
				<p>Il n'y a aucune commande</p>
				<%
					} else {
				%>
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
						<%
							for(int i = 0; i<commandesList.size(); i++){
						%>
						<tr>
							<th scope="row"><a href="ControllerServlet?action=commandeDetail&idCommande=<%= commandesList.get(i).getId() %>"><%= commandesList.get(i).getId() %></a></th>
							<td><%= commandesList.get(i).getDate().toString() %></td>
							<td><%= commandesList.get(i).getProduit() %></td>
							<td><%= commandesList.get(i).getQuantite() %></td>
							<td><%= commandesList.get(i).getPrix() %></td>
							<td><%= nomFournisseursList.get(i) %></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<%
					}
				%>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />