package com.zetcode;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador
{
    private static Controlador miControlador;

    private Controlador()
    {

    }

    public static Controlador getControlador()
    {
        if(Controlador.miControlador == null)
        {
            Controlador.miControlador = new Controlador();
        }
        return Controlador.miControlador;
    }

    //metodos

    public void eliminarPartidaGuardada(String pUsuario)
    {
        GestorPartidas.getGestorPartidas().eliminarPartidaGuardada(pUsuario);
    }

    public void guardarPartida(String pEstadoPartida, String pUsuario)
    {
        GestorPartidas.getGestorPartidas().guardarPartida(pEstadoPartida, pUsuario);
    }

    public String buscarEstadoPartida(String pUsuario)
    {
        try {
            return GestorPartidas.getGestorPartidas().buscarEstadoPartida(pUsuario);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
   
    public int obtenerId(String pUsuario)throws SQLException
    {
    	ResultSet resultadoSQL= GestorBD.getGestorBD().execSQL("SELECT idpersonalizacion FROM Usuario WHERE usuario='"+pUsuario+"'");
    	boolean hayPersonalizacion = resultadoSQL.next();
    	int rdo = 0;
        if(hayPersonalizacion)
        {
            rdo = resultadoSQL.getInt(1);
            resultadoSQL.close();
            return rdo;
        }
        else
        {
            System.out.println("No tienes ninguna partida guardada");
            resultadoSQL.close();
            return 0;
        }
    }
    
    public void obtenerPersonalizacion(int pId)throws SQLException
    {
    	ResultSet resultadoSQL= GestorBD.getGestorBD().execSQL("SELECT * FROM Personalizacion WHERE id='"+pId+"'");
        boolean hayPersonalizacion = resultadoSQL.next();
    }
}
