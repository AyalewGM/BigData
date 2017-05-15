package homework.Week1.Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reducer {
	public List<Pair<String,List<Integer>>> reducerInput(List<Pair<String,Integer>> list){
		List<String> keys=list.stream().map(x -> x.getKey()).distinct().collect(Collectors.toList());
		List<Pair<String,List<Integer>>> listGBP=new ArrayList<>();
		for(String key : keys){
			List<Integer> ints=new ArrayList<>();
			for(Pair<String,Integer> p : list){
				if(p.getKey().equals(key)){
					ints.add(p.getValue());
				}				
			}
			listGBP.add(new Pair(key,ints));
		}
		return listGBP;
	}
	public List<Pair<String,Integer>> reducerOutput(List<Pair<String,List<Integer>>> listGBP){
		int sum=0;
		List<Integer> ints=new ArrayList<>();
		List<Pair<String,Integer>> listPair=new ArrayList<>();
		for(Pair<String,List<Integer>> gbp : listGBP){
			sum=0;
			ints=gbp.getValue();
			for(int i : ints)
				sum+=i;
			listPair.add(new Pair(gbp.getKey(),sum));			
		}
		return listPair;		
	}
}
