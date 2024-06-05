class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<String,Integer> map=new  HashMap<>();
        List<String> list=new  ArrayList<>();
        for(int i=0;i<words[0].length();i++)
            list.add(""+words[0].charAt(i));
        for(int i=1;i<words.length;i++)
        {
            map.clear();
            for(int j=0;j<words[i].length();j++)
            {
                if(map.containsKey(""+words[i].charAt(j)))
                    map.put(""+words[i].charAt(j),map.get(""+words[i].charAt(j))+1);
                else
                    map.put(""+words[i].charAt(j),1);
            }
            for(int j=0;j<list.size();j++)
            {
                if(!map.containsKey(list.get(j)))
                {
                    list.remove(j);
                    j--;
                }
                else
                {
                    map.put(list.get(j),map.get(list.get(j))-1);
                    if(map.get(list.get(j))==0)
                        map.remove(list.get(j));
                }
            }
        }
        return list;
    }
}