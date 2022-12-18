package com.zetcode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.json.JSONObject;
import org.json.JSONArray;

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
    
    public void cambiarColorFondoBD(int pId,int pColor)
    {
        GestorPersonalizacion.getGestorPersonalizacion().cambiarColorFondoBD(pId,pColor);
    }
    public void cambiarColorLadrilloBD(int pId,int pColor,int pLadrillo)
    {
        GestorPersonalizacion.getGestorPersonalizacion().cambiarColorLadrilloBD(pId,pColor,pLadrillo);
    }
    public void cambiarSonidoBD(int pId,int pSonido)
    {

        GestorPersonalizacion.getGestorPersonalizacion().cambiarSonidoBD(pId,pSonido);

    }
    public void ponerColoresDefaultBD(int pId)
    {
    	GestorPersonalizacion.getGestorPersonalizacion().cambiarColoresDefaultBD(pId);
        
    }
    
    @SuppressWarnings("null")
	public Usuario getUserContrasena(String user, String password) throws SQLException {
		Usuario u = new Usuario(null,null,null,null,null,null,null);
		ResultSet resultadoSQL = GestorBD.execSQL("SELECT * FROM USUARIO WHERE usuario='" + user + "' and pwd='" + password + "'");
		boolean hayUser = resultadoSQL.next();
		if (hayUser) {
			u.setUser(resultadoSQL.getString(1));
			u.setClave(resultadoSQL.getString(2));
			u.setEmail(resultadoSQL.getString(3));
			u.setNombre(resultadoSQL.getString(4));
			u.setApellidos(resultadoSQL.getString(5));
			u.setDNI(resultadoSQL.getString(6));
			u.setFechaNacimiento(resultadoSQL.getString(7));
			resultadoSQL.close();
			return u;
		}
		return u;
	}

	public void deleteUser(Usuario user) {
		GestorBD.execSQLVoid("DELETE FROM USUARIO WHERE usuario='" + user.getUser() + "'");
	}

	public Vector<Usuario> getUsersList(String pUsuario) {
		Vector<Usuario> res = new Vector<Usuario>();
		Vector<Usuario> resultadoSQL = GestorBD.execSQLList("SELECT * FROM USUARIO");
		List<Usuario> u = resultadoSQL;
		for (Usuario users : u) {
			System.out.println(users.toString());
			res.add(users);
		}
		return res;
	}

	public boolean getUser(String user) throws SQLException {
		ResultSet resultadoSQL = GestorBD.execSQL("SELECT * FROM USUARIO WHERE usuario='" + user + "'");
		boolean hayUser = resultadoSQL.next();
		resultadoSQL.close();
		return hayUser;
	}

	public void storeUser(Usuario user) {
		String email = user.getEmail();
		GestorBD.execSQLVoid("INSERT INTO USUARIO VALUES (" + user.getUser() + "," + user.getClave() + ","
				+ email + "," + user.getNombre() + "," + user.getApellidos() + "," + user.getDNI() + ","
				+ user.getFechaNacimiento() + ")");
	}

	public boolean getDNI(String email, String DNI) throws SQLException {
		ResultSet resultadoSQL = GestorBD
				.execSQL("SELECT * FROM USUARIO WHERE email='" + email + "' and DNI='" + DNI + "'");
		boolean hayUser = resultadoSQL.next();
		resultadoSQL.close();
		return hayUser;
	}

	@SuppressWarnings("null")
	public Usuario getUser_2(String email, String DNI) throws SQLException {
		Usuario u = new Usuario(null,null,null,null,null,null,null);
		ResultSet resultadoSQL = GestorBD
				.execSQL("SELECT * FROM USUARIO WHERE email='" + email + "' and DNI='" + DNI + "'");
		boolean hayUser = resultadoSQL.next();
		if (hayUser) {
			u.setUser(resultadoSQL.getString(1));
			u.setClave(resultadoSQL.getString(2));
			u.setEmail(resultadoSQL.getString(3));
			u.setNombre(resultadoSQL.getString(4));
			u.setApellidos(resultadoSQL.getString(5));
			u.setDNI(resultadoSQL.getString(6));
			u.setFechaNacimiento(resultadoSQL.getString(7));
			resultadoSQL.close();
			return u;
		}
		return u;
	}

	public void setContrasena(String password, String pUsuario) {
		GestorBD.execSQLVoid("UPDATE USUARIO SET pwd='" + password + "' WHERE usuario='" + pUsuario + "'");
	}
	
	
	 public JSONObject buscarMejoresPartidas(String pUsuario) throws SQLException
	{
    		JSONObject j1 = new JSONObject();
		j1 = GestorPartidas.getGestorPartidas().buscarMejoresPartidas(pUsuario);
		return j1;
	}
    
	public JSONArray buscarMejoresXNivel()
	{
		JSONArray j2 = new JSONArray();
	j2 = GestorPartidas.getGestorPartidas().buscarMejoresXNivel();
	return j2;
	}
	public void cambiarDificultad(String dificultad,String pUsuario) {
    	if (dificultad == "Facil") {
			Board.getBoard(pUsuario).setBoardWidth(5);
			Board.getBoard(pUsuario).setBoardHeight(11);
			Board.getBoard(pUsuario).setPeriodInterval(450);

		} else if (dificultad == "Normal") {
			Board.getBoard(pUsuario).setBoardWidth(10);
			Board.getBoard(pUsuario).setBoardHeight(22);
			Board.getBoard(pUsuario).setPeriodInterval(300);

		} else if (dificultad == "Dificil") {
			Board.getBoard(pUsuario).setBoardWidth(20);
			Board.getBoard(pUsuario).setBoardHeight(44);
			Board.getBoard(pUsuario).setPeriodInterval(150);

		}
    	
    }
}
