package homework.Day2;

import homework.Day1.*;
import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ayu on 5/2/17.
 */
public class Tester {
    public static void main(String[] args) throws IOException {

        //String fPath = "C:\\Users\\ayu\\Desktop\\testDataForW1D1.txt";

        String fPath = "/media/ayu/OS/Documents and Settings/Ayu/Desktop/testDataForW1D1.txt";

        // List<String> mywordList = new ArrayList<String>();
        FileReader file = new FileReader();
        file.fileReader(fPath);
        Mapper mapper = new Mapper();

      List<GroupByPair<String, List<Integer>>> reducerInput  = mapper.combiner(mapper.map(file.fileReader(fPath)));
      reducerInput.forEach(System.out::println);
      Reducer reducer = new Reducer();
      List<Pair<String, Integer>> reuceroutPut= reducer.reduce(reducerInput);

      reuceroutPut.forEach(System.out::println);
    }
}
