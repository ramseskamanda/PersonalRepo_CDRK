import java.util.ArrayList;

public class tree{
	private Node root;
	private ArrayList<Node> nodes;

	public tree(){
		this.root = null;
		this.nodes = new ArrayList();
	}

	public Node findNode(String data){
		for(Node child: this.nodes)
			if(child.data == data) return child;
		return null;
	}

	public ArrayList<String> listParents(Node child){
		ArrayList<String> parents = new ArrayList();
		Node curr = child;
		while(curr != null){
			parents.add(curr.data);
			curr = curr.parent;
		}
		return parents;
	}

	public void addNode(String data, String parent){
		Node newNode = new Node(data, findNode(parent));
		if(this.root == null) this.root = newNode;
		this.nodes.add(newNode);
	}

	public String findLCA(String bonnie, String clyde){
		ArrayList<String> parents_bonnie = listParents(findNode(bonnie));
		ArrayList<String> parents_clyde = listParents(findNode(clyde));
		for(String s1: parents_bonnie)
			for(String s2: parents_clyde)
				if(s1.equals(s2)) return s1;
		return null;
	}

	public static void main(String[] args) {
		tree t = new tree();
		t.addNode("George", null);
		t.addNode("Lucas", "George");
		t.addNode("Bonnie", "Lucas");
		t.addNode("Georgette", "Lucas");
		t.addNode("Clyde", "Georgette");
		System.out.println(t.findLCA("Bonnie", "Clyde"));
	}
}

class Node{
	Node parent;
	ArrayList<Node> children;
	String data;

	public Node(String value, Node parent){
		this.parent = parent;
		this.children = new ArrayList();
		this.data = value;
	}
}