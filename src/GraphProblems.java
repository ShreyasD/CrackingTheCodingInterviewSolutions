import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphProblems {
	//
	static public class Graph {
		public ArrayList<Node> nodes;
	}
	
	static public class directedGraph extends Graph {
		public void addEdge(Node node1, Node node2) {
			node1.children.add(node2);
		}
	}
	
	static public class UndirectedGraph extends Graph {
		public void addEdge(Node node1, Node node2) {
			node1.children.add(node2);
			node2.children.add(node1);
		}
	}
	
	enum State {Unvisited, Visiting, Visited}
	
	static public class Node{
		public int value;
		public NodeState state; 
		protected ArrayList<Node> children;
		
		public Node(int value) {
			this.value = value;
 			this.children = new ArrayList<>();
 			this.state = NodeState.Unvisited;
		}
		
		public void addChild(Node e) {
			children.add(e);
		}
		
		public ArrayList<Node> getAdjacent() {
			return children;
		}
	}
	
	static public class TreeNode extends Node{
		TreeNode parent;

		public TreeNode(int value) {
			super(value);
		}
		
		public void addChildLeft(TreeNode left) {
			//if(left != null) {
				this.children.add(0, left);
				//left.parent = this;
			//}
		}
		
		public void addChildRight(TreeNode right) {
			//if(right != null) {
				this.children.add(1, right);
				//right.parent = this;
			//}
		}
		
		public TreeNode getChildLeft() {
			if(this.children.isEmpty()) return null;
			return (TreeNode) this.children.get(0);
		}
		
		public TreeNode getChildRight() {
			if(this.children.isEmpty() || this.children.size() < 2) return null;
			return (TreeNode) this.children.get(1);
		}
	}
	
	
	enum NodeState {Unvisited, Visiting, Visited}
	
	public static boolean doesPathExist(Graph g, Node start, Node end) { 
		if(start == end) return true;
		
		Queue<Node> q = new LinkedList<>();
		
		//BFS
		start.state = NodeState.Visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()) {
			u = q.remove();
			if(u != null) {
				for (Node n : u.getAdjacent()) {
					if(n.state == NodeState.Unvisited) {
						if(n == end) {
							return true;
						} else {
							n.state = NodeState.Visiting;
							q.add(n);
						}
					}
				}
			}
			u.state = NodeState.Visited;
		}
		return false; 
	}
	
	public static TreeNode createMinimalBST(int[] array, int start, int end) {
		if(end < start) return null;
		
		int mid = (start + end)/2;
		TreeNode n = new TreeNode(array[mid]);
		n.addChildLeft(createMinimalBST(array, start, mid-1));
		n.addChildRight(createMinimalBST(array, mid+1, end));
		return n;
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLinkedListPerLevel(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> listPerLevel = new ArrayList<LinkedList<TreeNode>>();
		createLinkedListPerLevel(root, listPerLevel, 0);
		return listPerLevel;
	}
	
	private static void createLinkedListPerLevel(TreeNode node, 
			ArrayList<LinkedList<TreeNode>> listPerLevel, int level) {
		if(node == null) return;
		LinkedList<TreeNode> list = null;
		if(listPerLevel.size() == level) {
			list = new LinkedList<TreeNode>();
			listPerLevel.add(list);
		} else {
			list = listPerLevel.get(level);
		}
		list.add(node);
		createLinkedListPerLevel(node.getChildLeft(), listPerLevel, level+1);
		createLinkedListPerLevel(node.getChildRight(), listPerLevel,level+1);
	}
	
	public static int checkHeight(TreeNode root) {
		if(root == null) return -1;
		
		int leftHeight = checkHeight(root.getChildLeft());
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root.getChildRight());
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) return Integer.MIN_VALUE;
		else return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	public static boolean isValidBST(TreeNode root) {
		return checkBST(root, null, null);
	}
	
	public static boolean checkBST(TreeNode node, Integer min, Integer max) {
		if(node == null) return true;
		
		if(min != null && node.value <= min || max != null && node.value > max) {
			return false;
		}
		
		if(!checkBST(node.getChildLeft(), min, node.value) ||
				!checkBST(node.getChildRight(), node.value, max)) {
			return false;
		}
		
		return true;
	}
	
	public static TreeNode getCommonAncestor(TreeNode a, TreeNode b) {
		int delta = depth(a) - depth(b);
		TreeNode first = (delta > 0) ? b : a; //shallower node
		TreeNode second = (delta > 0) ? a : b; //deeper node
		
		//Bring the deeper node up to the shallower node well
		while(delta > 0 && second != null) {
			second = second.parent;
			delta--;
		}
		
		while(first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		
		return first == null || second == null ? null : first;
	}
	
	public static int depth(TreeNode node) {
		int depth = 0;
		while(node.parent != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}

	public static void inOrderTraversal(TreeNode root) {
		if(root != null) {
			inOrderTraversal(root.getChildLeft());
			System.out.print(root.value);
			inOrderTraversal(root.getChildRight());
		}
	}
}
