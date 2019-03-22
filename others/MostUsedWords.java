package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MostUsedWords {
	
	public static void main(String[] args) {
		String statement = "This is a statement used to test my algorithm and this statement has repeated words "
				+ "because the algorithm should find out the most used words. If there are more than one word most used "
				+ "the algorithm should print them ordered by natural order. The algorithm must ignore the words present in "
				+ "the next string used";
		
		String wordsToIgnore = "is a to the";
		
		String[] aux = statement.replaceAll("\\.", "").split(" ");
		List<String> ignoreList = Arrays.asList(wordsToIgnore.split(" "));
		
		Map<String, Integer> mostUsedWords = new HashMap<>();
		
		for (int i = 0; i < aux.length; i++) {
			if(!ignoreList.contains(aux[i])) {
				mostUsedWords.merge(aux[i], 1, Integer::sum);
			}
		}
		
		System.out.println(mostUsedWords);
		
		Integer maxUse = Collections.max( mostUsedWords.values());
		
		System.out.println("Max use: "+maxUse);
		
		List<String> result = new ArrayList<>();
		
		mostUsedWords.forEach(
			(k,v) -> {
				if(v==maxUse) {
					result.add(k);
				}
			}
		);
		
		System.out.println(result);
		
	}

}
