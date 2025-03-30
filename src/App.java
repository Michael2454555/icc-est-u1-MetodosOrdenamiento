import java.util.Arrays;
import java.util.Scanner;

public class App { 
    public static void main(String[] args) throws Exception {

        int[] listado = {12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3, 27, -30, 14, 7, -1, 41, 20, -11, 8};
        
        MetodoBurbuja mB= new MetodoBurbuja();
        MetodoSeleccion mS= new MetodoSeleccion();
        MetodoInsercion mI = new MetodoInsercion();
        MetodoBurbujaMejorado mBM= new MetodoBurbujaMejorado();
        
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("--Métodos de Ordenamiento--");
            System.out.println(" 1 -> Burbuja");
            System.out.println(" 2 -> Selección");
            System.out.println(" 3 -> Inserción");
            System.out.println(" 4 -> Burbuja Mejorado");
            System.out.println(" 5 -> Salir");

            
            int metodo = getPositive(scanner,  "Ingrese la opción:");  

            if (metodo == 5) {
                System.out.println("Programa Cerrado");
                continuar = false;
                break;
                
            }
            if ( metodo < 1 || metodo > 4 ){
                System.out.println("Opción no existe. Intente nuevamente. ");
                continue;
            }
            
            boolean conPasos = getvalidBoolean(scanner,"¿Desea ver los pasos? (true/false) : " );

            

            String orden= getValidString(scanner, new String[]{"A","D"},
                    "¿Desea ordenar ascendentemente (A) o descendentemente (D) ?:");
            boolean ascendente = orden.equalsIgnoreCase("A");


            int[] resultados = new int[2];
            int[] copiaArreglo = Arrays.copyOf(listado, listado.length);

            switch (metodo) {
                case 1:
                    System.out.println("Método Burbuja");
                    resultados = mB.ordenar(copiaArreglo, !ascendente, conPasos);
                    break;
                case 2:
                    System.out.println("Método Selección");
                    resultados = mS.ordenar(copiaArreglo, !ascendente, conPasos);
                    break;
                case 3:
                    System.out.println("Método Inserción");
                    resultados = mI.ordenarAscendente(copiaArreglo, !ascendente, conPasos);
                    break;
                case 4:
                    System.out.println("Método Burbuja Mejorado");
                    resultados = mBM.ordenarAscendente(copiaArreglo, !ascendente, conPasos);
                    break;
                default:
                    System.out.println("Opción Invalida");
                    continue;

            }
            System.out.println("\n--FIN DEL METODO--");
            System.out.println("Arreglo ordenado -> ");
            printArray(copiaArreglo);
            System.out.println("Comparaciones Totales -> " + resultados[0]);
            System.out.println("Cambios Totales -> " + resultados[1]);
        }
        scanner.close();
        
    }  
    
    public static int  getPositive(Scanner scanner, String message){
        int input;
        do {
            System.out.print(message + " ");
            input = scanner.nextInt();
            if (input <= 0){
                System.out.println("El numero debe ser positivo" +" "+ "Intente nuevamente");
            }

        } while(input <= 0);
        return input;

    }

     public static String getVaString( Scanner scanner,String[] posibles , String message  ){
        String input;
        boolean valido;
        
        do{
            System.out.println(message + " ");
            input= scanner.next();
            valido= false;
            for (String posible: posibles ) {
                if (input.equalsIgnoreCase(posible)){
                    valido= true;
                    break;
                }
                
            }
            if (!valido) {
                System.out.println("Opción inválida. Intente nuevamente. ");
            }

        }while(!valido);
        return input;
          
    }
    public static boolean getvalidBoolean(Scanner scanner, String message) {
        while (true) {
            System.out.println(message +" ");
            if (scanner.hasNextBoolean()) {
                return scanner.nextBoolean();
                
            } else {
                System.out.println("Respuesta Invalida. Por favor, ingrese ¨true¨ o ¨false¨.");
                scanner.next();
            }   
            
        }
    }
    public static String getValidString(Scanner scanner, String[] posibles, String message) {
        String input;
        boolean valido;
        do {
            System.out.println(message + " ");
            input = scanner.next();
            valido = false;
            for (String posible : posibles) { 
                if (input.equalsIgnoreCase(posible)) {
                    valido = true;
                    break;
                }
            }
            if ((!valido)) {
                System.out.println("Opción inválida. Intente nuevamente.");
                
            }
        } while(!valido);
        return input;

    }

    public static void printArray(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}