<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.09.2016
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>Registration</title>
    </head>
    <body>
        <div class="main">
           <form action='' method='POST' >
           <p> Enter your fullname <br>
               <input type ='text' name='fullname'> </p>
           p>Enter e-mail <br>
            <input type='email' name='login'> </p>
           <p> Enter password at least 6 character <br>
            <input type='password' name='password'> </p>
           <p> Confirm password<br>
            <input type='password' name='repassword'> </p>
           <input type='radio' name='gender' value='1'> Male <br>
           <input type='radio' name='gender' value='0'> Female <br>
           <p><select name='country' required>
               <option></option>
               <option disabled> Select country</option>
               <option>China</option>
               <option>France</option>
               <option>Germany </option>
               <option>Russia</option>
               <option>USA</option>
                </select> </p>
            <p><textarea name='aboutYourself' placeholder='Read about yourself'></textarea> </p>
            <p><input type='checkbox' name='newsletter'> Subcsribe newsletter </p>
            <input type='submit' value='Registration'></form>


        </div>

    </body>
</html>
