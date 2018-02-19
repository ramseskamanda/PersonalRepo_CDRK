import numpy as np
'''
Answers to the questions:
Algorithm: See below
3 Test Cases: Any test will function
Running time: Worst case: O(n) Average Case: O(sqrt(n)) Best Case: O(1)
'''
class Node:
	def __init__(self, value, parent=None):
		self.parent = parent
		self.children = [self]
		self.data = value

	def add_children(self, child_node):
		self.children.append(child_node)

class Tree:
	def __init__(self):
		self.root = None
		self.nodes = []
		self.data = []

	def addNode(self, value, parent=None):
		if self.root is None:
			self.root = Node(value)
			self.nodes.append(self.root)
			self.data.append(value)
			print('root added:', value)
		else:
			node = self._find_parent(parent)
			if node != None:
				child = Node(value, parent=node)
				node.add_children(child)
				self.nodes.append(child)
				self.data.append(value)
				print('Child', value, 'was successfully added. Children:', self.data)
			else: print('Child', value, 'could not be added.')

	def findNode(self, data):
		if data in self.data: return self._find_parent(data)
		print(data, 'could not be found.')

	def findLCA(self, bonnie, clyde):
		bonnie, clyde = self.findNode(bonnie), self.findNode(clyde)
		parents_bonnie = self._parents_iterator(bonnie)
		parents_clyde = self._parents_iterator(clyde)
		_lca = self.root.data
		if _lca != None:
			for parent in parents_bonnie:
				if parent in parents_clyde:
					_lca = parent
					break
		return _lca

	def _find_parent(self, data):
		for child in self.nodes:
			if child.data == data:
				return child

	def _parents_iterator(self, node, parents=[]):
		if node.parent == None: return parents
		parents.append(node.parent.data)
		parents = self._parents_iterator(node.parent, parents=parents)
		return parents

if __name__ == '__main__':
	t = Tree()
	t.addNode('George')
	t.addNode('Lucas', parent='George')
	t.addNode('Bonnie', parent='Lucas')
	t.addNode('Georgette', parent='Lucas')
	t.addNode('Clyde', parent='Georgette')
	print(t.findLCA('Bonnie', 'Clyde'))
