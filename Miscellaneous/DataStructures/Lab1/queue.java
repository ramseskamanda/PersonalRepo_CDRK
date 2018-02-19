import java.util.*;
import java.lang.Integer;

public class queue{


	static class HomeMadeStack{
		public ArrayList<Integer> stack;

		public HomeMadeStack(){ this.stack = new ArrayList(); }

		public HomeMadeStack(int[] elements){
			this.stack = new ArrayList();
			for(int e: elements)
				this.stack.add(new Integer(e));
		}

		public String toString(){
			return Arrays.toString(this.stack.toArray());
		}

		public void enqueue(int element){
			this.stack.add(new Integer(element));
		}

		public int dequeue(){
			return this.stack.remove(this.stack.size() - 1).intValue();
		}
	}

	static class HomeMadeQueue{
		public ArrayList<Integer> stack;
		public HomeMadeStack left;
		public HomeMadeStack right;

		public HomeMadeQueue(){
			this.stack = new ArrayList();
			this.left = new HomeMadeStack();
			this.right = new HomeMadeStack();
		}
		/*
		public HomeMadeQueue(int[] elements){
			this.stack = new ArrayList();
			for(int e: elements)
				this.stack.add(new Integer(e));
			this.left = new HomeMadeStack();
			this.right = new HomeMadeStack();
		}
		*/
		public String toString(){
			return Arrays.toString(this.stack.toArray());
		}

		public void update(){
			this.stack = new ArrayList();
			for(int i = 0; i < this.left.stack.size(); i++)
				this.stack.add(this.left.stack.get(i).intValue());
			for(int i = 0; i < this.right.stack.size(); i++)
				this.stack.add(this.right.stack.get(i).intValue());
		}

		public void appendleft(int element){ this.left.enqueue(element); update(); }

	    public void appendright(int element){ this.right.enqueue(element); update(); }

	    public int popleft(){
	    	int first = this.left.dequeue();
	    	update();
	    	return first;
	    }

	    public int popright(){
	    	int last = this.right.dequeue();
	    	update();
	    	return last;
	    }
	}

	public static void main(String[] args) {
		HomeMadeQueue q = new HomeMadeQueue();
		for(int i = 0; i < 10; i++){
			q.appendleft(i);
			q.appendright(-i);
		}
		System.out.println(q.popright());
		System.out.println(q.popleft());
	}
}