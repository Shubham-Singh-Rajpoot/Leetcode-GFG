class Solution {
    public String[] sortPeople(String[] names, int[] heights)
    {
        HashMap<Integer,String> map=new  HashMap<>();
        for(int i=0;i<heights.length;i++)
            map.put(heights[i],names[i]);
        Arrays.sort(heights);
        for(int i=0;i<heights.length;i++)
            names[heights.length-i-1]=map.get(heights[i]);
        return names;
    }
}