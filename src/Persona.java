public class Persona implements Comparable
{
    char Prioridad;
    String Sintomas,Nombre;

    public char getPrioridad() {
        return Prioridad;
    }

    public String getNombre()
    {
        return  Nombre;
    }


    public String getSintomas() {
        return Sintomas;
    }

    public  Persona(char letra, String sintomas, String nombre )
    {
        Prioridad = letra;
        Sintomas= sintomas;
        Nombre=nombre;
    }


    @Override
    public int compareTo(Object o)
    {
        Persona p = (Persona) o;
        if (p.getPrioridad()<Prioridad)
            return 1;

        return -1;
    }

}
