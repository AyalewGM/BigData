package homework.Week1.Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Read from file
 */



public class ReadFile {
	public String readFileFromDir(String fileDir){
		String contents="";
		try {
			contents = new String(Files.readAllBytes(Paths.get(fileDir)));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return removeSpecChar(contents);
	}
	public String removeSpecChar(String s){
		List<String> s1=Arrays.asList(s.toLowerCase().replaceAll("[\\r,-]", " ").replaceAll("-", " ").split(" "));
		return s1.stream().map(x -> {
			StringBuilder sb=new StringBuilder();
			int i=0;
			int j=x.length()-1;
			while(i<j){
				if(x.charAt(i)<97||x.charAt(i)>122)
					i++;
				if(x.charAt(j)<97||x.charAt(j)>122)
					j--;
				else
				if(x.charAt(i)>=97&&x.charAt(i)<=122&&x.charAt(j)>=97&&x.charAt(j)<=122)
					break;
			}
			if(i>=j)
				return "";
			else{
				while(i<=j){
					sb.append(x.charAt(i));
					i++;
				}
			}
			return sb.toString();
		}).filter(x -> x.matches("[a-z]+")).collect(Collectors.joining(" "));
	}
}
