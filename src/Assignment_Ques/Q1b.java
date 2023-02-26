//package Assignment_Ques;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
////question 1b)
////        Assume you were hired to create an application for an ISP, and there is n number of network devices, such as
////        routers, that are linked together to provides internet access to home user users. You are given a 2D array that
////        represents network connections between these network devices such that a[i]=[xi,yi] where xi is connected to yi
////        device.  Suppose there is a power outage on a certain device provided as int n represents id of the device on
////        which power failure occurred)), Write an algorithm to return impacted network devices due to breakage of the
////        link between network devices. These impacted device list assists you notify linked consumers that there is a power
////        outage and it will take some time to rectify an issue. Note that: node 0 will always represent a source of internet
////        or gateway to international network..
//
//
//public class Q1b {
//
//    // A class to represent a graph.
//    // Size of Matrix will be V (number of vertices in graph) * V
//    int v;
//    //Matrix to define Graph
//    int[][] adjMatrix;
//    //Broken Node
//    int broken_Node;
//
//    // constructor
//    Q1b(int v, int[][] edges, int broken_Node) {
//        //defines the vertices
//        this.v = v;
//        // define the size of array as the number of vertices
//        this.adjMatrix = new int[v][v];
//        //looped over the elements of edges and populate it to Graph
//        for (int[] edge : edges) {
//            // Call AddEdge Function to Populate
//            add_Edge(edge[0], edge[1]);
//        }
//        //defines the brokenNode
//        this.broken_Node = broken_Node;
//
//    }
//
//    // Adds an edge to an undirected graph
//    void add_Edge(int src, int dest) {
//        // Add an edge from src to dest.
//        adjMatrix[src][dest] = 1;
//        // Since Network graph is undirected, add an edge from dest to src also
//        adjMatrix[dest][src] = 1;
//    }
//
//    // Removes a vertex and all edges connected to it
//    void Remove_Vertex() {
//        // Remove the vertex from the matrix
//        for (int i = 0; i < v; i++) {
//            adjMatrix[i][broken_Node] = 0;
//            adjMatrix[broken_Node][i] = 0;
//        }
//    }
//
//    // Returns a list of all disconnected Node
//    List<Integer> get_Disconnect_Subgraphs() {
//        //Call removeVertex function to remove the broken Node from Graph
//        Remove_Vertex();
//        // Mark all the vertices as not visited
//        boolean[] visited = new boolean[v];
//        //Defined a List of Integer as subgraphs that  returns disconnected node
//        List<Integer> subgraphs = new ArrayList<>();
//
//        // Find all subgraphs
//        for (int v = 0; v < this.v; ++v) {
//            //Checks if Vertext is Visited or is broken or not
//            //If Visited, it is not necssary to visit again and also if it is broken then it automatically separates graphs
//            if (!visited[v] && v != broken_Node) {
//                // Defined a subgraph for each as there might be multiple small disconnected due to one breakage point
//                List<Integer> subgraph = new ArrayList<>();
//                // Print all reachable vertices from v
//                Dfs(v, visited, subgraph);
//                // if the Subgraph is the breakpoint or if the subgraph has source of network then
//                //it is not disconnected from network
//                if (!subgraph.contains(broken_Node) && !subgraph.contains(0)) {
//                    //If above condition satisfied then all all small part of subgraph to subgraphs
//                    subgraphs.addAll(subgraph);
//                }
//            }
//        }
//        //Finally returned subgraphs
//        return subgraphs;
//    }
//
//    void Dfs(int v, boolean[] visited, List<Integer> subgraph) {
//        // Mark the current node as visited and add it to the subgraph
//        visited[v] = true;
//        subgraph.add(v);
//        // Recur for all the vertices adjacent to this vertex
//        for (int i = 0; i < this.v; ++i) {
//            if (adjMatrix[v][i] == 1 && !visited[i]) {
//                Dfs(i, visited, subgraph);
//            }
//        }
//    }
//
//    // Driver code
//    public static void main(String[] args) {
//        //Edges OF the Graph
//        int[][] edges = {{0,1}, {0,2}, {1,3}, {1,6}, {2,4}, {4,6}, {4,5}, {5,7}};
//        //broken Node
//        int brokenNode = 4;
//        // Create a graph
//        Graph g = new Graph(8,edges,brokenNode);
//
//        System.out.println("Interuppted Networks:");
//        //Get Disconencted Networks
//        List<Integer> subgraphs = g.getDisconnectedSubgraphs();
//        System.out.println(subgraphs);
//
//    }
//}
