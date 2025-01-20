class Solution
{
    public int firstCompleteIndex(int[] arr, int[][] mat)
    {
        HashMap<Integer,int[]> pos=new  HashMap<>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                int temp[]={i,j};
                pos.put(mat[i][j],temp);
            }
        }
        int rowpainted[]=new  int[mat.length];
        int colpainted[]=new  int[mat[0].length];
        for(int i=0;i<arr.length;i++)
        {
            int loc[]=pos.get(arr[i]);
            rowpainted[loc[0]]++;
            colpainted[loc[1]]++;
            if(rowpainted[loc[0]]==mat[0].length || colpainted[loc[1]]==mat.length)
                return i;
        }
        return arr.length-1;
    }
}