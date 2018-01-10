
package prog2;
/*
Programming Project 2
Aliza Bista <abista3@lsu.edu>
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Prog2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File(args[0]));
        AVLTree a = new AVLTree();
        while(file.hasNext()){
          String Check = file.next();
            if(Check.compareTo("insert") == 0){
                a.insert(file.next(), Integer.parseInt(file.next()));
            }
            if(Check.compareTo("remove") == 0){
                a.remove(file.next());
            }
            if(Check.compareTo("show") == 0){
                System.out.println(a.show());    
            } 
        }
    }      
}
