class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int covered=guards.length + walls.length;
        char matrix[][]=new  char[m][n];
        for(int[] i:guards)
            matrix[i[0]][i[1]]='G';
        for(int[] i:walls)
            matrix[i[0]][i[1]]='W';
        // for(int i=0;i<m;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         if(matrix[i][j]=='G')
        //         {
        //             for(int k=j+1;k<n && matrix[i][k]!='G' && matrix[i][k]!='W';k++)
        //             {
        //                 if(matrix[i][k]!='C')
        //                     covered++;
        //                 matrix[i][k]='C';
        //             }
        //             for(int k=i+1;k<m && matrix[k][j]!='G' && matrix[k][j]!='W';k++)
        //             {
        //                 if(matrix[k][j]!='C')
        //                     covered++;
        //                 matrix[k][j]='C';
        //             }
        //         }
        //         else if(matrix[i][j]=='')
        //         {
        //             for(int k=i+1;k<m;k++)
        //             {
        //                 if(matrix[i][j]=='G')

        //             }
        //         }
        //     }
        // }
        for(int i[]:guards)
        {
            for(int k=i[0]-1;k>=0 && matrix[k][i[1]]!='W' && matrix[k][i[1]]!='G';k--)//up
            {
                if(matrix[k][i[1]]!='C')
                    covered++;
                matrix[k][i[1]]='C';
            }
            for(int k=i[0]+1;k<m && matrix[k][i[1]]!='W' && matrix[k][i[1]]!='G';k++)//down
            {
                if(matrix[k][i[1]]!='C')
                    covered++;
                matrix[k][i[1]]='C';
            }
            for(int k=i[1]-1;k>=0 && matrix[i[0]][k]!='W' && matrix[i[0]][k]!='G';k--)//left
            {
                if(matrix[i[0]][k]!='C')
                    covered++;
                matrix[i[0]][k]='C';
            }
            for(int k=i[1]+1;k<n && matrix[i[0]][k]!='W' && matrix[i[0]][k]!='G';k++)//left
            {
                if(matrix[i[0]][k]!='C')
                    covered++;
                matrix[i[0]][k]='C';
            }
        }
        return (m*n)-covered;
    }
}