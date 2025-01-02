class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr=new int[queries.length];
        int[] pre=new int[words.length];
        if (vowelCheck(words[0]))
            pre[0]=1;
        for (int i=1;i<words.length;i++)
        {
            if(vowelCheck(words[i]))
                pre[i]=pre[i-1]+1;
            else
                pre[i]=pre[i-1];
        }
        int n = queries.length;
        for (int i = 0;i<n;i++)
        {
            if (queries[i][0] == 0)
                arr[i] = pre[queries[i][1]];
            else
                arr[i] = pre[queries[i][1]] - pre[queries[i][0]-1];
        }
        return arr;
    }
    public boolean vowelCheck(String s)
    {
        int n = s.length()-1;
        return (s.charAt(0) == 'a' || s.charAt(0) == 'e' || 
        s.charAt(0) == 'i' || s.charAt(0) == 'o' || 
        s.charAt(0) == 'u')  && 
        (s.charAt(n) == 'a' || s.charAt(n) == 'e' || 
        s.charAt(n) == 'i' || s.charAt(n) == 'o' || 
        s.charAt(n) == 'u');
    }
}