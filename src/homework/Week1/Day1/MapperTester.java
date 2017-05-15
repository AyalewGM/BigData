package homework.Week1.Day1;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ayu on 5/5/2017.
 */
public class MapperTester {
    public static void main(String[] args) throws IOException {

       // String fPath = "C:\\Users\\ayu\\Desktop\\testDataForW1D1.txt";
        String fPath = "/media/ayu/OS/Documents and Settings/Ayu/Desktop/testDataForW1D1.txt";
        FileReader fileReader= new FileReader();
        Mapper mapper= new Mapper();

         List<Pair<String, Integer>> mainList=  mapper.map(fileReader.fileReader(fPath));
         mainList.forEach(x-> System.out.println(x));

//        for(Pair m: mainList) System.out.println(m);
    }
}
