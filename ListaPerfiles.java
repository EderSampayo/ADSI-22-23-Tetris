package com.zetcode;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPerfiles {

	private static ListaPerfiles miListaPerfiles;
    private ArrayList<Perfil> listaP;

    private ListaPerfiles()
    {
        this.listaP = new ArrayList<Perfil>();
    }

    public static ListaPerfiles getMiListaPerfiles()
    {
        if (ListaPerfiles.miListaPerfiles == null)
        {
            ListaPerfiles.miListaPerfiles = new ListaPerfiles();
        }
        return ListaPerfiles.miListaPerfiles;
    }

    //metodos
	
    private Iterator<Perfil> getIterador()
	{
		return this.listaP.iterator();
	}
    
    public Perfil obtenerPerfil(Usuario user) {
    	Perfil perfilUser = null;
		boolean enc = false;
		Iterator <Perfil> itr = this.getIterador();
		while(itr.hasNext() && !enc) {
			perfilUser = itr.next();
			if (perfilUser.esEsteUsuario(user)) {
				enc = true;
			}
		}
		if(!enc) {
			perfilUser = null;
		}
		return perfilUser;
    }
    
}
