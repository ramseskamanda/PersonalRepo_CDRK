#include <iostream>
#include <cstdlib>
#include <string>
#include <vector>
using namespace std;

struct node
{
	node* parent;
	vector<node*> children;
	string data;
};

class Tree
{
private:
	node* root;
	node* findNode(node*, string, int);
	vector<string> listParents(node*);
public:
	Tree(){root = NULL;}
	void addNode(string, string);
	string findLCA(string, string);
};

struct node* Tree::findNode(node* ancestor, string data, int child){
	int index (0);
	node* curr;
	curr = ancestor;
	while(index < curr->children.size()){
		if(curr->data == data) return curr;
		else{
			curr = ancestor->children[index];
			++index;
		}
	}
	ancestor = curr->children[child];
	++child;
	return findNode(ancestor, data, child);
}

vector<string> Tree::listParents(node* n){
	vector<string> parents;
	node* curr;
	curr = n;
	while(curr != root){
		parents.emplace_back(curr->data);
		curr = curr->parent;
	}
	return parents;
}

void Tree::addNode(string data, string parent){
	node* t = new node;
	node* ancestor;
	t->data = data;
	t->parent = NULL;
	t->children.emplace_back(NULL);
	ancestor = root;

	if(root == NULL){
		root = t;
		cout << "Root added: " << data << endl;
	}
	else{
		t->parent = findNode(ancestor, data, 0);
		if(t->parent->children[0] == NULL) t->parent->children[0] = t;
		else t->parent->children.emplace_back(t);
		//t->children[0] = t;
		cout << "Node " << data << " added successfully." << endl;
	}
}

string Tree::findLCA(string bonnie, string clyde){
	node* ancestor;
	ancestor = root;
	node* b = findNode(ancestor, bonnie, 0);
	node* c = findNode(ancestor, clyde, 0);
	for(auto& parentB: listParents(b))
		for(auto& parentC: listParents(c))
			if(parentB == parentC) return parentB;
	cout << "No common ancestors." << endl;
	return NULL;
}

int main(){
	Tree t;
	t.addNode("George", NULL);
	t.addNode("Lucas", "George");
	t.addNode("Bonnie", "Lucas");
	t.addNode("Georgette", "Lucas");
	t.addNode("Clyde", "Georgette");
	cout << t.findLCA("Bonnie", "Clyde") << endl;
	return 0;
}