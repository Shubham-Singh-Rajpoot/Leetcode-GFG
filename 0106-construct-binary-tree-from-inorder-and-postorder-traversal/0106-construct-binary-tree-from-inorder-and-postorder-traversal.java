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
    HashMap<Integer,Integer> map=new  HashMap<>();
    HashMap<Integer,Integer> postmap=new  HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
            postmap.put(postorder[i],i);
        }
        return traverse(postorder,inorder,0,inorder.length-1);
    }
    public TreeNode traverse(int postorder[],int inorder[],int i,int j)
    {
        if(i>j)
            return null;
        int maxindex=0;
        for(int k=i;k<=j;k++)
            maxindex=Math.max(maxindex,postmap.get(inorder[k]));
        TreeNode temp=new  TreeNode(postorder[maxindex]);
        temp.left=traverse(postorder,inorder,i,map.get(postorder[maxindex])-1);
        temp.right=traverse(postorder,inorder,map.get(postorder[maxindex])+1,j);
        return temp;
    }
}