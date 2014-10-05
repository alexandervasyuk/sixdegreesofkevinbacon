import java.util.*;
 
public class Graph {
 
    protected Hashtable<String, Actor> nodes = new Hashtable<String, Actor>();
    protected ArrayList<Edge> edges = new ArrayList<Edge>();
     
    public Hashtable<String,Actor> getNodes() {
        return nodes;
    }

    public Actor getNode(String name) {
        return nodes.get(name);
    }
     
    public ArrayList<Edge> getEdges() {
        return edges;
    }
     
    public void unvisitAllNodes() {
        for (Actor a : nodes.values()) {
            a.unvisit();
            a.clearArrivedFrom();
        }
    }
     
    public ArrayList<Pair> getNeighbors(Actor a) {
        ArrayList<Pair> neighbors = new ArrayList<Pair>();
         
        for(int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
             
            if(edge.a == a)
                neighbors.add(new Pair(edge.b, edge.film));
                 
            if(edge.b == a)
                neighbors.add(new Pair(edge.a, edge.film));
        }
         
        return neighbors;
    }
     
    public void addNode(Actor a) {
        nodes.put(a.name, a);
    }
     
    public void addEdge(Edge a) {
        edges.add(a);
        edges.add(new Edge(a.b, a.a, a.film));
    }
     
	public boolean isRouteBetween(Actor n1, Actor n2) {
		Queue q = new Queue();
		if (n1 != n2 ) {
			n1.visit();
			q.enqueue(n1);
		} else 
			return true;
		
		while(!q.isEmpty()) {
			Actor n = (Actor) q.dequeue();
			for (Pair pair : getNeighbors(n)) {
                Actor node = pair.actor;
                String film_name = pair.film;
                if (node.visited == false) {
                    node.setArrivedFrom(n, film_name);
                    if (node == n2) 
                        return true;
                    node.visit();
                    q.enqueue(node);
                }
			}
		}
		return false;
	}
 
}
