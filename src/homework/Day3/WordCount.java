package homework.Day3;

import java.util.ArrayList;
import java.util.List;

public class WordCount {
	private int splits;
	
	WordCount(int splits){
		this.splits=splits;
	}
	public int getPartition(String key){
		return (int)key.hashCode()%this.splits;
	}
	public void fromMapperToReducer(List<Pair<String,Integer>> list, String nameMapper){
		for(int i=0;i<this.splits;i++){
			System.out.println("Pairs send from "+nameMapper+" "+"Reducer "+i);
			for(Pair<String,Integer> p : list){
				if(getPartition(p.getKey())==i)
					System.out.println(p);
			}
		}
	}
	public List<List<Pair<String,List<Integer>>>> sufferSort(List<List<Pair<String,Integer>>> list){
		List<List<Pair<String,List<Integer>>>> listResult=new ArrayList<>();
		List<Pair<String,List<Integer>>> listPairByKey;
		List<Pair<String,Integer>> listPair;
		Reducer reducer=new Reducer();
		for(int i=0;i<this.splits;i++){			//for each Reducer	
			listPairByKey=new ArrayList<>();
			listPair=new ArrayList<>();			
			for(List<Pair<String,Integer>> listPair1 : list){	//for each list of pair key-value
				for(Pair<String,Integer> p : listPair1){		//for each Pair key-value
					if(getPartition(p.getKey())==i){
						listPair.add(p);
					}
				}
			}			
			listPairByKey=reducer.reducerInput(listPair);
			listResult.add(listPairByKey);			
		}
		return listResult;
	}
	
	public List<List<Pair<String,Integer>>> reducersOutput(List<List<Pair<String,List<Integer>>>> list){
		Reducer reducer=new Reducer();
		List<List<Pair<String,Integer>>> listResult=new ArrayList<>();
		for(List<Pair<String,List<Integer>>> listPairByKey : list){
			listResult.add(reducer.reducerOutput(listPairByKey));
		}
		return listResult;
	}
}
