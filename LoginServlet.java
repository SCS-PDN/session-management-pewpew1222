package com.studentportal.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")


public class LoginServlet extends HttpServlet {

    private final HashMap<String, String> users = new HashMap<>();

    @Override
    public  void init() {
        users.put("student1", "pass1");
        users.put("stu dent2", "pass2");
        users.put("admin", "admin123");
    }

    @override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("upassword


                //validation

        if (users.containsKey(username) && users.get(username).equals(password)) {


            HttpSession session = request.getSession();
            session.setAttribute("username", username);


            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(userCookie);


            response.sendRedirect("DashboardServlet");
        } else {
            response.getWriter().println("Invalid credentials. Try again.");
        }
    }
}