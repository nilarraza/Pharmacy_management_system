
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

         <form   class="form-register" name="form1"  class="form-register col-10" method="post" action="/sendCancelMail" >
             <fieldset class="border p-2"> 
            
                 
                 <legend  class="w-auto">  Cancel Order</legend>
                	<input type="text" class="form-control" placeholder="mail" name="mail" value="${mail}" readonly required autofocus><br>          
                    <input type="text" class="form-control" placeholder="subject" name="subject" value="Order Confirmation"  readonly required autofocus><br>   
                      <input type="text" class="form-control" placeholder="content" name="content"    required autofocus><br>                 
					<button type="submit"  name="submit"  class="btn btn-outline-primary btn-lg btn-block">Send Mail </button><br><br>
               
                 
            </fieldset>
         </form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>
      
</body>
</html>