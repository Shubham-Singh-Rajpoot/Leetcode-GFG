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
    public TreeNode reverseOddLevels(TreeNode root)
    {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOddLevel = false;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode currentNode = queue.poll();
                levelNodes.add(currentNode);
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null) 
                    queue.offer(currentNode.right);
            }
            if (isOddLevel)
            {
                int left = 0, right = levelNodes.size() - 1;
                while (left < right)
                {
                    int temp = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            isOddLevel = !isOddLevel;
        }
        return root;
    }
}