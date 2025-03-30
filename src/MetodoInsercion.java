public class MetodoInsercion {
    private int comparaciones;
    private int cambios;

    
    public int[] ordenarAscendente(int[] arreglo, boolean isDes, boolean mostrarPasos) {
        comparaciones = 0;
        cambios = 0;
        int numComparacion = 1;

        if(mostrarPasos){
            System.out.println("Arreglo original -> ");
            printArray(arreglo);
        }
        for (int i = 1; i < arreglo.length; i++)    {
            int actual = arreglo[i];
            int j = i -1;
            while (j >= 0 ) {
                comparaciones++;
                boolean condicion= isDes ? (arreglo[j] < actual) : (arreglo[j] > actual) ;


                if (mostrarPasos) {
                    System.out.println("Comparación " + numComparacion + ": " + arreglo[j] + " " + (isDes ? " < " : " > ") + " " + actual);
                     numComparacion++;
                }
                if (!condicion) {
                    break;
                    
                }
                arreglo[j + 1] = arreglo[j];
                cambios++;

                if (mostrarPasos) {
                    System.out.println("Intercambio: " + " " + arreglo[j ] + " <-> " + (j +1));

                } else {
                    if (mostrarPasos) {
                        System.out.println("(No hay intercambio)");
                    }
                }

                if ((mostrarPasos)){
                    System.out.println("Estado actual -> ");
                    printArray(arreglo);
                }
                j--;
                
            } 
            arreglo[j + 1] = actual;
        }
        if (!mostrarPasos) {
            System.out.println("Comparación " + comparaciones);
            
        }
         return new int[]{comparaciones, cambios} ;  
    }

    public void printArray(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

