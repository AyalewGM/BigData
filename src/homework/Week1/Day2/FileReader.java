package homework.Week1.Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayu on 5/1/2017.
 */
public class FileReader {


    public  List<String>  fileReader(String folder) throws IOException {
List<String > myList= new ArrayList<>();

        File fr = null;
        BufferedReader bf = null;
        try {
            fr = new File(folder);
            bf = new BufferedReader(new java.io.FileReader(fr));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder b = new StringBuilder();
        String st = null;
        while ((st = bf.readLine()) != null) {
            b.append(st);
            b.append(" ");
        }
        String [] myArray = b.toString().split("[ -\"]+");
        return filter(myArray);


    }

    /**
     * Clean the file and returns the list.
     * @param arr
     * @return
     */

    public static List<String> filter(String[] arr) {


        List<String> str = new ArrayList<>();

        for (String e : arr) {
            if (e.endsWith(".")) {
                e.replaceAll(".", "");
            }
        }
        for (String e : arr) {

            boolean allLetters = e.chars().allMatch(Character::isLetter);
            if (allLetters && e != null && !e.equals("")) {

                str.add(e.toLowerCase());
            }

        }
        return str;

    }
}
