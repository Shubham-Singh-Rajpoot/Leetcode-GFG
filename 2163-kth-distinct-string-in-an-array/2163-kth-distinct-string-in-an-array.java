class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> occured=new  HashMap<>();
        for(int i=0;i<arr.length;i++)
            occured.put(arr[i],occured.getOrDefault(arr[i],0)+1);
        int cnt=0;
        for(int i=0;i<arr.length;i++)
        {
            if(occured.get(arr[i])==1)
                cnt++;
            if(cnt==k)
                return arr[i];
        }
        return "";
    }
}