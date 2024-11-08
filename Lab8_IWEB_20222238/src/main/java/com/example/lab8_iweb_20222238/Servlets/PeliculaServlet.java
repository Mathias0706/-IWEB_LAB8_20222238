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
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(
        name = "PeliculaServlet",
        value = {"/PeliculaServlet"}
)
public class PeliculaServlet extends HttpServlet {
    public PeliculaServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<PeliculaBean> list = null;
        String action = request.getParameter("action");
        new ArrayList();

        try {
            list = peliculaDAO.listarPeliculas();
        } catch (SQLException var26) {
            SQLException e = var26;
            throw new RuntimeException(e);
        }

        String vista = "listaPeliculas.jsp";
        request.setAttribute("lista", list);
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
        if (action == null) {
            action = "";
        }

        ArrayList peliculas2;
        SQLException e;
        switch (action) {
            case "eliminar":
                String idPeliculaStr = request.getParameter("idPelicula");

                try {
                    int idPelicula = Integer.parseInt(idPeliculaStr);
                    peliculaDAO.borrarPeliculas(idPelicula);
                    peliculaDAO.borrarProtagonistas(idPelicula);
                    response.sendRedirect("listaPeliculas.jsp");
                } catch (Exception var25) {
                    request.setAttribute("error", "Error al eliminar la película.");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;
            case "buscar":
                String nombrePelicula = request.getParameter("nombrePelicula");
                if (nombrePelicula != null && !nombrePelicula.trim().isEmpty()) {
                    peliculas2 = peliculaDAO.buscarPorNombre(nombrePelicula);
                } else {
                    try {
                        peliculas2 = peliculaDAO.listarPeliculas();
                    } catch (SQLException var24) {
                        SQLException e2 = var24;
                        throw new RuntimeException(e2);
                    }
                }

                request.setAttribute("peliculas", peliculas2);
                request.getRequestDispatcher("listaPeliculas.jsp").forward(request, response);
                break;
            case "guardar":
                int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
                String titulo = request.getParameter("titulo");
                String director = request.getParameter("director");
                int anoPublicacion = Integer.parseInt(request.getParameter("anoPublicacion"));
                double rating = Double.parseDouble(request.getParameter("rating"));
                double boxOffice = Double.parseDouble(request.getParameter("boxOffice"));

                try {
                    PeliculaDAO.guardarPelicula(idPelicula, titulo, director, anoPublicacion, rating, boxOffice);
                } catch (SQLException var23) {
                    e = var23;
                    throw new RuntimeException(e);
                }
            default:
                try {
                    peliculas2 = peliculaDAO.listarPeliculas();
                } catch (SQLException var22) {
                    e = var22;
                    throw new RuntimeException(e);
                }

                request.setAttribute("peliculas", peliculas2);
                request.getRequestDispatcher("listaPeliculas.jsp").forward(request, response);
        }

    }
}
