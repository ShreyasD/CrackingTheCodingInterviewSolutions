public class LinkedListProblems {
	
	public static LinkedListNode createLinkedList(int[] data) {
		LinkedListNode head = null;
		LinkedListNode tail = null;
		for(int i=0; i < data.length; i++) {
			LinkedListNode newNode = new LinkedListNode(data[i]);
			if(head == null) head = newNode;
			if(tail != null) tail.next = newNode;
			tail = newNode;
		}
		return head;
	}
	
	public static void printLinkedList(LinkedListNode head) {
		LinkedListNode node = head;
		System.out.print("LinkedList: ");
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	public static void removeDups(LinkedListNode head) {
		LinkedListNode current = head;
		while(current != null) {
			LinkedListNode runner = current;
			while(runner.next != null) {
				if(runner.next.data == current.data) {
					//remove it
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	public static LinkedListNode getElementAtIndexFromEnd(LinkedListNode head, int k) {
		LinkedListNode p1 = head, p2 = head;
		
		//traverse p1 k up
		for(int i=0; i <= k; i++) {
			if(p1 == null) return null; //list shorter than k
			p1 = p1.next;
		}
		
		//traverse p2 for remainder of p1
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	
	public static LinkedListNode getMiddleNode(LinkedListNode head) {
		LinkedListNode current = head;
		int length = 1;
		//Get length of the Linked List
		while(current != null) {
			length++;
			current = current.next;
		}
		
		int mid = length/2;
		current = head;
		for(int i=0; i<mid; i++) {
			current = current.next;
		}
		
		return current;
	}
	
	public static boolean deleteNode(LinkedListNode node) {
		if(node == null || node.next == null) return false;
		
		//copy next nodes data into current node
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
	
	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while(node != null) {
			LinkedListNode next = node.next;
			if(node.data < x) {
				node.next = head;
				head = node;
			} else {
				node.next = tail;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
	
	public static class LinkedListNode {
		LinkedListNode next = null;
		int data;
		
		public LinkedListNode(int data) {
			this.data = data;
		}
	}
}
