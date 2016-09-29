package ru.kpfu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Admin on 27.09.2016.
 */
public class SuccesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        out.println(getPageCode());
    }


    protected String getPageCode(){
        return "<!DOCTYPE html><html>"
                + "<head><meta charset='UTF-8'><title>Hello page</title></head>"
                + "<body>"
                +"<h1>Registration Succesfull!</h1>"
                +"</body></html>";

    }
}
