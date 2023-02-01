import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS {

    private int V;
    private LinkedList<Integer> adj[];

    // Create a graph
    BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Add edges to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS algorithm
    void BFS(int s) {

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {



//        data testing
//        vertex - edge
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
            BFS BFS = new BFS(numNodes);

            // read the edge
            int numEdges = scanner.nextInt();
            System.out.println("Num edge " + numEdges);

            // add the neighbors

            for (int i = 0; i < numEdges; i++) {
                // get the nodes
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                BFS.addEdge(a, b);

            }

            // close the scanner
            scanner.close();

            // BFS algo
            BFS.BFS(2);


        }

    }
