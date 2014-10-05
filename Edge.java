public class Edge {
 
    protected Actor a, b;
    protected String film;
     
    public Edge(Actor a, Actor b, String film) {
        this.a = a;
        this.b = b;
        this.film = film;
    }
     
    public String toString() {
        return a + " ==> " + b;
    }
 
}
