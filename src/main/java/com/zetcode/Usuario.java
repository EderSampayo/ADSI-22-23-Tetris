package com.zetcode;

public class Usuario
{
    private String nombre;
    private String apellido;
    private String clave;

    public Usuario(String pNombre, String pApellido, String pClave)
    {
        this.nombre = pNombre;
        this.apellido = pApellido;
        this.clave = pClave;
    }
    
    public String getNombre() {
    	return this.nombre;
    }
    
    public String getApellido() {
    	return this.apellido;
    }
}
