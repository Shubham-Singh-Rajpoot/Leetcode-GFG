class Solution {
    public int findMinDifference(List<String> timePoints)
    {
        int ans=3600;
        Collections.sort(timePoints);
        System.out.println(timePoints);
        for(int i=1;i<timePoints.size();i++)
        {
            int curr=Integer.parseInt(timePoints.get(i).substring(0,timePoints.get(i).indexOf(':')))*60 + Integer.parseInt(timePoints.get(i).substring(timePoints.get(i).indexOf(':')+1));
            int prev=Integer.parseInt(timePoints.get(i-1).substring(0,timePoints.get(i-1).indexOf(':')))*60 + Integer.parseInt(timePoints.get(i-1).substring(timePoints.get(i-1).indexOf(':')+1));
            ans=Math.min(ans,Math.min(curr-prev, (1440-curr)+prev));
        }
        int curr=Integer.parseInt(timePoints.get(timePoints.size()-1).substring(0,timePoints.get(timePoints.size()-1).indexOf(':')))*60 + Integer.parseInt(timePoints.get(timePoints.size()-1).substring(timePoints.get(timePoints.size()-1).indexOf(':')+1));
        int prev=Integer.parseInt(timePoints.get(0).substring(0,timePoints.get(0).indexOf(':')))*60 + Integer.parseInt(timePoints.get(0).substring(timePoints.get(0).indexOf(':')+1));
        ans=Math.min(ans,Math.min(curr-prev, (1440-curr)+prev));
        return ans;
    }
}