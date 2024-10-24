class Solution {
    public void solve(TreeNode root) {
        if (root == null) return;

        Queue<Pair<Integer, Pair<TreeNode, Integer>>> q = new LinkedList<>();
        Queue<Pair<Integer, Pair<TreeNode, Integer>>> cpy = new LinkedList<>();
        List<Integer> levelSum = new ArrayList<>();
        int level = 0;

        levelSum.add(root.val);
        q.offer(new Pair<>(level, new Pair<>(root, root.val)));
        cpy.offer(new Pair<>(level, new Pair<>(root, root.val)));

        while (!q.isEmpty()) {
            int n = q.size();
            int lvlSum = 0;

            while (n-- > 0) {
                TreeNode node = q.peek().getValue().getKey();
                q.poll();
                int sibSum = 0;

                if (node.left != null) sibSum += node.left.val;
                if (node.right != null) sibSum += node.right.val;

                if (node.left != null) {
                    q.offer(new Pair<>(level + 1, new Pair<>(node.left, sibSum)));
                    cpy.offer(new Pair<>(level + 1, new Pair<>(node.left, sibSum)));
                }

                if (node.right != null) {
                    q.offer(new Pair<>(level + 1, new Pair<>(node.right, sibSum)));
                    cpy.offer(new Pair<>(level + 1, new Pair<>(node.right, sibSum)));
                }

                lvlSum += sibSum;
            }

            levelSum.add(lvlSum);
            level++;
        }

        while (!cpy.isEmpty()) {
            int lvl = cpy.peek().getKey();
            int sibSum = cpy.peek().getValue().getValue();
            TreeNode node = cpy.peek().getValue().getKey();
            cpy.poll();

            node.val = levelSum.get(lvl) - sibSum;
        }
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        solve(root);
        return root;
    }
}