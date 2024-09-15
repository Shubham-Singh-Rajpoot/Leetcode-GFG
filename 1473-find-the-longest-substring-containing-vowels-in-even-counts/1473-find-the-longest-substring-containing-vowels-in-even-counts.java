class Solution {
    public int findTheLongestSubstring(String s) {
        int[] abc = new int[26];
        abc[0] = 1;
        abc['e' - 'a'] = 2;
        abc['i' - 'a'] = 4;
        abc['o' - 'a'] = 8;
        abc['u' - 'a'] = 16;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int xr = 0;
        mp.put(xr, -1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            xr ^= abc[s.charAt(i) - 'a'];
            if (mp.containsKey(xr)) {
                ans = Math.max(ans, i - mp.get(xr));
            } else {
                mp.put(xr, i);
            }
        }
        return ans;
    }
}