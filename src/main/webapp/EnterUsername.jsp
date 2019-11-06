<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

		<form class="form-signin" class="form-signin col-10" method="post" action="/resetPasswordEmail">
      <fieldset class="border p-2"> 
      <legend  class="w-auto">Reset</legend> 
      

       
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        
        <span>${msg}</span>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Reset Password</button><br><br>
        
        </fieldset>
      </form>

</body>
</html>