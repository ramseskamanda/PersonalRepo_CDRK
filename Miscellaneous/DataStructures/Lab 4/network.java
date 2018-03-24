import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;

public class network{

	static class Network{
		Map<String, Map<String, Integer>> graph;
		final int INF = 1000000;
		public Network(){
			this.graph = new HashMap();
		}

		public String toString(){
			String returner = "";
			for(String key: this.graph.keySet())
				returner += key + " ";
			return returner;
		}
		
		public void add_vertex(String name){
			this.graph.put(name, new HashMap());
		}

		public void add_edge(String from, String to, int cost){
			if(!this.graph.containsKey(from))
				this.graph.put(from, new HashMap());
			if(!this.graph.containsKey(to))
				this.graph.put(to, new HashMap());

			this.graph.get(from).put(to, cost);
			this.graph.get(to).put(from, cost);
		}

		public void add_hacked_vertex(String name){
			for(String neighbor: this.graph.get(name).keySet())
				this.graph.get(name).replace(neighbor, 10);
		}

		public String min(Map<String, Integer> dict){
			int minimum = INF + 1;
			String k = null;
			for(String key: dict.keySet()){
				if(dict.get(key) < minimum){
					minimum = dict.get(key);
					k = key;
				}
			}
			return k;
		}

		public void dijkstra(String src, String dest, ArrayList<String> visited, Map<String, Integer> distances, Map<String, String> predecessors){
			if(!this.graph.containsKey(src)) return;
			if(!this.graph.containsKey(dest)) return;
			if(src == dest){
				ArrayList<String> path = new ArrayList();
				String pred = dest;
				while(pred != null){
					path.add(pred);
					pred = predecessors.get(pred);
				}
				System.out.println("shortest path" + "".join(", ", path) + " cost=" + distances.get(dest));
			}
			else{
				if(visited.isEmpty())
					distances.put(src, 0);
				int new_distance;
				int old_distance;
				for(String neighbor: this.graph.get(src).keySet()){
					if(!visited.contains(neighbor)){
						new_distance = distances.get(src) + this.graph.get(src).get(neighbor);
						
						//Make the default value INF
						old_distance = distances.get(neighbor);
						//if(old_distance == null) old_distance = INF;
						if(new_distance < old_distance){
							distances.replace(neighbor, new_distance);
							predecessors.put(neighbor, src);
						}
					}
				}
				visited.add(src);
				Map<String, Integer> unvisited = new HashMap();
				int dist;
				for(String key: this.graph.keySet()){
					if(!visited.contains(key)){
						dist = distances.get(key);
						//if(dist == null) dist = INF;
						unvisited.put(key, dist);
					}
				}
				String x = min(unvisited);
				dijkstra(x, dest, visited, distances, predecessors);
			}
		}
	}

	public static void main(String[] args) {
		Network CONTROL = new Network();
		CONTROL.add_edge("London", "Tokyo", 1);
		CONTROL.add_edge("London", "Berlin", 1);
		CONTROL.add_edge("Berlin", "Tokyo", 1);
		CONTROL.add_edge("Tokyo", "Beijing", 1);
		CONTROL.add_edge("Los Angeles", "London", 1);
		CONTROL.add_edge("Los Angeles", "Beijing", 1);
		CONTROL.add_edge("Los Angeles", "Berlin", 1);
		CONTROL.add_hacked_vertex("Tokyo");
		CONTROL.add_hacked_vertex("Los Angeles");
		System.out.println(CONTROL);
		CONTROL.dijkstra("London", "Beijing", new ArrayList(), new HashMap(), new HashMap());
	}
}