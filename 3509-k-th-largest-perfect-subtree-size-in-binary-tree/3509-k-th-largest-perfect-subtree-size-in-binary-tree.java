/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    PriorityQueue<Integer> pq=new  PriorityQueue<>((a,b)->b-a);
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        traverse(root);
        //System.out.println(pq);
        for(int i=0;i<k-1 && !pq.isEmpty();i++)
            pq.poll();
        if(pq.size()==0)
            return -1;
        else
            return pq.poll();
    }
    public int[] traverse(TreeNode root)
    {
        int ans[]=new  int[3];
        //ans[0] is number of nodes
        //ans[1] is to calculate height
        //ans[2] is answer
        if(root==null)
            return ans;
        int left[]=traverse(root.left);
        int right[]=traverse(root.right);
        //System.out.print(root.val+"  "+left[0]+" "+left[1]+" "+left[2]+"  "+right[0]+" "+right[1]+" "+right[2]+"  ");
        if(left[0]==right[0] && left[1]==right[1] && left[2]!=-1 && right[2]!=-1)
        {
            ans[0]=left[0]+right[0]+1;
            ans[1]=left[1]+1;
            ans[2]=left[0]+right[0]+1;
            pq.add(ans[2]);
        }
        else if(left[0]!=right[0] || left[1]!=right[1] || left[2]==-1 || right[2]==-1)
            ans[2]=-1;
        //System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
        return ans;
    }
}