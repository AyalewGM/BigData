package homework.Week1.Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Modified Mapper from previous assignment
 * Created by Ayu on 5/5/2017.
 */
public class Mapper {

    public List<Pair<String,Integer>> map(String s){
        Hashtable<String,Integer> mapperTable =new Hashtable<String,Integer>();
        List<String> listString = Arrays.asList(s.split(" "));
        listString.stream().forEach(x -> {
            if(mapperTable .containsKey(x)){
                int key=mapperTable .get(x)+1;
                mapperTable .remove(x);
                mapperTable .put(x, key);
            }else{
                mapperTable .put(x, 1);
            }
        });

        List<Pair<String,Integer>> list =new ArrayList<>();
        for(String str: mapperTable .keySet()){
            list.add(new Pair(str,mapperTable .get(str)));
        }
        return list;

    }
}
