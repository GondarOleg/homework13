package com.epam.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        logger.error(request.getParameter("name"));



           // Connection con = (Connection) getServletContext().getAttribute("DBConnection");

            try {
                Class.forName("org.h2.Driver");
                Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "password");
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = con.prepareStatement("select username, useremail from \"Fortune cookies\".USERS  where username=? and userpassword=?");
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                logger.info(rs.getString(1));
                if(rs != null && rs.next()){

                    logger.info("User found with details="+rs.getString("username"));
                    logger.info("User found with details="+username);
                    HttpSession session = request.getSession();
                    session.setAttribute("User", username);
                    response.sendRedirect("cookiesTable.html");
                }else{
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/registerForm.html");
                    PrintWriter out= response.getWriter();

                    logger.error("User not found with username="+ username);

                    rd.include(request, response);
                    out.println("<font color=red>No user found with given username, please register first.</font>");
                }
            } catch ( SQLException | ClassNotFoundException e) {
                e.printStackTrace();

                logger.error("Database connection problem");
                throw new ServletException("DB Connection problem.");
            }  finally{
                //try {

//                    rs.close();
//                    ps.close();
              // }
//                catch (SQLException e) {
//                    logger.error("SQLException in closing PreparedStatement or ResultSet");;
//                }

            }
        }
    }

