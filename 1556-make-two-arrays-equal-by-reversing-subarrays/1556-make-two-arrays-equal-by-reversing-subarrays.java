class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> tm=new  HashMap<>();
        HashMap<Integer,Integer> am=new  HashMap<>();
        for(int i=0;i<target.length;i++)
        {
            tm.put(target[i],tm.getOrDefault(target[i],0)+1);
            am.put(arr[i],am.getOrDefault(arr[i],0)+1);
        }
        if(tm.equals(am))
            return true;
        return false;
    }
}