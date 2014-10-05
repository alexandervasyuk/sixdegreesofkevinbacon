import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Graph graph = new Graph();
		File folder = new File("./films");
		for (File file : folder.listFiles()) {
			try {
				JSONParser parser = new JSONParser();
				JSONObject obj = (JSONObject) parser.parse(new FileReader(file));
				JSONObject film = (JSONObject) obj.get("film");
				String film_name = (String) film.get("name");
				JSONArray cast = (JSONArray) obj.get("cast");
				for (Object o : cast) {
					JSONObject actor = (JSONObject) o;
					String name = (String) actor.get("name");
					Actor a;
					if (!graph.getNodes().containsKey(name)) {
						a = new Actor(name, film_name);
						graph.addNode(a);
					} else {
						a = graph.getNode(name);
					}
				}

				for (Object o1 : cast) {
					JSONObject a1 = (JSONObject) o1;
					String n1 = (String) a1.get("name");
					for (Object o2 : cast) {
						JSONObject a2 = (JSONObject) o2;
						String n2 = (String) a2.get("name");
						if (n1 != n2) {
							Actor one = graph.getNode(n1);
							Actor two = graph.getNode(n2);
							graph.addEdge(new Edge(one, two, film_name));
						}
					}
				}
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		}

		System.out.println("Provide an actor's name or type 'quit': ");
		Scanner sc = new Scanner(System.in);
		String st;
		while (sc.hasNext()) {
			st = sc.nextLine();
			if (st.equals("quit"))
				break;
			Actor root = graph.getNode(st);
			Actor kevin = graph.getNode("Kevin Bacon");
			if(root != null && graph.isRouteBetween(root, kevin)) {
				ArrayList<Pair> path = new ArrayList<Pair>();
				Pair p = new Pair(kevin, "");
				while(p != null) {
					path.add(p);
					p = p.actor.arrivedFrom;
				}
				for (int i = path.size() - 1; i > 0; i--) {
					System.out.print(path.get(i).actor.getName() + " (" + path.get(i).film + ") " + " => ");
				}
				System.out.print("Kevin Bacon");
			} else {
				System.out.println("No connection");
			}
			graph.unvisitAllNodes();
			System.out.println("\n\nProvide an actor's name or type 'quit': ");
		}
	}
}