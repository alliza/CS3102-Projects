
package prog2;
/*
A self balancing tree(AVL tree)
*/
public class AVLTree {
    /*
    the root of this tree
    */
    public Node Root;
    /*
    a node of a tree that stores String as key and int as value and refrences
    child node to the left and right
    *keep the hight update at every node of the tree
    */
    private class Node{
        /*
        a refrence to the left subtree rooted at that node
        */
        public Node left;
        /*
        a refrence to the right subtree rooted at that node
        */
        public Node right;
        /*
        value stored at this node
        */
        public int value;
        /*
        key strored at this node
        */
        public String key;
        /*
        height at this node
        */
        public int height;
        /*
        paramarized constructor at assign particular values to each variable of the node class
        */
        
        public Node(String key, int value,Node left,Node right){
            this.value = value;
            this.key = key;
            this.left = left;
            this.right = right;
            
           int l = 0, r = 0;
           if(left != null)
           {
               l = left.height;
           }
           if(right != null){
               r = right.height;
           }
           this.height = 1 + Math.max(l, r);
        }
    }
    /*
    construct an empty AVL tree
    */
    public AVLTree(){
        Root = null;
    }
    
    /*
    Insert the values to the node
    @param k and value are the values to be inserted
    */
    public Node insert(String k, int value){
        return insert(Root, k, value);
    }
    
    /*
    a recursive auxillary method for the insersition
    @param n is the refrence to the node object
    @param k and the v are the values to be inserted
    */
    private Node insert( Node n, String k, int v){
         if(n == null){
            Root = (new Node(k, v,null, null));
        }
         else if(k.compareTo(n.key) > 0){
            Root = (new Node(n.key,n.value, n.left,insert(n.right, k, v)));
        }
        else{
            Root = (new Node(n.key,n.value, insert(n.left, k, v), n.right));
        }
         if(Root.left != null){
         }
         if(Root.right!= null){
         }
         return toAVL(Root);
    }
    /*
    refrencing to the minimum value node in a tree
    */
    
    public Node findMin(Node v){
        if(v.left == null)
            return v;
        else
           return findMin(v.left);
    }
    /*
    Finding the minimum value in the right subtree of the node
    */
    
    public Node findSuccessor(Node v){
        if(v.right != null){
            return findMin(v.right);
        }
       
        return v;
    }
   /*
    to remove the required value from the tree
    @param k is the key that is to be removed from the tree
    */
    public Node remove(String k){
        return remove (Root, k);
    }
    /*
    A recursive method that remove the required value from the tree
    @param v is the refrence node and k is the key to be removed
    */
    private Node remove(Node v, String k){
        if(v.key == null){
            return null;
        }
        else if(k.compareTo(v.key) < 0){
            Root = (new Node (v.key,v.value,remove(v.left, k), v.right));
        }
       else if(k.compareTo(v.key) > 0){
            
            Root = (new Node (v.key,v.value,v.left, remove(v.right, k)));
        }
        else{
            if(v.left != null && v.right != null){
                Node NS = findSuccessor(v.right);
                Root = (new Node(NS.key,NS.value,v.left, remove(v.right,NS.key)));
            }
            else if(v.right == null){
                Root = (v.left);
            }
            else
                Root = (v.right);
            }
        return toAVL(Root);
    }
    /*
    method that restructure the tree for the unbalance condition at left and left
    @param z, refrence node where the tree is unbalanced,
    @param y, left child node of z with higher hight and x, the left child node of y with higher hight
    */
   
   private Node reStructureLL(Node z, Node y, Node x){
       Root = new Node(y.key, y.value,
                       new Node(x.key, x.value, x.left, x.right), 
                       new Node(z.key, z.value, y.right, z.right));
       return Root;
   }
    /*
    method that restructure the tree for the unbalance condition at right and right
    @param z, refrence node where the tree is unbalanced,
    @param y, right child node of z with higher hight and x, the right child node of y with higher hight
    */
   
   private Node reStructureRR(Node z, Node y, Node x){
       Root = new Node(y.key, y.value, 
                       new Node(z.key, z.value, z.left, y.left), 
                       new Node (x.key, x.value, x.left, x.right));
       return Root;
   }
    /*
    method that restructure the tree for the unbalance condition at left and right
    @param z, refrence node where the tree is unbalanced,
    @param y, left child node of z with higher hight and x, the right child node of y with higher hight
    */
   
   private Node reStructureLR(Node z, Node y, Node x){
       Root = new Node(x.key,x.value, 
                       new Node(y.key, y.value,y.left, x.left),
                       new Node(z.key,z.value,x.left,z.right));
       return Root;
   }
   
    /*
    method that restructure the tree for the unbalance condition at Right and left
    @param z, refrence node where the tree is unbalanced,
    @param y, right child node of z with higher hight and x, the lrft child node of y with higher hight
    */
   private Node reStructureRL(Node z, Node y, Node x){
       Root = new Node (x.key, x.value,
                        new Node (z.key, z.value, z.left,x.left),
                        new Node(y.key, y.value, x.right,y.right));
       return Root;
   }
   
    /*
    method that restructure the tree for the unbalance condition at left subtree
    @param z, refrence node where the tree is unbalanced,
    @param y, left child node of z 
    htis method recursevely the suitable restructure methods between (LR or LL)
    */
   private Node reStructureL(Node z, Node y){
       int l = 0, r = 0;
       if( y.left != null){
            l = y.left.height;
       }
       if(y.right != null){
           r = y.right.height;
       }
       if(l < r)
           return reStructureLR(z, y, y.right);
       else
           return reStructureLL(z, y, y.left);
   }
   /*
    method that restructure the tree for the unbalance condition at right subtree
    @param z, refrence node where the tree is unbalanced,
    @param y, right child node of z 
    htis method recursevely the suitable restructure methods between (RR or RL)
    */
   private Node reStructureR(Node z, Node y){
       int l = 0, r = 0;
       if(z.left != null){
            l = z.left.height;
       }
       if(z. right != null){
           r = z.right.height;
       }
       if(l < r){
           return reStructureRR(z, y, y.right);
       }
       else{
           return reStructureRL(z, y, y.left);
       }
   }
   /*
   this method checks if the tree is balanced at every node of the tree and recursively 
   calls the method reStructureL and reStructureL according to the requirements.
   @param z is the refrence node of the tree.
   */
   
   public Node toAVL(Node z){
       
       int l = 0, r = 0;
       if(z != null && z.left != null){
            l = z.left.height;
       }
       if(z != null && z.right != null){
           r = z.right.height;
       }
       if(l > r + 1){
           return reStructureL(z, z.left);
       }
       else if (r > l + 1){
               return reStructureR(z, z.right);
       }
       else
           return z;
   }
   /*
   Show method print the every node's key and value with proper indentation for the node at same level
   */
   public String show(){
       int Count = 0;
       return show(Root,Count);  
   }
   /*
   A auxillary recursive method that give the required figure of the given tree
   */
   private String show(Node n,int Count){
       String s = "" ;
     for(int i = 0; i < Count; i++){
           s = s+"  ";
       }
      s = s + n.key +" "+ n.value+"\n";
       if(n.left != null){
           if(n.right != null){
               Count += 1;
               s = s+show(n.left,Count)+ show(n.right,Count); 
           }
           else{
               Count += 1;
               s = s +show(n.left,Count);
           }
       }
       else{
           if(n.right != null){
               Count +=1;
               s = s +show(n.right,Count);
           }
           else{
               s = s;
           }
       }
       return s;
    }
}
