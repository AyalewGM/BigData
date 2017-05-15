package homework.Week1.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Ayu on 5/2/2017.
 */
public class Reducer  {

public Reducer(){

}

Function<List<List<Integer>>, List<Integer>> sumMapper= x->x.stream().map(y->y.stream().reduce(0,Integer::sum))
                                                       .collect(Collectors.toList());

    public List<Pair<String, Integer>> reduce(List<GroupByPair<String, List<Integer>>> reducerInput) {

        List<Pair<String, Integer>> finalList = new ArrayList<>();
        List<String> tempList= reducerInput.stream().map(x->x.getKey())
                .distinct().collect(Collectors.toList());
for(String st: tempList){
    //List<Pair<String, Integer>> intermediateList = new ArrayList<>();
    Integer sum1=0;
    if(reducerInput.stream().map(x->x.getKey()).equals(st)){

        sum1 = reducerInput.stream()
                .flatMap(l->l.getListValue().stream())
                .collect(Collectors.toList())
                .stream()
                .mapToInt(l->l.stream().reduce(0,Integer::sum)).reduce(0, Integer::sum);
//                reducerInput.stream().map(x->x.getListValue().stream().map(z->z.stream().reduce(0,Integer::sum)))
//                .collect(Collectors.toList()).stream().mapToInt(sumMapper).sum();

        }
        finalList.add(new Pair<String, Integer>(st,sum1));

    }

    return finalList;

    }

}
