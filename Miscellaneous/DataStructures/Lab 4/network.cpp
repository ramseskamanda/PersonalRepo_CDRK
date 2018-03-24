#include <iostream>
#include <stdio.h>
#include <vector>
#include <map>
#include <string>
using namespace std;
typedef map<string, map<string, int>> dict;

class Network{
public:
	dict graph;
	const int INF = 1000000;
	void add_vertex(string);
	void add_edge(string, string, int);
	string min(map<string, int>);
	void dijkstra(string, string, vector<string>, map<string, int>, map<string, string>);
};

ostream& operator<<(ostream &strm, const A &a) {
	string keys = "";
	for(auto& el: A)
		keys += el;
	return strm << "Network: " << keys;
}

void Network::add_vertex(string name){
	this->graph[name] = new map<string, int>();
}

void Network::add_edge(string from, string to, int cost){
	if(this->graph.count(from) == 0)
		add_vertex(from);
	if(this->graph.count(to) == 0)
		add_vertex(to);

	this->.graph[from][to] = cost;
	this->.graph[to][from] = cost;
}

int main(int argc, char const *argv[])
{
	Network CONTROL;
	CONTROL.add_edge("London", "Tokyo", 1);
	CONTROL.add_edge("London", "Berlin", 1);
	CONTROL.add_edge("Berlin", "Tokyo", 1);
	CONTROL.add_edge("Tokyo", "Beijing", 1);
	CONTROL.add_edge("Los Angeles", "London", 1);
	CONTROL.add_edge("Los Angeles", "Beijing", 1);
	CONTROL.add_edge("Los Angeles", "Berlin", 1);
	cout << CONTROL;
	return 0;
}