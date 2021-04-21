import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class VectorHeapTest {

    @org.junit.Test
    public void add()
    {
        Persona a = new Persona('C',"Fractura de pierna","Juan Perez");
        Persona b = new Persona('A',"Apendicitis","Maria Ramirez");
        Vector<Persona> Listado= new  Vector<>();

        Listado.add(a);
        Listado.add(b);

        VectorHeap v = new VectorHeap(Listado);

        Persona p = (Persona) v.remove();
        Persona p1 = (Persona) v.remove();

        assertEquals('A',p.getPrioridad());
        assertEquals('C',p1.getPrioridad());

    }

}