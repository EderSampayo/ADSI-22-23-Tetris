package com.zetcode;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;

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
   
    public int obtenerId(String pUsuario)
    {
    	try {
            return GestorPersonalizacion.getGestorPersonalizacion().obtenerId(pUsuario);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public JSONObject obtenerPersonalizacion(int pId)
    {
    	try {
            return GestorPersonalizacion.getGestorPersonalizacion().obtenerPersonalizacion(pId);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void cambiarColorFondoBD(int pColor)
    {
    	GestorPersonalizacion.getGestorPersonalizacion().cambiarColorFondoBD(pColor);
    }
    public void cambiarColorLadrilloBD(int pColor,int pLadrillo)
    {
    	GestorPersonalizacion.getGestorPersonalizacion().cambiarColorLadrilloBD(pColor,pLadrillo);
    }
    public void cambiarSonidoBD(int pSonido)
    {

    	GestorPersonalizacion.getGestorPersonalizacion().cambiarSonidoBD(pSonido);

    }
    public void ponerColoresDefaultBD()
    {
    	GestorPersonalizacion.getGestorPersonalizacion().cambiarColoresDefaultBD();

    }
    public void cambiarDificultad(String dificultad) {
    	if (dificultad == "Facil") {
			Board.getBoard().setBoardWidth(5);
			Board.getBoard().setBoardHeight(11);
			Board.getBoard().setPeriodInterval(450);

		} else if (dificultad == "Normal") {
			Board.getBoard().setBoardWidth(10);
			Board.getBoard().setBoardHeight(22);
			Board.getBoard().setPeriodInterval(300);

		} else if (dificultad == "Dificil") {
			Board.getBoard().setBoardWidth(20);
			Board.getBoard().setBoardHeight(44);
			Board.getBoard().setPeriodInterval(150);

		}
    	
    }

}

