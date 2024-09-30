class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2)
    {
        int max=0;
        HashSet<Integer> set=new  HashSet<>();
        for(int i=0;i<arr1.length;i++)
        {
            while(arr1[i]!=0)
            {
                set.add(arr1[i]);
                arr1[i]/=10;
            }
        }
        for(int i=0;i<arr2.length;i++)
        {
            while(arr2[i]!=0)
            {
                if(set.contains(arr2[i]))
                {
                    max=Math.max(max,arr2[i]);
                    break;
                }
                arr2[i]/=10;
            }
        }
        if(max==0)
            return 0;
        int len=0;
        while(max!=0)
        {
            len++;
            max/=10;
        }
        return len;
    }
}