import java.util.*;

public class Actor {
	protected String name;
	protected boolean visited;
	protected Pair arrivedFrom;

	public Actor(String name, String film) {
		this.name = name;
		visited = false;
		arrivedFrom = null;
	}

	public String getName() {
		return name;
	}

	public void setArrivedFrom(Actor a, String film_name) {
		arrivedFrom = new Pair(a,film_name);
	}

	public void clearArrivedFrom() {
		arrivedFrom = null;
	}

    public boolean isVisited() {
        return visited;
    }
     
    public void visit() {
        visited = true;
    }
     
    public void unvisit() {
        visited = false;
    }
}