//{ Driver Code Starts
//

import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        head = tail = new Node(val);
        
        size--;
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Solution obj = new Solution();
            
            Node result = obj.findIntersection(head1, head2);
            
            printList(result);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* structure of list Node:

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

*/

class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        Node temp=head2;
        HashMap<Integer,Integer> map=new  HashMap<>();
        while(temp!=null)
        {
            if(map.containsKey(temp.data))
                map.put(temp.data,map.get(temp.data)+1);
            else
                map.put(temp.data,1);
            temp=temp.next;
        }
        temp=head1;
        Node ans=new  Node(0);
        ans.next=null;
        Node temp2=ans;
        while(temp!=null)
        {
            if(map.containsKey(temp.data))
            {
                Node tmp=new  Node(temp.data);
                tmp.next=null;
                temp2.next=tmp;
                temp2=temp2.next;
                map.put(temp.data,map.get(temp.data)-1);
                if(map.get(temp.data)==0)
                    map.remove(temp.data);
            }
            temp=temp.next;
        }
        return ans.next;
    }
}