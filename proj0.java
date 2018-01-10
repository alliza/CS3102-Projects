/*Question
  The Project 0 code is a just a review:

  Read a file containing a list of up to 256 words.
  Store them in a simple array (not a vector or ArrayList).
  Print them in alphabetical order.
  You have undoubtedly encountered basic sorting in your Introduction to Programming coursework, so implement one of the algorithms you learned there.

  To begin, create a directory called prog0 to store the project files.

  If you are a Java user, add the following Java framework code into to a file named Prog0.java in the prog0 directory.

  // Programming Project 0
  // Mike Tiger VI <mtiger6@lsu.edu>

  import java.io.*;
  import java.util.Scanner;

  public class Prog0 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File(args[0]));

        while (input.hasNext()) {
            // etc...
        }

        // etc...
    }
}
*/
/*
input.txt
buy it use it break it fix it trash it change it mail upgrade it charge it point it zoom it press it snap it 
work it quick erase it write it cut it paste it save it load it check it quick rewrite it plug it play it burn 
it rip it drag it drop it zip unzip it lock it fill it call it find it view it code it jam unlock it surf it scroll 
it pause it click it cross it crack it switch update it name it read it tune it print it scan it send it fax rename it 
touch it bring it pay it watch it turn it leave it stop format it
*/

// Programming Project 0
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Prog0 { 
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        Scanner input = new Scanner(new File(args[0]));
        String[] arr = new String[256];
        int i = 0;
        String temp;
        
        while(input.hasNext())
        {
            arr[i] = input.next();
            i++;
        }
        for(int n = 0; n < i - 1; n++)
        {
            for(int j = 0; j < i - 1;j++)
            {
                if( arr[j].compareTo(arr[j+1]) > 0)
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int k = 0; k < i ; k++)
        {
            System.out.print(arr[k]+" ");
        }
    }
    
}
