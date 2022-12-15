package com.zetcode;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorPartidas
{
    private static GestorPartidas miGestorPartidas;

    private GestorPartidas()
    {

    }

    public static GestorPartidas getGestorPartidas()
    {
        if(GestorPartidas.miGestorPartidas == null)
        {
            GestorPartidas.miGestorPartidas = new GestorPartidas();
        }
        return GestorPartidas.miGestorPartidas;
    }

    //metodos

    public void eliminarPartidaGuardada(String pUsuario)
    {
        GestorBD.execSQLVoid("DELETE FROM PARTIDA WHERE usuario='"+pUsuario+"' AND fecha IS NULL");
        //System.out.println("Partida antigua eliminada correctamente");
    }

    public void guardarPartida(String pEstadoPartida, String pUsuario)
    {
        GestorBD.execSQLVoid("INSERT INTO PARTIDA(estadoPartida, usuario) VALUES ('"+pEstadoPartida+"', '"+pUsuario+"')");
        System.out.println("Partida guardada correctamente");
    }

    public String buscarEstadoPartida(String pUsuario) throws SQLException {
        ResultSet resultadoSQL= GestorBD.execSQL("SELECT estadoPartida FROM PARTIDA WHERE usuario='"+pUsuario+"' AND fecha IS NULL");
        boolean hayPartida = resultadoSQL.next();
        String rdo = null;
        if(hayPartida)
        {
            rdo = resultadoSQL.getString(1);
            resultadoSQL.close();
            return rdo;
        }
        else
        {
            System.out.println("No tienes ninguna partida guardada");
            resultadoSQL.close();
            return null;
        }
    }

}