package year2016.org.dima.algorithms.numeric;

public class GreatestCommonDevisor {
	
	public int gcd(int p, int r) {		
		int reminder = p % r;		
		if (reminder == 0) {
			return r;
		} else {			
			return gcd(r, reminder);
		}
	}		

}
