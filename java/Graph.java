import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int v;
	private LinkedList<Integer> adjList[];
	
	Graph(int v) {
		this.v = v;
		
		adjList = new LinkedList[v];
		
		for (int i = 0; i < v; ++i) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge (int src, int dest) {
		adjList[src].add(dest);
	}
	
	public void breadthFirstSearch (int src) {
		boolean[] visited = new boolean[v];
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[src] = true;
		queue.add(src);
		
		while(queue.size() != 0) {
			//Retrieve and remove the first element of the list
			src = queue.poll();
			
			System.out.print(src + " ");
			
			Iterator<Integer> itr = adjList[src].listIterator();
			while (itr.hasNext()) {
				
				int i = itr.next();
				
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.breadthFirstSearch(0);
	}
}
