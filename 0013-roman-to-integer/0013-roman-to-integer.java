class Solution
{
    public int romanToInt(String s)
    {
        HashMap<Character,Integer> map=new  HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i,sum=map.get(s.charAt(0));char ch=s.charAt(0);
        for(i=1;i<s.length();i++)
        {
            if(map.get(s.charAt(i))>map.get(ch))
                sum+=map.get(s.charAt(i))-(2*map.get(ch));
            else
                sum+=map.get(s.charAt(i));
            ch=s.charAt(i);
        }
        return sum;
    }
}