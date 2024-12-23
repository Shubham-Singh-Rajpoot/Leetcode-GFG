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
    public int minimumOperations(TreeNode root)
    {
        if (root == null)
            return 0;
        List<List<Integer>> levels=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> currentLevel=new ArrayList<>();
            for (int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                currentLevel.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            levels.add(currentLevel);
        }
        int totalSwaps=0;
        for (List<Integer> level:levels)
            totalSwaps+=countSwaps(level);
        return totalSwaps;
    }
    private int countSwaps(List<Integer> level)
    {
        int n=level.size();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=level.get(i);
        int[] sorted=arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> indexMap=new HashMap<>();
        for(int i=0;i<n;i++)
            indexMap.put(sorted[i],i);
        boolean[] visited=new boolean[n];
        int swaps=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i] || arr[i]==sorted[i])
                continue;
            int cycleSize=0;
            int j=i;
            while(!visited[j])
            {
                visited[j]=true;
                j=indexMap.get(arr[j]);
                cycleSize++;
            }
            if(cycleSize > 0)
                swaps+=(cycleSize-1);
        }
        return swaps;
    }
}