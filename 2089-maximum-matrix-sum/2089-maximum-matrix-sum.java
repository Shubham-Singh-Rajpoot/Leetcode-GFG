class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        long sum = 0;
        int negativeCount = 0;
        int lowest = Integer.MAX_VALUE;
        for (int[] rows : matrix)
        {
            for (int column = 0; column < m; column++)
            {
                if (rows[column] < 0)
                    negativeCount++;
                lowest = Math.min(lowest, Math.abs(rows[column]));
                sum += Math.abs(rows[column]);
            }
        }
        
        return negativeCount % 2 == 0 ? sum : (sum - (2L * lowest));
    }
}