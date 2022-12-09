package com.zetcode;

import java.util.ArrayList;

public class ListaUsuarios
{
    private static ListaUsuarios miListaUsuarios;
    private ArrayList<Usuario> listaU;

    private ListaUsuarios()
    {
        this.listaU = new ArrayList<Usuario>();
    }

    public static ListaUsuarios getMiListaUsuarios()
    {
        if (ListaUsuarios.miListaUsuarios == null)
        {
            ListaUsuarios.miListaUsuarios = new ListaUsuarios();
        }
        return ListaUsuarios.miListaUsuarios;
    }

    //metodos

}
