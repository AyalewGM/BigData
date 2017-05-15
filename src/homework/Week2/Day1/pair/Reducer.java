package homework.Week2.Day1.pair;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Reducer {

	public List< Pair<Pair<Integer,Integer>, Integer>> reducerOutput(List<Pair< Pair<Integer,Integer>, List<Integer>>> pairList){
		int sum=0;
		List<Integer> ints = new ArrayList<>();
		List< Pair<Pair<Integer,Integer>, Integer>> listPair=new ArrayList<>();
		for( Pair< Pair<Integer,Integer>, List<Integer>> p : pairList){
			sum=0;
			ints=p.getValue();
			for(int i : ints)
				sum+=i;
			listPair.add(new  Pair(p.getKey(),sum));
		}
		return listPair;
	}
}
