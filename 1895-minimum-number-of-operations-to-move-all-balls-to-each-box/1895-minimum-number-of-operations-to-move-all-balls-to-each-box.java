class Solution {
    public int[] minOperations(String boxes) {
        int ar[]=new  int[boxes.length()];
        List<Integer> list=new  ArrayList<Integer>();
        int i,j;
        for(i=0;i<boxes.length();i++)
            if(boxes.charAt(i)=='1')
                list.add(list.size(),i);
        for(i=0;i<ar.length;i++)
            for(j=0;j<list.size();j++)
                ar[i]=ar[i]+Math.abs(list.get(j)-i);
        return ar;
    }
}