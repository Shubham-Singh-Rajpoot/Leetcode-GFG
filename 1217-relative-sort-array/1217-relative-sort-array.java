class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map=new  HashMap<>();
        int i,index=0;
        for(i=0;i<arr2.length;i++)
            map.put(arr2[i],0);
        for(i=0;i<arr1.length;i++)
        {
            if(map.containsKey(arr1[i]))
            {
                map.put(arr1[i],map.get(arr1[i])+1);
                arr1[i]=-1;
            }
        }
        Arrays.sort(arr1);
        for(i=0;i<arr2.length;i++)
        {
            while(map.get(arr2[i])>0)
            {
                arr1[index++]=arr2[i];
                map.put(arr2[i],map.get(arr2[i])-1);
            }
            map.remove(arr2[i]);
        }
        return arr1;
    }
}