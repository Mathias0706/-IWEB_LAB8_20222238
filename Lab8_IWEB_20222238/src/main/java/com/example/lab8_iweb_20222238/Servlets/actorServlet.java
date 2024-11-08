package com.example.lab8_iweb_20222238.Servlets;

import com.example.lab8_iweb_20222238.Beans.ActorBean;
import com.example.lab8_iweb_20222238.Daos.ActorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(
        name = "actorServlet",
        value = {"/actorServlet"}
)
public class actorServlet extends HttpServlet {
    public actorServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idActor = Integer.parseInt(request.getParameter("idActor"));
        ActorDao Adao = new ActorDao();
        ArrayList<ActorBean> list = Adao.listarActores(idActor);
        String vista = "listaActores.jsp";
        request.setAttribute("lista", list);
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}