class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first,-1);
        for(int i=0; i<s.length(); i++){
            int curr = s.charAt(i) - 97;
            if(first[curr] == -1)
                first[curr] = i;
            last[curr] = i;
        }
        for(int i=0; i<first.length; i++){
            if(first[i] == -1)
                continue;
            Set<Character> set = new HashSet<>();
            for(int j = first[i]+1; j < last[i]; j++){
                set.add(s.charAt(j));
            }
            ans += set.size();

        }
        return ans;
    }
}