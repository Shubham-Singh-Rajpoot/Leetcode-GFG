class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] preSum = new long[nums.length + 1];
        for (int i = 1; i < preSum.length; i++)
            preSum[i] = preSum[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < preSum.length; i++) {
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - deque.peekFirst());
                deque.removeFirst();
            }
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        if (minLen != Integer.MAX_VALUE)
            return minLen;
        else
            return -1;
    }
}