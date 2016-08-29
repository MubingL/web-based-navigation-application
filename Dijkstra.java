package DijkstraFib;

import java.util.*; // For HashMap

public final class Dijkstra {
  
  public static Path shortestPaths(UndiGraph<Node> graph, Node source, Node sink) {
    
    FibonacciHeap<Node> pq = new FibonacciHeap<Node>();
    
    Map<Node, FibonacciHeap.Entry<Node>> entries = new HashMap<Node, FibonacciHeap.Entry<Node>>();
    
    //double result[]=new double [graph.size()];
    
    ArrayList<Edge> edgelist=new ArrayList<Edge>();
    
    for (Node node: graph)
      entries.put(node, pq.enqueue(node, Double.POSITIVE_INFINITY));
    
    pq.decreaseKey(entries.get(source), 0.0);
    
    while (!pq.isEmpty()) {
      
      FibonacciHeap.Entry<Node> curr = pq.dequeueMin();
//            System.out.println("curr node= "+curr.getValue().getNodeId());
      
      for (Edge arc : graph.edgesFrom(curr.getValue())) {
        
        double pathCost = curr.getPriority() + arc.getDistance();
        
        FibonacciHeap.Entry<Node> dest = entries.get((curr.getValue()==arc.getEnds().getOne())?arc.getEnds().getTwo():arc.getEnds().getOne());
        if (pathCost < dest.getPriority()){
          pq.decreaseKey(dest, pathCost);
          dest.getValue().setPrevious(curr.getValue());
//                 System.out.println("The previous of node "+curr.getValue().getNodeId()+"= "+dest.getValue().getNodeId());
        }
        
      }
//            System.out.println("size of current Fib-heap="+pq.size());
      
    }
    
    //while ((sink.getPrevious()!=null) && (sink.getPrevious()!=source)){
    while (sink.getPrevious()!=source){
      edgelist.add(0, graph.getEdge(sink.getPrevious(), sink));
      sink=sink.getPrevious();
    }
    edgelist.add(0, graph.getEdge(source, sink));
    Path path=new Path (edgelist);
    return path;
  }
  
}