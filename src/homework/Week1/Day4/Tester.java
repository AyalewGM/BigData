package homework.Week1.Day4;

import java.util.Scanner;

/**
 * Created by Ayu on 5/5/2017.
 */
public class Tester {
    public static void main(String[] args) {
      System.out.println("Enter the number of splits");
      Scanner sc = new Scanner(System.in);
        int numberOfSplit = sc.nextInt();


        FileReader fileReader= new FileReader();
        System.out.println( fileReader.getClass().getSimpleName());


    }


}
