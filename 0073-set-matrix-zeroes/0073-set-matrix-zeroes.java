class Solution {
    public void setZeroes(int[][] matrix) {
        int i,j;
        List<Integer> row=new  ArrayList<>();
        List<Integer> col=new  ArrayList<>();
        for(i=0;i<matrix.length;i++)
            for(j=0;j<matrix[0].length;j++)
                if(matrix[i][j]==0)
                {
                    row.add(row.size(),i);
                    col.add(col.size(),j);
                }
        for(i=0;i<row.size();i++)
            for(j=0;j<matrix[0].length;j++)
                matrix[row.get(i)][j]=0;
        for(i=0;i<col.size();i++)
            for(j=0;j<matrix.length;j++)
                matrix[j][col.get(i)]=0;
    }
}