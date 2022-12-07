package com.zetcode;

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
}
