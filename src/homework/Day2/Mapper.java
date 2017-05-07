package homework.Day2;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Ayu on 5/1/2017.
 */
public class Mapper {

    // Some utilities
       Function<String, Pair> formPair = x-> new Pair(x,1);

       Comparator<Pair> pairComparator = (Pair p1, Pair p2)->{
           String st1= (String) p1.getKey();
           String st2= (String ) p2.getKey();
           return st1.compareTo(st2);

    };

    /**
     *
     * The map function
     * Tasks- map every element of the string list to pair element of Pair list

     * @param stringList
     * @return
     */

       public  List<Pair<String,Integer>> map(List<String> stringList)  {
       // List<Pair<String, Integer>> mainList;// = new ArrayList<>();

       List mainList= stringList.stream()
               .collect(Collectors.groupingBy(Function.identity())).keySet().stream()
               .map(formPair)
               .sorted(pairComparator)
               .collect(Collectors.toList());
           mainList.forEach(System.out::println);
        return mainList;

    }


    public List<GroupByPair<String, List<Integer>>> compbiner(List<Pair<String, Integer>> pairList) {
//List<String> wordKeys = mapperList.stream().map()
        List<String> wordKeys = pairList.stream()
                .map(x -> x.getKey())
                .distinct().collect(Collectors.toList());


        List<GroupByPair<String, List<Integer>>> reducerList = new ArrayList<>();

        for (String key : wordKeys) {
            List<Integer> listValue = new ArrayList<Integer>();
            for (Pair<String, Integer> p : pairList) {
                if (p.getKey().equals(key)) {
                    listValue.add(p.getValue());
                }
            }
            GroupByPair<String, List<Integer>> gbp = new GroupByPair(key, listValue);
            reducerList.add(gbp);
        }

        return reducerList;


    }


}

