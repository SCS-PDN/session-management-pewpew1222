package com.studentportal.servlets;

import com.studentportal.Course;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("Welocome.This is Dashboard");


        // Sample course list
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("174", "Java ", "ABC"));
        courses.add(new Course("1474", "Web ", "DEF"));
        courses.add(new Course("147", "DS", "xxx"));

        request.setAttribute("courses", courses);

        // Fetch enrolled courses from session if any
        HttpSession session = request.getSession(false);
        List<Course> enrolledCourses = (List<Course>) session.getAttribute("enrolledCourses");
        if (enrolledCourses == null) {
            enrolledCourses = new ArrayList<>();
        }
        request.setAttribute("enrolledCourses", enrolledCourses);

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
    }
            }