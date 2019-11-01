
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
            
        
         <form  class="form-register"  class="form-register col-10" method="post" action="addCustomer">
             <fieldset class="border p-2"> 
                 
                 <legend  class="w-auto"> Customer Registration</legend>
               
                    <input type="text" class="form-control" placeholder="Contact Number" name="contactNo" maxlength="12" minlength="10" pattern="^[a-zA-Z0-9_.-]*$"  title="please enter a valid contact number" required autofocus><br>
                    <input type="email" name="email" class="form-control" placeholder="Email address"  title="eg:john@gmail.com" required autofocus><br>
                    <input type="text" name="nic" class="form-control" placeholder="NIC Number" pattern="[0-9]{9}[x|X|v|V]$" title="please enter a valid NIC number" required autofocus><br>
                    <input type="Date" name="dob" class="form-control" placeholder="Date of Birth" required autofocus><br>
<!--                <input type="text" name="slmcNo" class="form-control" placeholder="SLMC Registration Number" required autofocus><br>-->
                    <input type="text" name="username" class="form-control" placeholder="Username" min="4" max="15"  title="please enter a valid Username" required autofocus><br>
                    <input type="text"  name="password" class="form-control" placeholder="Password" minlength="6" required autofocus><br>                
                 
                 
                 <button type="submit" class="btn btn-outline-primary btn-lg btn-block">Sign Up</button><br><br>
                <p>have an Account? <a href="/login">Login Now!</a></p>
                 
            </fieldset>
         </form>
    

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>
      
</body>
</html>