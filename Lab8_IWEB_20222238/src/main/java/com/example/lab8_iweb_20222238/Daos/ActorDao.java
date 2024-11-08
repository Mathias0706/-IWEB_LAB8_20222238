package com.example.lab8_iweb_20222238.Daos;

import com.example.lab8_iweb_20222238.Beans.ActorBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActorDao extends DAObase {
    public ActorDao() {
    }

    public ArrayList<ActorBean> listarActores(int idPelicula) {
        ArrayList<ActorBean> lista = new ArrayList();
        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT p.idPelicula, pel.titulo AS tituloPelicula, a.idActor, a.Nombre, a.Apellido, a.anoNacimiento, a.premioOscar FROM Protagonistas p JOIN Actor a ON p.idActor = a.idActor JOIN Pelicula pel ON p.idPelicula = pel.idPelicula WHERE p.idPelicula = ?;";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                try {
                    pstmt.setInt(1, idPelicula);
                    ResultSet rs = pstmt.executeQuery();

                    try {
                        while(rs.next()) {
                            ActorBean actores = new ActorBean();
                            actores.setIdActor(rs.getInt(2));
                            actores.setNombre(rs.getString(3));
                            actores.setApellido(rs.getString(4));
                            actores.setAnoNacimiento(rs.getInt(5));
                            actores.setPremioOscar(rs.getBoolean(6));
                            lista.add(actores);
                        }
                    } catch (Throwable var15) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var14) {
                                var15.addSuppressed(var14);
                            }
                        }

                        throw var15;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var16) {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (Throwable var13) {
                            var16.addSuppressed(var13);
                        }
                    }

                    throw var16;
                }

                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Throwable var17) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var12) {
                        var17.addSuppressed(var12);
                    }
                }

                throw var17;
            }

            if (conn != null) {
                conn.close();
            }

            return lista;
        } catch (SQLException var18) {
            SQLException e = var18;
            throw new RuntimeException(e);
        }
    }
}

