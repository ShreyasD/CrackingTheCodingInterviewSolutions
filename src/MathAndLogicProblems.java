import java.util.ArrayList;
import java.util.Random;

public class MathAndLogicProblems {
	class Bottle {
		private boolean poisoned = false;
		private int id;
		
		public Bottle(int id) { this.id = id; }
		public int getld() { return id; }
		public void setAsPoisoned() { poisoned = true; }
		public boolean isPoisoned() { return poisoned; }
	}
	
	class TestStrip {
		public static final int DAYS_FOR_RESULT = 7;
		private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<ArrayList<Bottle>>();
		private int id;
		
		public TestStrip(int id) {this.id = id;}
		public int getld() { return id; }
		
		/* Re size list of days/drops to be large enough. */
		private void sizeDropsForDay(int day) {
			while (dropsByDay.size() <= day) {
				dropsByDay.add(new ArrayList<Bottle>());
			}
		}
		
		/* Add drop from bottle on specific day. */
		public void addDropOnDay(int day, Bottle bottle) {
			sizeDropsForDay(day);
			ArrayList<Bottle> drops = dropsByDay.get(day);
			drops.add(bottle);
		}
		
		/* Checks if any of the bottles in the set are poisoned. */
		private boolean hasPoison(ArrayList<Bottle> bottles) {
			for (Bottle b : bottles) {
				if (b.isPoisoned()) {
					return true;
				}
			}
			
			return false;
		}
		
		/* Get s bottles used in the test DAYS_FaR_RESULT days ago. */
		public ArrayList<Bottle> getLastWeeksBottles(int day) {
			if (day < DAYS_FOR_RESULT) {
				return null;
			}
			return dropsByDay.get(day - DAYS_FOR_RESULT);
		}
		
		/* Checks for poisoned bottles since before DAYS FOR RESULT */
		public boolean isPositiveOnDay(int day) {
			int testDay = day - DAYS_FOR_RESULT;
			if (testDay < 0 && testDay >= dropsByDay.size()) {
				return false;
			}
			
			for (int d = 0; d <= testDay; d++) {
				ArrayList<Bottle> bottles = dropsByDay.get(d);
				if (hasPoison(bottles)) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	public static boolean isPrimeNaive(int n) {
		if(n < 2) return false;
		
		for(int i=2; i < n; i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}
	
	public static boolean isPrimeBetter(int n) {
		boolean[] flags = new boolean[n + 1];
		int prime = 2;
		while(prime <= Math.sqrt(n)) {
			//check all number divisible by prime
			for(int i = prime * prime; i <= n; i += prime) {
				if(i == n) return false;
			}
			
			//get next prime
			int next = prime + 1;
			while(next < n && !flags[next]) {
				next++;
			}
			prime = next;
		}
		return true;
	}
	
	public static double runFamilies(int n) {
		int boys = 0, girls = 0;
		for(int i=0; i < n; i++) {
			int[] genders = runSingleFamily();
			girls += genders[0];
			boys += genders[0];
		}
		
		return girls / (double) (boys + girls);
	}
	
	public static int[] runSingleFamily() {
		int boys=0, girls=0;
		Random random = new Random();
		while(girls <= 0) {
			if(random.nextBoolean()) girls ++;
			else boys++;
		}
		
		return new int[]{girls, boys}; 
	}
	
	public static boolean[] hundredDoors() {
		boolean[] doors = new boolean[100];
		
		//Open all doors
		for(int i=0; i<100; i++) {
			doors[i] = true; 
		}
		
		//close every second
		for(int i=1; i < 100; i += 2) {
			doors[i] = false;
		}
		
		//
		for(int i=2; i < 100; i++) {
			for(int j=i; j<=100; j += i+1) {
				doors[i] = !doors[i];
			}
		}
		
		return doors;
	}
	
	
}
 