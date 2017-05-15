package homework.Week2.Day1.pair;



import java.util.*;
import java.util.stream.Collectors;

/**
 *  This is mapper implemeting Algorithm 3.8
 * Created by Ayu on 5/8/2017.
 */
public class Mapper {

    public List<Pair<Pair<Integer, Integer>, Integer>> map(int[] arr) {

        //Hashtable<String,Integer> mapperTable =new Hashtable<String,Integer>();
        //List<String> listString = Arrays.asList(s.split(" "));
        //return
        List<Pair<Pair<Integer, Integer>, Integer>> tempList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] != arr[i]) tempList.add(new Pair(new Pair(arr[i], arr[j]), 1));
                else break;
            }
        }
return tempList;

    }
    Comparator<Pair<Integer, Integer>> myComparator = new Comparator<Pair<Integer, Integer>>() {
        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            return o1.getKey().compareTo(o2.getKey());
        }
    };
//Comparator<  Pair<Integer, Integer> > comparator= new Comparator< Pair<Integer, Integer >() {
//    @Override
//    public int compare( Pair<Integer, Integer>> o1, Pair<Integer, Integer>> o2) {
//        return o1.getKey().compareTo(o2.getKey());
//    }
//};

    public List<Pair<Pair<Integer,Integer>,List<Integer>>> reducerInput(List<Pair< Pair<Integer,Integer>, Integer>> list){
        List<Pair<Integer, Integer>> keys=list.stream().map(x ->x.getKey()).distinct().sorted(myComparator).collect(Collectors.toList());
        List<Pair<Pair<Integer,Integer>, List<Integer>>> pairList=new ArrayList<>();
        for(Pair key : keys){
            List<Integer> ints=new ArrayList<>();
            for( Pair<Pair<Integer,Integer>, Integer> p : list){
                if(p.getKey().equals(key)){
                    ints.add(p.getValue());
                }
            }
            pairList.add(new  Pair(key,ints));
        }
        return pairList;
    }


}
