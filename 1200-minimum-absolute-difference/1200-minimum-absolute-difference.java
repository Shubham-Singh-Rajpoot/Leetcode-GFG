class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans=new  ArrayList<>();
        HashSet<Integer> set=new  HashSet<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i+1]-arr[i]<min)
                min=arr[i+1]-arr[i];
            set.add(arr[i]);
        }
        set.add(arr[arr.length-1]);
        for(int i=0;i<arr.length-1;i++)
        {
            if(set.contains(arr[i]+min))
            {
                List<Integer> temp=new  ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i]+min);
                ans.add(temp);
            }
        }
        return ans;
    }
}