class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for(int i = 0; i < n; i++)
            if(checkSubstring(words, i, words[i], n))
                res.add(words[i]);
        return res;
    }
    boolean checkSubstring(String[] words, int idx, String subStr, int n)
    {
        for(int j = 0; j < n; j++)
        {
            if(idx==j)
                continue;
            if(words[j].contains(subStr))                
                return true;
        }
        return false;
    }    
}