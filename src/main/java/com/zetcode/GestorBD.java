package com.zetcode;

import java.io.File;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;

import org.apache.ibatis.jdbc.ScriptRunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.FileNotFoundException;

public class GestorBD
{
	static boolean inicializado = false;
    static String DB_URL = "jdbc:h2:~/bdtetris";
    static String USER = "admin";
    static String PASS = "admin1";
    static Statement consulta = null;
    static Connection conexion = null;

    private static Connection getConnection() {
        if (!inicializado) {
            GestorBD.inicializar(false);
        }

        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void inicializarTest() {
        if (inicializado) {
            DB_URL = "jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1";
        } else {
            inicializar(true);
        }
    }

    private static void inicializar(Boolean esTest) {
        inicializado = true;
        String JDBC_DRIVER = "org.h2.Driver";
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            System.err.println("Error con los drivers de la base de datos. Cerrando el programa.");
            System.exit(1);
        }

        try {
            if (esTest) {
                DB_URL = "jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1";
            } else {
                DB_URL = "jdbc:h2:" + new File("bdtetris").getCanonicalPath();
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        Boolean bdd_existe = false;
        Connection conn = null;
        Statement stat = null;
        try {
            conn = GestorBD.getConnection();
            stat = conn.createStatement();
            ResultSet resultado = stat.executeQuery("SELECT * FROM USUARIO");
            bdd_existe = true;
            resultado.next();
            String a = resultado.getString("usuario");
            conn.close();
            stat.close();
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stat != null) {
                    stat.close();
                }
            } catch (Exception ex) {
            }
            // La base de datos no existe, no hay que hacer nada porque bdd_existe ya es false
        }

        if (!bdd_existe) {
            try {
                conn = GestorBD.getConnection();
                ScriptRunner sr = new ScriptRunner(conn);
                Reader reader = new BufferedReader(new FileReader("tetris.sql"));
                sr.runScript(reader);
                try {
                    conn.close();
                } catch(Exception e) {
                }
            } catch (FileNotFoundException e) {
                System.err.println(e);
            }
        }
    }
    
    public static void execSQLVoid(String pConsulta) { //INSERT, UPDATE, DELETE
    	try {
            if (conexion != null) {
                conexion.close();
            }
            if (consulta != null) {
                consulta.close();
            }
            conexion = GestorBD.getConnection();
    		consulta = conexion.createStatement();
    		consulta.executeUpdate(pConsulta);
    	} catch (Exception e) {
            e.printStackTrace();
    		System.err.println(e);
    	}
    }
    
    public static ResultSet execSQL(String pConsulta) { //SELECT
    	ResultSet resultado = null;
    	try {
            if (conexion != null) {
                conexion.close();
            }
            if (consulta != null) {
                consulta.close();
            }
            conexion = GestorBD.getConnection();
    		consulta = conexion.createStatement();
    		resultado = consulta.executeQuery(pConsulta);
    	} catch (Exception e) {
            e.printStackTrace();
    		System.err.println(e);
    	}
    	return resultado;
    }
    
    public static Vector<String> execSQLList(String pConsulta) { // SELECT
		ResultSet resultado = null;
		Vector<String> list = new Vector<String>();

		try {
			if (conexion != null) {
				conexion.close();
			}
			if (consulta != null) {
				consulta.close();
			}
			conexion = GestorBD.getConnection();
			consulta = conexion.createStatement();
			resultado = consulta.executeQuery(pConsulta);
			while(resultado.next()) {
				String res = resultado.getString("usuario");
				list.add(res);
				resultado.next();
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
		return list;
	}
}