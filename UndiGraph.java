package DijkstraFib;

import java.util.*; // For HashMap

public final class UndiGraph<T> implements Iterable<T> {
    
    private final Map<Node, ArrayList<Edge>> mGraph = new HashMap<Node, ArrayList<Edge>>();

    public boolean addNode(Node node) {

        if (mGraph.containsKey(node))
            return false;

        mGraph.put(node, new ArrayList<Edge>());
        return true;
    }
    
    public void addEdge(Edge edge) {

        if (!mGraph.containsKey(edge.getEnds().getOne()) || !mGraph.containsKey(edge.getEnds().getTwo()))
            throw new NoSuchElementException("Both nodes must be in the graph.");
        
        //System.out.println(mGraph.get(edge.getEnds()[0]));
        mGraph.get(edge.getEnds().getOne()).add(edge);
        //System.out.println("add edge "+edge.getEdgeId()+" and mapping to node "+edge.getEnds().getOne().getNodeId());
        //System.out.println(mGraph.get(edge.getEnds().getOne()).size());
        //mGraph.put(edge.getEnds().getOne(), mGraph.get(edge.getEnds().getOne()));
        mGraph.get(edge.getEnds().getOneNext()).add(edge);
        //mGraph.put(edge.getEnds().getTwo(), mGraph.get(edge.getEnds().getTwo()));
        //System.out.println("add edge "+edge.getEdgeId()+" and mapping to node "+edge.getEnds().getOneNext().getNodeId());
        //System.out.println(mGraph.get(edge.getEnds().getOneNext()).size());
    }
    
    public void addEdge(Node one, Node two, double length) {
        
     Edge edge=new Edge (one,two,length);
        if (!mGraph.containsKey(one) || !mGraph.containsKey(two))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        mGraph.get(one).add(edge);
        mGraph.get(two).add(edge);
    }
    
    public Edge getEdge(Node one, Node two){
     
     if (!mGraph.containsKey(one) || !mGraph.containsKey(two))
            throw new NoSuchElementException("Both nodes must be in the graph.");

//     if(!edgesFrom(start).containsKey(dest))
//      throw new NoSuchElementException("There is no path connecting these two nodes.");
     
     for (Edge edge:mGraph.get(one)){
      //System.out.println("incident edge on node "+one.getNodeId()+": "+edge.getEdgeId());
      Node node = (one == edge.getEnds().getOne()) ? edge.getEnds().getTwo() : edge.getEnds().getOne();
      if (node==two){
       //System.out.println("Found edge "+edge.getEdgeId());
       return edge;
      }
       
     }
     
     //System.out.println("Didn't find a match!");
  return null;
     
    }

    public void removeEdge(Edge edge) {

        if (!mGraph.containsKey(edge.getEnds().getOne()) || !mGraph.containsKey(edge.getEnds().getOneNext()))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        mGraph.get(edge.getEnds().getOne()).remove(edge);
        mGraph.get(edge.getEnds().getOneNext()).remove(edge);
    }

    public ArrayList<Edge> edgesFrom(Node node) {

        ArrayList<Edge> arcs = mGraph.get(node);
        if (arcs == null)
            throw new NoSuchElementException("Source node does not exist.");

        return arcs;
    }
    
    public Node findConnection(Edge edge1,Edge edge2){
  NodePair pair1=edge1.getEnds();
  int pair1One=pair1.getOne().getNodeId();
  int pair1Two=pair1.getOneNext().getNodeId();
  //System.out.println("edge "+edge1.getEdgeId()+": node"+pair1One+"-node"+pair1Two);
  NodePair pair2=edge2.getEnds();
  int pair2One=pair2.getOne().getNodeId();
  int pair2Two=pair2.getOneNext().getNodeId();
  //System.out.println("edge "+edge2.getEdgeId()+": node"+pair2One+"-node"+pair2Two);
  
  if ((pair1One==pair2One)||(pair1One==pair2Two)){
   //System.out.println("enter if");
   return pair1.getOne();
  }
  else if((pair1Two==pair2One)||(pair1Two==pair2Two)){
   //System.out.println("enter else if");
   return pair1.getOneNext();
  }
  else {
   //System.out.println("two edges do not connect");
   return null;
  }
 }

    @SuppressWarnings("unchecked")
 public Iterator<T> iterator() {
        return (Iterator<T>) mGraph.keySet().iterator();
    }
    
    public boolean containsNode(Node node) {
        return mGraph.containsKey(node);
    }
    
    public boolean containsEdge(Edge edge)
    {
     return mGraph.containsValue(edge);
    }
    
    public int size() {
        return mGraph.size();
    }
    
    public boolean isEmpty() {
        return mGraph.isEmpty();
    }
}
