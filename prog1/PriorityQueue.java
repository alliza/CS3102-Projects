
package prog1;
import java.util.Arrays;
public class PriorityQueue {
    int position;
    Node[] NodeArr;
     public PriorityQueue(){
        NodeArr = new Node[255];
        position = 0;
    }
     /*
     Insert name and Priority in array
     */
     public void insert(String name, int Priority){
       
            NodeArr[position] = new Node(name, Priority);
            bubbleUp();
            position +=1;
    }
     /*
     shift big value to parent node
     */
    public void bubbleUp(){
        int pos = position;
        while(pos > 0 && NodeArr[(pos-1)/2].Priority < NodeArr[pos].Priority){
            Node temp = NodeArr[(pos-1)/2];
            NodeArr[(pos-1)/2] = NodeArr[pos];
            NodeArr[pos] = temp;
            pos = (pos-1)/2;
        }
    }
    /*
    remove the max priority from array
    */
    public String remove(){
            Node temp2 = NodeArr[0];    
            NodeArr[0] = NodeArr[position -1];
            position--;
            bubbleDown(0);
            return temp2.name;
    }
    /*
    move the smaller value to chile node
    */
    public void bubbleDown(int n){
       Node temp1 = NodeArr[n];
      int max = n;
      int lC = (2*n)+1;
      int rC = (2*n)+2;
      if(lC < position && NodeArr[max].Priority < NodeArr[lC].Priority){
        max = lC;
        }
      if(rC < position && NodeArr[max].Priority < NodeArr[rC].Priority){
        max = rC;
        }
      if(max != n){
          Node temp2 = NodeArr[n];
          NodeArr[n] = NodeArr[max];
          NodeArr[max] = temp1;
          bubbleDown(max);
        }
    }
}
