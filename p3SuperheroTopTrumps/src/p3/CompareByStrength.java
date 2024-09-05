/**
 * 
 */
package p3;

import java.util.Comparator;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class CompareByStrength implements Comparator<TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
	
		return o1.getStrength() - o2.getStrength();
	}
	
	

}
