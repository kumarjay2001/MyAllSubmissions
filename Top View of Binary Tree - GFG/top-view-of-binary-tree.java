//{ Driver Code Starts
//Initial Template for JAVA

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

public class Tree {
    
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
    static void printInorder(Node root)
    {
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

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
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
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
   static class Pair{
        Node curr;
        int hd;
       public Pair(Node curr,int hd){
            this.curr=curr;
            this.hd=hd;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> al=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        if(root==null){
            return al;
        }
        int mini=0,maxi=0;
        HashMap<Integer,Node> hm=new HashMap<>();
        q.add(new Pair(root,0));
        q.add(null);
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                Pair curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }
                }else{
                    if(!hm.containsKey(curr.hd)){
                        hm.put(curr.hd,curr.curr);
                    }
                    if(curr.curr.left!=null){
                        q.add(new Pair(curr.curr.left,curr.hd-1));
                        mini=Math.min(mini,curr.hd-1);
                    }
                    if(curr.curr.right!=null){
                        q.add(new Pair(curr.curr.right,curr.hd+1));
                        maxi=Math.max(maxi,curr.hd+1);
                    }
                }
            }
        }
        
       for(int i=mini;i<=maxi;i++){
           al.add(hm.get(i).data);
       }
       return al;
    }
}