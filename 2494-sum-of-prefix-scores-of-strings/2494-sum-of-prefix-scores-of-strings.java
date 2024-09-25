class Solution {
    class Trie{
        Trie children[] =new Trie [26];
        int count = 0;
    }
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        for(String s : words){
            Trie curr = root;
            for(char ch:s.toCharArray()){
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a']=new Trie();
                }
                curr = curr.children[ch-'a'];
                curr.count++;
            }
        } 
        int n = words.length;
        int ans[] = new int[n];
        int i =0;
        for(String s:words){
            Trie curr = root;
            int sum = 0;
            for(char ch:s.toCharArray()){
                curr = curr.children[ch-'a'];
                sum+=curr.count;
            }
            ans[i]=sum;
            i++;
        }
        return ans;
    }
}