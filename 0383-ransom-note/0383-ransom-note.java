class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int ar[]=new  int[26];
        for(int i=0;i<magazine.length();i++)
            ar[magazine.charAt(i)-97]++;
        for(int i=0;i<ransomNote.length();i++)
        {
            if(ar[ransomNote.charAt(i)-97]==0)
                return false;
            else
                ar[ransomNote.charAt(i)-97]--;
        }
        return true;
    }
}