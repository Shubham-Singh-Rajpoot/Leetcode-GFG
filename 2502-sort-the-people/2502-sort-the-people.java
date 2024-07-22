class Solution {
    public String[] sortPeople(String[] names, int[] heights)
    {
        int index=0;
        String stemp;
        int temp;
        for(int i=0;i<heights.length-1;i++)
        {
            index=i;
            for(int j=i+1;j<heights.length;j++)
                if(heights[j]>heights[index])
                    index=j;
            temp=heights[index];
            heights[index]=heights[i];
            heights[i]=temp;
            stemp=names[index];
            names[index]=names[i];
            names[i]=stemp;
        }
        return names;
    }
}