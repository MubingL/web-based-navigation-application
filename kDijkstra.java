package DijkstraFib;
import java.util.*;

public final class kDijkstra {
	
	public static Path[] kShortestPaths(UndiGraph<Node> graph, Node source, Node sink, int k){
		
		Path [] A=new Path[k];
		A[0]=Dijkstra.shortestPaths(graph, source, sink);
		
		for (int jj=0;jj<k-1;jj++){

			FibonacciHeap<Path> B=new FibonacciHeap <Path>();
			Map<Path, FibonacciHeap.Entry<Path>> entries = new HashMap<Path, FibonacciHeap.Entry<Path>>();
			Node mid;
//			System.out.println("Found the "+jj+1+"th shortest path A["+jj+"]: ");
//			for (int xx=0;xx<A[jj].getEdgeList().size();xx++){
//				System.out.print("-"+A[jj].getEdgeList().get(xx).getEdgeId());
//			}
			if (jj==0){
				mid=source;
			}else{
				mid=graph.findConnection(A[jj].getEdgeList().get(jj-1), A[jj].getEdgeList().get(jj));
			}
//			System.out.println();
			
			for (int i=jj+1;i<=A[jj].getEdgeList().size();i++){
//				System.out.println("current Fib-heap is empty: "+B.isEmpty());
//				System.out.println("jj="+jj+" current mid node is node"+mid.getNodeId());
				ArrayList<Edge> rootEdgeList=new ArrayList<Edge>();
				
				for (int ii=0;ii<i-1;ii++){
					rootEdgeList.add(A[jj].getEdgeList().get(ii));
//					System.out.println("edge"+A[jj].getEdgeList().get(ii).getEdgeId()+" add to rootlist");
				}
				
				graph.removeEdge(A[jj].getEdgeList().get(i-1));		
//				System.out.println("edge"+A[jj].getEdgeList().get(i-1).getEdgeId()+"temporarily removed");
				Path spurPath=Dijkstra.shortestPaths(graph, mid, sink);
//				System.out.println("spurpath: ");
//				for (int yy=0;yy<spurPath.getEdgeList().size();yy++){
//					System.out.print("-"+spurPath.getEdgeList().get(yy).getEdgeId());
//				}
//				System.out.println();
				rootEdgeList.addAll(spurPath.getEdgeList());
//				System.out.println("new path: ");
//				for (int yy=0;yy<rootEdgeList.size();yy++){
//					System.out.print("-"+rootEdgeList.get(yy).getEdgeId());
//				}
//				System.out.println();
				Path path=new Path (rootEdgeList);		
				graph.addEdge(A[jj].getEdgeList().get(i-1));
				entries.put(path, B.enqueue(path, path.getLength()));
//				System.out.println("current Fib-heap size="+B.size());
				if (i==A[jj].getEdgeList().size())
					break;
				mid=graph.findConnection(A[jj].getEdgeList().get(i-1), A[jj].getEdgeList().get(i));
				
			}
			
			FibonacciHeap.Entry<Path> curr = B.dequeueMin();
			A[jj+1]=curr.getValue();
//			System.out.println("the "+jj+"th shortest path: "+A[jj+1].getLength());
		}
		return A;
	}
}
