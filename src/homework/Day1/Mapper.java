package homework.Day1;

import homework.Day2.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ayu on 5/1/2017.
 */
public class Mapper<K, V> {

    /**
     * Write a Java program to accomplish the following tasks. Please submit Java program and test run on the file attached.
     * <p>
     * Given a text-file input123,
     * <p>
     * The program will extract each “word” and form a key-value pair (you MUST create a pair class)
     * where the key is the “word” and value is integer one.  Note that your program should treat Cat and cat as the same word.
     * Each pair is inserted into a List (of pairs).
     * Sort the List using “Collections”. This may involve writing a comparator for the pair class.
     * Output the List
     * Note that tokens such as input123, abc.txt,  a23bc and abc_ptr  are not words. However, key-value is two words.
     * As a good programming habit, you want to use generics.
     * Example:
     * <p>
     * INPUT :
     * <p>
     * --------------------------------------------------------------------------
     * <p>
     * Write a Java program to accomplish the following tasks.
     * <p>
     * Given a text-file as input,
     */

    private K key;

    private V value;
    //Private R rTexts;


    public Mapper(K key, V value ) {

        this.key= key;
        this.value= value;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mapper)) return false;

        Mapper<?, ?> mapper = (Mapper<?, ?>) o;

        if (key != null ? !key.equals(mapper.key) : mapper.key != null) return false;
        return value != null ? value.equals(mapper.value) : mapper.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "{" +
                  key + ", "+
                  value +
                '}';
    }



    public static List<Pair<String,Integer>> mapperListMaker(String fPath) throws IOException {
        List<Pair<String, Integer>> mainList = new ArrayList<>();

        String[] myArray = fileReader(fPath);

        List<String> wordList = filter(myArray);


        for (String e : wordList) {
            mainList.add(new Pair<>(e,1));
            // System.out.println(e);
        }

        Collections.sort(mainList,  (e1,e2) -> e1.getKey().compareTo(e2.getKey()));

        return mainList;

//        for (Mapper p: mainList) {
//            System.out.println(p);}
//
//
//
    }

    /**
     * File reader
     * @param folder
     * @return
     * @throws IOException
     */

public static String[]  fileReader(String folder) throws IOException {

    File fr = null;
    BufferedReader bf = null;
    try {
        fr = new File(folder);
        bf = new BufferedReader(new FileReader(fr));

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
    return myArray;


}

    /**
     * Filterout all the words which are not words according to the given requirement.
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
    /**
     * Reading from the file.
     */

    public static void main(String[] args) throws IOException {

        String fPath = "C:\\Users\\ayu\\Desktop\\testDataForW1D1.txt";
        // List<String> mywordList = new ArrayList<String>();

        List<Pair<String, Integer>> mainList = mapperListMaker(fPath);

        for(Pair m: mainList) System.out.println(m);
    }

}


///////////////////////////// Out put \\\\\\\\\\\\\\\\\\\\\\\\\\\\

/*
{a, 1}
{a, 1}
{a, 1}
{a, 1}
{and, 1}
{and, 1}
{and, 1}
{and, 1}
{are, 1}
{as, 1}
{as, 1}
{cat, 1}
{cat, 1}
{collections, 1}
{comparator, 1}
{each, 1}
{each, 1}
{extract, 1}
{for, 1}
{form, 1}
{given, 1}
{inserted, 1}
{integer, 1}
{into, 1}
{involve, 1}
{is, 1}
{is, 1}
{is, 1}
{is, 1}
{key, 1}
{list, 1}
{list, 1}
{may, 1}
{not, 1}
{note, 1}
{note, 1}
{output, 1}
{pair, 1}
{pair, 1}
{pair, 1}
{program, 1}
{program, 1}
{same, 1}
{should, 1}
{sort, 1}
{such, 1}
{that, 1}
{that, 1}
{the, 1}
{the, 1}
{the, 1}
{the, 1}
{the, 1}
{the, 1}
{the, 1}
{this, 1}
{tokens, 1}
{treat, 1}
{two, 1}
{using, 1}
{value, 1}
{where, 1}
{will, 1}
{word, 1}
{word, 1}
{writing, 1}
{your, 1}
*/
