class Solution {
    public String[] createGrid(int m, int n) {
        String ar[]=new  String[m];
        StringBuilder temp=new  StringBuilder();
        for(int i=0;i<n;i++)
            temp.append('.');
        ar[0]=temp.toString();
        for(int i=1;i<m;i++)
        {
            StringBuilder str=new StringBuilder();
            for(int j=0;j<n;j++)
            {
                if(j==n-1)
                    str.append('.');
                else
                    str.append('#');
            }
            ar[i]=str.toString();
        }
        return ar;
    }
}