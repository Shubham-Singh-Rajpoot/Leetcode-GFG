class Solution {
    public String smallestNumber(String pattern) {
       int n=pattern.length();
       int count=1;
       char ch=pattern.charAt(0);
       Stack<Integer> stack=new Stack<>();
       StringBuilder sb=new StringBuilder();
        for(int i=0;i<=n;i++)
        {
            if(i<n)
                ch=pattern.charAt(i);
            stack.push(count);
            count+=1;
            if(i==n || ch=='I')
                while(!stack.isEmpty())
                    sb.append(stack.pop());
        }
        return sb.toString();
    }
}