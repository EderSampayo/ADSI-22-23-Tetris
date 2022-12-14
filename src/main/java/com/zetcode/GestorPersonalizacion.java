package com.zetcode;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONObject;

public class GestorPersonalizacion
{
    private static GestorPersonalizacion miGestorPersonalizacion;

    private GestorPersonalizacion()
    {

    }

    public static GestorPersonalizacion getGestorPersonalizacion()
    {
        if(GestorPersonalizacion.miGestorPersonalizacion == null)
        {
        	GestorPersonalizacion.miGestorPersonalizacion = new GestorPersonalizacion();
        }
        return GestorPersonalizacion.miGestorPersonalizacion;
    }

    //metodos

    public int obtenerId(String pUsuario)throws SQLException
    {
    	ResultSet resultadoSQL= GestorBD.execSQL("SELECT idpersonalizacion FROM Usuario WHERE usuario='"+pUsuario+"'");
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
    
    public JSONObject obtenerPersonalizacion(int pId)throws SQLException
    {
    	ResultSet resultadoSQL= GestorBD.execSQL("SELECT * FROM Personalizacion WHERE id='"+pId+"'");
        boolean hayPersonalizacion = resultadoSQL.next();
        if(hayPersonalizacion) {
        	
        	JSONObject obj=new JSONObject();    
            obj.put("colorFondo",resultadoSQL.getInt("colorFondo"));    
            obj.put("ladrillo1",resultadoSQL.getInt("ladrillo1")); 
            obj.put("ladrillo2",resultadoSQL.getInt("ladrillo2")); 
            obj.put("ladrillo3",resultadoSQL.getInt("ladrillo3")); 
            obj.put("ladrillo4",resultadoSQL.getInt("ladrillo4")); 
            obj.put("ladrillo5",resultadoSQL.getInt("ladrillo5")); 
            obj.put("ladrillo6",resultadoSQL.getInt("ladrillo6")); 
            obj.put("ladrillo7",resultadoSQL.getInt("ladrillo7")); 
            obj.put("sonido",resultadoSQL.getInt("sonido")); 
            resultadoSQL.close();
            return obj;
        }
        else {
        	return null;
        }
    }

	public void cambiarColorFondoBD(int pColor) {
		GestorBD.execSQLVoid("INSERT INTO Personalizacion(colorFondo) VALUES ('"+pColor+"')");
        System.out.println("Color de fondo cambiado correctamente");
	}
	public void cambiarColorLadrilloBD(int pColor,int pLadrillo) {
		if(pLadrillo == 1) {
			GestorBD.execSQLVoid("INSERT INTO Personalizacion(ladrillo1) VALUES ('"+pColor+"')");
		}
		else if(pLadrillo == 2) {
			GestorBD.execSQLVoid("INSERT INTO Personalizacion(ladrillo2) VALUES ('"+pColor+"')");
		}
		else if(pLadrillo == 3) {
			GestorBD.execSQLVoid("INSERT INTO Personalizacion(ladrillo3) VALUES ('"+pColor+"')");
		}
		else if(pLadrillo == 4) {
			GestorBD.execSQLVoid("INSERT INTO Personalizacion(ladrillo4) VALUES ('"+pColor+"')");
		}
		else if(pLadrillo == 5) {
			GestorBD.execSQLVoid("INSERT INTO Personalizacion(ladrillo5) VALUES ('"+pColor+"')");
		}
		else if(pLadrillo == 6) {
			GestorBD.execSQLVoid("INSERT INTO Personalizacion(ladrillo6) VALUES ('"+pColor+"')");
		}
		else if(pLadrillo == 7) {
			GestorBD.execSQLVoid("INSERT INTO Personalizacion(ladrillo7) VALUES ('"+pColor+"')");
		}
        System.out.println("Color de ladrillo cambiado correctamente");
	}
	public void cambiarSonidoBD(int pSonido) {
		GestorBD.execSQLVoid("INSERT INTO Personalizacion(sonido) VALUES ('"+pSonido+"')");
        System.out.println("Sonido cambiado correctamente");
	}
	public void cambiarColoresDefaultBD() {
		GestorBD.execSQLVoid("INSERT INTO Personalizacion(ladrillo1,ladrillo2,ladrillo3,ladrillo4,ladrillo5,ladrillo6,ladrillo7) VALUES ('0','0','0','0','0','0','0')");
        System.out.println("Sonidos por defecto cambiados correctamente");
	}
}