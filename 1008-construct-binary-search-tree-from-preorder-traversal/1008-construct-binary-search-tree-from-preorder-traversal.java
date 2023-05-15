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
    int curr=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int inorder[]=new  int[preorder.length];
        int i;
        for(i=0;i<preorder.length;i++)
            inorder[i]=preorder[i];
        Arrays.sort(inorder);
        for(i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return traverse(preorder,0,preorder.length);
    }
    public TreeNode traverse(int []preorder,int leftlimit,int rightlimit)
    {
        if(leftlimit==rightlimit)
            return null;
        TreeNode root=new  TreeNode(preorder[curr]);
        int index=map.get(root.val);
        curr+=1;
        root.left=traverse(preorder,leftlimit,index);
        root.right=traverse(preorder,index+1,rightlimit);
        return root;
    }
}