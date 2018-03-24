class Network:
	def __init__(self):
		self.graph = {}

	def __str__(self):
		return ''.join([key + ' ' for key in self.graph.keys()])

	def add_vertex(self, name):
		self.graph[name] = {}

	def add_edge(self, frm, to, cost=0):
		if frm not in self.graph:
			self.graph[frm] = {}
		if to not in self.graph:
			self.graph[to] = {}

		self.graph[frm][to] = cost
		self.graph[to][frm] = cost
		print('Connection successfully added between:', frm, to)

	def add_hacked_vertex(self, name, state=10):
		for neighbor in self.graph[name].keys():
			self.graph[name][neighbor] = state
		print(name, 'was hacked! Avoid that route!')

	def dijkstra(self, graph, src, dest, visited=[], distances={}, predecessors={}):
	    if src not in graph:
	        raise TypeError('The root of the shortest path tree cannot be found')
	    if dest not in graph:
	        raise TypeError('The target of the shortest path cannot be found')    
	    if src == dest:
	        path=[]
	        pred=dest
	        while pred != None:
	            path.append(pred)
	            pred=predecessors.get(pred,None)
	        print('shortest path: '+str(path[::-1])+" cost="+str(distances[dest])) 
	    else:
	        if not visited:
	            distances[src]=0
	        for neighbor in graph[src]:
	            if neighbor not in visited:
	                new_distance = distances[src] + graph[src][neighbor]
	                if new_distance < distances.get(neighbor,float('inf')):
	                    distances[neighbor] = new_distance
	                    predecessors[neighbor] = src
	        visited.append(src)
	        unvisited={}
	        for k in graph:
	            if k not in visited:
	                unvisited[k] = distances.get(k,float('inf'))        
	        x=min(unvisited, key=unvisited.get)
	        self.dijkstra(graph,x,dest,visited,distances,predecessors)

if __name__ == '__main__':
	CONTROL = Network()
	CONTROL.add_edge("London", "Tokyo", cost=1)
	CONTROL.add_edge("London", "Berlin", cost=1)
	CONTROL.add_edge("Berlin", "Tokyo", cost=1)
	CONTROL.add_edge("Tokyo", "Beijing", cost=1)
	CONTROL.add_edge("Los Angeles", "London", cost=1)
	CONTROL.add_edge("Los Angeles", "Beijing", cost=1)
	CONTROL.add_edge("Los Angeles", "Berlin", cost=1)
	CONTROL.add_hacked_vertex("Tokyo", state=5)
	CONTROL.add_hacked_vertex("Los Angeles", state=10)
	CONTROL.dijkstra(CONTROL.graph, "London", "Beijing")