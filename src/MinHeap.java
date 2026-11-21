import java.util.ArrayList;

public class MinHeap {

    // Atributos
    private ArrayList<Integer> monticulo;

    // Métodos
    // Constructor
    public MinHeap() {
        monticulo = new ArrayList<>();
    }

    // Operaciones
    private boolean estaVacio() {
        return monticulo.isEmpty();
    }

    private int getIzq(int i) {
        return (2 * i) + 1;
    }

    private int getDer(int i) {
        return (2 * i) + 2;
    }

    private int getPadre(int i) {
        return (i - 1) / 2;
    }

    public void insertar(int nodo) {
        monticulo.add(nodo);

        // Invocar upHeapify() sobre la casilla en la que se acaba de insertar ese nodo
        upHeapify(monticulo.size() - 1);
    }

    private void upHeapify(int i) {
        // Sustituir de manera exhaustiva el nodo de la casilla i con su padre, si es menor que él
        if (i > 0) {
            int padre = getPadre(i);

            if (monticulo.get(i) < monticulo.get(padre)) {
                int temp = monticulo.get(i);

                monticulo.set(i, monticulo.get(padre));
                monticulo.set(padre, temp);

                // Volver a ejecutar el método sobre la posición del padre
                upHeapify(padre);
            }
        }
    }

    public int eliminarMin() {
        if (estaVacio()) {
            System.out.println("El montículo está vacío.\n");
            return -1;
        }

        int temp = monticulo.get(0);

        // Si solamente existe un elemento, se elimina directamente
        if (monticulo.size() == 1) {
            monticulo.remove(0);
        } else {
            // Movemos el último elemento del array a la primera casilla
            int ultimo = monticulo.remove(monticulo.size() - 1);
            monticulo.set(0, ultimo);

            // Una vez movido, se aplica downHeapify() sobre la cima
            downHeapify(0);
        }

        return temp;
    }

    private void downHeapify(int i) {
        // Sustituir de manera exhaustiva el nodo de la casilla i por el menor de sus hijos
        int izq = getIzq(i);
        int der = getDer(i);
        int menor = i;

        // Verificar si existe el hijo izquierdo y es menor que el nodo actual
        if (izq < monticulo.size() && monticulo.get(izq) < monticulo.get(menor)) {
            menor = izq;
        }

        // Verificar si existe el hijo derecho y es menor que el nodo actual
        // Si los dos hijos son iguales, se mantiene el izquierdo
        if (der < monticulo.size() && monticulo.get(der) < monticulo.get(menor)) {
            menor = der;
        }

        // Si alguno de los hijos es menor, se intercambian las posiciones
        if (menor != i) {
            int temp = monticulo.get(i);

            monticulo.set(i, monticulo.get(menor));
            monticulo.set(menor, temp);

            // Volver a ejecutar el método sobre la nueva posición del nodo
            downHeapify(menor);
        }
    }

    public int peek() {
        if (estaVacio()) {
            System.out.println("El montículo está vacío.\n");
            return -1;
        }

        return monticulo.get(0);
    }

    public void heapify(int[] arreglo) {
        // Elimina los elementos actualmente almacenados en el ArrayList
        monticulo.clear();

        // Toma los contenidos del arreglo recibido como argumento y los copia en el ArrayList
        for (int i = 0; i < arreglo.length; i++) {
            monticulo.add(arreglo[i]);
        }

        // Ordena los elementos del ArrayList con base en el principio de ordenamiento del montículo mínimo
        for (int i = (monticulo.size() / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    // Mostrar los elementos almacenados en el montículo
    public void mostrarMonticulo() {
        if (estaVacio()) {
            System.out.println("El montículo está vacío.\n");
        } else {
            System.out.println("Elementos del montículo: " + monticulo);
        }
    }
}