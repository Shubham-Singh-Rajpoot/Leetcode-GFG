class Solution {
    public String sortVowels(String s) {
        ArrayList<Integer> indexes=new  ArrayList<>();
        String vowels="aeiouAEIOU";
        ArrayList<Character> vow=new  ArrayList<>();
        ArrayList<Character> cons=new  ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(vowels.indexOf(s.charAt(i))!=-1)
            {
                indexes.add(i);
                vow.add(s.charAt(i));
            }
            else
                cons.add(s.charAt(i));
        }
        Collections.sort(vow);
        StringBuilder str=new  StringBuilder();
        while(indexes.size()!=0)
        {
            while(str.length()<indexes.get(0))
                str.append(cons.remove(0));
            str.append(vow.get(0));
            vow.remove(0);
            indexes.remove(0);
        }
        while(cons.size()!=0)
            str.append(cons.remove(0));
        return str.toString();
    }
}