import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    // Graph creation
    DFS(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    // Add edges
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // DFS algorithm
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {



//        dữ liệu test
//        2 số dòng đầu tiên là số đỉnh và số cạnh

//        4 6
//        0 1
//        0 2
//        1 2
//        2 0
//        2 3
//        3 3

        String file = "src/filename.txt";
        Scanner scanner = new Scanner(new File(file));

        // read the number of nodes
        int numNodes = scanner.nextInt();
        // create graph
        DFS graph = new DFS(numNodes);

        // read the edge
        int numEdges = scanner.nextInt();
        System.out.println("Num edge " + numEdges);

        // add the neighbors

        for (int i = 0; i < numEdges; i++) {
            // get the nodes
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph.addEdge(a, b);

        }

        // close the scanner
        scanner.close();

        // BFS algo
        graph.DFS(2);


    }

}
