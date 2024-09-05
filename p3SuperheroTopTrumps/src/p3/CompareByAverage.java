/**
 * 
 */
package p3;

import java.util.Comparator;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class CompareByAverage implements Comparator<TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		// TODO Auto-generated method stub
		if (o1.averageOfStats() > o2.averageOfStats()) {
			return 1;
		} else if (o1.averageOfStats() < o2.averageOfStats()) {
			return -1;
		} else {
			return 0;
		}
	}

}
