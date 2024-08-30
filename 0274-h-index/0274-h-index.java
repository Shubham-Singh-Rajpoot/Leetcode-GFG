class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count=0;
        int i=citations.length-1;
        while(i>=0 && citations[i]>=count+1)
        {
            count++;
            i--;
        }
        return count;
    }
}