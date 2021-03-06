<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<meta equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="homepage">
	<div id="page-wrapper">
		<div id="header-wrapper">
			<header id="header" class="container">
				<div id="logo">
					<h1>
						<a href="Home.jsp">Exam-Java</a>
					</h1>
				</div>
				<nav id="nav">
					<ul>
						<li id="home"><a href="Home.jsp">Accueil</a></li>
						<%
							if (session.getAttribute("session-role") == "responsableAchat") {
						%>
						<li id="gestionResponsableAchat"><a href="ControllerServlet?action=listeCommandes">Gestion Commandes</a>
							<ul>
								<li class="current" id="commandesList"><a href="ControllerServlet?action=listeCommandes">Récapitulatif des commandes</a></li>
							</ul>
						</li>
						<%
							}else if(session.getAttribute("session-role") == "responsableStock"){
						%>
						<li id="gestionResponsableStock"><a href="ControllerServlet?action=listeLivraisons">Gestion stock</a>
							<ul>
								<li id="listeAccusesReceptions"><a href="ControllerServlet?action=listeAccusesReceptions">Liste des accusés réceptions</a></li>
								<li id="listeLivraisons"><a href="ControllerServlet?action=listeLivraisons">Liste des livraisons</a></li>
							</ul>
						</li>
						<li id="gestionResponsableStock"><a href="ControllerServlet?action=listeCommandes">Gestion Commandes</a>
							<ul>
								<li class="current" id="commandesList"><a href="ControllerServlet?action=listeCommandes">Récapitulatif des commandes</a></li>
							</ul>
						</li>
						<%
							}else if(session.getAttribute("session-role") == "comptable"){
						%>
						<li id="gestionComptablePaiement"><a href="ControllerServlet?action=listePaiements">Gestion Paiements</a>
							<ul>
								<li id="listeFactures"><a href="ControllerServlet?action=listeFactures">Liste des factures</a></li>
								<li class="current" id="paiementsList"><a href="ControllerServlet?action=listePaiements">Récapitulatif des paiements</a></li>
							</ul>
						</li>
						<li id="gestionComptableCommande"><a href="ControllerServlet?action=listeCommandes">Gestion Commandes</a>
							<ul>
								<li class="current" id="commandesList"><a href="ControllerServlet?action=listeCommandes">Récapitulatif des commandes</a></li>
							</ul>
						</li>
						<%
							}
						%>
						<%
							if (session.getAttribute("login") != null) {
						%>
						<li id="deconnexion"><a href="ControllerServlet?action=deconnexion">Déconnexion</a></li>
						<%
							} else {
						%>
						<li id="connexion"><a href="Connexion.jsp">Connexion</a></li>
						<%
							}
						%>
					</ul>
				</nav>
			</header>
		</div>
		
		<!-- Contenu partiel -->
		<div class="content">
			<%
				if (request.getAttribute("alert-success") != null) {
			%>
				<div class="alert alert-success" role="alert">
				  <p><%= request.getAttribute("alert-success") %></p>
				</div>
			<%
				request.removeAttribute("alert-success");
			
				} else if (request.getAttribute("alert-info") != null) {
			%>
				<div class="alert alert-info" role="alert">
				  <p><%= request.getAttribute("alert-info") %></p>
				</div>
			<%
				request.removeAttribute("alert-info");
			
				} else if (request.getAttribute("alert-warning") != null){
			%>
				<div class="alert alert-warning" role="alert">
				  <p><%= request.getAttribute("alert-warning") %></p>
				</div>							
			<% 
				request.removeAttribute("alert-warning");
			
			} else if (request.getAttribute("alert-danger") != null){ 
			%>
				<div class="alert alert-danger" role="alert">
				  <p><%= request.getAttribute("alert-danger") %></p>
				</div>							
			<% 
				request.removeAttribute("alert-danger");
			} %>
			
