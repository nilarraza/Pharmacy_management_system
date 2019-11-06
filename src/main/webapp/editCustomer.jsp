
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   
     <link rel="stylesheet" href="css/docRegister.css" >
</head>
    
<body class="text-center">

         <form   class="form-register" name="form1"  class="form-register col-10" method="post" action="updateCustomer" >
             <fieldset class="border p-2"> 
            
                 
                 <legend  class="w-auto">  Edit Details</legend>
                	<input type="text" class="form-control" placeholder="user_id" name="user_id" value="${user.user_id}" readonly required autofocus><br>          
                    <input type="text" class="form-control" placeholder="contactNo" name="contactNo" value="${user.contactNo}"  required autofocus><br>          
                    <input type="text" name="email" class="form-control" placeholder="email" value="${user.email}" required autofocus><br>
                     <input type="text" name="nic" class="form-control" placeholder="nic" value="${user.nic}" required autofocus><br>
                    <input type="text" name="dob" class="form-control" placeholder="dob" value="${user.dob}" required autofocus><br>                                      	 
                  	  <input type="text" name="role" class="form-control" placeholder="role" value="${user.role}" readonly autofocus><br>
                    	<input type="text" name="username" class="form-control" placeholder="username" value="${user.username}" required autofocus><br>
                  	  <input type="text" name="password" class="form-control" placeholder="password"  value="${user.password}" readonly required autofocus><br>
                    
                    
                 <button type="submit"  name="submit" value="Update Pharmasist" class="btn btn-outline-primary btn-lg btn-block">Save </button><br><br>
               
                 
            </fieldset>
         </form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>
      
</body>
</html>