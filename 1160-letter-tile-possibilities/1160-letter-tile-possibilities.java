class Solution
{
    HashMap<String,Integer> map=new  HashMap<>();
    public int numTilePossibilities(String tiles)
    {
        traverse(tiles,"");
        return map.size();
    }
    public void traverse(String tiles,String s)
    {
        char temp;
        if(tiles.length()==0)
            return;
        for(int i=0;i<tiles.length();i++)
        {
            temp=tiles.charAt(i);
            if(map.containsKey(s+temp))
                continue;
            map.put(s+temp,1);
            // if(i==0 && i==tiles.length()-1)
            //     traverse("",s+temp);
            // else if(i==0)
            //     traverse(tiles.substring(i+1),s+temp);
            // else if(i==tiles.length()-1)
            //     traverse(tiles.substring(0,i),s+temp);
            // else
                traverse(tiles.substring(0,i)+tiles.substring(i+1),s+temp);
        }
    }
}