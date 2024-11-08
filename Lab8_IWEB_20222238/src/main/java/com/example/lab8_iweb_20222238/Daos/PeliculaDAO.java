package com.example.lab8_iweb_20222238.Daos;

import com.example.lab8_iweb_20222238.Beans.PeliculaBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeliculaDAO extends DAObase {
    public PeliculaDAO() {
    }

    public ArrayList<PeliculaBean> listarPeliculas() throws SQLException {
        ArrayList<PeliculaBean> peliculas = new ArrayList();
        String sql = "SELECT\n    p.idPelicula,\n    p.titulo,\n    p.director,\n    p.anoPublicacion,\n    p.rating,\n    p.boxOffice,\n    g.nombre AS genero\nFROM \n    Pelicula p\nJOIN \n    Genero g ON p.idGenero = g.idGenero\nORDER BY\n    p.rating DESC;";

        try {
            Connection conn = getConnection();

            try {
                PreparedStatement ps = conn.prepareStatement(sql);

                try {
                    ResultSet rs = ps.executeQuery();

                    while(rs.next()) {
                        PeliculaBean p = new PeliculaBean();
                        p.setIdPelicula(rs.getInt("idPelicula"));
                        p.setTitulo(rs.getString("titulo"));
                        p.setDirector(rs.getString("director"));
                        p.setAnoPublicacion(rs.getInt("anoPublicacion"));
                        p.setBoxOffice(rs.getDouble("boxOffice"));
                        p.setRating(rs.getDouble("rating"));
                        p.setGenero(rs.getString("genero"));
                        peliculas.add(p);
                    }
                } catch (Throwable var9) {
                    if (ps != null) {
                        try {
                            ps.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (Throwable var10) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var11) {
            SQLException e = var11;
            e.printStackTrace();
        }

        return peliculas;
    }

    public void borrarPeliculas(int idPelicula) throws SQLException {
        String sql = "DELETE FROM `mydb`.`Pelicula`\nWHERE `idPelicula` = ?;";
        String user = "root";
        String password = "root0706";
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection conn = DriverManager.getConnection(url, user, password);

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            try {
                ps.setInt(1, idPelicula);
                ps.executeUpdate();
            } catch (Throwable var12) {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (Throwable var11) {
                        var12.addSuppressed(var11);
                    }
                }

                throw var12;
            }

            if (ps != null) {
                ps.close();
            }
        } catch (Throwable var13) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Throwable var10) {
                    var13.addSuppressed(var10);
                }
            }

            throw var13;
        }

        if (conn != null) {
            conn.close();
        }

    }

    public void borrarProtagonistas(int idPelicula) throws SQLException {
        String sql = "DELETE FROM `mydb`.`Protagonista`\nWHERE `idPelicula` = ?;";
        String user = "root";
        String password = "root0706";
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection conn = DriverManager.getConnection(url, user, password);

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            try {
                ps.setInt(1, idPelicula);
                ps.executeUpdate();
            } catch (Throwable var12) {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (Throwable var11) {
                        var12.addSuppressed(var11);
                    }
                }

                throw var12;
            }

            if (ps != null) {
                ps.close();
            }
        } catch (Throwable var13) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Throwable var10) {
                    var13.addSuppressed(var10);
                }
            }

            throw var13;
        }

        if (conn != null) {
            conn.close();
        }

    }

    public ArrayList<PeliculaBean> buscarPorNombre(String nombrePelicula) {
        ArrayList<PeliculaBean> peliculas = new ArrayList();
        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre AS genero FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero WHERE p.titulo LIKE ? ORDER BY p.rating DESC";

        try {
            Connection conn = getConnection();

            try {
                PreparedStatement ps = conn.prepareStatement(sql);

                try {
                    ps.setString(1, "%" + nombrePelicula + "%");
                    ResultSet rs = ps.executeQuery();

                    try {
                        while(rs.next()) {
                            PeliculaBean pelicula = new PeliculaBean();
                            pelicula.setIdPelicula(rs.getInt("idPelicula"));
                            pelicula.setTitulo(rs.getString("titulo"));
                            pelicula.setDirector(rs.getString("director"));
                            pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                            pelicula.setRating(rs.getDouble("rating"));
                            pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                            pelicula.setGenero(rs.getString("genero"));
                            peliculas.add(pelicula);
                        }
                    } catch (Throwable var12) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var11) {
                                var12.addSuppressed(var11);
                            }
                        }

                        throw var12;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var13) {
                    if (ps != null) {
                        try {
                            ps.close();
                        } catch (Throwable var10) {
                            var13.addSuppressed(var10);
                        }
                    }

                    throw var13;
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (Throwable var14) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var9) {
                        var14.addSuppressed(var9);
                    }
                }

                throw var14;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var15) {
            SQLException e = var15;
            e.printStackTrace();
        }

        return peliculas;
    }

    public static void guardarPelicula(int idPelicula, String titulo, String director, int anoPublicacion, double rating, double boxOffice) throws SQLException {
        String sql = "UPDATE Pelicula SET titulo = ?, director = ?, anoPublicacion = ?, rating = ?, boxOffice = ? WHERE idPelicula = ?";

        try {
            Connection conn = getConnection();

            try {
                PreparedStatement ps = conn.prepareStatement(sql);

                try {
                    ps.setInt(1, idPelicula);
                    ps.setString(2, titulo);
                    ps.setString(3, director);
                    ps.setInt(4, anoPublicacion);
                    ps.setDouble(5, rating);
                    ps.setDouble(6, boxOffice);
                    ps.executeUpdate();
                } catch (Throwable var15) {
                    if (ps != null) {
                        try {
                            ps.close();
                        } catch (Throwable var14) {
                            var15.addSuppressed(var14);
                        }
                    }

                    throw var15;
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (Throwable var16) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var13) {
                        var16.addSuppressed(var13);
                    }
                }

                throw var16;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var17) {
            SQLException e = var17;
            e.printStackTrace();
        }

    }

    public PeliculaBean obtenerPeliculaId(int idPelicula) {
        PeliculaBean pelicula = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException var15) {
            ClassNotFoundException e = var15;
            throw new RuntimeException(e);
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre AS genero FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero WHERE p.idPelicula = ?;";

        try {
            Connection conn = getConnection();

            try {
                PreparedStatement ps = conn.prepareStatement(sql);

                try {
                    ps.setInt(1, idPelicula);
                    ResultSet rs = ps.executeQuery();

                    try {
                        if (rs.next()) {
                            pelicula = new PeliculaBean();
                            pelicula.setIdPelicula(rs.getInt("idPelicula"));
                            pelicula.setTitulo(rs.getString("titulo"));
                            pelicula.setDirector(rs.getString("director"));
                            pelicula.setAnoPublicacion(Integer.parseInt(rs.getString("anoPublicacion")));
                            pelicula.setRating(rs.getDouble("rating"));
                            pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                            pelicula.setGenero(rs.getString("genero"));
                        }
                    } catch (Throwable var16) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var14) {
                                var16.addSuppressed(var14);
                            }
                        }

                        throw var16;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var17) {
                    if (ps != null) {
                        try {
                            ps.close();
                        } catch (Throwable var13) {
                            var17.addSuppressed(var13);
                        }
                    }

                    throw var17;
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (Throwable var18) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var12) {
                        var18.addSuppressed(var12);
                    }
                }

                throw var18;
            }

            if (conn != null) {
                conn.close();
            }

            return pelicula;
        } catch (SQLException var19) {
            SQLException e = var19;
            throw new RuntimeException(e);
        }
    }
}

