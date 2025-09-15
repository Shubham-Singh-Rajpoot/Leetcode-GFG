class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String ar[]=text.split(" ");
        int ans=0;
        for(String s:ar)
        {
            int i=0;
            for(i=0;i<brokenLetters.length();i++)
                if(s.indexOf(brokenLetters.charAt(i))!=-1)
                    break;
            if(i==brokenLetters.length())
                ans++;
        }
        return ans;
    }
}