package homework.Week2.Day1.pair;

/**
 * Created by ayu on 5/9/17.
 */
public class PairApproachTester {
    public static void main(String[] args) {
        int [] myArray= new int[]{15,91,80,12,19, 80, 18, 17, 15,80,19,18};
        Mapper mapper = new Mapper();
        System.out.println( mapper.map(myArray));
        System.out.println(mapper.reducerInput(mapper.map(myArray)));

        Reducer reducer = new Reducer();

        System.out.println(reducer.reducerOutput(mapper.reducerInput(mapper.map(myArray))));

    }
}
