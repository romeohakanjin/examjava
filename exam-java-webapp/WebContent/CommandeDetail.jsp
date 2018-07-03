<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />
<%@ page import="java.util.List" %>
<%@ page import="webservice.Commande"%>
<% Commande commande = (Commande) request.getAttribute("commande"); %>
<% String nomFournisseur = (String) request.getAttribute("fournisseur"); %>
<div  class="gestion-commande">
	<!-- <div class="header-container">
		<div>
			<ul>
				<li><a href="ControllerServlet?action=modifierCommande" class="modifier">Modifier</a></li>
			</ul>
		</div>
		<div>
	</div> -->
	<div class="container">
		<div id="content">
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
							<th scope="row"><a href="ControllerServlet?action=commandeDetail"><%= commande.getId() %></a></th>
							<td><%= commande.getDate().toString() %></td>
							<td><%= commande.getProduit() %></td>
							<td><%= commande.getQuantite() %></td>
							<td><%= commande.getPrix() %></td>
							<td><%= nomFournisseur %></td>
						</tr>
					</tbody>
				</table>
			</div>            
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />