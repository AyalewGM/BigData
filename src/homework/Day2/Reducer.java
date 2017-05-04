package homework.Day2;

import homework.Day1.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ayu on 5/2/2017.
 */
public class Reducer<K, V> {


    private K key;

    private List<V> values = new ArrayList<V>();



    public Reducer(K key, V value ) {

        this.key= key;
        this.values.add(value);

    }
public Reducer(){

}

    public List<Reducer<String, List<Integer>>> groupByPair(List<Pair<String, Integer>> pairList) {
//List<String> wordKeys = mapperList.stream().map()
        List<String> wordKeys = pairList.stream()
                .map(x -> x.getKey())
                .distinct().collect(Collectors.toList());


        List<Reducer<String, List<Integer>>> reducerList = new ArrayList<>();

        for (String key : wordKeys) {
            List<Integer> listValue = new ArrayList<Integer>();
            for (Pair<String, Integer> p : pairList) {
                if (p.getKey().equals(key)) {
                    listValue.add(p.getValue());
                }
            }
            Reducer<String, List<Integer>> gbp = new Reducer(key, listValue);
            reducerList.add(gbp);
        }

       return reducerList;


    }


    public List<Pair<String, Integer>> reducer(List<Reducer<String, List<Integer>>> myOtherList) {

        List<Pair<String, Integer>> finalList = new ArrayList<>();
        finalList = myOtherList.stream()
                .map(x -> new Pair(x.key, x.values.size()))

                .collect(Collectors.toList());

    return finalList;

}

    public static void main(String[] args) throws IOException {

        String fPath = "C:\\Users\\ayu\\Desktop\\testDataForW1D1.txt";
        // List<String> mywordList = new ArrayList<String>();
        Mapper <String, Integer>myMapper = new Mapper<> ();
        Reducer<String, List<Integer>> myReducer = new Reducer<>();

        List<Pair<String, Integer>> mainList = myMapper.mapperListMaker(fPath);

        List<Reducer<String, List<Integer>>> reducerInputList = myReducer.groupByPair(mainList);

        List<Pair<String, Integer>> reducerOutPut = myReducer.reducer(reducerInputList);



    }

}
