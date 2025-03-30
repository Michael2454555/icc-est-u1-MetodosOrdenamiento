public class MetodoBurbuja {
    private int comparaciones;
    private int cambios;
    
    public int[] ordenar(int[] arreglo, boolean isDes, boolean mostrarPasos) {
        comparaciones = 0;
        cambios = 0;
        int numComparacion = 1; 
        
        if (mostrarPasos) {
            System.out.println("Arreglo original -> ");
            printArray(arreglo);
        }
        
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                comparaciones++;
                
                
                if (mostrarPasos) {
                    System.out.println("Comparación " + numComparacion + ": " + arreglo[j] +
                        " " + (isDes ? "<" : ">") + " " + arreglo[j + 1]);
                    numComparacion++;
                }
                
                boolean condicion = isDes ? (arreglo[j] < arreglo[j + 1]) : (arreglo[j] > arreglo[j + 1]);
                
                if (condicion) {
                    cambios++;
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    
                    if (mostrarPasos) {
                        System.out.println("Intercambio: " + temp + " <-> " + arreglo[j]);
                    }
                } else {
                    if (mostrarPasos) {
                        System.out.println("(No hay intercambio)");
                    }
                }
                
                if (mostrarPasos) {
                    System.out.print("Estado actual -> ");
                    printArray(arreglo);
                }
            }
        }
        
        
        if (!mostrarPasos) {
            System.out.println("Comparación " + comparaciones);
        }
        
        return new int[]{comparaciones, cambios};
    }
    
    public void printArray(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
