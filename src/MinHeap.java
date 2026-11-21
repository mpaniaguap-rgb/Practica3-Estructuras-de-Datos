import java.util.ArrayList;

public class MinHeap {

    //Atributos 
    private ArrayList<Integer> monticulo;

    //Métodos
    //Constructor 
    public MinHeap (){
        monticulo = new ArrayList<>();
    }

    //Operaciones 
    private boolean estaVacio(){
        return monticulo.isEmpty();
    }

    private int getIzq(int i){
        return (2 * i) +1;
    }

    private int getDer(int i){
        return (2 * 1) + 2;
    }

    private int getPadre(int i){
        return (i - 1) / 2;
    }

    public void insertar(int nodo) {
        monticulo.add(nodo);
        // Invocar upHeapify() sobre la casilla en la que se acaba de insertar ese nodo
    }

    private void upHeapify(int i) {
        // Sustituir de manera exhaustiva el nodo de la casilla i con su padre, si es menor que él
    }

    public int pop() {
        if (estaVacio()) {
            System.out.println("El montículo está vacío.\n");
            return -1;
        }
        int temp = monticulo.removeFirst();
        // Movemos el último elemento del array a la primera casilla
        // Una vez movido, se aplica downHeapify() sobre la cima
        return temp;
    }

    private void downHeapify() {
        // Sustituir de manera exhaustiva el nodo de la casilla i por el menor de sus hijos, si son diferentes
        // Si los dos hijos son iguales, se sustituye por el de la izq
        // Si entre los hijos no hay ninguno que sea menor que el de la casilla i, entonces no se hace nada
    }

    public int peek() {
        if (estaVacio()) {
            System.out.println("El montículo está vacío.\n");
            return -1;
        }
        return monticulo.getFirst();
    }

    public void heapify(int[] arreglo) {
        // Elimina los elementos actualmente almacenados en el ArrayList
        // Toma los contenidos del arreglo recibido como argumento y los copia en el ArrayList
        // Ordena los elementos del ArrayList con base en el principio de ordenamiento del montículo mínimo
    }

}