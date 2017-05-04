package homework.Day3;
/**
 * Driver class
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordCountTester{
	public static void main(String[] agrs){
		ReadFile reader=new ReadFile();
		String fPath1="C\\Users\\Ayu\\DownLoads\\Files\\InputSplit1.txt";
		String fPath2="C\\Users\\Ayu\\DownLoads\\Files\\InputSplit2.txt";
		String fPath3="C\\Users\\Ayu\\DownLoads\\Files\\InputSplit3.txt";



		String file1=reader.readFileFromDir(fPath1);
		String file2=reader.readFileFromDir(fPath2);
		String file3=reader.readFileFromDir(fPath3);
		
		String[] strings={file1,file2, file3};
		int splits=4;
		
		WordCount wc=new WordCount(splits);
		Mapper mapper=new Mapper();
		
		List<List<Pair<String,Integer>>> listPair=new ArrayList<>();
		for(int i=0;i<strings.length;i++){
			System.out.println("Mapper "+i+" output");
			mapper.Map(strings[i]).forEach(System.out::println);
		}
		
		for(int i=0;i<strings.length;i++){
			wc.fromMapperToReducer(mapper.Map((strings[i])), "Mapper "+i);
			listPair.add(mapper.Map(strings[i]));
		}
		
		List<List<Pair<String, List<Integer>>>> listValuesByKey = wc.sufferSort(listPair);
		
		
		System.out.println(listPair.size());
		System.out.println(listValuesByKey.size());
		int i=0;
		for(List<Pair<String,List<Integer>>> list : listValuesByKey){
			list=list.stream().sorted(new Comparator<Pair<String,List<Integer>>>(){
				@Override
				public int compare(Pair<String,List<Integer>> p1,Pair<String,List<Integer>> p2){
					return p1.getKey().compareTo(p2.getKey());
				}
			}).collect(Collectors.toList());
			System.out.println("Reducer "+i+" input");
			list.forEach(System.out::println);
			i++;
		}
		
		i=0;
		listPair=wc.reducersOutput(listValuesByKey);
		for(List<Pair<String,Integer>> list : listPair){
			list = list.stream().sorted(new Comparator<Pair<String,Integer>>(){
				@Override
				public int compare(Pair<String,Integer> p1,Pair<String,Integer> p2){
					return p1.getKey().compareTo(p2.getKey());
				}
			}).collect(Collectors.toList());
			System.out.println("Reducer "+i+" output");
			list.forEach(System.out::println);
			i++;
		}
	}

}
