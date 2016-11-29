
public class BitManipulationProblems {

	public static int updateBits(int n, int m, int i, int j) {
		int left = ~0 << (j+1);
		System.out.println("left: " + Integer.toBinaryString(left));
		int right = ((1 << i) - 1);
		System.out.println("right: " + Integer.toBinaryString(right));
		int mask = left | right;
		System.out.println("mask: " + Integer.toBinaryString(mask));
		int n_cleared = n & mask;
		System.out.println("n_cleared: " + Integer.toBinaryString(n_cleared));
		int m_shifted = m << i;
		System.out.println("m_shifted: " + Integer.toBinaryString(m_shifted));
		return n_cleared | m_shifted;
	}
}
