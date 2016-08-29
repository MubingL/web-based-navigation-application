Read Me:

Introduction:
This Java project realize the Dijkstra and Yen’s Algorithm by using Fibonacci Heap as Data Structure. Users can query for k shortest paths with graph defined in WazeApp.java, or initialize their own graphs by redefining the graph in WazeApp.java.

How to run the code:
To run the code, simply put all nine .java files in DijkstraFib folder under the same directory. Then compile and run WazeApp.java for obtaining results. Users can also change the start and  destination nodes by changing the parameters and change how many shortest path they want to obtain by changing the k value in WazaApp.java.

About the result:
In the result, users can obtain three shortest path by an increasing order of the total length of the path. Under each path, the edge-numbers shows what are the edges to form the path.

In the current code, it calculates the three shortest paths from Node4(start) to Node 5(end). 
And the first shortest path is Node 4—edge9—edge7—Node5;
the second shortest path is Node 4—edge4—edge12—edge6—Node5;
the first shortest path is Node 4—edge4—edge3—edge11—edge6—Node5;
