import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MinHeap monticulo = new MinHeap();

        menu(monticulo);
    }

    // Menú para utilizar las operaciones del montículo mínimo
    public static void menu(MinHeap monticulo) {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MONTÍCULO MÍNIMO =====");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Consultar mínimo (peek)");
            System.out.println("4. Convertir arreglo en montículo (heapify)");
            System.out.println("5. Mostrar montículo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el número que desea insertar: ");
                    int numero = entrada.nextInt();

                    monticulo.insertar(numero);

                    System.out.println("Elemento insertado correctamente.");
                    break;

                case 2:
                    int eliminado = monticulo.eliminarMin();

                    if (eliminado != -1) {
                        System.out.println("Elemento mínimo eliminado: " + eliminado);
                    }
                    break;

                case 3:
                    int minimo = monticulo.peek();

                    if (minimo != -1) {
                        System.out.println("El elemento mínimo es: " + minimo);
                    }
                    break;

                case 4:
                    System.out.print("¿Cuántos elementos tendrá el arreglo?: ");
                    int cantidad = entrada.nextInt();

                    if (cantidad < 0) {
                        System.out.println("La cantidad no puede ser negativa.");
                    } else {
                        int[] arreglo = new int[cantidad];

                        for (int i = 0; i < cantidad; i++) {
                            System.out.print("Ingrese el elemento " + (i + 1) + ": ");
                            arreglo[i] = entrada.nextInt();
                        }

                        monticulo.heapify(arreglo);

                        System.out.println("El arreglo se convirtió en un montículo mínimo.");
                    }
                    break;

                case 5:
                    monticulo.mostrarMonticulo();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

        entrada.close();
    }
}