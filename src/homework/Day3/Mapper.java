package homework.Day3;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
	public List<Pair<String,Integer>> Map(String s){
		List<String> listString = Arrays.asList(s.split(" "));
		return listString.stream()
				.sorted()
				.map(x -> new Pair(x,1))
				.collect(Collectors.toList());
	}
}
