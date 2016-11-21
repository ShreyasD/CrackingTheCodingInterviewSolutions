import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackProblems {
	public static class StackWithMin extends Stack<NodeWithMin> {
		public void push(int value) {
			super.push(new NodeWithMin(value, Math.min(value, min())));
		}
		
		public int min() {
			if(this.isEmpty()) return Integer.MAX_VALUE;
			return peek().min;
		}
	}
	
	private static class NodeWithMin {
		public int value;
		public int min;
		public NodeWithMin(int value, int min) {
			this.value = value;
			this.min = min;
		}
	}
	
	public static class StackWithCapacity extends Stack<Integer> {
		int capacity;
		
		public StackWithCapacity(int capacity) {
			super();
			this.capacity = capacity;
		}
		
		public boolean isFull() {
			return size() >= capacity;
		}
	}
	
	public class AnimalShelter {
		LinkedList<Animal> cats = new LinkedList<>();
		LinkedList<Animal> dogs = new LinkedList<>();
		int order = 0;
		
		public void enqueue(Animal a) {
			a.setOrder(order);
			order++;
			if(a.type == AnimalType.CAT) {
				cats.add(a);
			} else {
				dogs.add(a);
			}
		}
		
		public Animal dequeueAny() throws Exception {
			if(cats.isEmpty() && dogs.isEmpty()) throw new Exception("Empty Shelter");
			if(cats.isEmpty()) return dogs.removeFirst();
			if(dogs.isEmpty()) return cats.removeFirst();
			
			//Both have animals
			if(cats.getFirst().getOrder() < dogs.getFirst().getOrder()) return cats.removeFirst();
			return dogs.removeFirst();
		}
		
		public Animal dequeueCat() throws Exception {
			if(cats.isEmpty()) throw new Exception("No cats.");
			return cats.removeFirst();
		}
		
		public Animal dequeueDog() throws Exception {
			if(dogs.isEmpty()) throw new Exception("No dogs.");
			return dogs.removeFirst();
		}
	}
	
	public class Animal {
		
		public AnimalType type;
		private int order;
		
		public Animal(AnimalType type) {
			this.type = type;
		}
		
		public int getOrder() {
			return order;
		}
		  
		public void setOrder(int order) {
			this.order = order;
		}
	}
	
	public enum AnimalType {
		CAT,
		DOG
	}
	
	public static class SetOfStacks {
		ArrayList<StackWithCapacity> stacks = new ArrayList<StackWithCapacity>();
		int capacity = 0;
	
		public SetOfStacks(int capacity) {
			this.capacity = capacity;
		}
		
		private StackWithCapacity getLastStack() {
			if(stacks.size() == 0) {
				stacks.add(new StackWithCapacity(capacity));
			}
			return stacks.get(stacks.size() - 1);
		}
		
		public boolean isEmpty() {
			return getLastStack().isEmpty();
		}
		
		public void push(int value) {
			StackWithCapacity currentStack = getLastStack();
			if(!currentStack.isFull()) {
				currentStack.push(value);
			} else {
				StackWithCapacity newStack = new StackWithCapacity(capacity);
				newStack.push(value);
				stacks.add(newStack);
			}
		}
		
		public int pop() throws Exception {
			StackWithCapacity currentStack = getLastStack();
			if(currentStack.isEmpty()) throw new Exception("Empty Stack");
			int value = currentStack.pop();
			if(currentStack.size() == 0) stacks.remove(stacks.size() - 1);
			return value;
		}
		
		public int popAt(int index) {
			StackWithCapacity stackAtIndex = stacks.get(index);
			int value = stackAtIndex.pop();
			if(stackAtIndex.size() == 0) stacks.remove(stackAtIndex);
			return value;
		}
	}
	
	public static void sortStack(Stack<Integer> inputStack) {
		Stack<Integer> sortedStack = new Stack<Integer>();
		while(!inputStack.isEmpty()) {
			int temp = inputStack.pop();
			while(!sortedStack.isEmpty() && sortedStack.peek() > temp) {
				inputStack.push(sortedStack.pop());
			}
			sortedStack.push(temp);
		}
		
		//Copy the elements from R back into s
		while(!sortedStack.isEmpty()) {
			inputStack.push(sortedStack.pop());
		}
	}
	
	public static void printStack(Stack<Integer> s) {
		Stack<Integer> tempStack = new Stack<Integer>();
		while(!s.isEmpty()) {
			int temp = s.pop();
			System.out.print(temp + ", ");
			tempStack.push(temp);
		}
		
		//Copy Elements back
		while(!tempStack.isEmpty()) {
			s.push(tempStack.pop());
		}
	}
}
