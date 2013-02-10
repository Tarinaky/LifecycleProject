<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style.css" type="text/css" />
<title> Monster Mash </title>
<script type="text/javascript">

/*This function checks that the email address entered in by the user
is valid and if not then it alerts the user appropriately.*/
function validate(form) {
    var email = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    var emailValue = document.forms["details"]["email"].value;
    if (!email.test(emailValue)) {
    	alert("Please enter a valid email address");
        return false;
    }
	return true;
}
</script>
</head>
<body>
<div id="container">
	<div id="header">
	<img src="header.png" />
		<div id="navigation">
			<ul>
				<li><a href="login.jsp">Login</a></li>
			</ul>
		</div>	
	</div>   
	<div id="content">
	    <img class="page_header" src="createaccount.png" />
        <form id="details" action ="Register" method="get" onsubmit="return validate(this)">
           <p style="text-align:center;">UserName: <input type="text" name="userName" size="20" maxlength="60" /> </p>
           <p style="text-align:center;">Password: <input type="password" name="password" size="20" maxlength="60" /> </p>  
           <p style="text-align:center;">Re-enter Password: <input type="password" name="pasword" size="20" maxlength="60" /> </p>     
           <p style="text-align:center;"><input style = "text-align: center" type="submit" name="submit" value="Submit" /></p>
        </form>
        </div>
		<div id="footer">
			<p>Monster Mash &copy; 2013 MonsterMash.com</p> 
		</div>
</div>
</body>
</html>