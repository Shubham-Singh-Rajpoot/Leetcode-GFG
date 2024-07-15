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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map=new  HashMap<>();
        HashSet<Integer> set=new  HashSet<>();
        for(int i=0;i<descriptions.length;i++)
            set.add(descriptions[i][0]);
        for(int i=0;i<descriptions.length;i++)
        {
            if(!map.containsKey(descriptions[i][0]))
                map.put(descriptions[i][0],new  TreeNode(descriptions[i][0]));
            if(!map.containsKey(descriptions[i][1]))
                map.put(descriptions[i][1],new  TreeNode(descriptions[i][1]));
            if(set.contains(descriptions[i][1]))
                set.remove(descriptions[i][1]);
            if(descriptions[i][2]==1)
                map.get(descriptions[i][0]).left=map.get(descriptions[i][1]);
            else
                map.get(descriptions[i][0]).right=map.get(descriptions[i][1]);
        }
        Iterator<Integer> it=set.iterator();
        return map.get(it.next());
    }
}