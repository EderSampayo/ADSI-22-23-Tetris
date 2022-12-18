package com.zetcode;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;


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
    
    
    public JSONObject buscarMejoresPartidas(String pUsuario) throws SQLException
	{
    	JSONObject j1 = new JSONObject();
    	if (pUsuario.equals("")) 	//búsqueda global
    	{
    		ResultSet resultadoSQL = GestorBD.execSQL("SELECT * FROM PARTIDA ORDER BY puntos DESC LIMIT 5");
    		while (resultadoSQL.next()) //Mientras haya datos 
    		{
    			String quien = resultadoSQL.getString("usuario"); 	//quién ha jugado dicha partida
    			int cuanto = resultadoSQL.getInt("puntos");		//puntuación obtenida en la partida
    			j1.put(quien, cuanto);
    		}
    		resultadoSQL.close();
    	}
    	else		//búsqueda solo de usuario
    	{
    		ResultSet resultadoSQL = GestorBD.execSQL("SELECT * FROM PARTIDA WHERE usuario= "+pUsuario+" ORDER BY puntos DESC LIMIT 5");
    		while (resultadoSQL.next())
    		{
    			int cuanto = resultadoSQL.getInt("puntos");		//puntuación obtenida en la partida
    			//no se pregunta el usuario de cada partida porque ya se conoce
    			j1.put(pUsuario, cuanto);
    		}
    		resultadoSQL.close();
    	}
    	return j1;
	}
    
    public JSONArray buscarMejoresXNivel()
    {
    	JSONArray j2 = new JSONArray();
    	JSONObject j1n1 = new JSONObject();
    	JSONObject j1n2 = new JSONObject();
    	JSONObject j1n3 = new JSONObject();
    	
    	ResultSet resultadoSQL1 = GestorBD.execSQL("SELECT * FROM PARTIDA WHERE nivel=1 ORDER BY puntos DESC LIMIT 5");
		try {
			while (resultadoSQL1.next())
			{
				int cuanto = resultadoSQL1.getInt("puntos");		//puntuación obtenida en la partida
				String quien = resultadoSQL1.getString("usuario");	//quién ha jugado dicha partida
				j1n1.put(quien, cuanto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultadoSQL1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ResultSet resultadoSQL2 = GestorBD.execSQL("SELECT * FROM PARTIDA WHERE nivel=2 ORDER BY puntos DESC LIMIT 5");
		try {
			while (resultadoSQL2.next())
			{
				int cuanto = resultadoSQL2.getInt("puntos");		//puntuación obtenida en la partida
				String quien = resultadoSQL2.getString("usuario");	//quién ha jugado dicha partida
				j1n2.put(quien, cuanto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultadoSQL2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ResultSet resultadoSQL3 = GestorBD.execSQL("SELECT * FROM PARTIDA WHERE nivel=3 ORDER BY puntos DESC LIMIT 5");
		try {
			while (resultadoSQL3.next())
			{
				int cuanto = resultadoSQL3.getInt("puntos");		//puntuación obtenida en la partida
				String quien = resultadoSQL3.getString("usuario");	//quién ha jugado dicha partida
				j1n3.put(quien, cuanto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultadoSQL3.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		j2.put(j1n1);
		j2.put(j1n2);
		j2.put(j1n3);
		
		return j2;
    }

}
