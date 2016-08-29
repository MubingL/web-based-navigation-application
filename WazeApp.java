package DijkstraFib;
//import java.util.*;

public class WazeApp {

 public static void main(String[] args) {

  UndiGraph<Node> graph = new UndiGraph<Node> ();
  
  //Initialization below generates a graph for presenting results
  //for example, input 8 nodes in the map for calculation
  
  Node node0=new Node (0,41.974556,-121.904167);
  Node node1=new Node (1,41.974766,-121.902153);
  Node node2=new Node (2,41.988075,-121.89679);
  Node node3=new Node (3,41.998032,-121.889603);
  Node node4=new Node (4,42.008739,-121.886681);
  Node node5=new Node (5,41.970314,-121.915062);
  Node node6=new Node (6,41.973942,-121.910088);
  Node node7=new Node (7,41.969482,-121.916199);
  Node node8=new Node (8,41.968456,-121.903198);
  graph.addNode(node0);
  graph.addNode(node1);
  graph.addNode(node2);
  graph.addNode(node3);
  graph.addNode(node4);
  graph.addNode(node5);
  graph.addNode(node6);
  graph.addNode(node7);
  graph.addNode(node8);
  
  //create 13 node pairs to form the edges
  
  NodePair ends1=new NodePair (node0,node1);
  NodePair ends2=new NodePair (node0,node6);
  NodePair ends3=new NodePair (node1,node2);
  NodePair ends4=new NodePair (node2,node3);
  NodePair ends5=new NodePair (node3,node4);
  NodePair ends6=new NodePair (node5,node6);
  NodePair ends7=new NodePair (node5,node7);
  NodePair ends8=new NodePair (node5,node8);
  NodePair ends9=new NodePair (node4,node7);
  NodePair ends10=new NodePair (node4,node8);
  NodePair ends11=new NodePair (node1,node7);
  NodePair ends12=new NodePair (node2,node7);
  NodePair ends13=new NodePair (node3,node7);
  
  //assign length for each edge
  
  Edge edge1=new Edge (0,ends1,2.574);
  Edge edge2=new Edge (1,ends2,2.057);
  Edge edge3=new Edge (2,ends3,3.4253);
  Edge edge4=new Edge (3,ends4,2.83565);
  Edge edge5=new Edge (4,ends5,2.63575);
  Edge edge6=new Edge (5,ends6,5.2363);
  Edge edge7=new Edge (6,ends7,6.43476);
  Edge edge8=new Edge (7,ends8,7.4462);
  Edge edge9=new Edge (8,ends9,9.5734);
  Edge edge10=new Edge (9,ends10,6.3563);
  Edge edge11=new Edge (10,ends11,5.3345);
  Edge edge12=new Edge (11,ends12,5.65645);
  Edge edge13=new Edge (12,ends13,5.85745);
  graph.addEdge(edge1);
  graph.addEdge(edge2);
  graph.addEdge(edge3);
  graph.addEdge(edge4);
  graph.addEdge(edge5);
  graph.addEdge(edge6);
  graph.addEdge(edge7);
  graph.addEdge(edge8);
  graph.addEdge(edge9);
  graph.addEdge(edge10);
  graph.addEdge(edge11);
  graph.addEdge(edge12);
  graph.addEdge(edge13);
  
  //k represents how many shortest paths the user is querying
  int k=3;
  Path[] path=new Path [k];
  path=kDijkstra.kShortestPaths(graph, node4, node5,k);
  for (int i=0;i<k;i++){
   System.out.println("The "+(i+1)+"th shortest path: ");
   for (int j=0;j<path[i].getEdgeList().size();j++){
    System.out.println("edge"+path[i].getEdgeList().get(j).getEdgeId());
   }
  }

 }
}

