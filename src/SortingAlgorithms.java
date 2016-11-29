import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SortingAlgorithms {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		int[] array = {7,2,1,6,8,5,3,4};
		quickSort(array, 0, 7);
		System.out.print("quickSort: ");
		for(int i=0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		array = new int[]{7,2,1,6,8,5,3,4};
		mergeSort(array);
		System.out.print("mergeSort: ");
		for(int i=0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.print("Searched 7 in array: " + binarySearch(7, array));
		
		System.out.print("Fibonaci at 9: " + getFibonaci(9)[9]);
		
		array = new int[]{3,4,5,6,1,2};
		System.out.print("Searched 2 in array: " + shiftedBinarySearch(2, array));
		
		char[] testString = new char[]{'t', 'e', 's','t','s','t','r','i','n','g'};
		System.out.println(areAllCharsInStringUnique(testString));
		
		String testStr1 = "abcdefg";
		String testStr2 = "gfedcab";
		System.out.println(isPermutation(testStr1, testStr2));
		
		testStr1 = "Mr John Smith              ";
		char[] input = testStr1.toCharArray();
		urlify(input, 13);
 		testStr1 = new String(input);
		System.out.println(testStr1);
		
		testStr1 = "tactcoapapa";
		System.out.println("isPermutationPalindrome: " + isPermutationPalindrome(testStr1));
		
		testStr1 = "pale";
		testStr2 = "bae";
		System.out.println("isOneEdit Away: " + isOneEditAway(testStr1, testStr2)) ;
		
		testStr1 = "aabbccddeefff";
		System.out.println("compressed String: " + basicStringCompression(testStr1));
		
		//Matrices
		int[][] matrix = new int[][]{{1,2,3,4},
									 {1,2,3,4}, 
									 {1,2,3,4},
									 {1,2,3,4}};
		if(MatrixProblems.rotateMatrix(matrix)) {
			printMatrix(matrix);
		}
		
		matrix = new int[][]{{1,2,3,4},
							 {1,0,3,4},
							 {2,4,2,0},
							 {4,5,2,1}};
		MatrixProblems.zeroMatrix(matrix);
		printMatrix(matrix);
		
		//LinkedList
		LinkedListProblems.LinkedListNode linkedList = LinkedListProblems.createLinkedList(new int[]{2,3,1,2,4,5,12});
		LinkedListProblems.printLinkedList(linkedList);
		LinkedListProblems.removeDups(linkedList);
		LinkedListProblems.printLinkedList(linkedList);
		System.out.println("Element at 3 from back is: " + LinkedListProblems.getElementAtIndexFromEnd(linkedList, 3).data);
		
		linkedList = LinkedListProblems.createLinkedList(new int[]{2,3,1,2,4,5,12});
		LinkedListProblems.LinkedListNode mid = LinkedListProblems.getMiddleNode(linkedList);
		System.out.println("Delete " + mid.data + " from ");
		LinkedListProblems.printLinkedList(linkedList);
		if(LinkedListProblems.deleteNode(mid)) {
			LinkedListProblems.printLinkedList(linkedList);
		}
		
//		linkedList = createLinkedList(new int[]{2,3,1,2,4,5,12});
//		printLinkedList(linkedList);
//		LinkedListNode partitioned = partition(linkedList, 2);
//		printLinkedList(partitioned);
		
		int number = 12345;
		System.out.println("Reverse " + number + ": " + reverseInt(number));
		
		String s = "tree";
		String freqSortedString = frequencySort(s);
		System.out.println("freqSortedString: " + freqSortedString);
		
		int[] nums = {1,1,1,2,2,3};
		List<Integer> topkFrequent = topKFrequent(nums, 2);
		for(Integer i : topkFrequent) {
			System.out.print(i + " ");
		}
		 
		StackProblems.StackWithMin stackMin = new StackProblems.StackWithMin();
		stackMin.push(7);
		stackMin.push(9);
		stackMin.push(10);
		System.out.println("Stack Min: " + stackMin.min());
		
		Stack<Integer> testStack = new Stack<Integer>();
		testStack.push(4);
		testStack.push(2);
		testStack.push(9);
		testStack.push(7);
		StackProblems.sortStack(testStack);
		 StackProblems.printStack(testStack);
		 
		System.out.println(Integer.toBinaryString(BitManipulationProblems.updateBits(0b10000000000, 0b10011, 2, 6)));
		
		System.out.println("Is 97 a prime? (Naive)" + MathAndLogicProblems.isPrimeNaive(97));
		System.out.println("Is 97 a prime? (Smart)" + MathAndLogicProblems.isPrimeNaive(97));
		
		System.out.println("Gender Ratio: " + MathAndLogicProblems.runFamilies(100));
		
		boolean[] doors = MathAndLogicProblems.hundredDoors();
		int openCount = 0;
		for(int i=0; i<doors.length; i++) {
			if(doors[i]) openCount++;
		}
		System.out.println("Open doors: " + openCount);
		
		int[] sortedArray = {0,1,2,3,4,5,6,7,8,9};
		GraphProblems.TreeNode root = GraphProblems.createMinimalBST(sortedArray, 0, sortedArray.length - 1);
		GraphProblems.inOrderTraversal(root);
		
		System.out.println("Levels: ");
		ArrayList<LinkedList<GraphProblems.TreeNode>> levels = GraphProblems.createLinkedListPerLevel(root);
		for(LinkedList<GraphProblems.TreeNode> list : levels) {
			for(GraphProblems.TreeNode node : list) {
				System.out.print(node.value + ' ');
			}
			System.out.print("\n");
		}
	}
	
	private static void printMatrix(int[][] matrix) {
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.print('\n');
		}
	}
	
	private static void quickSort(int[] array, int start, int end) {
		if(start > end) {
			int pIndex = partition(array, start, end);
			quickSort(array, start, pIndex-1);
			quickSort(array, pIndex+1, end);
		}
	}
	
	private static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int pIndex = start;
		for(int i=start; i<end; i++) {
			if(array[i] < pivot) {
				swap(array, i, pIndex);
				pIndex++;
			}
		}
		swap(array, pIndex, end); //Put pivot in the right place
		return pIndex;
	}
	
	private static void mergeSort(int[] array) {
		int size = array.length, mid = array.length/2, left[], right[];
		if(size < 2) return;
		
		left = new int[mid];
		right = new int[size-mid];
		
		//Populate arrays
		for(int i=0; i<mid; i++) {
			left[i] = array[i];
		}
		
		for(int i=mid; i<size; i++) {
			right[i-mid] = array[i];
		}
		
		mergeSort(left);
		mergeSort(right);
		merge(array, left, right);
	}
	
	private static void merge(int[] array, int[] left, int[] right) {
		int i=0,j=0,k=0,leftSize=left.length, rightSize=right.length;
		
		while(i<leftSize && j<rightSize) {
			if(left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		
		//if we didn't finish either the left or right array
		while(i<leftSize) {
			array[k] = left[i];
			i++;
			k++;
		}
		
		while(j < leftSize) {
			array[k] = right[j];
			j++;
			k++;
		}
	}
	
	private static int binarySearch(int number, int[] array) {
		int nArray = array.length, mid = array.length/2;
		int[] temp;
		if(number == array[mid]) return mid;
		else if (number < array[mid]) {
			//create temp array and search that
			temp = new int[mid];
			for(int i=0; i < mid; i++) {
				array[i] = temp[i];
			}
			return binarySearch(number, temp);
		} else {
			//create temp array and search that
			temp = new int[nArray - mid];
			for(int i=mid; i < nArray; i++) {
				temp[i-mid] = array[i];
			}
			return mid + binarySearch(number, temp);
		}
	}
	
	private static int[] getFibonaci(int n) {
		int[] array = new int[n+1];
		array[0] = 0;
		array[1] = 1;
		for(int i=2; i <= n; i++) {
			array[i] = array[i-1] + array[i-2]; 
		}
		
		return array;
	}
	
	private static int shiftedBinarySearch(int number, int[] array) {
		int start = 0, end = array.length-1;
		
		while(start <= end) {
			int mid = start + ((end - start)/2);
			if(array[mid] == number) return mid;
			
			if(array[start] < array[mid]) {
				//if bottom half is sorted
				if(array[start] <= number && number < array[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				//if top half is sorted
				if(array[mid] < number && number <= array[end]) 
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		
		return -1;
	}
	 
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private static boolean areAllCharsInStringUnique(char[] str) {
		int start = 0, end = str.length;
		
		while(start < end) {
			char cToCompare = str[start];
			for(int i=start + 1; i < end; i++) {
				if(str[i] == cToCompare) return false;
			}
			start++;
		}
		
		//duplicate chars not found
		return true;
	}
	
	private static boolean isPermutation(String str1, String str2) {
		//if lengths are not identical they can't be permutations
		if(str1.length() != str2.length()) return false;
		
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		for(char c : str1.toCharArray()) {
			Character cTemp = new Character(c);
			if (charCountMap.containsKey(cTemp)) 
				charCountMap.put(cTemp, new Integer(charCountMap.get(cTemp) + 1));
			else charCountMap.put(cTemp, new Integer(1));
		}
		
		for(char c : str2.toCharArray()) {
			Character cTemp = new Character(c);
			if(!charCountMap.containsKey(cTemp) || charCountMap.get(cTemp) == 0) 
				return false;
		}
		
		return true;
	}
	
	private static void urlify(char[] str, int length) {
		int spaceCount = 0, index = 0;
		
		//Count number of spaces in given length to add space
		for(int i=0; i<length; i++) {
			if(str[i] == ' ') spaceCount++;
		}
		index = length + spaceCount * 2;
		str[index] = '\0';
		
		//Go through reverse and
		for(int i=length-1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index-1] = str[i];
				index--;
			}
		}
		
	}
	
	private static boolean isPermutationPalindrome(String str) {
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		
		//Count Chars
		for(int i=0; i < str.length(); i++) {
			Character cTemp = new Character(str.charAt(i));
			int count = (charCountMap.containsKey(cTemp)) ? 
					charCountMap.get(cTemp).intValue() + 1 : 1;
			charCountMap.put(cTemp, count);
		}
		
		//look for odd counts (cannot be greater than 1)
		boolean foundOdd = false;
		for(Character c : charCountMap.keySet()) {
			if(charCountMap.get(c).intValue() % 2 == 1) {
				if(foundOdd) return false;
				foundOdd = true;
			}
		}
		
		return true;
	}
	
	private static boolean isOneEditAway(String str1, String str2) {
		if(str2.length() > str1.length() + 1 || str2.length() < str1.length() - 1) {
			//String is too big or too small
			return false;
		}
		
		//if replacement
		if(str1.length() == str2.length()) {
			boolean charDifferentFound = false;
			for(int i=0; i < str1.length(); i++) {
				if(str1.charAt(i) != str2.charAt(i)){
					if(charDifferentFound) return false;
					charDifferentFound = true; 
				}
			}
		} else if(str1.length() > str2.length()) {
			//removal
			return isOneInsertAway(str2, str1);
		} else {
			//insertion
			return isOneInsertAway(str1, str2);
		}
		
		return true;
	}
	
	private static boolean isOneInsertAway(String str1, String str2) {
		int index1 = 0;
		int index2 = 0;
		
		while(index1 < str1.length() && index2 < str2.length()) {
			if(str1.charAt(index1) != str2.charAt(index2)) {
				if(index1 != index2) return false;
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		
		return true;
	}
 
	private static String basicStringCompression(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for(int i=0; i < str.length(); i++) {
			countConsecutive++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		
		return (compressed.length() < str.length()) ? compressed.toString() : str;
	}
	
	private static int reverseInt(int number) {
		int length = (int)(Math.log10(number));
		int reversed = 0;
		while(number > 0) {
			int digit = number % 10;
			number /= 10;
			reversed += (digit * Math.pow(10.0, length));
			length--;
		}
		
		return reversed;
	}
	
	private static String frequencySort(String s) {
		if(s.length() <= 1) return s;
        
        HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();
		
		//Count Characters
		for(int i=0; i < s.length(); i++) {
			Character c = new Character(s.charAt(i));
			int count = (characterCount.containsKey(c)) ? 
					characterCount.get(c).intValue() + 1 : 1;
			characterCount.put(c, count);
		}
		
		//Bucket Sort
		List<Character> [] bucketList = new List[s.length() - 1];
		for(Character c : characterCount.keySet()) {
			int count = characterCount.get(c);
			if(bucketList[count] == null) {
				bucketList[count] = new ArrayList<Character>();
			}
			bucketList[count].add(c);
		}
		
		//Create sorted string
		StringBuilder sb = new StringBuilder();
		for(int i=bucketList.length-1; i >= 0; i--) {
			if(bucketList[i] != null) {
				for(Character c : bucketList[i]) {
					for(int j=0; j < characterCount.get(c); j++) {
						sb.append(c);
					}
				}
			}
		}
		
		return sb.toString();
	}
	
	private static List<Integer> topKFrequent(int[] nums, int k) {
		if(nums.length <= k) {
			List<Integer> intList = new ArrayList<Integer>();
			for (int index = 0; index < nums.length; index++)
			{
			    intList.add(nums[index]);
			}
			return intList;
		}
		HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
		
		//Count numbers
		for(int i=0; i<nums.length; i++) {
			int count = (numCount.containsKey(nums[i])) ? 
					numCount.get(nums[i]).intValue() + 1 : 1;
			numCount.put(nums[i], count);
		}
		
		//Sort from top
		List<Integer>[] countBuckets = new List[nums.length];
		for(Integer i : numCount.keySet()) {
			if(countBuckets[numCount.get(i)] == null) {
				countBuckets[numCount.get(i)] = new ArrayList<Integer>();
			}
			countBuckets[numCount.get(i)].add(i);
		}
		
		//Create return list
		int returnSize = 0;
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i=countBuckets.length-1; i >=0; i--) {
			if(countBuckets[i] != null) {
				for(Integer num : countBuckets[i]) {
					ret.add(num);
					returnSize++;
					if(returnSize >= k) return ret;
				}
			}
		}
		
		return ret;
	}
}
