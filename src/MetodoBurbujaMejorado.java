public class MetodoBurbujaMejorado {
    private int comparaciones;
    private int cambios;

    public int[] ordenarAscendente (int[] arreglo, boolean isDes, boolean mostrarPasos) {
        comparaciones = 0;
        cambios = 0;
        int numComparacion = 1;
        boolean intercambio;

        if (mostrarPasos) {
            System.out.println("Arreglo original -> ");
            printArray(arreglo);
        }

        for (int i = 0; i < arreglo.length - 1; i++) {
            intercambio = false;
            for (int j = 0; j < arreglo.length -i - 1; j++) { 
                comparaciones++;
                boolean condicion = isDes ? 
                (arreglo[j] < arreglo[j + 1]) : 
                (arreglo[j] > arreglo[j + 1]);
                String operador = isDes ? " < " : " > ";

                if(mostrarPasos) {
                    System.out.println("Comparación " + numComparacion + ": " + arreglo[j] + 
                        " " + operador + " " + arreglo[j + 1]);
                        numComparacion++;
                }

                if(condicion) {
                    cambios++;
                    int temp = arreglo[j];
                    arreglo[j]= arreglo[j + 1];
                    arreglo[j + 1]= temp;
                    intercambio = true;

                    if (mostrarPasos) {
                        System.out.println("Intercambio: " + " " + temp + "<-> " + arreglo[j + 1]);
                        
                    }

                } else {
                    if ((mostrarPasos)) {
                        System.out.println("(No hay intercambio)");
                        
                    }
                }
                
                if ((mostrarPasos)) {
                    System.out.println("Estado actual -> ");
                    printArray(arreglo);
                }

            }if (!intercambio) break;
        } 
            
        


        if (!mostrarPasos) {
            System.out.println("Comparación " + comparaciones);
        }


        return new int[]{comparaciones, cambios};
    }

    public void printArray(int[] arreglo){
        for(int num : arreglo){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}