class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map1=new  HashMap<>();
        HashMap<Character,Integer> map2=new  HashMap<>();
        if(s2.length()<s1.length())
            return false;
        int i;
        for(i=0;i<s1.length();i++)//creatingg hashmap of s1
        {
            if(map1.containsKey(s1.charAt(i)))
                map1.put(s1.charAt(i),map1.get(s1.charAt(i))+1);
            else
                map1.put(s1.charAt(i),1);
        }
        for(i=0;i<s1.length();i++)//hashmap of s2 of length equal to s1
        {
            if(map2.containsKey(s2.charAt(i)))
                map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1);
            else
                map2.put(s2.charAt(i),1);
        }
        if(map1.equals(map2))
            return true;
        for(i=s1.length();i<s2.length();i++)
        {
            if(map2.containsKey(s2.charAt(i)))
                map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1);
            else
                map2.put(s2.charAt(i),1);
            map2.put(s2.charAt(i-s1.length()),map2.get(s2.charAt(i-s1.length()))-1);
            if(map2.get(s2.charAt(i-s1.length()))==0)
                map2.remove(s2.charAt(i-s1.length()));
            if(map1.equals(map2))
                return true;
        }
        return false;
    }
}