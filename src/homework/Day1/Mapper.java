package homework.Day1;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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
     * The map function
     * Tasks- map every element of the string list to pair element of Pair list

     * @param stringList
     * @return
     */

       public  List<Pair<String,Integer>> map(List<String> stringList)  {
      List<Pair<String, Integer>> mainList;// = new ArrayList<>();

     mainList= stringList.stream()
               .collect(Collectors.groupingBy(Function.identity())).keySet().stream()
               .map(formPair)
               .sorted(pairComparator)
               .collect(Collectors.toList());
          // mainList.forEach(System.out::println);
        return mainList;
    }
}

