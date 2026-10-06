class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new  Stack<>();
        char c;
        for(int i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            if(stack.isEmpty())
                stack.add(c);
            else if(c==')')
            {
                if(stack.peek()=='(')
                    stack.pop();
                else
                    stack.add(c);
            }
            else
                stack.add(c);
        }
        return stack.size();
    }
}