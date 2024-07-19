class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row[]=new  int[matrix.length];
        int col[]=new  int[matrix[0].length];
        int tmp;
        List<Integer> list=new  ArrayList<>();
        for(int i=0;i<matrix.length;i++)
        {
            tmp=matrix[i][0];
            for(int j=1;j<matrix[i].length;j++)
            {
                if(matrix[i][j]<tmp)
                    tmp=matrix[i][j];
            }
            row[i]=tmp;
        }
        for(int j=0;j<matrix[0].length;j++)
        {
            tmp=matrix[0][j];
            for(int i=1;i<matrix.length;i++)
            {
                if(matrix[i][j]>tmp)
                    tmp=matrix[i][j];
            }
            col[j]=tmp;
        }
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++)
                if(row[i]==col[j])
                    list.add(row[i]);
        return list;
    }
}