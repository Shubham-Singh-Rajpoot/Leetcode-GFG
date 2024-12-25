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
    int maxl=-1;
    public List<Integer> largestValues(TreeNode root)
    {
        dfs(root,0);
        List<Integer> list=new  ArrayList<>();
        for(int i=0;i<=maxl;i++)
            list.add(list.size(),map.get(i));
        return list;
    }
    public void dfs(TreeNode root,int level)
    {
        if(root==null)
            return;
        if(level>maxl)
            maxl=level;
        if(map.containsKey(level))
        {   
            if(map.get(level)<root.val)
                map.put(level,root.val);
        }
        else
            map.put(level,root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}