import java.util.ArrayList;
import java.util.Arrays;

public class DynamicProgrammingAndRecursion {
	public static int getNthFibonnaci1(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return getNthFibonnaci1(n-1) + getNthFibonnaci1(n-2);
	}
	
	public static int getNthFibonnaci2(int n) {
		return getNthFibonnaci2Memo(n, new int[n + 1]);
	}
	
	public static int getNthFibonnaci2Memo(int n, int[] memo) {
		if(n == 0 || n == 1) return n;
		
		if(memo[n] == 0) {
			memo[n] = getNthFibonnaci2Memo(n-1, memo) + getNthFibonnaci2Memo(n-2, memo);
		}
		return memo[n];
	}
	
	public static int getNthFibonnaciBottomUp(int n) {
		if(n == 0 || n == 1) return n;
		
		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		for(int i=2; i < n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		
		return memo[n-1] + memo[n-2];
	}
	
	public static int getNthFibonnaciBottomUpLessMemory(int n) {
		if(n == 0) return 0;
		int a = 0;
		int b = 1;
		
		for(int i=2; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		
		return a + b;
	}
	
	public static int countWays(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return countWays(n, memo);
	}
	
	public static int countWays(int n, int[] memo) {
		if(n < 0) return 0;
		if(n == 0) return 1;
		if(memo[n] > -1) return memo[n];
		memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
		return memo[n];
	}
	
	public static int magicIndex(int[] array, int start, int end) {
		if(end < start) return -1;
		int mid = (start + end)/2;
		if(array[mid] == mid) return mid;
		if(mid < array[mid]) {
			return magicIndex(array, start, mid-1);
		}
		if(mid > array[mid]) {
			return magicIndex(array, mid + 1, end);
		}
		return -1;
	}
	
	public static int magicIndexNotDistinct(int[] array, int start, int end) {
		if(end < start) return -1;
		int mid = (start + end)/2;
		if(array[mid] == mid) return mid;
		
		//Search Left
		int minIndex = Math.min(mid - 1, array[mid]);
		int left = magicIndexNotDistinct(array, start, minIndex);
		if(left >= 0) return left;
		
		//Search Right
		int maxIndex = Math.max(mid + 1, array[mid]);
		int right = magicIndexNotDistinct(array, maxIndex, end);
		return right;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int i = 0;
		allSubsets.add(new ArrayList<Integer>());
		while(i < set.size()) {
			//add the current element on every subset and re-add
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(set.get(i));
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
			i++;
		}
		return allSubsets;
	}
}
