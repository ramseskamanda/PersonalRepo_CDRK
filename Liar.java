import java.util.*;
import java.lang.Math;

public class Liar {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	while(true){
            System.out.println("Please enter an integer or 0000 to exit to bonus: ");
            int x = in.nextInt();
            if(x==0000){
                break;
            }
            double prob = Math.random();
            if(x % 2 == 0){
                if(prob <= 0.1){
                    System.out.println("Odd.");
                } else {
                    System.out.println("Even");
                }
            } else {
                if(prob <= 0.1){
                    System.out.println("Even.");
                } else {
                    System.out.println("Odd");
                }
            }
        }
        String[] unsorted = {"dog", "cat", "zebra", "turtle", "dogs"};
        String[] sorted = selection_sort(unsorted);
        for(int i = 0; i < sorted.length; i++){
            System.out.print(sorted[i]);
            System.out.print(", ");
        }
        System.out.print("\n");
        /*
            The short way that works perfectly
        */
        List<String> unsorted_list = Arrays.asList(unsorted);
        java.util.Collections.sort(unsorted_list);
        for(String s:unsorted_list){
            System.out.print(s + ", ");
        }
    }

    public static String[] selection_sort(String[] strings) {
        /*
            The long way that only works in theory but I made myself
        */
        for(int i = 0; i < strings.length-1; i++){
            int index = i;
            for(int j = i+1; j < strings.length; j++)
                if(strings[j].compareTo(strings[index]) == -1)
                    index = j;

            String smallerString = strings[index];
            strings[index] = strings[i];
            strings[i] = smallerString;
        }
        return strings;
    }
}