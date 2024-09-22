
class Solution {
    
    public int calculateSteps(int n, long curr, long next) {
        int count = 0;

        while (curr <= n) {
            count += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return count;
    }

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = calculateSteps(n, curr, curr + 1);

            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                k--;
                curr *= 10;
            }
        }
        return curr;
    }
}