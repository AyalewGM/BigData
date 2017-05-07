package homework.Day2;

import homework.Day1.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ayu on 5/2/2017.
 */
public class Reducer  {


  /*
    public Reducer(K key, V value ) {

        this.key= key;
        this.values.add(value);

    }*/
public Reducer(){

}



    public List<Pair<String, Integer>> reduce(List<GroupByPair<String, List<Integer>>> reducerInput) {

        List<Pair<String, Integer>> finalList = new ArrayList<>();
        finalList = reducerInput.stream()
                .map(x -> new Pair(x.getKey(), x.getListValue().size()))

                .collect(Collectors.toList());

    return finalList;

}



}
