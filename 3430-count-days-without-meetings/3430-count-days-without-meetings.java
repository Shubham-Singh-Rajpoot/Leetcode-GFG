class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0, start = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > start)
                res += meeting[0] - start - 1;
            start = Math.max(start, meeting[1]);
        }
        res += days - start;
        return res;
    }
}