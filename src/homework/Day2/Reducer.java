package homework.Day2;

import homework.Day1.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Ayu on 5/2/2017.
 */
public class Reducer<K, V> {


    private K key;

    private V value;



    public Reducer(K key, V value ) {

        this.key= key;
        this.value= value;

    }


    public static void main(String[] args) throws IOException {

        String fPath = "C:\\Users\\ayu\\Desktop\\testDataForW1D1.txt";
        // List<String> mywordList = new ArrayList<String>();

        List<Mapper<String, Integer>> mainList = Mapper.mapperListMaker(fPath);


    }
public List<Reducer<String, List<Integer> > > groupByPair(List<Mapper<String, Integer>> mapperList){

        List<Reducer<String, List<Integer>>> reducerList = new ArrayList<>();

        reducerList= mapperList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.toList()));



       return reducerList;
}


public List<Reducer<String, Integer>> reducer(List<Reducer<String, List<Integer> > > myOtherList){



}

}
