class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack=new  Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(stack.isEmpty())
                stack.add(c);
            else if(c==']')
            {
                if(stack.peek()=='[')
                    stack.pop();
                else
                    stack.add(c);
            }
            else
            {
                stack.add(c);
            }
        }
        return (int)Math.ceil(stack.size()/4.0);
    }
}