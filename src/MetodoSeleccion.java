public class MetodoSeleccion {
    private int comparaciones;
    private int cambios;

    public int[] ordenar(int[] arreglo, boolean isDes, boolean mostrarPasos){
        comparaciones = 0;
        cambios = 0;
        int numComparacion = 1;

        if (mostrarPasos) {
            System.out.println("Arreglo original -> ");
            printArray(arreglo);
        }

        for(int i = 0 ; i < arreglo.length - 1; i++) {
            int extremo = i;

            for(int j = i + 1; j < arreglo.length; j++) {
                comparaciones++;
                boolean condicion = isDes ? (arreglo[j] > arreglo[extremo]) : (arreglo[j] < arreglo[extremo]);
                
                
                if (mostrarPasos) {
                    System.out.println("Comparación " + numComparacion+ ": " + arreglo[j] + " " + 
                        (condicion ? " > " : " < ") + " " + arreglo[extremo]);
                        numComparacion++;
                }

                if (condicion) {
                    extremo = j;
                    
                }
            }

            if (i != extremo) {
                cambios++;
                int temp = arreglo [i];
                arreglo[i] = arreglo[extremo];
                arreglo[extremo] = temp; 
    
                if (mostrarPasos) {
                    System.out.println("Intercambio: " +  " " + temp + " <-> " + arreglo[i]);
                    
                }
       
            } else {
                if (mostrarPasos) {
                    System.out.println("(No hay intercambio)");
                }
            }
            if (mostrarPasos) {
                System.out.println("Estado actual -> ");
                printArray(arreglo);
                
            }
             
        }

         return new int[]{comparaciones, cambios};
    }



    public void printArray(int[] arreglo) {
        for(int num : arreglo) {
            System.out.print(num  + " ");
        }
        System.out.println();
    }
}

