import java.util.Vector;

/*Esta Clase se obutvo del material proporcionado en clase*/

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {


    /**
     * Override de la interface PriorityQueue
     * @return el primer valor en la cola
     */
    @Override
        public E getFirst() {
            return data.get(0);
    }

    /**
     * Override de la interface PriorityQueue
     * Confirmar si el vector esta vacio
     * @return estado booleano segun si esta vacio o no
     */
    @Override
    public boolean isEmpty() {
        return 0== data.size();
    }

    /**
     * Override de la interface PriorityQueue
     * @return tamaño del vector
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Override de la interface PriorityQueue
     * Limpiar el vector
     */
    @Override
    public void clear() {
        data.clear();
    }

    /**
     * Vector para almacenar
     */
    protected Vector<E> data;

    /**
     * Constructor
     */
    public VectorHeap()
    // post: constructs a new priority queue
    {
        data = new Vector<E>();
    }

    /**
     * Override del costructor
     * @param v Vector desordenadosque que agregara elemento por elemento para ser ordenado
     */
    public VectorHeap(Vector<E> v)
    // post: constructs a new priority queue from an unordered vector
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }
    }

    /**
     * Metodo protegido estatico para asignar hijo izquierdo
     * @param i posision para buscar al padre mediante la funcion matematica
     * @return posision del padre
     */
    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i-1)/2;
    }

    /**
     * Metodo protegido estatico para asignar hijo izquierdo
     * @param i posision para ubicar al hijo izquierdo
     * @return posision del hijo izquierdo
     */
    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2*i+1;
    }

    /**
     * Metodo privado estatico para asignar hijo derecho
     * @param i posision para ubicar al hijo izquierdo
     * @return posision del hijo derecho
     */
    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return (2*i+1) + 1;
    }

    /**
     * Ordenamiento del vector al agregar un nuevo dato
     * @param leaf posision del elemento a ordenar al ser agregado
     */
    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        Persona value =(Persona) data.get(leaf);



        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {

            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,(E) value);
    }

    /**
     * Agregar un nuevo valor
     * @param value nuevo elemento a agregar al vector de la clase
     */
    @Override
    public void add(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * Ordenamiento cuanto se retira un elemento
     * @param root ruta del elemento a ordenar al retirar un elemto
     */
    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {

        int heapSize = data.size();
        Persona value = (Persona) data.get(root);

        while (root < heapSize) {

            int childpos = left(root);
            if (childpos < heapSize)
            {

                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if (((Persona)data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down

                } else { // found right location
                    data.set(root,(E) value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,(E) value);
                return;
            }
        }
    }

    /**
     * Quitar el primer elemnto
     * @return Primer elemento del vector
     */
    @Override
    public E remove()
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }




}
