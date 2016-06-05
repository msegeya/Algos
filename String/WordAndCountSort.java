import java.util.*;

class WordAndCountSort 
				implements Comparator<WordAndCount> {

	@Override
	public int compare(WordAndCount wc1, WordAndCount wc2) {
		return wc1.count - wc2.count;
	}
}