package com.studentportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.studentportal.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseId = request.getParameter("courseId");

        // Simulate course lookup
        Course course = null;
        switch (courseId) {
            case "101": course = new Course("174", "Java ", "ABC"); break;
            case "102": course = new Course("102", "1474", "Web ", "DEF"); break;
            case "103": course = new Course("103", "147", "DS", "xxx"); break;
        }

        if (course != null) {
            HttpSession session = request.getSession();
            List<Course> enrolled = (List<Course>) session.getAttribute("enrolledCourses");
            if (enrolled == null) {
                enrolled = new ArrayList<>();
            }
            enrolled.add(course);
            session.setAttribute("enrolledCourses", enrolled);
        }

        response.sendRedirect("DashboardServlet");
    }
}
    }
            }