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
    List<TreeNode> list=new  ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete)
    {
        list.add(root);
        boolean flag=false;
        for(int i=0;i<to_delete.length;i++)
        {
            for(int j=0;j<list.size();j++)
            {
                flag=delete(list.get(j),to_delete[i],null,1);
                if(flag==true)
                    break;
            }
        }
        return list;
    }
    public boolean delete(TreeNode root,int target,TreeNode prev,int left)
    {
        if(root==null)
            return false;
        if(root.val==target)
        {
            if(root.left!=null)
                list.add(root.left);
            if(root.right!=null)
                list.add(root.right);
            if(prev!=null)
            {
                if(left==1)
                    prev.left=null;
                else
                    prev.right=null;
            }
            else
            {
                for(int i=0;i<list.size();i++)
                {
                    if(list.get(i)==root)
                    {
                        list.remove(i);
                        return true;
                    }
                }
            }
        }
        return delete(root.left,target,root,1) || delete(root.right,target,root,0);
    }
}