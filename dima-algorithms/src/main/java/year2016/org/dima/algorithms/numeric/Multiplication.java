package year2016.org.dima.algorithms.numeric;

public class Multiplication {
			
	public static void main(String[] args) {
		
		Multiplication mul = new Multiplication();
		System.out.println(mul.mult(6, 4));		
	}
	
	int mult(int x, int y) {
		return mull(x, y, y);		
	}	
	
	private int mull(int x, int y, int z) {
		if ( x == 0) {
			return z;
		} else {
			x = x >> 1;
			y = y << 1;
			if (x % 2 == 0) {
				return mull(x, y, z);
			} else {
				return mull(x, y, z + y);
			}			
		}		
	}
	

}
