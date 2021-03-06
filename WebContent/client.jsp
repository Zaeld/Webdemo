<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="domaine.Client"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Client</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="CSS/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src='js/js.js'></script>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="index.html">Acceuil <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="maphoto.html">Ma
					photo</a></li>
			<li class="nav-item"><a class="nav-link" href="mavideo.html">Ma
					vid�o</a></li>
			<li class="nav-item"><a class="nav-link" href="ListeClients">Liste
					des Clients</a></li>
		</ul>
	</div>
	</nav>
		<div class="container">
		<div class="text-center">
		<div class="row">
		<c:out value="${client}"></c:out>
		<p class="col"><a class="btn btn-success" href="ModifierClient?idClient=${client.getIdClient()}"><span class="glyphicon glyphicon-list"></span>Modifier Client</a>
      <p class="col"><a class="btn btn-danger" href="SupprimerClient?idClient=${client.getIdClient()}"><span class="glyphicon glyphicon-list"></span>Supprimer Client</a>
</div>
</div>
</div>
</body>
</html>