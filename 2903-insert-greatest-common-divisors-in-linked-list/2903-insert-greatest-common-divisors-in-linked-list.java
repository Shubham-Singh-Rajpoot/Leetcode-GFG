/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head)
    {
        ListNode temp=head;
        int num1=head.val;
        int num2;
        while(temp.next!=null)
        {
            num2=temp.next.val;
            ListNode tt=new  ListNode(gcd(Math.min(num1,num2),Math.max(num1,num2)));
            tt.next=temp.next;
            temp.next=tt;
            temp=tt.next;
            num1=num2;
        }
        return head;
    }
    public int gcd(int num1,int num2)
    {
        if(num2%num1==0)
            return num1;
        return gcd(num2%num1,num1);
    }
}