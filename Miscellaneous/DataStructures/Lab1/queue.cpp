#include <iostream>
#include <string>
#include <vector>
using namespace std;

class HomeMadeStack{
public:
	vector<int> v = {};
	HomeMadeStack(vector<int>);
	void enqueue(int);
	int dequeue();
	string print();
};

HomeMadeStack::HomeMadeStack(vector<int> elements){
	for (auto& e: elements)
		v.emplace_back(e);
}

void HomeMadeStack::enqueue(int element){
	v.emplace_back(element);
}

int HomeMadeStack::dequeue(){
	int last (v.back());
	v.pop_back();
	return last;
}

string HomeMadeStack::print(){
	string s;
	for(auto& e: v)
		s.append(to_string(e));
	return s;
}

class HomeMadeQueue{
public:
	vector<int> v;
	HomeMadeStack left;
	HomeMadeStack right;
	void update();
	void appendleft(int);
	void appendright(int);
	int popleft();
	int popright();
};

void HomeMadeQueue::update(){
	v.clear();
	for(auto& e: left.v)
		v.emplace_back(e);
	for(auto& e: right.v)
		v.emplace_back(e);
}

void HomeMadeQueue::appendleft(int element){
	left.enqueue(element);
	update();
}

void HomeMadeQueue::appendright(int element){
	right.enqueue(element);
	update();
}

int HomeMadeQueue::popleft(){
	int first = left.dequeue();
	update();
	return first;
}

int HomeMadeQueue::popright(){
	int last = right.dequeue();
	update();
	return last;
}

int main(){
	vector<int> test = {1, 2, 3, 4};
	HomeMadeStack s(test);
	for (int i = 0; i < 10; ++i)
		s.enqueue(i);
	cout << s.dequeue() << endl;
	cout << s.print();
	return 0;
}