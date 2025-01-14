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

    public void guardarPartida(String pEstadoPartida, String pUsuario, int puntos)
    {
        GestorPartidas.getGestorPartidas().guardarPartida(pEstadoPartida, pUsuario, puntos);
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
    

	public Usuario getUserContrasena(String user, String password) throws SQLException {
		Usuario u = new Usuario(null,null,null,null,null,null,null);
		ResultSet resultadoSQL = GestorBD.execSQL("SELECT * FROM USUARIO WHERE usuario='" + user + "' AND pwd='" + password + "'");
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
		else {
			return null;
		}
	}

	public void deleteUser(Usuario user) {
		GestorBD.execSQLVoid("DELETE FROM USUARIO WHERE usuario='" + user.getUser() + "'");
	}

	public Vector<String> getUsersList(String pUsuario) {
		Vector<String> res = new Vector<String>();
		Vector<String> resultadoSQL = GestorBD.execSQLList("SELECT usuario FROM USUARIO");
		List<String> u = resultadoSQL;
		for (String users : u) {
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
		GestorBD.execSQLVoid("INSERT INTO USUARIO(usuario, pwd, email, nombre, apellidos, DNI, fNac) VALUES ('"
				+ user.getUser() + "','" + user.getClave() + "','" + email + "','" + user.getNombre() + "','"
				+ user.getApellidos() + "','" + user.getDNI() + "','" + user.getFechaNacimiento() + "',)");
		int id = obtenerId(user.getUser());
		GestorPersonalizacion.getGestorPersonalizacion().crearPersonalizacion(id);
	}

	public boolean comprobarDatos(String email, String DNI) throws SQLException {
		ResultSet resultadoSQL = GestorBD
				.execSQL("SELECT * FROM USUARIO WHERE email='" + email + "' and DNI='" + DNI + "'");
		boolean hayUser = resultadoSQL.next();
		resultadoSQL.close();
		return hayUser;
	}


	public Usuario getUser_2(String email, String DNI) throws SQLException {
		Usuario u = new Usuario(null, null, null, null, null, null, null);
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

	public Usuario getUser_3(String user) throws SQLException {
		Usuario u = new Usuario(null, null, null, null, null, null, null);
		ResultSet resultadoSQL = GestorBD
				.execSQL("SELECT * FROM USUARIO WHERE usuario='" + user + "'");
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
	public void cambiarDificultad(int dificultad,String pUsuario) {
    	if (dificultad == 1) {
			Board.getBoard(pUsuario,0).setBoardWidth(5);
			Board.getBoard(pUsuario,0).setBoardHeight(11);
			Board.getBoard(pUsuario,0).setPeriodInterval(450);

		} else if (dificultad == 2) {
			Board.getBoard(pUsuario,0).setBoardWidth(10);
			Board.getBoard(pUsuario,0).setBoardHeight(22);
			Board.getBoard(pUsuario,0).setPeriodInterval(300);

		} else if (dificultad == 3) {
			Board.getBoard(pUsuario,0).setBoardWidth(20);
			Board.getBoard(pUsuario,0).setBoardHeight(44);
			Board.getBoard(pUsuario,0).setPeriodInterval(150);

		}
    	
    }

	public int obtenerPuntos(String pUsuario) {
		try {
			return GestorPartidas.getGestorPartidas().obtenerPuntos(pUsuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public void guardarPartidaTerminada(int puntos, int nivel, String usuario) {
		GestorPartidas.getGestorPartidas().guardarPartidaTerminada(puntos,nivel,usuario);
		
	}
}
