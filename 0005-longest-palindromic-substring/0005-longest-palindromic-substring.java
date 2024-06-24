class Solution
{
    int startIndex,maxL;
    public String longestPalindrome(String s)
    {
	    if(s.length()<2)
		    return s;
        for(int i=0;i<s.length()-1;i++)
        {
     	    traverse(s,i,i); //For ODD length palindrome
     	    traverse(s,i,i+1); //For EVEN length palindrome
        }
        return s.substring(startIndex,startIndex+maxL);
    }
    public void traverse(String s,int j,int k)
    {
	    while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k))
	    {
		    j--;
		    k++;
	    }
	    if(maxL<k-j-1)
	    {
		    startIndex=j+1;
		    maxL=k-j-1;
	    }
    }
}