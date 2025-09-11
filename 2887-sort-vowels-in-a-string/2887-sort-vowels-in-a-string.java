class Solution {
    public String sortVowels(String s) {
        ArrayList<Integer> indexes=new  ArrayList<>();
        String vowels="AEIOUaeiou";
        int cnt[]=new int[10];
        ArrayList<Character> cons=new  ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(vowels.indexOf(s.charAt(i))!=-1)
            {
                indexes.add(i);
                cnt[vowels.indexOf(s.charAt(i))]++;
            }
            else
                cons.add(s.charAt(i));
        }
        StringBuilder str=new  StringBuilder();
        int curr=0;
        while(indexes.size()!=0)
        {
            while(cnt[curr]==0)
                curr++;
            while(str.length()<indexes.get(0))
                str.append(cons.remove(0));
            str.append(vowels.charAt(curr));
            cnt[curr]--;
            indexes.remove(0);
        }
        while(cons.size()!=0)
            str.append(cons.remove(0));
        return str.toString();
    }
}