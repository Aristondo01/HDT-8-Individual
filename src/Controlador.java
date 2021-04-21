import java.util.PriorityQueue;
import java.util.Vector;

public class Controlador
{
    Lector leer;

    public  Controlador()
    {
        leer = new Lector();
    }
    public void Start()
    {
        Vector<?> pacientes = leer.Leer ("pacientes.txt");

        VectorHeap ImplementacionPropia = new VectorHeap(pacientes);

        int i = ImplementacionPropia.size();
        System.out.println("VectorHeap implementación propia los resultados son:");
        for (int j=0; j<i;j++)
        {
            Persona p = (Persona) ImplementacionPropia.remove();
            System.out.println("Paciente No."+(j+1)+" "+p.getNombre()+" con sintomas de "+p.getSintomas());
        }

        PriorityQueue<Persona> pq = new PriorityQueue();
        for (int j=0;j<i;j++)
        {
            pq.add((Persona) pacientes.get(j));
        }

        System.out.println("\n\nPriorityQueue implementación JCF los resultados son:");

        for (int j=0; j<i;j++)
        {
            Persona p = pq.remove();
            System.out.println("Paciente No."+(j+1)+" "+p.getNombre()+" con sintomas de "+p.getSintomas());
        }




    }
}
