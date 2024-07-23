class Solution {
    public int[] frequencySort(int[] nums) {
        int map[][]=new int[201][2];
        for(int i=0;i<nums.length;i++)
        {
            map[nums[i]+100][0]=nums[i];
            map[nums[i]+100][1]++;
        }
        int temp;
        Arrays.sort(map,(a,b)->Integer.compare(a[1],b[1]));
        for(int i=0;i<map.length;i++)
        {
            for(int j=i+1;j<map.length && map[j][1]==map[i][1];j++)
            {
                if(map[j][0]>map[i][0])
                {
                    temp=map[i][0];
                    map[i][0]=map[j][0];
                    map[j][0]=temp;
                }
            }
        }
        temp=0;
        for(int i=0;i<map.length;i++)
        {
            while(map[i][1]!=0)
            {
                nums[temp++]=map[i][0];
                map[i][1]--;
            }
        }
        return nums;
    }
}