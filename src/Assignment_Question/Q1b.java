package Assignment_Question;

/*Question 1;
b)
        Assume you were hired to create an application for an ISP, and there is n number of network devices,
         such as routers, that are linked together to provides internet access to home user users.
         You are given a 2D array that represents network connections between these network devices such
         that a[i]=[xi,yi] where xi is connected to yi device.
         Suppose there is a power outage on a certain device provided as int n represents id of the device
         on which power failure occurred)), Write an algorithm to return impacted network devices due to breakage
         of the link between network devices. These impacted device list assists you notify linked consumers
         that there is a power outage and it will take some time to rectify an issue. Note that: node 0 will
         always represent a source of internet or gateway to international network..

        Input: edges= {{0,1}, {0,2}, {1,3}, {1,6}, {2,4}, {4,6}, {4,5}, {5,7}}
        Target Device (On which power Failure occurred): 4
        Output (Impacted Device List) = {5,7}
        Explanation: power failure on network device 4 will disconnect 5 and 7 from internet*/

import java.util.ArrayList;
import java.util.List;

class Isp_Application {

    // A class to represent a graph.
    // Matrix size will be v (number of vertices in graph) * v
    int v;
    //Matrix to define Graph
    int[][] adj_Matrix;
    //Broken Node
    int broken_Node;

    // Constructor
    Isp_Application(int V, int[][] edges, int brokenNode) {
        //defines the vertices
        this.v = V;
        // define array size as the number of vertices
        this.adj_Matrix = new int[V][V];
        //looped over the edge elements and added them to the graph
        for (int[] edge : edges) {
            // Call AddEdge Function to Populate
            addEdge(edge[0], edge[1]);
        }
        //defines the brokenNode
        this.broken_Node = brokenNode;
    }

    // An edge is added to an undirected graph.
    void addEdge(int src, int dest) {
        // Add an edge from src to dest.
        adj_Matrix[src][dest] = 1;
        // Since Network graph is undirected, add an edge from dest to src also
        adj_Matrix[dest][src] = 1;
    }

    // Removes a vertex and all edges that are related to it.
    void removeVertex() {
        // Remove the vertex from the matrix
        for (int i = 0; i < v; i++) {
            adj_Matrix[i][broken_Node] = 0;
            adj_Matrix[broken_Node][i] = 0;
        }
    }

    // Returns  list of disconnected Node
    List<Integer> getDisconnectedSubgraphs() {
        //Call removeVertex function to remove the broken Node from Graph
        removeVertex();
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[v];
        //A List of Integers is defined as a subgraph that returns a disconnected node.
        List<Integer> subgraphs = new ArrayList<>();

        //Detect subgraphs
        for (int v = 0; v < this.v; ++v) {
            //Checks if Vertext is Visited or is broken or not
            //If it has been visited, it is not necessary to return, and if it is broken, it automatically splits graphs.
            if (!visited[v] && v != broken_Node) {
                // While there may be numerous little detached due to one breaking point, a subgraph was defined for each.
                List<Integer> subgraph = new ArrayList<>();
                // Print every reachable vertices from v
                DFSUtil(v, visited, subgraph);
                // If the Subgraph is a breakpoint or has a network source, it is not separated from the network.
                if (!subgraph.contains(broken_Node) && !subgraph.contains(0)) {
                    //If above condition satisfies then every small part of subgraph to subgraphs
                    subgraphs.addAll(subgraph);
                }
            }
        }
        // returned subgraphs
        return subgraphs;
    }

    void DFSUtil(int v, boolean[] visited, List<Integer> subgraph) {
        // Add the current node to the subgraph after marking it as visited.
        visited[v] = true;
        subgraph.add(v);
        // Recur for all the vertices adjacent to this vertex
        for (int i = 0; i < this.v; ++i) {
            if (adj_Matrix[v][i] == 1 && !visited[i]) {
                DFSUtil(i, visited, subgraph);
            }
        }
    }
    // Driver code
    public static void main(String[] args) {
        //Edges OF the Graph
        int[][] edges = {{0,1}, {0,2}, {1,3}, {1,6}, {2,4}, {4,6}, {4,5}, {5,7}};
        //broken Node
        int brokenNode = 4;
        // Create a graph
        Isp_Application g = new Isp_Application(8,edges,brokenNode);

        System.out.println("Interuppted Networks:");
        //Get Disconencted Networks
        List<Integer> subgraphs = g.getDisconnectedSubgraphs();
        System.out.println(subgraphs);

    }
}

