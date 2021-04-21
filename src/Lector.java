import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Lector {

    public Vector<?> Leer(String nombre)
    {
        Vector<Persona> temp = new Vector<>();
        try
        {
            File Archivo = new File(nombre);
            Scanner Lector = new Scanner(Archivo);

            while (Lector.hasNextLine())
            {
                String Line = Lector.nextLine();
                String [] arr = Line.split(",");
                Persona p = new Persona((arr[2]).charAt(0),arr[1],arr[0]);
                temp.add(p);
            }

        }
        catch (Exception e)
        {
            System.out.println("Error al abrir el archivo "+ e);
        }
        return temp;
    }


}
