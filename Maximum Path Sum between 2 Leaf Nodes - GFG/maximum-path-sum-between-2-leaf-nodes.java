//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution ob = new Solution();
            System.out.println(ob.maxPathSum(root));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution
{   
    Node setTree(Node root) {
      Node temp = new Node(0);
      if (root.right == null) {
          root.right = temp;
      } else {
          root.left = temp;
      }
      return root;
    }
    
    int maxPathSum(Node root) { 
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        if (root.left == null || root.right == null) {
            root = setTree(root);
        }
        maxPathSumUtil(root, res);
        return res.val;
    }
    
    int maxPathSumUtil(Node node, Res res) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.data;
 
        int ls = maxPathSumUtil(node.left, res);
        int rs = maxPathSumUtil(node.right, res);
 
        if (node.left != null && node.right != null) {
            res.val = Math.max(res.val, ls + rs + node.data);
            return Math.max(ls, rs) + node.data;
        }
        return node.left == null ? rs + node.data : ls + node.data;
    }
}

class Res {
    int val;
}