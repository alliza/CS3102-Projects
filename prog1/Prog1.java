
package prog1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Prog1 {
    public static void main(String[] args) throws FileNotFoundException {
     
       Scanner input = new Scanner(new File(args[0]));
       PriorityQueue m = new PriorityQueue();
       String[] arr = new String[300];
       int a = 0, i =0;
       while(input.hasNext())
       {
        arr[a] = input.next();
        a++;
       }
       while(arr[i] != null)
       {
           if(arr[i].compareTo("insert") == 0){
              m.insert(arr[i + 1], Integer.parseInt(arr[i+2]));
              i = i+3;
           }
           else
           {
               System.out.println(m.remove());
               i = i+1;
           }
       }
    }
    
}
