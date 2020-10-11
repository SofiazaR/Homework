package ru.itis.servlets;

import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 05.10.2020
 * 4. Simple Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "976017";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/srl";

    private UsersRepository usersRepository;



    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            throw new IllegalStateException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            usersRepository = new UsersRepositoryJdbcImpl(connection);
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usersForJsp", usersRepository.findAll());
        req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
    }
}

