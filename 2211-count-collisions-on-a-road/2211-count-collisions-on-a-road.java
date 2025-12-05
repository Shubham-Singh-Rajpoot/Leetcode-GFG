class Solution {
    public int countCollisions(String directions) {
        int ans=0;
        Stack<Character> s=new  Stack<>();
        int start=0;
        while(start<directions.length() && directions.charAt(start)=='L')
            start++;
        directions=directions.substring(start);
        for(int i=0;i<directions.length();i++)
        {
            if(directions.charAt(i)=='R')
                s.push('R');
            else if(directions.charAt(i)=='L')
            {
                if(s.isEmpty())
                {
                    ans++;
                    continue;
                }
                ans+=2;
                s.pop();
                while(!s.isEmpty())
                {
                    ans++;
                    s.pop();
                }
            }
            else
            {
                while(!s.isEmpty())
                {
                    ans++;
                    s.pop();
                }
            }
        }
        return ans;
    }
}