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
    List<Integer> list=new  ArrayList<>();
    public TreeNode balanceBST(TreeNode root)
    {
        Inorder(root);
        root=helper(0,list.size()-1);
        return root;
    }
    public void Inorder(TreeNode root)
    {
        if(root==null)
            return;
        Inorder(root.left);
        list.add(root.val);
        Inorder(root.right);
    }
    public TreeNode helper(int low,int high)
    {
        if(low>high)
            return null;
        int mid=(low+high)/2;
        TreeNode temp=new  TreeNode(list.get(mid),helper(low,mid-1),helper(mid+1,high));
        return temp;
    }
}