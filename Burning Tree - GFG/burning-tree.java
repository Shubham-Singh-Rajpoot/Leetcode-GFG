//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    static HashMap<Node,Node> map=new HashMap<>();
    static Node targetroot;
    public static int minTime(Node root, int target) 
    {
        int ans=0;
        traverse(root,target,null);
        HashSet<Node> set=new  HashSet<>();
        List<Node> queue=new  ArrayList<>();
        queue.add(targetroot);
        while(queue.size()!=0)
        {
            ans=ans+1;
            int s=queue.size();
            for(int i=0;i<s;i++)
            {
                Node temp=queue.get(0);
                queue.remove(0);
                set.add(temp);
                if(!(set.contains(map.get(temp)))&&map.get(temp)!=null)
                    queue.add(map.get(temp));
                if(!(set.contains(temp.right))&&temp.right!=null)
                    queue.add(temp.right);
                if(!(set.contains(temp.left))&&temp.left!=null)
                    queue.add(temp.left);
            }
        }
        return ans-1;
    }
    public static void traverse(Node root,int target,Node parent)
    {
        map.put(root,parent);
        if(root.data==target)
            targetroot=root;
        if(root.left!=null)
            traverse(root.left,target,root);
        if(root.right!=null)
            traverse(root.right,target,root);
    }
}