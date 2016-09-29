package ru.kpfu.servlets;

import ru.kpfu.repositories.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Admin on 20.09.2016.
 */
public class RegistrationServlet extends HttpServlet {
    private DataBase db = new DataBase();
    private String name="" ;
    private String login="";
    private String password;
    private String repassword;
    private String gender = "-1";
    private String country;
    private String aboutYourself="";
    private String newsletter;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        out.println(getErrorPageCode(""));
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String[] data = new String[7];
         name = req.getParameter("fullname");
         login = req.getParameter("login");
         password = req.getParameter("password");
         repassword = req.getParameter("repassword");
         gender = req.getParameter("gender");
         country = req.getParameter("country");
         aboutYourself = req.getParameter("aboutYourself");
         newsletter = req.getParameter("newsletter");

        String errorMessage="Check all items: <br>";
        PrintWriter out = resp.getWriter();

        if(db.Reader(login)) errorMessage+="This login already taken <br>";
        if(name.equals("")) errorMessage+="Enter the name <br>";
        if(!name.matches("^[a-zA-Z\\s{,2}]{0,50}$")) errorMessage+= "Name must contain valid characters <br>";
        if(!login.matches("^[a-zA-Z0-9_@.-]{11,25}$")) errorMessage+= "Login must contain valid characters and have a length from 11 to 25 <br>";
        if(password.length()<6) errorMessage+="The password must be at least 6 characters <br>";
        if(!password.equals(repassword)) errorMessage+="Passwords don't match";
        if(gender!=null){
            if(gender.equals("-1"))
                errorMessage += "Select gender";
        }
        else {
            errorMessage += "Select gender";
            gender = "-1";
        }

        if(errorMessage.equals("Check all items: <br>")) {
            data[0]=login;
            data[1]=name;
            data[2]=password;
            data[3]=gender;
            data[4]=country;
            data[5]=aboutYourself;
            data[6]=newsletter;

            db.Writer(data);
            resp.sendRedirect("/succes");
            out.println("Registration succesful!");
        }
        else{
            out.println(getErrorPageCode(errorMessage));
            errorMessage="Check all items: <br>";
        }
    }

    protected String getPageCode(){
        return
                "<!DOCTYPE html><html>"
                        + "<head><meta charset='UTF-8'><title>Hello page</title></head>"
                        + "<body>"
                        + "<form action='' method='POST' >"
                        + "<p> Enter your fullname <br>"
                        + "<input type ='text' name='fullname'> </p>"
                        +"<p>Enter e-mail <br> "
                        + "<input type='email' name='login'> </p>"
                        + "<p> Enter password at least 6 character <br>"
                        + "<input type='password' name='password'> </p>"
                        + "<p> Confirm password<br>"
                        + "<input type='password' name='repassword'> </p>"
                        + "<input type='radio' name='gender' value='1'> Male <br>"
                        + "<input type='radio' name='gender' value='0'> Female <br>"
                        + "<p><select name='country' required>"
                        + "<option></option>"
                        +"<option disabled> Select country</option>"
                        +"<option>China</option>"
                        +"<option>France</option>"
                        +"<option>Germany </option>"
                        +"<option>Russia</option>"
                        +"<option>USA</option>"
                        +" </select> </p>"
                        + "<p><textarea name='aboutYourself' placeholder='Read about yourself'></textarea> </p>"
                        +"<p><input type='checkbox' name='newsletter'> Subcsribe newsletter </p>"
                        + "<input type='submit' value='Registration'></form>"
//                        + message
                        + "</body></html>";
    }

protected String getErrorPageCode(String message){
        return

                "<!DOCTYPE html><html>"
                        + "<head><meta charset='UTF-8'><title>Hello page</title></head>"
                        + "<body>"
                        + "<form action='' method='POST' >"
                        + "<p> Enter your fullname <br>"
                        + "<input type ='text' name='fullname' value="+name+"> </p>"
                        +"<p>Enter e-mail <br> "
                        + "<input type='email' name='login' value="+login+"> </p>"
                        + "<p> Enter password at least 6 character <br>"
                        + "<input type='password' name='password'> </p>"
                        + "<p> Confirm password<br>"
                        + "<input type='password' name='repassword'> </p>"
                        + "<input type='radio' name='gender' value='1' "+ (gender.equals("1") ? " checked ":" ") +"> Male <br>"
                        + "<input type='radio' name='gender' value='0' "+ (gender.equals("0") ? " checked ":" ") +"> Female <br>"
                        + "<p><select name='country' required value="+country+">"
                        + "<option></option>"
                        +"<option disabled> Select country</option>"
                        +"<option value='China'>China</option>"
                        +"<option>France</option>"
                        +"<option>Germany </option>"
                        +"<option>Russia</option>"
                        +"<option>USA</option>"
                        +" </select> </p>"
                        + "<p><textarea name='aboutYourself' placeholder='Read about yourself'>"+aboutYourself+"</textarea> </p>"
                        +"<p><input type='checkbox' name='newsletter'> Subcsribe newsletter </p>"
                        + "<input type='submit' value='Registration'></form>"
                        + message
                        + "</body></html>";
    }

}
