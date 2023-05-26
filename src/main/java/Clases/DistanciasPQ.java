
package Clases;
import java.util.*;


public class DistanciasPQ {

    private int[][] graph;
    private int numVertices;
    int nn=0;
    
    public DistanciasPQ(int[][] graph) {
        this.graph = graph;
        this.numVertices = graph.length;
    }

    public void findShortestPaths(int source) {
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int minDistance = findMinDistance(distances, visited);
            visited[minDistance] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && graph[minDistance][j] != 0 &&
                    distances[minDistance] != Integer.MAX_VALUE &&
                    distances[minDistance] + graph[minDistance][j] < distances[j]) {
                    distances[j] = distances[minDistance] + graph[minDistance][j];
                }
            }
        }

        printShortestPaths(distances);
    }

    public int findMinDistance(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && distances[i] <= minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public void printShortestPaths(int[] distances) {
        int l=0;
        System.out.println("Las rutas mas cortas desde esa direccion hacia los diferentes municipios del Depto. de Chimaltenango :");
        String[] paisesAmerica = {"Acatenango", "Chimaltenango", "El tejar", "Parramos", "Patzicia", "Patzún", "Pochota", "San Andres Itzapa", "San José Poaquíl", "San Juan Comalapa", "San Martín Jilotepeque", "Santa Apolonia", "Santa Cruz Balanyá","Tecpán","Yepocapa","Zaragoza"
};

        for (int i = 0; i < numVertices; i++) {
            
            System.out.println("Municipio :"+" "+paisesAmerica[i]+" = " + distances[i]);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de grafo representando las distancias entre países
        
        int Pos;// Variable para ubicar la publicacion 
        int[][] graph = {
            //Municipios con distancias entre si
            { 0,  13,  28,  5, 17,  8, 22, 22, 18, 28, 13, 33, 28, 27, 18, 27 },   // Minicipio 1:
            { 1,   0,  18, 25, 23, 18, 17, 26, 16, 27, 23, 35, 26, 23, 12, 24 },   // Minicipio 2:
            { 5,  15,   0, 28, 22, 17, 15, 28, 12, 29, 33, 35, 25, 21, 20, 23 },   // Minicipio 3:
            { 15, 39,   7,  0, 24, 23, 13, 24, 11, 23, 43, 28, 26, 19, 22, 28 },   // Minicipio 4:
            { 12, 15,   6, 26,  0, 17, 11, 35, 18, 26, 23, 22, 29, 39, 23, 29 },   // Minicipio 5:
            { 14, 25,   5, 10, 28,  0, 32, 38, 13, 24, 13, 21, 26, 29, 25, 25 },   // Minicipio 6:
            { 16, 32,  14,  7, 12, 15,  0, 42, 14, 27, 28, 31, 23, 18, 29, 27 },   // Minicipio 7:
            { 19, 31,  13,  4, 11, 11, 25,  0, 19, 25, 25, 30, 26, 14, 14, 24 },   // Minicipio 8:
            { 25, 33,  12, 12, 19, 13, 28, 17,  0, 27, 29, 32, 24, 25, 13, 24 },   // Minicipio 9:
            { 18, 35,  15,  9, 25,  9, 11, 25, 15,  0, 22, 33, 27, 23, 11, 23 },  // Minicipio 10:
            { 17, 15,  12,  8, 28,  8, 14, 26, 15, 23,  0, 38, 27, 21, 10, 24 },  // Minicipio 11:
            { 15, 32,  11,  3, 13,  7, 17, 21, 11, 28, 35, 0,  26, 29, 12, 20 },  // Minicipio 12:
            { 28, 12,  18, 14, 11,  8, 15, 24, 15, 25, 31, 27,  0, 29, 12, 24 },  // Minicipio 13:
            { 14, 28,  28, 11, 15,  5, 13, 23, 18, 29, 23, 23, 24, 0,  12, 24 },  // Minicipio 14:
            { 15, 21,  14,  7, 17, 10, 12, 22, 15, 22, 21, 20, 22, 29,  0, 24 },  // Minicipio 15:
            { 29, 25,  10,  5, 12,  8, 18, 11, 17, 25, 20, 22, 26, 29, 12,  0 },  // Minicipio 16:
        }; 

        DistanciasPQ dijkstra = new DistanciasPQ(graph);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el municipio de Chimaltenango que quiere consultar \n"+ 
    "   1)  Acatenango\n" +
    "   2)  Chimaltenango\n" +
    "   3)  El tejar\n" +
    "   4)  Parramos\n" +
    "   5)  Patzicia\n" +
    "   6)  Patzún\n" +
    "   7)  Pochota\n" +
    "   8)  San Andres Itzapa\n" +
    "   9)  San José Poaquíl\n" +
    "  10)  San Juan Comalapa\n" +
    "  11)  San Martín Jilotepeque\n" +
    "  12)  Santa Apolonia\n" +
    "  13)  Santa Cruz Balanyá\n" +
    "  14)  Tecpán\n" +
    "  15)  Yepocapa\n" +
    "  16)  Zaragoza\n");
        
        String nombre = scanner.next();
        Pos = Integer.parseInt(nombre);
        Pos=(Pos-1);
        dijkstra.findShortestPaths(Pos); // Calcular las rutas más cortas el municipio seleccionado
    }
}


