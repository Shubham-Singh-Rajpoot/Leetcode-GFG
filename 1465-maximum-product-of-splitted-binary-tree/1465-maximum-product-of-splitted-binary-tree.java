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
    public int maxProduct(TreeNode root)
    {
        long max=0,treesum=0;
        treesum=sum(root);
        for(int i=0;i<list.size();i++)
            max=Math.max(max,(treesum-list.get(i))*list.get(i));
        return (int)(max%1000000007);
    }
    public int sum(TreeNode root)
    {
        if(root==null)
            return 0;
        int ls=sum(root.left);
        int rs=sum(root.right);
        list.add(root.val+ls+rs);
        return root.val+ls+rs;
    }
}