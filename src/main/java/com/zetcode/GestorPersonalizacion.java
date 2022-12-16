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
    	ResultSet resultadoSQL= GestorBD.execSQL("SELECT idPersonalizacion FROM USUARIO WHERE usuario='"+pUsuario+"'");
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
            System.out.println("No tienes ninguna personalizacion guardada");
            resultadoSQL.close();
            return 0;
        }
    }
    
    public JSONObject obtenerPersonalizacion(int pId)throws SQLException
    {
    	ResultSet resultadoSQL= GestorBD.execSQL("SELECT * FROM PERSONALIZACION WHERE id='"+pId+"'");
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

	public void cambiarColorFondoBD(int pId,int pColor) {
		GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET colorFondo="+pColor+" WHERE id="+pId+"");
        System.out.println("Color de fondo cambiado correctamente");
	}
	public void cambiarColorLadrilloBD(int pId,int pColor,int pLadrillo) {
		if(pLadrillo == 1) {
			GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET ladrillo1="+pColor+" WHERE id="+pId+"");
		}
		else if(pLadrillo == 2) {
			GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET ladrillo2="+pColor+" WHERE id="+pId+"");
		}
		else if(pLadrillo == 3) {
			GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET ladrillo3="+pColor+" WHERE id="+pId+"");
		}
		else if(pLadrillo == 4) {
			GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET ladrillo4="+pColor+" WHERE id="+pId+"");
		}
		else if(pLadrillo == 5) {
			GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET ladrillo5="+pColor+" WHERE id="+pId+"");
		}
		else if(pLadrillo == 6) {
			GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET ladrillo6="+pColor+" WHERE id="+pId+"");
		}
		else if(pLadrillo == 7) {
			GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET ladrillo7="+pColor+" WHERE id="+pId+"");
		}
        System.out.println("Color de ladrillo cambiado correctamente");
	}
	public void cambiarSonidoBD(int pId,int pSonido) {
		GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET sonido="+pSonido+" WHERE id="+pId+"");
        System.out.println("Sonido cambiado correctamente");
	}
	public void cambiarColoresDefaultBD(int pId) {
		GestorBD.execSQLVoid("UPDATE PERSONALIZACION SET ladrillo1 = 0, ladrillo2 = 0, ladrillo3 = 0, ladrillo4 = 0, ladrillo5 = 0, ladrillo6 = 0, ladrillo7 = 0 WHERE id='"+pId+"'");
        System.out.println("Colores por defecto cambiados correctamente");
	}
}