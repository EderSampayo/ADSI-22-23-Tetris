package com.zetcode;


public class Identificacion
{
    private static Identificacion miId;

    private Identificacion()
    {

    }

    public static Identificacion getMiId()
    {
        if (Identificacion.miId == null)
        {
            Identificacion.miId = new Identificacion();
        }
        return Identificacion.miId;
    }

    //metodos

    public void registrar()
    {

    }

    public void logear()
    {

    }

    private boolean esAdmin()
    {
        return false;
    }
}
