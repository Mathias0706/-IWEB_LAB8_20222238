package com.example.lab8_iweb_20222238.Servlets;

import com.example.lab8_iweb_20222238.Beans.PeliculaBean;
import com.example.lab8_iweb_20222238.Daos.PeliculaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "detalleServlet",
        value = {"/detalleServlet"}
)
public class detalleServlet extends HttpServlet {
    public detalleServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
        PeliculaDAO peliDao = new PeliculaDAO();
        PeliculaBean pelicula = peliDao.obtenerPeliculaId(idPelicula);
        String vista = "viewPelicula.jsp";
        request.setAttribute("pelicula", pelicula);
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

