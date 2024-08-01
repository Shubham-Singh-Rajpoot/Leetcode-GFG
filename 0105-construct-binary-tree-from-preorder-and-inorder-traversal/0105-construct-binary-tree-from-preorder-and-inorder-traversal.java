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
class Solution
{
    HashMap<Integer,Integer> map=new  HashMap<>();
    HashMap<Integer,Integer> premap=new  HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
            premap.put(preorder[i],i);
        }
        return traverse(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode traverse(int preorder[],int inorder[],int i,int j)
    {
        if(i>j)
            return null;
        int minindex=inorder.length-1;
        for(int k=i;k<=j;k++)
            minindex=Math.min(minindex,premap.get(inorder[k]));
        TreeNode temp=new  TreeNode(preorder[minindex]);
        temp.left=traverse(preorder,inorder,i,map.get(preorder[minindex])-1);
        temp.right=traverse(preorder,inorder,map.get(preorder[minindex])+1,j);
        return temp;
    }
}