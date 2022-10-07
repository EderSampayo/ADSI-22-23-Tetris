package com.zetcode;

import java.util.ArrayList;

public class Perfil {
	
	private String nombre;
	private String apellido;
	private int clave;
	private int mejorMarca;
	
	public Perfil(String pNombre, String pApellido)
	{
		this.nombre = pNombre;
		this.apellido = pApellido;
		this.mejorMarca = 0;
	} 
	
    public boolean esEsteUsuario(Usuario user) {
    	
    	boolean es = false;
    	if(user.getNombre() == this.nombre && user.getApellido() == this.apellido) {
    		es = true;
    	}
		return es ;
    }
    
    public void modificarMarca(int pMarca) {
    	this.mejorMarca = pMarca;
    }
    
    
}
