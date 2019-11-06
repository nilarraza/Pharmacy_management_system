
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="css/docRegister.css">
<link rel="stylesheet" href="css/Mycard.css">
</head>

<body class="text-center">

	<a href="/success" class="btn btn-primary btn-lg active" role="button"
		aria-pressed="true">Home</a>


	<legend class="w-auto"> My Card</legend>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Delete</th>
				

			</tr>
		</thead>

		<tbody>
			<c:forEach var="drug" items="${drugs }">
				<tr>

					<td>${drug.id}</td>
					<td>${drug.pid}</td>
					<td>${drug.price}</td>
					<td><a href="/deleteDrugSp?id=${drug.id}"><i
							class="fas fa-trash-alt"></i></a></td>
					


				</tr>
				
			</c:forEach>
			
			 <form   class="form-register"  method="post" action="/purchase">
			<tr>
			<td></td>
			<td></td>
			<td><input type="text" name="total" value="${total}" readonly></td>
			<td><input type="text" name="promo" placeholder="Enter Promotion code"></td>
			 <td><button type="submit" name="submit"  class="btn btn-primary">Purchase</button></td>
			</tr>
			
			</form>


		</tbody>
	</table>
	



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>